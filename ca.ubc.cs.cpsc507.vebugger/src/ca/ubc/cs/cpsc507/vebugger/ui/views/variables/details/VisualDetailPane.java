package ca.ubc.cs.cpsc507.vebugger.ui.views.variables.details;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.model.IDebugElement;
import org.eclipse.debug.core.model.IExpression;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.debug.core.model.IWatchExpressionDelegate;
import org.eclipse.debug.core.model.IWatchExpressionListener;
import org.eclipse.debug.core.model.IWatchExpressionResult;
import org.eclipse.debug.ui.IDetailPane;
import org.eclipse.jdt.debug.core.IJavaFieldVariable;
import org.eclipse.jdt.debug.core.IJavaObject;
import org.eclipse.jdt.debug.core.IJavaPrimitiveValue;
import org.eclipse.jdt.debug.core.IJavaVariable;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPartSite;
import org.omg.CORBA.portable.UnknownException;

public class VisualDetailPane implements IDetailPane, IWatchExpressionListener {

    public static final String VISUAL_DETAIL_PANE_ID = "VisualDetailPane";
    private static final String VEBUGGER_RENDERING_METHOD_EXPRESSION = "vebugger.VisualDebuggerAid.toString";

    // TODO externalize strings
    public static final String VISUAL_DETAIL_PANE_NAME = "Visual Debugger";
    public static final String VISUAL_DETAIL_PANE_DESCRIPTION = "A visual debugger that allows developers to provide short scripts to visuals objects.";

    private Browser browser;

    @Override
    public void init(IWorkbenchPartSite partSite) {
    }

    @Override
    public Control createControl(Composite parent) {
        browser = new Browser(parent, SWT.H_SCROLL | SWT.V_SCROLL);
        browser.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        return browser;
    }

    @Override
    public void dispose() {
        browser.dispose();
        browser = null;
    }

    @Override
    public void display(IStructuredSelection selection) {
        try {
            // Clear the text for now
            browser.setText("");

            if (!selection.isEmpty() || !(selection instanceof TreeSelection)) {

                Object firstElement = selection.getFirstElement();
                if (firstElement != null && firstElement instanceof IDebugElement) {

                    IDebugElement element = (IDebugElement) firstElement;

                    if (element instanceof IVariable) {
                        displayVariable(selection, element);
                    } else if (element instanceof IExpression) {
                        displayExpression(element);
                    } else {
                        // FIXME we don't treat other selection types yet
                        throw new DebugException(null);
                    }

                }
            }
        } catch (DebugException e) {
            setBrowserTextToString("Could not parse " + selection + "\n\n<pre>" + e.getMessage() + "</pre>", "Error");
            e.printStackTrace();
        }
    }

    @Override
    public boolean setFocus() {
        return false;
    }

    @Override
    public String getID() {
        return VISUAL_DETAIL_PANE_ID;
    }

    @Override
    public String getName() {
        return VISUAL_DETAIL_PANE_NAME;
    }

    @Override
    public String getDescription() {
        return VISUAL_DETAIL_PANE_DESCRIPTION;
    }

    @Override
    public void watchEvaluationFinished(final IWatchExpressionResult result) {
        if (result != null) {
            Display.getDefault().asyncExec(new Runnable() {
                @Override
                public void run() {
                    try {
                        if (result.hasErrors()) {
                            DebugException e = result.getException();
                            if (e != null) {
                                throw e;
                            } else {
                                throw new UnknownException(null);
                            }
                        }
                        browser.setText(result.getValue().getValueString());
                    } catch (DebugException | UnknownException e) {
                        setBrowserTextToString(e.toString(), "Error!");
                    }
                }
            });
        }
    }

    /**
     * Render a selected variable.
     * 
     * @param selection
     *            the selection object
     * @param element
     *            the variable element
     * @throws DebugException
     */
    private void displayVariable(IStructuredSelection selection, IDebugElement element) throws DebugException {
        IValue value = ((IVariable) element).getValue();

        if (value instanceof IJavaPrimitiveValue) {
            setBrowserTextToPrimitive((IJavaPrimitiveValue) value);
        } else {
            TreePath firstElementTreePath = ((TreeSelection) selection).getPaths()[0];
            String watchExpression = generateWatchExpression(firstElementTreePath);
            String messageExpression = generateMessageExpression(watchExpression);

            // Iterate all threads and run our rendering
            // expression in them in the hopes that we can find
            // the relevant selection in only one thread
            // FIXME find a better way to derive the correct thread!
            IWatchExpressionDelegate delegate = DebugPlugin.getDefault().getExpressionManager()
                    .newWatchExpressionDelegate(element.getModelIdentifier());
            for (IThread thread : element.getDebugTarget().getThreads()) {
                delegate.evaluateExpression(messageExpression, thread, this);
            }
        }
    }

    /**
     * Render a watch expression.
     * 
     * FIXME we don't treat watch expression yet, this will just render their
     * {@link String} value.
     * 
     * @param element
     *            the expression element
     */
    private void displayExpression(IDebugElement element) {
        IValue value = ((IExpression) element).getValue();
        if (value instanceof IJavaPrimitiveValue) {
            setBrowserTextToPrimitive((IJavaPrimitiveValue) value);
        } else if (value instanceof IJavaObject) {
            setBrowserTextToString(value.toString());
        } else if (value != null) {
            setBrowserTextToString(value.toString(), "Error!");
        }
    }

    private void setBrowserTextToString(String text) {
        browser.setText("<html><body><p>" + text + "</p></body></html>");
    }

    private void setBrowserTextToString(String text, String title) {
        browser.setText("<html><body><h1>" + title + "</h1><p>" + text + "</p></body></html>");
    }

    private void setBrowserTextToPrimitive(IJavaPrimitiveValue value) {
        setBrowserTextToString("<pre>" + value + "</pre>");
    }

    /**
     * Generate a Java expression that represents the selection.
     * 
     * e.g. if we selected the "foo" field of the 3rd object in an array called
     * "bar" inside an object called "baz", build "baz.bar[2].foo"
     * 
     * @param treePath
     *            the selection {@link TreePath} object
     * @return a Java expression that represents the selection
     * @throws DebugException
     */
    private String generateWatchExpression(TreePath treePath) throws DebugException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < treePath.getSegmentCount(); i++) {
            Object part = treePath.getSegment(i);
            if (part instanceof IJavaFieldVariable) {
                sb.append('.');
                sb.append(((IJavaFieldVariable) part).getName());
            } else if (part instanceof IJavaVariable) {
                sb.append(((IJavaVariable) part).getName());
            }
        }
        return sb.toString();
    }

    /**
     * Generate a Java expression that represents a call to the Vebugger
     * rendering aid.
     * 
     * e.g. for the expression "foo" generate
     * "vebugger.VisualDebuggerAid.toString(foo)"
     * 
     * @param watchExpression
     *            the expression to render
     * @return a Java expression that represents a call to the Vebugger
     *         rendering aid
     */
    private String generateMessageExpression(String watchExpression) {
        StringBuilder sb = new StringBuilder(VEBUGGER_RENDERING_METHOD_EXPRESSION).append('(').append(watchExpression)
                .append(')');

        return sb.toString();
    }
}
