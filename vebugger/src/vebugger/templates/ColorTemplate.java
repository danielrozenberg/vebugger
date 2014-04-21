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
        sb.append(
                "<table><tbody><tr><td rowspan=\"4\" style=\"background:url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAoAAAAKCAYAAACNMs+9AAAAGUlEQVQYlWNoaGj4j44ZsIGhoHCQOYcihQDTKHzPovZrygAAAABJRU5ErkJggg==) repeat; padding: 0\"><div style=\"width:100px; height:100px; background-color: #")
                .append(String.format("%06x", color.getRGB() & 0xffffff)).append("; opacity: ")
                .append(color.getAlpha() / 255.0)
                .append(";\"></div></td><td style=\"color: red\">Red</td><td style=\"color: red\">")
                .append(color.getRed())
                .append("</td></tr><tr><td style=\"color: green\">Green</td><td style=\"color: green\">")
                .append(color.getGreen())
                .append("</td></tr><tr><td style=\"color: blue\">Blue</td><td style=\"color: blue\">")
                .append(color.getBlue())
                .append("</td></tr><tr><td style=\"color: black\">Alpha</td><td style=\"color: black\">")
                .append(color.getAlpha()).append("</td></tr></tbody></table>");
    }

}
