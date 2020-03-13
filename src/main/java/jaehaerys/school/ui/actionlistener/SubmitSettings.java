package jaehaerys.school.ui.actionlistener;

import jaehaerys.school.ui.MainFrame;
import jaehaerys.school.ui.ViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubmitSettings implements ActionListener {

    private MainFrame frame = ViewController.getMainFrame();
    private String view = "Home";

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.changeViewTo(view);
    }
}
