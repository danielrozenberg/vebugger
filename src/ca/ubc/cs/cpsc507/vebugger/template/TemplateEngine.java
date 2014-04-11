package ca.ubc.cs.cpsc507.vebugger.template;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.debug.core.DebugException;
import org.eclipse.jdt.debug.core.IJavaClassType;
import org.eclipse.jdt.debug.core.IJavaFieldVariable;
import org.eclipse.jdt.debug.core.IJavaInterfaceType;
import org.eclipse.jdt.debug.core.IJavaObject;

public class TemplateEngine {

    private static final String BASE_TEMPLATE = "<html><body><pre>{{@toString}}</pre></body></html>";

    private static final Pattern TOKEN_PATTERN = Pattern.compile("(.*?)\\{\\{([@#]?)(\\w+?)\\}\\}");
    private static final char TOKEN_METHOD = '@';
    private static final char TOKEN_ITERATOR_FIELD_START = '#';
    private static final char TOKEN_ITERATOR_METHOD_START = '$';
    private static final char TOKEN_ITERATOR_END = '/';

    public static String render(IJavaObject obj) throws DebugException, TemplateEngineRenderException {
        IJavaClassType classType = (IJavaClassType) obj.getJavaType();
        return renderTemplate(getMatchingTemplate(classType), obj);
    }

    private static String getMatchingTemplate(IJavaClassType classType) throws DebugException {
        String template = loadTemplate(classType.toString());
        if (template != null) {
            return template;
        }

        IJavaClassType superclassType;
        while ((superclassType = classType.getSuperclass()) != null
                && !superclassType.toString().equals(Object.class.getCanonicalName())) {
            template = loadTemplate(classType.toString());
            if (template != null) {
                return template;
            }
        }

        for (IJavaInterfaceType interfaceType : classType.getAllInterfaces()) {
            template = loadTemplate(interfaceType.toString());
            if (template != null) {
                return template;
            }
        }

        while ((superclassType = classType.getSuperclass()) != null
                && !superclassType.toString().equals(Object.class.getCanonicalName())) {
            for (IJavaInterfaceType interfaceType : superclassType.getAllInterfaces()) {
                template = loadTemplate(interfaceType.toString());
                if (template != null) {
                    return template;
                }
            }
        }

        return BASE_TEMPLATE;
    }

    private static String loadTemplate(String type) {
        // TODO Auto-generated method stub
        if (type.equals("dfcsdc.Ffdcadfs")) {
            return "<html><body><table border=\"2\"><tr><td colspan=\"2\">{{i}}</td></tr><tr><td>{{jx}}</td><td>{{k}}</td></tr></table></body></html>";
        }
        return null;
    }

    private static String renderTemplate(String matchingTemplate, IJavaObject obj) throws TemplateEngineRenderException {
        try {
            StringBuilder outputStringBuilder = new StringBuilder();

            int lastMatchEnd = 0;
            Matcher matcher = TOKEN_PATTERN.matcher(matchingTemplate);
            while (matcher.find(lastMatchEnd)) {
                String prefix = matcher.group(1);
                String tokenType = matcher.group(2);
                String tokenName = matcher.group(3);

                outputStringBuilder.append(prefix);

                if (tokenType.isEmpty()) {
                    IJavaFieldVariable fieldVariable = obj.getField(tokenName, false);
                    if (fieldVariable != null) {
                        outputStringBuilder.append(fieldVariable.getValue());
                    } else {
                        throw new TemplateEngineRenderException("Field {{" + tokenName
                                + "}} does not exist in template at char " + matcher.start(3) + ".", null);
                    }
                }

                lastMatchEnd = matcher.end();
            }

            outputStringBuilder.append(matchingTemplate, lastMatchEnd, matchingTemplate.length());
            return outputStringBuilder.toString();
        } catch (DebugException e) {
            throw new TemplateEngineRenderException(e);
        }
    }
}
