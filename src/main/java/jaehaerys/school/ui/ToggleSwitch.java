package jaehaerys.school.ui;

import javax.swing.*;

public class ToggleSwitch extends JToggleButton {

    private boolean darkMode =true;

    public ToggleSwitch() {
        super();
        setSwitchIcon();
    }

    public void changeMode() {
        darkMode = !darkMode;
        setSwitchIcon();
    }

    private void setSwitchIcon(){
        if (darkMode){
            setImageIcon("/images/switchOn.jpg");
        } else {
            setImageIcon("/images/switchOff.jpg");
        }
    };

    private void setImageIcon(String path) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            this.setIcon(new ImageIcon(imgURL));
        } else {
            System.err.println("Couldn't find file: " + path);
        }
    }

    public boolean isDarkMode() {
        return darkMode;
    }
}
