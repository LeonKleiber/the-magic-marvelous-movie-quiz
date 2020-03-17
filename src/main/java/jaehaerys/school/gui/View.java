package jaehaerys.school.gui;

import org.json.simple.JSONObject;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public abstract class View extends JPanel {

    public static final Color BLACK = new Color(30, 30, 30);
    public static final Color WHITE = new Color(190, 190, 190);

    // Border
    final Border NO_BORDER = new EmptyBorder(0, 0, 0, 0);
    final Border THIN_WHITE_BORDER = new LineBorder(WHITE, 1);


    // Font Size
    private final int BIG = 40;
    private final int MEDIUM = 20;
    private final int SMALL = 15;

    String name;
    ChangeView changeView;

    public View(String name, ChangeView changeView) {
        this.name = name;
        this.changeView = changeView;
        setBackground(BLACK);
        setForeground(WHITE);
    }

    public String getName() {
        return name;
    }


    void pnl(JPanel pnl) {
        pnl.setBackground(BLACK);
        pnl.setForeground(WHITE);
    }

    private void text(JComponent component) {
        component.setForeground(WHITE);
    }

    void btn(JButton btn) {
        btn.setBorder(NO_BORDER);
        text(btn);
    }

    void bigBtn(JButton btn) {
        btn(btn);
        setFontSize(btn, BIG);
    }

    void title(JLabel lbl) {
        setFontSize(lbl, BIG);
        centerLabel(lbl);
        text(lbl);
    }

    void toggleSwitchLbl(JLabel lbl) {
        setFontSize(lbl, SMALL);
        text(lbl);
    }


    private void setFontSize(JComponent component, int size) {
        component.setFont(new Font("Arial", Font.PLAIN, size));
    }

    void radioBtn(JRadioButton radioBtn) {
        setFontSize(radioBtn, MEDIUM);
        centerRadioBtn(radioBtn);
        text(radioBtn);
    }

    void submitBtn(JButton btn) {
        btn(btn);
        setFontSize(btn, MEDIUM);
        btn.setSize(200, 100);
    }

    private void centerRadioBtn(JRadioButton radioBtn) {
        radioBtn.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void centerLabel(JLabel lbl) {
        lbl.setHorizontalAlignment(SwingConstants.CENTER);
    }


    void toggleSwitch(JToggleButton tb) {
        tb.setBorder(NO_BORDER);
    }

    void question(JLabel lbl) {
        setFontSize(lbl, MEDIUM);
        centerLabel(lbl);
        text(lbl);
    }

    void slider(JSlider slider) {
        slider.setMajorTickSpacing(1);
        slider.setPaintLabels(true);
        slider.setFocusable(false);
        slider.setEnabled(false);

        text(slider);
    }

    void table(JTable table) {
        table.setBackground(BLACK);
        text(table);
        table.setGridColor(WHITE);
        table.setBorder(THIN_WHITE_BORDER);
        table.getColumnModel().getColumn(0).setPreferredWidth(10);
        table.getColumnModel().getColumn(1).setPreferredWidth(400);
        table.getColumnModel().getColumn(2).setPreferredWidth(90);
        table.setRowHeight(50);
        table.setTableHeader(null);
        table.setEnabled(false);
    }

    public abstract void setContent(Language language);

    public JSONObject getContent(Language language) {
        return language.getViewContent(this.name);
    }
}

