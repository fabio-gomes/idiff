package components;

import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.UIManager;

/**
 *
 * @author Fernanda Floriano Silva
 */
public class File extends javax.swing.JFrame {

    /** Creates new form File */
    public File() {
        translateFileChooser();
        initComponents();
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon("src/main/resources/components/icons/icon.png").getImage());

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("File Selection");

        fileChooser.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        fileChooser.setName("fileChooser"); // NOI18N
        fileChooser.setOpaque(false);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(fileChooser, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(fileChooser, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new File().setVisible(true);
            }
        });
    }

    private void OpenActionPerformed(java.awt.event.ActionEvent evt) {
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            java.io.File selectedFile = fileChooser.getSelectedFile();
        } else {
            System.out.println("File access cancelled by user.");
        }
    }

    private void CloseActionPerformed(java.awt.event.ActionEvent evt) {
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.CANCEL_OPTION) {
            this.setVisible(false);
        } else {
            System.out.println("File access cancelled by user.");
        }
    }

    private void translateFileChooser() {
        UIManager.put("FileChooser.lookInLabelMnemonic", "L");
        UIManager.put("FileChooser.lookInLabelText", "Look in");
        UIManager.put("FileChooser.saveInLabelMnemonic", "I");
        UIManager.put("FileChooser.saveInLabelText", "Save in");
        UIManager.put("FileChooser.upFolderToolTipText", "Up Folder");
        UIManager.put("FileChooser.upFolderAccessibleName", "Up Folder");
        UIManager.put("FileChooser.homeFolderToolTipText", "Home Folder");
        UIManager.put("FileChooser.homeFolderAccessibleName", "Home Folder");
        UIManager.put("FileChooser.newFolderToolTipText", "New Folder");
        UIManager.put("FileChooser.newFolderAccessibleName", "New Folder");
        UIManager.put("FileChooser.listViewButtonToolTipText", "List View");
        UIManager.put("FileChooser.listViewButtonAccessibleName", "List View");
        UIManager.put("FileChooser.detailsViewButtonToolTipText", "Details");
        UIManager.put("FileChooser.detailsViewButtonAccessibleName", "Details");
        UIManager.put("FileChooser.fileNameLabelMnemonic", "N");
        UIManager.put("FileChooser.fileNameLabelText", "File Name");
        UIManager.put("FileChooser.filesOfTypeLabelMnemonic", "A");
        UIManager.put("FileChooser.filesOfTypeLabelText", "Files of Type");
        UIManager.put("FileChooser.fileNameHeaderText", "Name");
        UIManager.put("FileChooser.fileSizeHeaderText", "File Size");
        UIManager.put("FileChooser.fileTypeHeaderText", "File Type");
        UIManager.put("FileChooser.fileDateHeaderText", "File Date");
        UIManager.put("FileChooser.fileAttrHeaderText", "File Attr");
        UIManager.put("FileChooser.cancelButtonText", "Cancel");
        UIManager.put("FileChooser.cancelButtonMnemonic", "C");
        UIManager.put("FileChooser.cancelButtonToolTipText", "Cancel");
        UIManager.put("FileChooser.openButtonText", "Open");
        UIManager.put("FileChooser.openButtonMnemonic", "O");
        UIManager.put("FileChooser.openButtonToolTipText", "Open");
        UIManager.put("FileChooser.saveButtonText", "Save");
        UIManager.put("FileChooser.saveButtonToolTipText", "S");
        UIManager.put("FileChooser.saveButtonToolTipText", "Save");
        UIManager.put("FileChooser.updateButtonText", "Update");
        UIManager.put("FileChooser.updateButtonToolTipText", "U");
        UIManager.put("FileChooser.updateButtonToolTipText", "Update");
        UIManager.put("FileChooser.helpButtonText", "Help");
        UIManager.put("FileChooser.helpButtonToolTipText", "H");
        UIManager.put("FileChooser.helpButtonToolTipText", "Help");
        UIManager.put("FileChooser.acceptAllFileFilterText", "All files");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser fileChooser;
    // End of variables declaration//GEN-END:variables
}
