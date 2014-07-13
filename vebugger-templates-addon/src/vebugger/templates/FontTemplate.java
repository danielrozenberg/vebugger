package vebugger.templates;

import java.awt.Font;

import vebugger.VebuggerTemplate;

public class FontTemplate extends VebuggerTemplate {

    @Override
    public Class<?> getType() {
        return Font.class;
    }

    @Override
    public void render(StringBuilder sb, Object obj) {
        Font font = (Font) obj;
        sb.append("<p style=\"font-family: ").append(font.getName()).append("; font-size: ").append(font.getSize())
                .append(';');
        if (font.isBold()) {
            sb.append(" font-weight: bold;");
        }
        if (font.isItalic()) {
            sb.append(" font-style: italic;");
        }
        sb.append("\">The quick brown fox jumps over the lazy dog (").append(font.getName()).append(' ')
                .append(font.getSize()).append(")</p>");
    }

}
