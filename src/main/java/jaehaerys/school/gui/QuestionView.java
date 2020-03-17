package jaehaerys.school.gui;

import org.json.simple.JSONObject;

import javax.swing.*;
import java.awt.*;

public class QuestionView extends View {

    private JLabel questionLbl;
    private JRadioButton firstChoice, secondChoice, thirdChoice;
    private JButton btnNext;

    public QuestionView(ChangeView changeView) {
        super("Question", changeView);
        setLayout(new GridLayout(5, 1));

        questionLbl = new JLabel("<html>My Question stays the Same what color is a Orange?</html>");
        question(questionLbl);

        firstChoice = new JRadioButton("Purple");
        radioBtn(firstChoice);

        secondChoice = new JRadioButton("Orange");
        radioBtn(secondChoice);

        thirdChoice = new JRadioButton("Red");
        radioBtn(thirdChoice);

        btnNext = new JButton();
        btnNext.addActionListener(changeView);
        submitBtn(btnNext);

        add(questionLbl, BorderLayout.NORTH);
        add(firstChoice);
        add(secondChoice);
        add(thirdChoice);
        add(btnNext, BorderLayout.SOUTH);

    }

    @Override
    public void setContent(Language language) {
        JSONObject content = getContent(language);

        btnNext.setText((String) content.get("result"));
    }
}
