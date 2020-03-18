package jaehaerys.school.gui;

import org.json.simple.JSONObject;

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


        table = new JTable();
        Object[][] data = {
            {"1", "What color is Thanos", "Purple"},
            {"8", "How manny Avengers were in the first movie?", "6"},

        };
        table.setModel(new DefaultTableModel(data, new String[]{"Question Number", "Question", "Answer"}));


        tableScrollBar = new JScrollPane(table);


        btnRestart = new JButton();
        btnRestart.addActionListener(changeView);

        add(slider);
        add(tableScrollBar);
        add(btnRestart);
    }

    @Override
    public void setContent(Language language) {
        JSONObject content = getContent(language);

        btnRestart.setText((String) content.get("restart"));
    }

    @Override
    public void setStyle(Style style) {
        style.pnl(this);
        style.slider(slider);
        style.table(table);
        style.scrollPane(tableScrollBar);
        style.submit(btnRestart);
    }
}
