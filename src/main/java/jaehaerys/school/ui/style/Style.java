package jaehaerys.school.ui.style;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;


public class Style {

    //  Color
    public static final Color BLACK = new Color(30, 30, 30);
    public static final Color WHITE = new Color(190, 190, 190);


    public static final  Dimension DEFAULT_FRAME_SIZE = new Dimension(500,500);

    // Border
    private final Border NO_BORDER= new EmptyBorder(0,0,0,0);


    // Font Size
    private final int BIG = 40;
    private final int MEDIUM = 20;
    private final int SMALL = 15;

    private void text(JComponent component){
        component.setForeground(WHITE);
    }

    public void btn(JButton btn){
        btn.setBorder(NO_BORDER);
        text(btn);
    }

    public void bigBtn(JButton btn){
        btn(btn);
        setFontSize(btn,BIG);
    }

    public void subtitle(JLabel lbl){
        setFontSize(lbl, BIG);
        centerLabel(lbl);
        text(lbl);
    }
    public void toggleSwitchLbl(JLabel lbl) {
        setFontSize(lbl, SMALL);
        text(lbl);
    }


    private void setFontSize(JComponent component,int size){
        component.setFont(new Font("Arial", Font.PLAIN, size));
    }

    public void radioBtn(JRadioButton radioBtn) {
        setFontSize(radioBtn, MEDIUM);
        centerRadioBtn(radioBtn);
        text(radioBtn);
    }

    public void submitBtn(JButton btn) {
        btn(btn);
        setFontSize(btn, MEDIUM);
        btn.setSize(200, 100);
    }

    private void centerRadioBtn(JRadioButton radioBtn){
        radioBtn.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void centerLabel(JLabel lbl){
        lbl.setHorizontalAlignment(SwingConstants.CENTER);
    }


    public void toggleSwitch(JToggleButton tb) {
        tb.setBorder(NO_BORDER);
    }

    public void question(JLabel lbl) {
        setFontSize(lbl, MEDIUM);
        centerLabel(lbl);
        text(lbl);
    }

    public void slider(JSlider slider) {
        slider.setMajorTickSpacing(1);
        slider.setPaintLabels(true);
        slider.setFocusable(false);
        slider.setEnabled(false);
        
        text(slider);
    }

    public void table(JTable table) {
        table.setBackground(BLACK);
        text(table);
        table.setGridColor(BLACK);
        table.setBorder(NO_BORDER);
        table.getAutoResizeMode();
        table.getColumnModel().getColumn(0).setPreferredWidth(10);
        table.getColumnModel().getColumn(1).setPreferredWidth(400);
        table.getColumnModel().getColumn(2).setPreferredWidth(90);
        table.setRowHeight(50);
        table.setTableHeader(null);
        table.setEnabled(false);
        table.setAutoCreateColumnsFromModel(true);
    }
}
