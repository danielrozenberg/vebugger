package vebugger.templates;

import java.util.Iterator;
import java.util.Set;

import vebugger.VebuggerTemplate;
import vebugger.VisualDebuggerAid;

public class SetTemplate extends VebuggerTemplate {

    @Override
    public Class<?> getType() {
        return Set.class;
    }

    @Override
    public void render(StringBuilder sb, Object obj) {
        Set<?> set = (Set<?>) obj;
        int size = set.size();
        int cloudSpan = (int) Math.ceil(Math.sqrt(size));
        Iterator<?> iterator = set.iterator();

        sb.append("<style>");
        sb.append("table.java-util-Set > tbody > tr > td > div {border: 1px dotted silver; -webkit-border-radius: 10px; -moz-border-radius: 10px; border-radius: 10px; padding: 10px}");
        sb.append("</style>");
        sb.append("<table class=\"java-util-Set\"><tbody>");
        for (int i = 0; i < cloudSpan; i++) {
            sb.append("<tr>");
            for (int j = 0; j < cloudSpan; j++) {
                if (iterator.hasNext()) {
                    sb.append("<td><div>").append(VisualDebuggerAid.toString(iterator.next())).append("</div></td>");
                } else {
                    sb.append("<td></td>");
                }
            }
            sb.append("</tr>");
        }
        sb.append("</tbody></table>");
    }

}
