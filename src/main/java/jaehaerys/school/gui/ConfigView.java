package jaehaerys.school.gui;

import jaehaerys.school.logic.QuestionConfig;
import jaehaerys.school.logic.SelectRb;
import org.json.simple.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfigView extends View implements ActionListener {

    private JPanel pnlTopic, pnlDifficulty, pnlRbTopic, pnlRbDifficulty;
    private JButton btnSubmit;
    private JLabel lblTopic, lblDifficulty;
    private JRadioButton rbMarvel, rbPotter, rbEasy, rbMedium, rbHard;


    public ConfigView(ChangeView changeView, Style style) {
        super("Config", changeView);
        setLayout(new GridLayout(3, 1));

        pnlTopic = new JPanel();
        pnlTopic.setLayout(new GridLayout(2, 1));

        lblTopic = new JLabel();

        pnlRbTopic = new JPanel();
        pnlRbTopic.setLayout(new GridLayout(1, 3));

        rbMarvel = new JRadioButton("MCU");
        rbMarvel.addActionListener(new SelectRb(style,this));
        rbPotter = new JRadioButton("Harry Potter");
        rbPotter.addActionListener(new SelectRb(style,this));

        pnlRbTopic.add(rbMarvel);
        pnlRbTopic.add(rbPotter);
        createButtonGroup(new JRadioButton[]{rbMarvel, rbPotter});

        pnlTopic.add(lblTopic);
        pnlTopic.add(pnlRbTopic);

        pnlDifficulty = new JPanel();
        pnlDifficulty.setLayout(new GridLayout(2, 1));

        lblDifficulty = new JLabel();

        pnlRbDifficulty = new JPanel();
        pnlRbDifficulty.setLayout(new GridLayout(1, 3));

        rbEasy = new JRadioButton();
        rbEasy.addActionListener(new SelectRb(style,this));
        rbMedium = new JRadioButton("Medium");
        rbMedium.addActionListener(new SelectRb(style,this));
        rbHard = new JRadioButton("Hard");
        rbHard.addActionListener(new SelectRb(style,this));

        pnlRbDifficulty.add(rbEasy);
        pnlRbDifficulty.add(rbMedium);
        pnlRbDifficulty.add(rbHard);
        createButtonGroup(new JRadioButton[]{rbEasy, rbMedium, rbHard});

        pnlDifficulty.add(lblDifficulty);
        pnlDifficulty.add(pnlRbDifficulty);


        btnSubmit = new JButton("Submit");
        btnSubmit.addActionListener(this);

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

    @Override
    public void setStyle(Style style) {
        style.pnl(this);
        style.pnl(pnlTopic);
        style.title(lblTopic);
        style.pnl(pnlRbTopic);
        style.rb(rbMarvel);
        style.rb(rbPotter);
        style.pnl(pnlDifficulty);
        style.title(lblDifficulty);
        style.pnl(pnlRbDifficulty);
        style.rb(rbEasy);
        style.rb(rbMedium);
        style.rb(rbHard);
        style.submit(btnSubmit);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String topic = "";
        if (rbMarvel.isSelected()) {
            topic = "mcu";
        } else if (rbPotter.isSelected()) {
            topic = "hp";
        }
        int difficulty = 0;
        if (rbEasy.isSelected()) {
            difficulty = 1;
        } else if (rbMedium.isSelected()) {
            difficulty = 2;
        } else if (rbHard.isSelected()) {
            difficulty = 3;
        }

        if (!topic.equals("") && difficulty != 0) {
            QuestionConfig.setTopic(topic);
            QuestionConfig.setLevel(difficulty);
            changeView.actionPerformed(e);
        }
    }
}
