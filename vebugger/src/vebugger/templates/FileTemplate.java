package vebugger.templates;

import java.io.File;

import vebugger.VebuggerTemplate;

public class FileTemplate extends VebuggerTemplate {

    @Override
    public Class<?> getType() {
        return File.class;
    }

    @Override
    public void render(StringBuilder sb, Object obj) {
        File file = (File) obj;
        sb.append("<style>td.code {font-family: monospace;}</style>");
        sb.append("<pre>").append(file.toString()).append("</pre>");
        sb.append("<table border=\"1\"><thead><tr><th>Property</th><th>Value</th></tr></thead></tbody>");
        sb.append("<tr><td class=\"code\">isAbsolute()</td><td class=\"code\">").append(file.isAbsolute()).append("</td></tr>");
        if (file.exists()) {
            sb.append("<tr><td class=\"code\">isFile()</td><td class=\"code\">").append(file.isFile()).append("</td></tr>");
            sb.append("<tr><td class=\"code\">isDirectory()</td><td class=\"code\">").append(file.isDirectory()).append("</td></tr>");
            sb.append("<tr><td class=\"code\">isHidden()</td><td class=\"code\">").append(file.isHidden()).append("</td></tr>");
            sb.append("<tr><td>Permissions</td><td><pre>");
            boolean noPermissions = true;
            if (file.canRead()) {
                sb.append("readable\n");
                noPermissions = false;
            }
            if (file.canWrite()) {
                sb.append("writable\n");noPermissions = false;
            }
            if (file.canExecute()) {
                sb.append("executable");noPermissions = false;
            }
            if (noPermissions) {
            	sb.append("&lt;none&gt;");
            }
            sb.append("</pre></td></tr>");
        } else {
            sb.append("<tr><td colspan=\"2\">(file does not exist)</td></tr>");
        }
        sb.append("</tbody></table>");
    }

}
