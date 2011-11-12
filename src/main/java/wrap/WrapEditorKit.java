package wrap;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.ViewFactory;

/**
 * 
 * @author Fernanda Floriano Silva
 */
@SuppressWarnings("serial")
public class WrapEditorKit extends StyledEditorKit {

    private ViewFactory defaultFactory = new WrapColumnFactory();

    @Override
    public ViewFactory getViewFactory() {
        return getDefaultFactory();
    }

    @Override
    public MutableAttributeSet getInputAttributes() {
        MutableAttributeSet mAttrs = super.getInputAttributes();
        mAttrs.removeAttribute("line_break_attribute");
        return mAttrs;
    }

    /**
     * @return the defaultFactory
     */
    public ViewFactory getDefaultFactory() {
        return defaultFactory;
    }

    /**
     * @param defaultFactory the defaultFactory to set
     */
    public void setDefaultFactory(ViewFactory defaultFactory) {
        this.defaultFactory = defaultFactory;
    }
}
