package components;

import details.Icon;
import details.Laf;
import diretorioDiff.resultados.ResultadoArquivo;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import wrap.Wrap;

/**
 *
 * @author Fernanda Floriano Silva
 */
@SuppressWarnings("serial")
public class MainFDiff extends javax.swing.JFrame {

    private FileComponent fileComponent = new FileComponent();
    private static MainFDiff instance;

    public static MainFDiff setInstance(File file, ResultadoArquivo result) {
        if (instance != null) {
            instance.dispose();
        }
        instance = new MainFDiff(file, result);
        return instance;
    }

    /** Creates new form FileOverView
     * @param file
     * @param result  
     */
    public MainFDiff(File file, ResultadoArquivo result) {
        initComponents();
        Laf.setlaf();
        setLocationRelativeTo(null);
        setIconImage(Icon.getIcon());

        try {
            init(file);
            showResult(result);
        } catch (MalformedURLException ex) {
            Logger.getLogger(MainFDiff.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainFDiff.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void init(File file) throws MalformedURLException, IOException {
        new Wrap().setWrapPane(pane);
        fileComponent.submitFile(file, pane);
        panel.setBorder(BorderFactory.createTitledBorder(file.getName()));
    }

    private void showResult(ResultadoArquivo result) {
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pane = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("File Overview");

        panel.setBorder(javax.swing.BorderFactory.createTitledBorder("File Name"));
        panel.setName("panel"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        pane.setName("pane"); // NOI18N
        jScrollPane1.setViewportView(pane);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane pane;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
