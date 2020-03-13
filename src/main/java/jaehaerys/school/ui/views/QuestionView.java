package jaehaerys.school.ui.views;

import jaehaerys.school.ui.actionlistener.ChangeView;
import jaehaerys.school.ui.panels.View;

import javax.swing.*;
import java.awt.*;

public class QuestionView extends View {

    private JLabel questionLbl;
    private JRadioButton firstChoice, secondChoice, thirdChoice;
    private JButton btnNext;


    public QuestionView() {
        super("Question");
    }

    @Override
    public void configurePanel() {
        setLayout(new GridLayout(5,1));
    }

    @Override
    public void addElementsToPanel() {
        add(questionLbl);
        add(firstChoice);
        add(secondChoice);
        add(thirdChoice);
        add(btnNext);
    }

    @Override
    public void createElements() {
        questionLbl = new JLabel("<html>1. What is the color of Thanos skin?</html>");
        firstChoice = new JRadioButton("Purple");
        secondChoice = new JRadioButton("Orange");
        thirdChoice = new JRadioButton("Red");
        btnNext = new JButton();
        btnNext.addActionListener(new ChangeView("Result"));

    }

    @Override
    public void addStyleToElements() {
        style.question(questionLbl);
        style.radioBtn(firstChoice);
        style.radioBtn(secondChoice);
        style.radioBtn(thirdChoice);
        style.submitBtn(btnNext);
    }

    @Override
    protected void setContent() {
        btnNext.setText((String) language.get("btnNext"));
    }
}
