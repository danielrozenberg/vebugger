package vebugger.templates;

import org.apache.commons.lang3.StringEscapeUtils;

import vebugger.VebuggerTemplate;

public class CharSequenceTemplate extends VebuggerTemplate {

    @Override
    public Class<?> getType() {
        return CharSequence.class;
    }

    @Override
    public void render(StringBuilder sb, Object obj) {
        sb.append(StringEscapeUtils.escapeHtml4(obj.toString()));
    }

}
