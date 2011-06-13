package components;

import algorithms.DiffException;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.jdesktop.application.Action;

/**
 *
 * @author Fernanda Floriano Silva
 */
public class FileSelection extends javax.swing.JFrame {

    private JFileChooser fileChooser;

    /**
     * Creates new form FileSelection 
     */
    public FileSelection() {
        initComponents();
        setlaf();
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon("src/main/resources/components/icons/icon.png").getImage());
    }

    /**
     * Set Look and Feel
     */
    private void setlaf() {
        try {
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            } catch (Exception ex) {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }
        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        } catch (UnsupportedLookAndFeelException ex) {
        }
    }

    /**
     * Show About Box
     */
    @Action
    public void showAboutProject() {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new AboutILCS().setVisible(true);
            }
        });
    }

    /**
     * Show About Team
     */
    @Action
    public void showAboutTeam() {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new AboutTeam().setVisible(true);
            }
        });
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        fileTextField2 = new javax.swing.JTextField();
        file1 = new javax.swing.JLabel();
        file2 = new javax.swing.JLabel();
        fileTextField = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        closeButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        fileButton1 = new javax.swing.JButton();
        fileButton2 = new javax.swing.JButton();
        mainLabel = new javax.swing.JLabel();
        compareWith = new javax.swing.JLabel();
        aboutProject = new javax.swing.JToggleButton();
        aboutTeam = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("File Selection");

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(FileSelection.class);
        fileTextField2.setBackground(resourceMap.getColor("jTextField2.background")); // NOI18N
        fileTextField2.setText("Select directory or file for comparison...");
        fileTextField2.setName("fileTextField2"); // NOI18N

        file1.setText("Artifact : ");
        file1.setName("file1"); // NOI18N

        file2.setText("Artifact : ");
        file2.setName("file2"); // NOI18N

        fileTextField.setBackground(resourceMap.getColor("jTextField1.background")); // NOI18N
        fileTextField.setText("Select directory or file...");
        fileTextField.setName("fileTextField"); // NOI18N
        fileTextField.setRequestFocusEnabled(false);
        fileTextField.setSelectionColor(new java.awt.Color(0, 0, 51));

        jSeparator1.setName("jSeparator1"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance().getContext().getActionMap(FileSelection.class, this);
        closeButton.setAction(actionMap.get("close")); // NOI18N
        closeButton.setFont(new java.awt.Font("sansserif", 1, 12));
        closeButton.setIcon(resourceMap.getIcon("closeButton.icon")); // NOI18N
        closeButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        closeButton.setBorderPainted(false);
        buttonGroup.add(closeButton);
        closeButton.setName("closeButton"); // NOI18N

        okButton.setAction(actionMap.get("loadFiles")); // NOI18N
        okButton.setFont(new java.awt.Font("sansserif", 1, 12));
        okButton.setIcon(resourceMap.getIcon("okButton.icon")); // NOI18N
        okButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        okButton.setBorderPainted(false);
        buttonGroup.add(okButton);
        okButton.setName("okButton"); // NOI18N

        fileButton1.setAction(actionMap.get("findBasedArtifact")); // NOI18N
        fileButton1.setIcon(resourceMap.getIcon("fileButton1.icon")); // NOI18N
        fileButton1.setToolTipText(resourceMap.getString("fileButton1.toolTipText")); // NOI18N
        fileButton1.setBorder(null);
        buttonGroup.add(fileButton1);
        fileButton1.setContentAreaFilled(false);
        fileButton1.setName("fileButton1"); // NOI18N

        fileButton2.setAction(actionMap.get("findComparedArtifact")); // NOI18N
        fileButton2.setIcon(resourceMap.getIcon("fileButton2.icon")); // NOI18N
        fileButton2.setToolTipText(resourceMap.getString("fileButton2.toolTipText")); // NOI18N
        fileButton2.setBorder(null);
        fileButton2.setBorderPainted(false);
        buttonGroup.add(fileButton2);
        fileButton2.setContentAreaFilled(false);
        fileButton2.setName("fileButton2"); // NOI18N

        mainLabel.setFont(new java.awt.Font("sansserif", 1, 14));
        mainLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainLabel.setText("Comparable Artifacts Selection");
        mainLabel.setName("mainLabel"); // NOI18N

        compareWith.setFont(new java.awt.Font("sansserif", 1, 12));
        compareWith.setText("Compare with:");
        compareWith.setName("compareWith"); // NOI18N

        aboutProject.setAction(actionMap.get("showAboutProject")); // NOI18N
        aboutProject.setIcon(resourceMap.getIcon("aboutProject.icon")); // NOI18N
        aboutProject.setText(""); // NOI18N
        aboutProject.setToolTipText(resourceMap.getString("aboutProject.toolTipText")); // NOI18N
        aboutProject.setBorderPainted(false);
        aboutProject.setContentAreaFilled(false);
        aboutProject.setName("aboutProject"); // NOI18N

        aboutTeam.setAction(actionMap.get("showAboutTeam")); // NOI18N
        buttonGroup.add(aboutTeam);
        aboutTeam.setIcon(resourceMap.getIcon("aboutTeam.icon")); // NOI18N
        aboutTeam.setText("");
        aboutTeam.setToolTipText(resourceMap.getString("aboutTeam.toolTipText")); // NOI18N
        aboutTeam.setBorderPainted(false);
        aboutTeam.setContentAreaFilled(false);
        aboutTeam.setName("aboutTeam"); // NOI18N

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(file2)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(fileTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE))
                            .add(layout.createSequentialGroup()
                                .add(file1)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(fileTextField2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE))
                            .add(compareWith))
                        .add(18, 18, 18)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(fileButton2, 0, 0, Short.MAX_VALUE)
                            .add(fileButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 31, Short.MAX_VALUE))
                        .add(15, 15, 15))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(aboutProject, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 55, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(aboutTeam, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 53, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 179, Short.MAX_VALUE)
                        .add(closeButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 92, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(okButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 88, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(6, 6, 6)))
                .addContainerGap())
            .add(jSeparator1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(mainLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(16, 16, 16)
                .add(mainLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(fileButton1)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(fileTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(file2)))
                .add(12, 12, 12)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(layout.createSequentialGroup()
                        .add(compareWith)
                        .add(12, 12, 12)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(file1)
                            .add(fileTextField2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(fileButton2))
                .add(18, 18, 18)
                .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(aboutProject, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(aboutTeam, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                        .add(okButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                        .add(closeButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Find Based Artifact
     */
    @Action
    public void findBasedArtifact() {
        findFile(fileTextField);
    }

    /**
     * Find Compared Artifact
     */
    @Action
    public void findComparedArtifact() {
        findFile(fileTextField2);
    }

    /**
     * Find File
     * @param tField 
     */
    private void findFile(JTextField tField) {
        translateFileChooser();
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon("src/main/resources/components/icons/icon.png").getImage());


        fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("File Chooser");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        int resultado = fileChooser.showOpenDialog(this);
        if (resultado == JFileChooser.CANCEL_OPTION) {
            fileChooser.setVisible(false);
        } else {
            tField.setText(fileChooser.getSelectedFile().getAbsolutePath());
            tField.setForeground(Color.BLACK);
        }
    }

    /**
     * Load Files
     * @throws DiffException
     * @throws FileNotFoundException
     * @throws IOException 
     */
    @Action
    public void loadFiles() throws DiffException, FileNotFoundException, IOException {
        System.out.println("Load Files...");
        File artifact1 = new File(fileTextField.getText());
        File artifact2 = new File(fileTextField2.getText());

        if ((artifact1.isDirectory()) || (artifact2.isDirectory())) {
            showDDiff(artifact1, artifact2);
        } else {
            showILCS(artifact1, artifact2);
        }
        this.setVisible(false);

    }

    /**
     * Create and Show Gui
     */
    private static void createAndShowGUI() {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new FileSelection().setVisible(true);
            }
        });
    }

    /**
     * Main
     * @param args 
     */
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    /**
     * Show ILCS
     * @param baseFile
     * @param comparedFile
     * @throws DiffException
     * @throws FileNotFoundException
     * @throws IOException 
     */
    private void showILCS(File baseFile, File comparedFile) throws DiffException, FileNotFoundException, IOException {
        MainILCS ilcs = new MainILCS(baseFile, comparedFile);
        ilcs.setVisible(true);
    }

    /**
     * Show Diff
     * @param baseDirectory
     * @param comparedDirectory 
     */
    private void showDDiff(File baseDirectory, File comparedDirectory) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new MainDDiff().setVisible(true);
            }
        });
    }

    /**
     * Close
     */
    @Action
    public void close() {
        this.setVisible(false);
    }

    /**
     * Translate File Chooser
     */
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
    private javax.swing.JToggleButton aboutProject;
    private javax.swing.JToggleButton aboutTeam;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel compareWith;
    private javax.swing.JLabel file1;
    private javax.swing.JLabel file2;
    private javax.swing.JButton fileButton1;
    private javax.swing.JButton fileButton2;
    private javax.swing.JTextField fileTextField;
    private javax.swing.JTextField fileTextField2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables
}
