package jaehaerys.school.ui.actionlistener;

import jaehaerys.school.ui.ToggleSwitch;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwitchMode implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        ToggleSwitch toggleSwitch = (ToggleSwitch) e.getSource();
        toggleSwitch.changeMode();
    }

}
