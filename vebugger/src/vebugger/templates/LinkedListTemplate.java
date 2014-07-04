package vebugger.templates;

import java.util.LinkedList;

import vebugger.VebuggerTemplate;
import vebugger.VisualDebuggerAid;

public class LinkedListTemplate extends VebuggerTemplate {

    @Override
    public Class<?> getType() {
        return LinkedList.class;
    }

    @Override
    public void render(StringBuilder sb, Object obj) {
        LinkedList<?> list = (LinkedList<?>) obj;

        sb.append("<style>");
        sb.append("table.java-util-LinkedList {border-collapse: collapse; font-size: 12px;}");
        sb.append("table.java-util-LinkedList > * > tr > * {padding: 4px; text-align: center;}");
        sb.append("table.java-util-LinkedList > thead > tr {border-bottom: 2px solid black;}");
        sb.append("table.java-util-LinkedList > * > tr > *:first-child {border-right: 1px dotted silver;}");
        sb.append("table.java-util-LinkedList > tbody > tr > th {color: silver; font-weight: normal;}");
        sb.append("table.java-util-LinkedList > tbody > tr > td:last-child > div {border: 1px dotted silver; -webkit-border-radius: 10px; -moz-border-radius: 10px; border-radius: 10px; display: inline-block; padding: 10px; text-align: initial;}");
        sb.append("</style>");

        if (list.size() > 0) {
            sb.append(
                    "<table class=\"java-util-LinkedList\"><thead><tr><th>Index</th><th>Value</th></tr></thead><tbody><tr><th>")
                    .append(-1).append("</th><th>head</th></tr><tr><th></th><td>↑ ↓</td></tr>");
            int i = 0;
            for (Object o : list) {
                sb.append("<tr><th>").append(i).append("</th><td><div>").append(VisualDebuggerAid.toString(o, false))
                        .append("</div></td></tr>");
                sb.append("<tr><th></th><td>↑ ↓</td></tr>");
                i++;
            }
            sb.append("<tr><th>").append(i).append("</th><th>tail</th></tr></tbody></table>");
        } else {
            sb.append("[] <span style=\"color: silver; font-style: italic;\">(empty LinkedList)</span>");
        }
    }
}
