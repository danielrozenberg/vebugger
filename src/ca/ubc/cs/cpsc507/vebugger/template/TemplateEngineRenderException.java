package ca.ubc.cs.cpsc507.vebugger.template;

public class TemplateEngineRenderException extends Exception {

    private static final long serialVersionUID = 7881260668906342318L;

    public TemplateEngineRenderException(String message, Throwable cause) {
        super(message, cause);
    }

    public TemplateEngineRenderException(Throwable cause) {
        super(cause);
    }

}
