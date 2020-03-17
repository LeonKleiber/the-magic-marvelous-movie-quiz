package jaehaerys.school.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ResultView extends View {

    JSlider slider;
    JTable table;
    JScrollPane tableScrollBar;
    JButton btnRestart;

    public ResultView(ChangeView changeView) {
        super("Result", changeView);
        GridLayout layout = new GridLayout(3, 1);
        setLayout(layout);

        slider = new JSlider(JSlider.HORIZONTAL, 0, 10, 8);
        slider(slider);

        table = new JTable();
        Object[][] data = {
            {"1", "What color is Thanos", "Purple"},
            {"8", "How manny Avengers were in the first movie?", "6"},

        };
        table.setModel(new DefaultTableModel(data, new String[]{"Question Number", "Question", "Answer"}));
        table(table);

        tableScrollBar = new JScrollPane(table);
        tableScrollBar.getViewport().setBackground(BLACK);
        tableScrollBar.setBackground(BLACK);
        tableScrollBar.setBorder(NO_BORDER);

        btnRestart = new JButton("Restart");
        btnRestart.addActionListener(changeView);
        bigBtn(btnRestart);

        add(slider);
        add(tableScrollBar);
        add(btnRestart);
    }
}
