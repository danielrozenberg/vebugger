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

        sb.append("<style>");
        sb.append("table.array {border-collapse: collapse; font-size: 12px;}");
        sb.append("table.array > * > tr > * {padding: 4px;}");
        sb.append("table.array > thead > tr {border-bottom: 2px solid black;}");
        sb.append("table.array > thead > tr > th.array-index, table.array > tbody > tr > th {border-right: 1px dotted silver;}");
        sb.append("table.array > tbody > tr > * {border-bottom: 1px dotted silver;}");
        sb.append("table.array > tbody > tr:last-child > * {border-bottom: none;}");
        sb.append("</style>");

        if (array.length > 0) {
            sb.append("<table class=\"array\"><thead><tr><th class=\"array-index\">Index</th><th>Value</th></tr></thead><tbody>");
            for (int i = 0; i < array.length; i++) {
                sb.append("<tr><th>").append(i).append("</th><td>").append(VisualDebuggerAid.toString(array[i], false))
                        .append("</td></tr>");
            }
            sb.append("</tbody></table>");
        } else {
            sb.append("[] <span style=\"color: silver; font-style: italic;\">(empty array)</span>");
        }
    }

}
