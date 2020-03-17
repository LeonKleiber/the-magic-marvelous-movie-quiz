package jaehaerys.school.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeView implements ActionListener {

    private MainFrame mainFrame;

    public ChangeView(MainFrame mF) {
        mainFrame = mF;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton actionBtn = (JButton) e.getSource();
        String view;
        String text = actionBtn.getText();
        switch (text) {
            case "Start":
                view = "Config";
                break;
            case "Settings":
                view = "Settings";
                break;
            case "Submit":
                view = "Question";
                break;
            case "See Result":
                view = "Result";
                break;
            case "Home":
            case "Restart":
            default:
                view = "Home";
                break;
        }
        mainFrame.changeViewTo(view);
    }
}
