package vebugger.templates;

import java.util.Map;
import java.util.Map.Entry;

import vebugger.VebuggerTemplate;
import vebugger.VisualDebuggerAid;

public class MapTemplate extends VebuggerTemplate {

    @Override
    public Class<?> getType() {
        return Map.class;
    }

    @Override
    public void render(StringBuilder sb, Object obj) {
        sb.append("<style>");
        sb.append("table.java-util-Map {border-collapse: collapse; font-size: 12px;}");
        sb.append("table.java-util-Map > * > tr > * {padding: 4px;}");
        sb.append("table.java-util-Map > thead > tr {border-bottom: 2px solid black;}");
        sb.append("table.java-util-Map > * > tr > *:first-child:not(:last-child) {border-right: 1px dotted silver;}");
        sb.append("table.java-util-Map > tbody > tr > * {border-bottom: 1px dotted silver;}");
        sb.append("table.java-util-Map > tbody > tr:last-child > * {border-bottom: none;}");
        sb.append("</style>");

        sb.append("<table class=\"java-util-Map\"><thead><tr><th>Key</th><th>Value</th></tr></thead><tbody>");
        for (Entry<?, ?> entry : ((Map<?, ?>) obj).entrySet()) {
            sb.append("<tr><td>").append(VisualDebuggerAid.toString(entry.getKey(), false)).append("</td><td>")
                    .append(VisualDebuggerAid.toString(entry.getValue(), false)).append("</tr>");
        }
        sb.append("</tbody></table>");
    }

}
