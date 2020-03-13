package jaehaerys.school.ui.panels;

import jaehaerys.school.ui.style.Style;

import javax.swing.*;
import java.awt.*;

public class ConfigRadioButtonPanel  extends JPanel{

    protected Style style = new Style();

    private final String[] choices;
    private JRadioButton firstChoiceRadioBtn,secondChoiceRadioBtn,thirdChoiceRadioBtn;
    private ButtonGroup bgConfig;

    public ConfigRadioButtonPanel(String[] choices) {
        this.choices = choices;
        configurePanel();
        createElements();
        addStyleToElements();
        addElementsToPanel();
    }


    public void configurePanel() {
        setLayout(new GridLayout(1,3));
        setBackground(style.BLACK);
    }


    public void addElementsToPanel() {
        add(firstChoiceRadioBtn);
        add(secondChoiceRadioBtn);
        add(thirdChoiceRadioBtn);
    }


    public void createElements() {
        firstChoiceRadioBtn = new JRadioButton(choices[0]);
        secondChoiceRadioBtn = new JRadioButton(choices[1]);
        thirdChoiceRadioBtn = new JRadioButton(choices[2]);
        makeRadioButtonGroup();
    }

    private void makeRadioButtonGroup() {
        bgConfig= new ButtonGroup();
        bgConfig.add(firstChoiceRadioBtn);
        bgConfig.add(secondChoiceRadioBtn);
        bgConfig.add(thirdChoiceRadioBtn);
    }


    public void addStyleToElements() {
        style.radioBtn(firstChoiceRadioBtn);
        style.radioBtn(secondChoiceRadioBtn);
        style.radioBtn(thirdChoiceRadioBtn);
    }
}
