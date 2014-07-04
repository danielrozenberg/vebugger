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
        sb.append("<style>");
        sb.append("table.java-io-File {border-collapse: collapse; font-size: 12px;}");
        sb.append("table.java-io-File > * > tr > * {padding: 4px;}");
        sb.append("table.java-io-File > thead > tr {border-bottom: 2px solid black;}");
        sb.append("table.java-io-File > * > tr > *:first-child:not(:last-child) {border-right: 1px dotted silver;}");
        sb.append("table.java-io-File > tbody > tr > * {border-bottom: 1px dotted silver;}");
        sb.append("table.java-io-File > tbody > tr:last-child > * {border-bottom: none;}");
        sb.append("</style>");

        sb.append("<pre>").append(file.toString()).append("</pre>");
        sb.append("<table class=\"java-io-File\"><thead><tr><th>Property</th><th>Value</th></tr></thead></tbody>");
        sb.append("<tr><td><code>isAbsolute()</code></td><td><code>").append(file.isAbsolute())
                .append("</code></td></tr>");
        if (file.exists()) {
            sb.append("<tr><td><code>isFile()</code></td><td><code>").append(file.isFile()).append("</code></td></tr>");
            sb.append("<tr><td><code>isDirectory()</code></td><td><code>").append(file.isDirectory())
                    .append("</code></td></tr>");
            sb.append("<tr><td><code>isHidden()</code></td><td><code>").append(file.isHidden())
                    .append("</code></td></tr>");
            sb.append("<tr><td>Permissions</td><td><pre>");
            boolean noPermissions = true;
            if (file.canRead()) {
                sb.append("readable\n");
                noPermissions = false;
            }
            if (file.canWrite()) {
                sb.append("writable\n");
                noPermissions = false;
            }
            if (file.canExecute()) {
                sb.append("executable");
                noPermissions = false;
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
