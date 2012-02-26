package gui.components;

import idiff.experiments.XLSFile;
import ilcs.grain.Grain;
import ilcs.ILCSBean;
import java.awt.Color;
import java.util.Iterator;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFCell;

/**
 * TableComponent
 * @author Fernanda Floriano Silva
 */
public class TableComponent {

    /**
     * Constructor
     */
    public TableComponent() {
    }

    /**
     * Clean Model
     * @param tableDetails 
     */
    public void cleanTabelModel(JTable tableDetails) {
        if ((DefaultTableModel) tableDetails.getModel() != null) {
            deleteTableRows(tableDetails);
        }
        ((DefaultTableModel) tableDetails.getModel()).removeTableModelListener(tableDetails);
        tableDetails.revalidate();
        tableDetails.repaint();
    }

    /**
     * Print Lines
     * @param list1
     * @param list2
     * @param diferences 
     * @param tableDetails
     * @param ilcsb  
     */
    public void printTableLines(List<Grain> list1, List<Grain> list2, List<Grain> diferences, JTable tableDetails, ILCSBean ilcsb, XLSFile xls) {
        Iterator<Grain> it1 = list1.iterator();
        Iterator<Grain> it2 = list2.iterator();

        createLineTitle(xls, "Moves Retrieved");
        printMoves(it1, it2, tableDetails, ilcsb.getPerspective(), xls);

        if (ilcsb.getPerspective() == 1) {
            createLineTitle(xls, "Differences Retrieved");
            printDifferences(diferences, tableDetails, xls);
        }
        printNotFound(tableDetails);

        tableDetails.setCellSelectionEnabled(false);
        tableDetails.setRowSelectionAllowed(true);
    }

    private void createLineTitle(XLSFile xls, String title) {
        xls.createNextRow();
        HSSFCell cell = xls.getNewCell();
        cell.setCellValue(title);
        xls.createNextRow();
    }

    /**
     * Print Differences not found
     * @param tableDetails 
     */
    private void printNotFound(JTable tableDetails) {
        if (tableDetails.getRowCount() == 0) {
            ((DefaultTableModel) tableDetails.getModel()).addRow(new Object[]{" Differences not found ", "---", "---", "---"});
            tableDetails.setForeground(Color.RED);

        }
    }

    /**
     * Print differences
     * @param diferences
     * @param tableDetails 
     */
    private void printDifferences(List<Grain> diferences, JTable tableDetails, XLSFile xls) {
        for (Iterator<Grain> it = diferences.iterator(); it.hasNext();) {
            Grain grain = it.next();
            if (grain != null) {
                switch (grain.getSituation()) {
                    case REMOVED:
                        insertCell(xls, new Object[]{grain.getGrain(), grain.getSituation(), printTableReference(grain.getOriginalReference()), "---"});
                        ((DefaultTableModel) tableDetails.getModel()).addRow(new Object[]{grain.getGrain(), grain.getSituation(), printTableReference(grain.getOriginalReference()), "---"});
                        tableDetails.setForeground(Color.BLACK);
                        break;
                    case ADDED:
                        insertCell(xls, new Object[]{grain.getGrain(), grain.getSituation(), "---", printTableReference(grain.getOriginalReference())});
                        ((DefaultTableModel) tableDetails.getModel()).addRow(new Object[]{grain.getGrain(), grain.getSituation(), "---", printTableReference(grain.getOriginalReference())});
                        tableDetails.setForeground(Color.BLACK);
                        break;
                }
            }
        }
    }

    /**
     * Print Moves
     * @param it1
     * @param it2
     * @param tableDetails 
     */
    private void printMoves(Iterator<Grain> it1, Iterator<Grain> it2, JTable tableDetails, int perpective, XLSFile xls) {
        while (it1.hasNext() || it2.hasNext()) {
            Grain grain1 = it1.next();
            Grain grain2 = it2.next();

            if (verifyConditions(grain1, grain2, perpective)) {
                insertCell(xls, new String[]{grain1.getGrain(), "MOVED", printTableReference(grain1.getOriginalReference()), printTableReference(grain2.getOriginalReference())});
                ((DefaultTableModel) tableDetails.getModel()).addRow(new String[]{grain1.getGrain(), "MOVED", printTableReference(grain1.getOriginalReference()), printTableReference(grain2.getOriginalReference())});
                tableDetails.setForeground(Color.BLACK);
            }
        }
    }

    /**
     * 
     * @param grain1
     * @param grain2
     * @param perpective
     * @return boolean
     */
    private boolean verifyConditions(Grain grain1, Grain grain2, int perpective) {
        boolean condition = (grain1 != null) || (grain2 != null);
        if (perpective == 1) {
            return ((condition) && (((grain1.getIdIteration() != 1) && (grain2.getIdIteration() != 1))));
        } else {
            return condition;
        }
    }

    /**
     * Print Reference
     * @param originalReference
     * @return String
     */
    public String printTableReference(List<Integer> originalReference) {
        char level = 'F';
        String stringResult = "";
        for (Iterator<Integer> it = originalReference.iterator(); it.hasNext();) {
            int id = it.next();
            level = getGrainLevel(level);
            stringResult = stringResult + " - " + getNameGrainLevel(level) + " " + id;
        }
        return stringResult.substring(3);
    }

    /**
     * Get Name Grain Level
     * @param levelGrain
     * @return String
     */
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

    /**
     * Get Grain Level
     * @param levelGrain
     * @return char
     */
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

    /**
     * Delete Rows
     * @param tableDetails 
     */
    public void deleteTableRows(JTable tableDetails) {
        int rowCount = ((DefaultTableModel) tableDetails.getModel()).getRowCount();
        for (int i = 0; i < rowCount; i++) {
            ((DefaultTableModel) tableDetails.getModel()).removeRow(0);
        }
    }

    private void insertCell(XLSFile xls, Object[] contents) {
        xls.createNextRow();
        HSSFCell cell = xls.getNewCell();
        for (int i = 0; i < contents.length; i++) {
            cell.setCellValue(contents[i].toString());
            cell = xls.getNewCell();
        }

    }
}