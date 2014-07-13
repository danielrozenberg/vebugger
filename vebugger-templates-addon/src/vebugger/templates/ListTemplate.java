package vebugger.templates;

import java.util.List;

import vebugger.VebuggerTemplate;
import vebugger.VisualDebuggerAid;

public class ListTemplate extends VebuggerTemplate {

    @Override
    public Class<?> getType() {
        return List.class;
    }

    @Override
    public void render(StringBuilder sb, Object obj) {
        List<?> list = (List<?>) obj;
        sb.append(VisualDebuggerAid.toString(list.toArray(), false));
    }

}
