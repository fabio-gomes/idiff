package components;

import algorithms.Diff;
import algorithms.DiffException;
import algorithms.FileGrain;
import algorithms.Grain;
import algorithms.IResultDiff;
import algorithms.Result;
import java.awt.Cursor;
import java.awt.Dimension;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.JToolBar.Separator;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import org.jdesktop.application.Action;
import org.jdesktop.application.Application;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.layout.GroupLayout;
import org.jdesktop.layout.LayoutStyle;

/**
 *
 * @author Fernanda Floriano Silva
 */
public class MainILCS extends javax.swing.JFrame {

    private File basedFile;
    private File comparedFile;
    private IResultDiff result = new Result();

    /** Creates new form MainILCS */
    public MainILCS(File basedFile, File comparedFile) throws DiffException {
        initComponents();
        setlaf();
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon("src/main/resources/components/icons/icon.png").getImage());
        setFiles(basedFile, comparedFile);
    }

    private void cleanModel() {
        if ((DefaultTableModel) tableDetails.getModel() != null) {
            deleteRows();
        }
        ((DefaultTableModel) tableDetails.getModel()).removeTableModelListener(tableDetails);
        tableDetails.revalidate();
        tableDetails.repaint();
    }

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

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        exitDialog = new JDialog();
        noButton = new JButton();
        yesButton = new JButton();
        exitLabel = new JLabel();
        jLabel1 = new JLabel();
        mainButtonGroup = new ButtonGroup();
        toolBar = new JToolBar();
        jSeparator4 = new Separator();
        runMenuBar = new JButton();
        jSeparator1 = new Separator();
        fileSelectionMenuBar = new JButton();
        jSeparator3 = new Separator();
        overviewMenuBar = new JButton();
        jSeparator2 = new Separator();
        mainSplitPane = new JSplitPane();
        detailsScrollPane = new JScrollPane();
        detailsTextPane = new JTextPane();
        splitPaneUp = new JSplitPane();
        splitPaneLeft = new JSplitPane();
        dirScrollPane1 = new JScrollPane();
        dirTree1 = new JTree();
        dirScrollPane2 = new JScrollPane();
        dirTree2 = new JTree();
        splitPaneRight = new JSplitPane();
        baseFileScrollPane = new JScrollPane();
        baseFileEditorPane = new JEditorPane();
        comparedFileScrollPane = new JScrollPane();
        comparedFileEditorPane = new JEditorPane();
        jScrollPane1 = new JScrollPane();
        tableDetails = new JTable();

        ResourceBundle bundle = ResourceBundle.getBundle("components/Bundle"); // NOI18N
        exitDialog.setTitle(bundle.getString("MainILCS.exitDialog.title")); // NOI18N

        noButton.setText(bundle.getString("MainILCS.noButton.text")); // NOI18N

        yesButton.setText(bundle.getString("MainILCS.yesButton.text")); // NOI18N

        exitLabel.setText(bundle.getString("MainILCS.exitLabel.text")); // NOI18N

        jLabel1.setIcon(new ImageIcon(getClass().getResource("/components/icons/icone_help.png"))); // NOI18N

        GroupLayout exitDialogLayout = new GroupLayout(exitDialog.getContentPane());
        exitDialog.getContentPane().setLayout(exitDialogLayout);
        exitDialogLayout.setHorizontalGroup(
            exitDialogLayout.createParallelGroup(GroupLayout.LEADING)
            .add(exitDialogLayout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .addPreferredGap(LayoutStyle.RELATED)
                .add(exitLabel, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.RELATED)
                .add(yesButton)
                .addPreferredGap(LayoutStyle.RELATED)
                .add(noButton)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        exitDialogLayout.setVerticalGroup(
            exitDialogLayout.createParallelGroup(GroupLayout.LEADING)
            .add(exitDialogLayout.createSequentialGroup()
                .add(exitDialogLayout.createParallelGroup(GroupLayout.LEADING)
                    .add(exitDialogLayout.createSequentialGroup()
                        .add(31, 31, 31)
                        .add(exitDialogLayout.createParallelGroup(GroupLayout.BASELINE)
                            .add(exitLabel)
                            .add(yesButton)
                            .add(noButton)))
                    .add(jLabel1))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle(bundle.getString("MainILCS.title")); // NOI18N
        setIconImages(null);
        setMinimumSize(new Dimension(1365, 700));
        setModalExclusionType(null);
        setName("frame"); // NOI18N
        setResizable(false);

        toolBar.setRollover(true);
        toolBar.setName("Menu Bar"); // NOI18N
        toolBar.add(jSeparator4);

        ActionMap actionMap = Application.getInstance().getContext().getActionMap(MainILCS.class, this);
        runMenuBar.setAction(actionMap.get("runProject")); // NOI18N
        ResourceMap resourceMap = Application.getInstance().getContext().getResourceMap(MainILCS.class);
        runMenuBar.setIcon(resourceMap.getIcon("runMenuBar.icon")); // NOI18N
        runMenuBar.setToolTipText(resourceMap.getString("runMenuBar.toolTipText")); // NOI18N
        runMenuBar.setBorder(null);
        mainButtonGroup.add(runMenuBar);
        runMenuBar.setContentAreaFilled(false);
        runMenuBar.setFocusable(false);
        runMenuBar.setHorizontalTextPosition(SwingConstants.CENTER);
        runMenuBar.setMaximumSize(new Dimension(60, 44));
        runMenuBar.setMinimumSize(new Dimension(60, 44));
        runMenuBar.setPreferredSize(new Dimension(60, 44));
        runMenuBar.setVerticalTextPosition(SwingConstants.BOTTOM);
        toolBar.add(runMenuBar);
        toolBar.add(jSeparator1);

        fileSelectionMenuBar.setAction(actionMap.get("fileSelection")); // NOI18N
        fileSelectionMenuBar.setIcon(resourceMap.getIcon("fileSelectionMenuBar.icon")); // NOI18N
        fileSelectionMenuBar.setToolTipText(resourceMap.getString("fileSelectionMenuBar.toolTipText")); // NOI18N
        mainButtonGroup.add(fileSelectionMenuBar);
        fileSelectionMenuBar.setContentAreaFilled(false);
        fileSelectionMenuBar.setFocusable(false);
        fileSelectionMenuBar.setHorizontalTextPosition(SwingConstants.CENTER);
        fileSelectionMenuBar.setVerticalTextPosition(SwingConstants.BOTTOM);
        toolBar.add(fileSelectionMenuBar);
        toolBar.add(jSeparator3);

        overviewMenuBar.setAction(actionMap.get("showDDiff")); // NOI18N
        overviewMenuBar.setIcon(resourceMap.getIcon("overviewMenuBar.icon")); // NOI18N
        overviewMenuBar.setToolTipText(resourceMap.getString("overviewMenuBar.toolTipText")); // NOI18N
        mainButtonGroup.add(overviewMenuBar);
        overviewMenuBar.setContentAreaFilled(false);
        overviewMenuBar.setFocusable(false);
        overviewMenuBar.setHorizontalTextPosition(SwingConstants.CENTER);
        overviewMenuBar.setVerticalTextPosition(SwingConstants.BOTTOM);
        toolBar.add(overviewMenuBar);
        toolBar.add(jSeparator2);

        mainSplitPane.setDividerLocation(500);
        mainSplitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        mainSplitPane.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        mainSplitPane.setOneTouchExpandable(true);

        detailsTextPane.setBorder(BorderFactory.createTitledBorder(bundle.getString("MainILCS.detailsTextPane.border.title"))); // NOI18N
        detailsScrollPane.setViewportView(detailsTextPane);

        mainSplitPane.setBottomComponent(detailsScrollPane);

        splitPaneUp.setBorder(BorderFactory.createEtchedBorder());
        splitPaneUp.setDividerLocation(200);
        splitPaneUp.setOneTouchExpandable(true);

        splitPaneLeft.setDividerLocation(230);
        splitPaneLeft.setOrientation(JSplitPane.VERTICAL_SPLIT);

        dirScrollPane1.setBorder(BorderFactory.createTitledBorder(bundle.getString("MainILCS.dirScrollPane1.border.title"))); // NOI18N

        dirTree1.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        DefaultMutableTreeNode treeNode1 = new DefaultMutableTreeNode("root");
        dirTree1.setModel(new DefaultTreeModel(treeNode1));
        dirScrollPane1.setViewportView(dirTree1);

        splitPaneLeft.setTopComponent(dirScrollPane1);

        dirScrollPane2.setBorder(BorderFactory.createTitledBorder(bundle.getString("MainILCS.dirScrollPane2.border.title"))); // NOI18N

        treeNode1 = new DefaultMutableTreeNode("root");
        dirTree2.setModel(new DefaultTreeModel(treeNode1));
        dirScrollPane2.setViewportView(dirTree2);

        splitPaneLeft.setRightComponent(dirScrollPane2);

        splitPaneUp.setLeftComponent(splitPaneLeft);

        splitPaneRight.setDividerLocation(560);
        splitPaneRight.setDividerSize(40);

        baseFileScrollPane.setBorder(BorderFactory.createTitledBorder(bundle.getString("MainILCS.baseFileScrollPane.border.title"))); // NOI18N

        baseFileEditorPane.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        baseFileScrollPane.setViewportView(baseFileEditorPane);

        splitPaneRight.setLeftComponent(baseFileScrollPane);

        comparedFileScrollPane.setBorder(BorderFactory.createTitledBorder(bundle.getString("MainILCS.comparedFileScrollPane.border.title"))); // NOI18N

        comparedFileEditorPane.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        comparedFileScrollPane.setViewportView(comparedFileEditorPane);

        splitPaneRight.setRightComponent(comparedFileScrollPane);

        splitPaneUp.setRightComponent(splitPaneRight);

        mainSplitPane.setLeftComponent(splitPaneUp);

        jScrollPane1.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        tableDetails.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Content", "Situation", "From", "To"
            }
        ));
        tableDetails.setToolTipText(bundle.getString("MainILCS.tableDetails.toolTipText")); // NOI18N
        tableDetails.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(tableDetails);
        tableDetails.getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableDetails.getColumnModel().getColumn(0).setHeaderValue(bundle.getString("MainILCS.tableDetails.columnModel.title1")); // NOI18N
        tableDetails.getColumnModel().getColumn(1).setHeaderValue(bundle.getString("MainILCS.tableDetails.columnModel.title0")); // NOI18N
        tableDetails.getColumnModel().getColumn(2).setHeaderValue(bundle.getString("MainILCS.tableDetails.columnModel.title2")); // NOI18N
        tableDetails.getColumnModel().getColumn(3).setHeaderValue(bundle.getString("MainILCS.tableDetails.columnModel.title3")); // NOI18N

        mainSplitPane.setBottomComponent(jScrollPane1);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.LEADING)
            .add(toolBar, GroupLayout.DEFAULT_SIZE, 1365, Short.MAX_VALUE)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(mainSplitPane, GroupLayout.DEFAULT_SIZE, 1353, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.RELATED)
                .add(mainSplitPane, GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startDiff(File basedFile, File comparedFile) throws DiffException {
        cleanModel();
        Grain grain = new FileGrain();
        loadTreeFiles(basedFile, comparedFile);
        Diff diff = new Diff(basedFile, comparedFile);
        result = diff.compare(grain);
        printLines(result.getGrainsFrom(), result.getGrainsTo(), result.getDifferences());
        result.cleanResult();

    }

    @Action
    public void runProject() throws DiffException {
        System.out.println("Run Project Action Executed");
        startDiff(getBasedFile(), getComparedFile());
    }

    @Action
    public void fileSelection() {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new FileSelection().setVisible(true);
            }
        });
    }

    @Action
    public void showDDiff() {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new MainDDiff().setVisible(true);
            }
        });
    }

    private void printLines(List<Grain> list1, List<Grain> list2, List<Grain> diferences) {
        Iterator<Grain> it1 = list1.iterator();
        Iterator<Grain> it2 = list2.iterator();
        while (it1.hasNext() || it2.hasNext()) {
            Grain grain1 = it1.next();
            Grain grain2 = it2.next();

            if (((grain1 != null) || (grain2 != null)) && (!grain1.getOriginalReference().equals(grain2.getOriginalReference()))) {
                ((DefaultTableModel) tableDetails.getModel()).addRow(new String[]{grain1.getGrain(), "MOVED", printReference(grain1.getOriginalReference()), printReference(grain2.getOriginalReference())});
            }
        }

        for (Iterator<Grain> it3 = diferences.iterator(); it3.hasNext();) {
            Grain grain = it3.next();
            if (grain != null) {
                if ((grain.getSituation()).equals(Grain.Situation.REMOVED)) {
                    ((DefaultTableModel) tableDetails.getModel()).addRow(new Object[]{grain.getGrain(), grain.getSituation(), printReference(grain.getOriginalReference()), "---"});
                } else {
                    ((DefaultTableModel) tableDetails.getModel()).addRow(new Object[]{grain.getGrain(), grain.getSituation(), "---", printReference(grain.getOriginalReference())});
                }
            }
        }

    }

    private String printReference(List<Integer> originalReference) {
        char level = 'F';
        String stringResult = "";
        for (Iterator<Integer> it = originalReference.iterator(); it.hasNext();) {
            int id = it.next();
            level = getGrainLevel(level);
            stringResult = stringResult + getNameGrainLevel(level) + " " + id + " ";
        }
        return stringResult;
    }

    private String getNameGrainLevel(char levelGrain) {
        switch (levelGrain) {
            case 'F':
                return "File";
            case 'L':
                return "Line";
            case 'W':
                return "Word";
            case 'C':
                return "Character";
            default:
                return "File";
        }
    }

    private char getGrainLevel(char levelGrain) {
        switch (levelGrain) {
            case 'F':
                return 'L';
            case 'L':
                return 'W';
            case 'W':
                return 'C';
            default:
                return 'F';
        }
    }

    private void setFiles(File basedFile, File comparedFile) {
        setBasedFile(basedFile);
        setComparedFile(comparedFile);
    }

    public File getBasedFile() {
        return basedFile;
    }

    public void setBasedFile(File basedFile) {
        this.basedFile = basedFile;
    }

    public File getComparedFile() {
        return comparedFile;
    }

    public void setComparedFile(File comparedFile) {
        this.comparedFile = comparedFile;
    }

    private void deleteRows() {
        for (int i = 0; i < ((DefaultTableModel) tableDetails.getModel()).getRowCount(); i++) {
            ((DefaultTableModel) tableDetails.getModel()).removeRow(0);
        }
    }

    private void loadTreeFiles(File basedFile, File comparedFile) {
        TreePath treePath1 = new TreePath(basedFile.getAbsolutePath());
        TreePath treePath2 = new TreePath(comparedFile.getAbsolutePath());
        loadTreePath(treePath1, treePath2);
    }

    public void loadTreePath(TreePath treePath1, TreePath treePath2) {
        //TODO IMPLEMENTAR
        
       
    }
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JEditorPane baseFileEditorPane;
    private JScrollPane baseFileScrollPane;
    private JEditorPane comparedFileEditorPane;
    private JScrollPane comparedFileScrollPane;
    private JScrollPane detailsScrollPane;
    private JTextPane detailsTextPane;
    private JScrollPane dirScrollPane1;
    private JScrollPane dirScrollPane2;
    private JTree dirTree1;
    private JTree dirTree2;
    private JDialog exitDialog;
    private JLabel exitLabel;
    private JButton fileSelectionMenuBar;
    private JLabel jLabel1;
    private JScrollPane jScrollPane1;
    private Separator jSeparator1;
    private Separator jSeparator2;
    private Separator jSeparator3;
    private Separator jSeparator4;
    private ButtonGroup mainButtonGroup;
    private JSplitPane mainSplitPane;
    private JButton noButton;
    private JButton overviewMenuBar;
    private JButton runMenuBar;
    private JSplitPane splitPaneLeft;
    private JSplitPane splitPaneRight;
    private JSplitPane splitPaneUp;
    private JTable tableDetails;
    private JToolBar toolBar;
    private JButton yesButton;
    // End of variables declaration//GEN-END:variables
}
