package vebugger;

/**
 * A template that renders a class to HTML.
 */
public abstract class VebuggerTemplate {

    public VebuggerTemplate() {
    }

    /**
     * Returns the {@link Class} that this template handles.
     * 
     * @return the {@link Class} that this template handles
     */
    public abstract Class<?> getType();

    /**
     * Returns the HTML representation of the object obj.
     * 
     * This method should not return the &lt;html&gt; and &lt;body&gt; elements,
     * as these will be provided by the rendering aid.
     * 
     * @param sb
     *            the {@link StringBuilder} to work with
     * @param obj
     *            the object to render
     * 
     * @return a partial HTML representation of the passed object
     */
    public abstract void render(StringBuilder sb, Object obj);

}
