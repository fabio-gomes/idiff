package idiff.resources;

import ilcs.grain.GrainBean;
import gui.components.resources.GrainHighLight;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

/**
 *
 * @author Fernanda Floriano Silva
 */
public class Listener {

    /**
     * Set Mouse Adapter
     * @param paneFrom
     * @param paneTo
     * @param leftScrollPane
     * @param rightScrollPane  
     */
    public static void setMouseAdapter(final JTextPane paneFrom, final JTextPane paneTo, final JScrollPane leftScrollPane, final JScrollPane rightScrollPane) {
        paneFrom.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                GrainHighLight.removeAllHighLight(paneFrom, paneTo);
                Scroll.adjustmentScroll(leftScrollPane, rightScrollPane);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                GrainHighLight.removeAllHighLight(paneFrom, paneTo);
                Scroll.adjustmentScroll(leftScrollPane, rightScrollPane);

            }
        });
    }

    public static void setMouseAdapter(final JTextPane pane) {
        pane.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                GrainHighLight.removeHighLight(pane);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                GrainHighLight.removeHighLight(pane);
            }
        });
    }

    /**
     * Set Mouse Motion
     * @param paneFrom
     * @param grainBeanFrom
     * @param grainBeanTo
     * @param paneTo
     * @param leftScrollPane
     * @param rightScrollPane  
     */
    public static void setMouseMotion(final JTextPane paneFrom, final GrainBean grainBeanFrom, final GrainBean grainBeanTo, final JTextPane paneTo, final JScrollPane leftScrollPane, final JScrollPane rightScrollPane) {
        paneFrom.addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent e) {
                Scroll.adjustmentScroll(leftScrollPane, rightScrollPane);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                Scroll.removeAdjustmentScroll(leftScrollPane, rightScrollPane);
                Point pt = new Point(e.getX(), e.getY());
                GrainHighLight.setHighLightPoint(pt, grainBeanFrom, paneFrom, grainBeanTo, paneTo);
            }
        });
    }

    public static void setMouseMotion(final JTextPane pane, final GrainBean grainBean, final Color color, final String fileName) {
        pane.addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent e) {
                GrainHighLight.removeHighLight(pane);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                Point pt = new Point(e.getX(), e.getY());
                GrainHighLight.setHighLightPoint(pt, grainBean, pane);

                if (verifyStart(pt) && verifyEnd(pt)) {
                    pane.setToolTipText(fileName);
                }
            }

            private boolean verifyEnd(Point pt) {
                return pane.viewToModel(pt) <= grainBean.getStartPosition() + grainBean.getLength();
            }

            private boolean verifyStart(Point pt) {
                return grainBean.getStartPosition() <= pane.viewToModel(pt);
            }
        });
    }

    /**
     * 
     * @param paneFrom
     * @param paneTo
     * @param leftScrollPane
     * @param rightScrollPane 
     */
    public static void cleanMouseListener(final JTextPane paneFrom, final JTextPane paneTo, final JScrollPane leftScrollPane, final JScrollPane rightScrollPane) {
        paneFrom.addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent e) {
                GrainHighLight.removeAllHighLight(paneFrom, paneTo);
                Scroll.adjustmentScroll(leftScrollPane, rightScrollPane);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                Scroll.removeAdjustmentScroll(leftScrollPane, rightScrollPane);
                GrainHighLight.removeAllHighLight(paneFrom, paneTo);
            }
        });
    }

    public static void cleanMouseListener(final JTextPane pane) {
        pane.addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent e) {
                GrainHighLight.removeHighLight(pane);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                GrainHighLight.removeHighLight(pane);
                pane.setToolTipText(null);
            }
        });
    }
}