package jaehaerys.school.ui.panels;

import javax.swing.*;

public class DifficultyPanel extends GameModePanel {

    public DifficultyPanel() {
        super();
    }

    @Override
    public void createElements() {
        lblTitle = new JLabel("Difficulty");
        radioButtonPnl = new ConfigRadioButtonPanel(new String[]{"Easy", "Medium", "Hard"});
    }



}
