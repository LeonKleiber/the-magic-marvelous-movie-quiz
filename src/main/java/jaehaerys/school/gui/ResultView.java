package jaehaerys.school.gui;

import org.json.simple.JSONObject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ResultView extends View {

    JSlider slider;
    JTable table;
    JScrollPane tableScrollBar;
    JButton btnRestart;
    private Style style;

    public ResultView(ChangeView changeView) {
        super("Result", changeView);
        GridLayout layout = new GridLayout(3, 1);
        setLayout(layout);

        slider = new JSlider(JSlider.HORIZONTAL, 0, 10, 8);


        table = new JTable();
        table.setModel(new DefaultTableModel(new String[][]{
            {"1"}, {"1"}, {"1"}
        },
            new String[]{"Question Number", "Question", "Answer"}));
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
        this.style = style;
        style.pnl(this);
        style.slider(slider);
        style.table(table);
        style.scrollPane(tableScrollBar);
        style.submit(btnRestart);
    }

    public void setData(List<String[]> falseAnswers) {

        slider.setValue(10 - falseAnswers.size());

        String[][] tableData = new String[falseAnswers.size()][3];
        int i = 0;
        for (String[] falseAnswer : falseAnswers) {
            tableData[i] = falseAnswer;
            i++;
        }


        table.setModel(new DefaultTableModel(tableData,
            new String[]{"Question Number", "Question", "Answer"}));

        style.table(table);
    }
}
