package jaehaerys.school.ui.panels;

import javax.swing.*;

public class Table  {
    public JTable table;

    public Table(){
        Object[][] data = {
            {"1", "What color is Thanos", "Purple"},
            {"8", "How manny Avengers were in the first movie?", "6"},

        };
        table= new JTable(data, new String[]{"Question Number", "Question", "Answer"});
    }
}
