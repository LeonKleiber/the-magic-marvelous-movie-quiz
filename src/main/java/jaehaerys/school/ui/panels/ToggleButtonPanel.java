package jaehaerys.school.ui.panels;

import jaehaerys.school.ui.ToggleSwitch;
import jaehaerys.school.ui.actionlistener.SwitchMode;

import javax.swing.*;

public class ToggleButtonPanel extends Panel {

    private JLabel lblOn, lblOff;
    private ToggleSwitch toggleSwitch;

    @Override
    public void configurePanel() { }

    @Override
    public void addElementsToPanel() {
        add(lblOff);
        add(toggleSwitch);
        add(lblOn);
    }

    @Override
    public void createElements() {
        lblOff = new JLabel("Off");
        toggleSwitch = new ToggleSwitch();
        toggleSwitch.addActionListener( new SwitchMode());
        lblOn = new JLabel("On");
    }

    @Override
    public void addStyleToElements() {
        style.toggleSwitchLbl(lblOff);
        style.toggleSwitch(toggleSwitch);
        style.toggleSwitchLbl(lblOn);
    }


}
