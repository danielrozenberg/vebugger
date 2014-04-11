package ca.ubc.cs.cpsc507.vebugger.ui.views.variables.details;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IDebugElement;
import org.eclipse.debug.core.model.IExpression;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.debug.ui.IDetailPane;
import org.eclipse.jdt.debug.core.IJavaArray;
import org.eclipse.jdt.debug.core.IJavaObject;
import org.eclipse.jdt.debug.core.IJavaPrimitiveValue;
import org.eclipse.jdt.debug.core.IJavaValue;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbenchPartSite;

import ca.ubc.cs.cpsc507.vebugger.template.TemplateEngine;
import ca.ubc.cs.cpsc507.vebugger.template.TemplateEngineRenderException;

public class VisualDetailPane implements IDetailPane {

    public static final String VISUAL_DETAIL_PANE_ID = "VisualDetailPane";

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
        browser.setText("");

        if (!selection.isEmpty()) {
            Object firstElement = selection.getFirstElement();

            if (firstElement != null && firstElement instanceof IDebugElement) {
                try {
                    IDebugElement element = (IDebugElement) firstElement;

                    Object value;
                    if (element instanceof IVariable) {
                        value = ((IVariable) element).getValue();
                    } else if (element instanceof IExpression) {
                        value = ((IExpression) element).getValue();
                    } else {
                        throw new DebugException(null);
                    }

                    if (value instanceof IJavaPrimitiveValue) {
                        setPrimitiveContent("<pre>" + value.toString() + "</pre>");
                    } else if (value instanceof IJavaArray) {
                        // TODO iterate all values and display them
                        String contents = "<table><tr>";
                        for (int i = 0; i < ((IJavaArray) value).getLength(); i++) {
                            contents += "<td style=\"color: silver\">" + i + "</td>";
                        }
                        contents += "</tr><tr>";
                        for (IJavaValue subValue : ((IJavaArray) value).getValues()) {
                            contents += "<td style=\"border: 1px solid black;\">" + subValue.toString() + "</td>";
                        }
                        contents += "</tr></table>";
                        setPrimitiveContent(contents);
                    } else if (value instanceof IJavaObject) {
                        // TODO stuff
                        browser.setText(TemplateEngine.render((IJavaObject) value));
                    } else {
                        // TODO throw?
                    }

                } catch (DebugException | TemplateEngineRenderException e) {
                    setPrimitiveContent("Could not parse " + selection + "\n\n<pre>" + e.getMessage() + "</pre>",
                            "Error");
                    e.printStackTrace();
                }
            }
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

    private void setPrimitiveContent(String text) {
        browser.setText("<html><body><p>" + text + "</p></body></html>");
    }

    private void setPrimitiveContent(String text, String title) {
        browser.setText("<html><body><h1>" + title + "</h1><p>" + text + "</p></body></html>");
    }

}
