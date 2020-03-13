package jaehaerys.school.ui.views;


import jaehaerys.school.ui.actionlistener.ChangeView;
import jaehaerys.school.ui.panels.Table;
import jaehaerys.school.ui.panels.View;

import javax.swing.*;
import java.awt.*;

public class ResultView extends View {

    JLabel title;
    JSlider slider;
    Table table;
    JScrollPane tableScrollBar;
    JButton btnRestart;


    public ResultView() {
        super("Result");
    }



    @Override
    public void configurePanel() {
        setLayout(new GridLayout(3,1));
    }

    @Override
    public void addElementsToPanel() {
        add(slider);
        add(tableScrollBar);
        add(btnRestart);
    }

    @Override
    public void createElements() {
        slider = new JSlider(JSlider.HORIZONTAL,0,10, 8);
        table = new Table();
        tableScrollBar = new JScrollPane(table.table);
        btnRestart = new JButton();
        btnRestart.addActionListener(new ChangeView("Home"));
    }

    @Override
    public void addStyleToElements() {
        style.slider(slider);
        style.table(table.table);
        tableScrollBar.setBackground(style.BLACK);
        style.bigBtn(btnRestart);
    }

    @Override
    protected void setContent() {
        btnRestart.setText((String) language.get("btnRestart"));
    }
}
