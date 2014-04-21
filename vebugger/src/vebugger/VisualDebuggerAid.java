package vebugger;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.reflections.Reflections;

public final class VisualDebuggerAid {

    private static Map<Class<?>, VebuggerTemplate> templates = new HashMap<>();
    static {
        Reflections reflections = new Reflections("vebugger.templates");
        Set<Class<? extends VebuggerTemplate>> templateClasses = reflections.getSubTypesOf(VebuggerTemplate.class);
        for (Class<? extends VebuggerTemplate> templateClass : templateClasses) {
            try {
                VebuggerTemplate template = templateClass.newInstance();
                templates.put(template.getType(), template);
            } catch (InstantiationException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static final String toString(Object obj) {
        return toString(obj, true);
    }

    public static final String toString(Object obj, boolean includeHtmlWrapper) {
        if (obj != null) {
            VebuggerTemplate template = findMatchingTemplate(obj.getClass());
            if (template != null) {
                StringBuilder sb = new StringBuilder();
                template.render(sb, obj);

                if (includeHtmlWrapper) {
                    sb.insert(0, "<html><body>");
                    sb.append("</body></html>");
                }

                return sb.toString();
            }
        }

        return String.valueOf(obj);
    }

    private static final VebuggerTemplate findMatchingTemplate(Class<?> clazz) {
        VebuggerTemplate template = findMatchingClassTemplate(clazz);
        if (template == null) {
            template = findMatchingInterfaceTemplate(clazz);
        }
        if (template == null && clazz.isArray()) {
            template = findMatchingClassTemplate(Object[].class);
        }
        return template;
    }

    private static final VebuggerTemplate findMatchingClassTemplate(Class<?> clazz) {
        if (!clazz.equals(Object.class)) {
            VebuggerTemplate template;
            if ((template = templates.get(clazz)) != null) {
                return template;
            }
            return findMatchingClassTemplate(clazz.getSuperclass());
        }
        return null;
    }

    private static VebuggerTemplate findMatchingInterfaceTemplate(Class<?> clazz) {
        if (!clazz.equals(Object.class)) {
            VebuggerTemplate template;
            for (Class<?> interfaze : clazz.getInterfaces()) {
                if ((template = templates.get(interfaze)) != null) {
                    return template;
                }
            }
            return findMatchingInterfaceTemplate(clazz.getSuperclass());
        }
        return null;
    }

}
