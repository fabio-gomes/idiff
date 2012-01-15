package components;

import idiff.resources.Icon;
import idiff.resources.Laf;
import org.jdesktop.application.Action;

/**
 *
 * @author Fernanda Floriano Silva
 */
public class Error extends javax.swing.JDialog {

    private static final long serialVersionUID = 1L;

    /** Creates new form Error
     * @param parent
     * @param modal  
     */
    public Error(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        Laf.setlaf();
        initComponents();
        setLocationRelativeTo(null);
        setIconImage(Icon.getIcon());
    }

    /**
     * 
     * @param errorLabel 
     */
    public void setErrorLabel(String errorLabel) {
        this.errorLabel.setText(errorLabel);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        errorLabel = new javax.swing.JLabel();
        closeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Error");

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(Error.class);
        errorLabel.setFont(resourceMap.getFont("jLabel2.font")); // NOI18N
        errorLabel.setForeground(resourceMap.getColor("jLabel2.foreground")); // NOI18N
        errorLabel.setIcon(resourceMap.getIcon("jLabel2.icon")); // NOI18N
        errorLabel.setText("  Please enter a valid file ");
        errorLabel.setToolTipText(resourceMap.getString("errorLabel.toolTipText")); // NOI18N
        errorLabel.setName("errorLabel"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance().getContext().getActionMap(Error.class, this);
        closeButton.setAction(actionMap.get("closeError")); // NOI18N
        closeButton.setText(resourceMap.getString("jButton1.text")); // NOI18N
        closeButton.setToolTipText(resourceMap.getString("closeButton.toolTipText")); // NOI18N
        closeButton.setName("closeButton"); // NOI18N

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(errorLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, closeButton))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(errorLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(closeButton)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Close Error Frame
     */
    @Action
    public void closeError() {
        this.dispose();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel errorLabel;
    // End of variables declaration//GEN-END:variables
}
