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
        sb.append("<table border=\"1\"><thead><tr><th>Key</th><th>Value</th></tr></thead><tbody>");
        for (Entry<?, ?> entry : ((Map<?, ?>) obj).entrySet()) {
            sb.append("<tr><td>").append(VisualDebuggerAid.toString(entry.getKey())).append("</td><td>")
                    .append(VisualDebuggerAid.toString(entry.getValue())).append("</tr>");
        }
        sb.append("</tbody></table>");
    }

}
