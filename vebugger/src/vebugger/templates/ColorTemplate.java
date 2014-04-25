package vebugger.templates;

import java.awt.Color;

import vebugger.VebuggerTemplate;

public class ColorTemplate extends VebuggerTemplate {

    @Override
    public Class<?> getType() {
        return Color.class;
    }

    @Override
    public void render(StringBuilder sb, Object obj) {
        Color color = (Color) obj;
        int hashCode = color.hashCode();

        sb.append("<style>");
        sb.append("table.java-awt-Color-")
                .append(hashCode)
                .append(" > tbody > tr > td.color {background:url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAoAAAAKCAYAAACNMs+9AAAAGUlEQVQYlWNoaGj4j44ZsIGhoHCQOYcihQDTKHzPovZrygAAAABJRU5ErkJggg==) repeat; padding: 0}");
        sb.append("table.java-awt-Color-").append(hashCode)
                .append(" tbody > tr > td.color > div {width:100px; height:100px; background-color: #")
                .append(String.format("%06x", color.getRGB() & 0xffffff)).append("; opacity: ")
                .append(color.getAlpha() / 255.0).append(";}");
        sb.append("table.java-awt-Color-").append(hashCode).append(" tbody > tr > td.value {font-family: monospace;}");
        sb.append("table.java-awt-Color-").append(hashCode).append(" tbody > tr > td.red {color: red;}");
        sb.append("table.java-awt-Color-").append(hashCode).append(" tbody > tr > td.green {color: green;}");
        sb.append("table.java-awt-Color-").append(hashCode).append(" tbody > tr > td.blue {color: blue;}");
        sb.append("table.java-awt-Color-").append(hashCode).append(" tbody > tr > td.alpha {color: black;}");
        sb.append("</style>");

        sb.append("<table class=\"java-awt-Color-")
                .append(hashCode)
                .append("\"><tbody><tr><td rowspan=\"4\" class=\"color\"><div></div></td><td class=\"value red\">Red</td><td class=\"value red\">")
                .append(color.getRed())
                .append("</td></tr><tr><td class=\"value green\">Green</td><td class=\"value green\">")
                .append(color.getGreen())
                .append("</td></tr><tr><td class=\"value blue\">Blue</td><td class=\"value blue\">")
                .append(color.getBlue())
                .append("</td></tr><tr><td class=\"value alpha\">Alpha</td><td class=\"value alpha\">")
                .append(color.getAlpha()).append("</td></tr></tbody></table>");
    }
}
