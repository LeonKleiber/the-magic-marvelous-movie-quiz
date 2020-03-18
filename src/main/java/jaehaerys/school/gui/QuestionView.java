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

        firstChoice = new JRadioButton("Purple");


        secondChoice = new JRadioButton("Orange");


        thirdChoice = new JRadioButton("Red");


        btnNext = new JButton();
        btnNext.addActionListener(changeView);


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

    @Override
    public void setStyle(Style style) {
        style.pnl(this);
        style.question(questionLbl);
        style.rb(firstChoice);
        style.rb(secondChoice);
        style.rb(thirdChoice);
        style.submit(btnNext);
    }
}
