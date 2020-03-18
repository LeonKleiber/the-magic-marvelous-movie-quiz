package jaehaerys.school.gui;

import jaehaerys.school.logic.QuestionConfig;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionView extends View implements ActionListener {

    private JLabel questionLbl;
    private JRadioButton firstChoice, secondChoice, thirdChoice;
    private JButton btnNext;
    private List<JSONObject> questions;
    private List<String[]> falseAnswers;
    private String rightOption;
    private int questionCounter;
    private JSONObject content;
    private ButtonGroup bgOptions;
    private String question;
    private ResultView resultView;

    public QuestionView(ChangeView changeView) {
        super("Question", changeView);

        setLayout(new GridLayout(5, 1));

        questionLbl = new JLabel();

        bgOptions = new ButtonGroup();

        firstChoice = new JRadioButton();
        secondChoice = new JRadioButton();
        thirdChoice = new JRadioButton();

        bgOptions.add(firstChoice);
        bgOptions.add(secondChoice);
        bgOptions.add(thirdChoice);

        btnNext = new JButton();
        btnNext.addActionListener(this);


        add(questionLbl, BorderLayout.NORTH);
        add(firstChoice);
        add(secondChoice);
        add(thirdChoice);
        add(btnNext, BorderLayout.SOUTH);


    }

    public void startQuestions(ResultView rv) {
        this.resultView = rv;
        questions = new QuestionConfig().loadQuestion();
        falseAnswers = new ArrayList<>();
        Collections.shuffle(questions);
        questionCounter = 0;
        nextQuestion();
        btnNext.setText((String) content.get("next"));
    }

    private void checkQuestion() {
        boolean answer = false;
        if (
            firstChoice.getText().equals(rightOption) && firstChoice.isSelected() ||
                secondChoice.getText().equals(rightOption) && secondChoice.isSelected() ||
                thirdChoice.getText().equals(rightOption) && thirdChoice.isSelected()
        ) {
            answer = true;
        }

        if (!answer) {
            falseAnswers.add(new String[]{"<html>" + questionCounter + "</html>", "<html>" + question + "</html>", "<html>" + rightOption + "</html>"});
        }
    }

    private void nextQuestion() {
        bgOptions.clearSelection();
        JSONObject question = questions.get(questionCounter);
        questionCounter++;
        this.question = (String) question.get("question");
        questionLbl.setText("<html><center>" + questionCounter + ") " + this.question + "</html>");
        JSONArray options = (JSONArray) question.get("options");
        Collections.shuffle(options);


        JSONObject firstOption = (JSONObject) options.get(0);
        String firstText = (String) firstOption.get("choice");
        if ((boolean) firstOption.get("correct")) {
            rightOption = firstText;
        }
        firstChoice.setText(firstText);

        JSONObject secondOption = (JSONObject) options.get(1);
        String secondText = (String) secondOption.get("choice");
        if ((boolean) secondOption.get("correct")) {
            rightOption = secondText;
        }
        secondChoice.setText(secondText);

        JSONObject thirdOption = (JSONObject) options.get(2);
        String thirdText = (String) thirdOption.get("choice");
        if ((boolean) thirdOption.get("correct")) {
            rightOption = thirdText;
        }
        thirdChoice.setText(thirdText);
    }

    @Override
    public void setContent(Language language) {
        this.content = getContent(language);

        btnNext.setText((String) content.get("next"));
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


    @Override
    public void actionPerformed(ActionEvent e) {

        if (null != bgOptions.getSelection()) {
            checkQuestion();
            if (questionCounter < 10) {
                nextQuestion();
                if (questionCounter == 10) {
                    btnNext.setText((String) content.get("result"));
                }
            } else {
                resultView.setData(falseAnswers);
                changeView.actionPerformed(e);
            }
        }
    }
}
