package jaehaerys.school.logic;

import jaehaerys.school.gui.Style;
import jaehaerys.school.gui.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectRb implements ActionListener {
    private Style style;
    private View view;

    public SelectRb(Style style, View view){
        this.style = style;
        this.view = view;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        view.setStyle(style);
    }
}
