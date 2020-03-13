package jaehaerys.school.ui.panels;

import javax.swing.*;
import java.awt.*;

public class DarkModePanel extends Panel {

    private JLabel lblTitle;
    private ToggleButtonPanel tbDarkMode;

    public DarkModePanel() {
        super();
    }



    @Override
    public void configurePanel() {
        setLayout(new GridLayout(2,1));
    }

    @Override
    public void addElementsToPanel(){
        add(lblTitle);
        add(tbDarkMode);
    }


    @Override
    public void createElements(){
        lblTitle = new JLabel("Dark Mode:");
        tbDarkMode = new ToggleButtonPanel();
    }
    @Override
    public void addStyleToElements() {
        style.subtitle(lblTitle);
    }
}
