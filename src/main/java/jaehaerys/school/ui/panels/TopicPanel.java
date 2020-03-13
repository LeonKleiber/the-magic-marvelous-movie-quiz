package jaehaerys.school.ui.panels;


import javax.swing.*;

public class TopicPanel extends GameModePanel {

    public TopicPanel(){
        super();
    }

    @Override
    public void createElements() {
        lblTitle = new JLabel("Topics");
        radioButtonPnl = new ConfigRadioButtonPanel(new String[]{"MCU", "Harry Potter", "Star Wars"});
    }

}
