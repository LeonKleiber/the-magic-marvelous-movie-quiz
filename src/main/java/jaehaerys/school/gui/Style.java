package jaehaerys.school.gui;


import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Style {

    private final Color BLACK = new Color(30, 30, 30);
    private final Color RED = new Color(100, 30, 30);
    private final Color WHITE = new Color(190, 190, 190);
    private final Color BLUE = new Color(30, 30, 100);

    // Border
    private final Border NO_BORDER = new EmptyBorder(0, 0, 0, 0);
    // Font Size
    private final int BIG = 40;
    private final int MEDIUM = 20;
    private final int SMALL = 15;
    private Color background;
    private Color foreground;
    private Color selectedRb;
    private boolean darkMode;
    private MainFrame mF;

    public Style(MainFrame mF) {
        background = BLACK;
        foreground = WHITE;
        selectedRb = RED;
        darkMode = true;
        this.mF = mF;

    }


    public void setMode(boolean darkMode) {
        if (darkMode != this.darkMode) {
            changeMode();
        }
    }

    private void changeMode() {
        darkMode = !darkMode;
        if (darkMode) {
            background = BLACK;
            foreground = WHITE;
        } else {
            background = WHITE;
            foreground = BLACK;
        }
        selectedRb = RED;
        mF.updateStyle();
    }

    // Panel
    void pnl(JPanel pnl) {
        defaultStyle(pnl);
    }

    // Label
    private void centerLabel(JLabel lbl) {
        lbl.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void lbl(JLabel lbl) {
        defaultStyle(lbl);
        centerLabel(lbl);
    }

    void title(JLabel lbl) {
        lbl(lbl);
        setFontSize(lbl, BIG);
    }

    void question(JLabel lbl) {
        lbl(lbl);
        setFontSize(lbl, MEDIUM);
    }

    void onOff(JLabel lbl) {
        defaultStyle(lbl);
        setFontSize(lbl, SMALL);
    }

    private void btn(JButton btn) {
        btn.setBorder(NO_BORDER);
        defaultStyle(btn);
    }

    void menu(JButton btn) {
        btn(btn);
        setFontSize(btn, BIG);
    }

    void submit(JButton btn) {
        btn(btn);
        setFontSize(btn, MEDIUM);
    }


    private void centerRadioBtn(JRadioButton radioBtn) {
        radioBtn.setHorizontalAlignment(SwingConstants.CENTER);
    }

    void rb(JRadioButton rb) {
        setFontSize(rb, MEDIUM);
        centerRadioBtn(rb);
        defaultStyle(rb);
        rb.setIcon(new ImageIcon());
        if( rb.isSelected()){
            rb.setForeground(RED);
        }
    }


    void toggleSwitch(JToggleButton tb) {
        tb.setBorder(NO_BORDER);
    }

    //Slider
    void slider(JSlider slider) {
        slider.setMajorTickSpacing(1);
        slider.setPaintLabels(true);
        slider.setFocusable(false);
        slider.setEnabled(false);

        defaultStyle(slider);
    }

    //Table
    void table(JTable table) {
        defaultStyle(table);
        table.setBackground(background);

        table.setGridColor(foreground);
        table.setBorder(NO_BORDER);
        table.getColumnModel().getColumn(0).setPreferredWidth(20);
        table.getColumnModel().getColumn(1).setPreferredWidth(400);
        table.getColumnModel().getColumn(2).setPreferredWidth(90);
        table.setRowHeight(50);
        table.setGridColor(background);
        table.setTableHeader(null);
        table.setEnabled(false);
    }

    // ScrollPane
    void scrollPane(JScrollPane scroll) {
        defaultStyle(scroll);
        scroll.getViewport().setBackground(background);
        scroll.getViewport().getView().setBackground(background);
        scroll.setBorder(NO_BORDER);
    }

    // Over All
    private void setFontSize(JComponent component, int size) {
        component.setFont(new Font("Arial", Font.PLAIN, size));
    }

    private void defaultStyle(JComponent component) {
        component.setForeground(foreground);
        component.setBackground(background);
    }

    public Color getForeground() {
        return foreground;
    }

    public Color getSelectedRb() {
        return selectedRb;
    }
}
