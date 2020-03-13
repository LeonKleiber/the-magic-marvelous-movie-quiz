package jaehaerys.school.ui.panels;

import javax.swing.*;
import java.awt.*;

public abstract class GameModePanel extends Panel {
    JLabel lblTitle;
    ConfigRadioButtonPanel radioButtonPnl;

    @Override
    public void configurePanel() {
        setLayout(new GridLayout(2,1));
    }

    @Override
    public void addElementsToPanel() {
        add(lblTitle);
        add(radioButtonPnl);
    }
    @Override
    public void addStyleToElements() {
        style.subtitle(lblTitle);
    }
}
