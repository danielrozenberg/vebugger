package vebugger.templates;

import vebugger.VebuggerTemplate;
import vebugger.VisualDebuggerAid;

public class ArrayTemplate extends VebuggerTemplate {

    @Override
    public Class<?> getType() {
        return Object[].class;
    }

    @Override
    public void render(StringBuilder sb, Object obj) {
        Object[] array = (Object[]) obj;

        if (array.length > 0) {
            sb.append("<table border=\"1\"><thead><tr>");
            for (int i = 0; i < array.length; i++) {
                sb.append("<th>").append(i).append("</th>");
            }
            sb.append("</tr></thead><tbody><tr>");
            for (Object o : array) {
                sb.append("<td>").append(VisualDebuggerAid.toString(o)).append("</td>");
            }
            sb.append("</tr></tbody></table>");
        } else {
            sb.append("[] <span style=\"color: silver; font-style: italic;\">(empty array)</span>");
        }
    }

}
