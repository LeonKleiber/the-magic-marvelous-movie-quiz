package jaehaerys.school.gui;

import org.json.simple.JSONObject;

import javax.swing.*;
import java.awt.*;

public class ConfigView extends View {

    private JPanel pnlTopic, pnlDifficulty, pnlRbTopic, pnlRbDifficulty;
    private JButton btnSubmit;
    private JLabel lblTopic, lblDifficulty;
    private JRadioButton rbMarvel, rbPotter, rbStarWars, rbEasy, rbMedium, rbHard;


    public ConfigView(ChangeView changeView) {
        super("Config", changeView);
        setLayout(new GridLayout(3, 1));

        pnlTopic = new JPanel();
        pnlTopic.setLayout(new GridLayout(2, 1));
        pnl(pnlTopic);


        lblTopic = new JLabel();
        title(lblTopic);

        pnlRbTopic = new JPanel();
        pnlRbTopic.setLayout(new GridLayout(1, 3));
        pnl(pnlRbTopic);

        rbMarvel = new JRadioButton("MCU");
        radioBtn(rbMarvel);
        rbPotter = new JRadioButton("Harry Potter");
        radioBtn(rbPotter);
        rbStarWars = new JRadioButton("Star Wars");
        radioBtn(rbStarWars);

        pnlRbTopic.add(rbMarvel);
        pnlRbTopic.add(rbPotter);
        pnlRbTopic.add(rbStarWars);
        createButtonGroup(new JRadioButton[]{rbMarvel, rbPotter, rbStarWars});

        pnlTopic.add(lblTopic);
        pnlTopic.add(pnlRbTopic);

        pnlDifficulty = new JPanel();
        pnlDifficulty.setLayout(new GridLayout(2, 1));
        pnl(pnlDifficulty);


        lblDifficulty = new JLabel();
        title(lblDifficulty);

        pnlRbDifficulty = new JPanel();
        pnlRbDifficulty.setLayout(new GridLayout(1, 3));
        pnl(pnlRbDifficulty);

        rbEasy = new JRadioButton();
        radioBtn(rbEasy);
        rbMedium = new JRadioButton("Medium");
        radioBtn(rbMedium);
        rbHard = new JRadioButton("Hard");
        radioBtn(rbHard);

        pnlRbDifficulty.add(rbEasy);
        pnlRbDifficulty.add(rbMedium);
        pnlRbDifficulty.add(rbHard);
        createButtonGroup(new JRadioButton[]{rbEasy, rbMedium, rbHard});

        pnlDifficulty.add(lblDifficulty);
        pnlDifficulty.add(pnlRbDifficulty);


        btnSubmit = new JButton("Submit");
        btnSubmit.addActionListener(this.changeView);
        submitBtn(btnSubmit);

        add(pnlTopic);
        add(pnlDifficulty);
        add(btnSubmit);
    }

    private void createButtonGroup(JRadioButton[] radioButtons) {
        ButtonGroup bg = new ButtonGroup();
        for (JRadioButton rb : radioButtons) bg.add(rb);
    }

    @Override
    public void setContent(Language language) {
        JSONObject content = getContent(language);

        lblTopic.setText((String) content.get("topic"));
        lblDifficulty.setText((String) content.get("difficulty"));
        rbEasy.setText((String) content.get("easy"));
        rbMedium.setText((String) content.get("medium"));
        rbHard.setText((String) content.get("hard"));
        btnSubmit.setText((String) content.get("submit"));

    }
}
