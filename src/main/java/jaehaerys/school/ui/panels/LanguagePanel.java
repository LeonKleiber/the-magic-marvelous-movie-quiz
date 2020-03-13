package jaehaerys.school.ui.panels;

import javax.swing.*;
import java.awt.*;

public class LanguagePanel extends Panel{

    private JLabel lblTitle;
    private JRadioButton rbEnglish, rbGerman;
    private ButtonGroup bgLanguages;

    public LanguagePanel() {
        super();
    }


    @Override
    public void configurePanel() {
        setLayout(new GridLayout(3,1));
    }

    @Override
    public void addElementsToPanel(){
        add(lblTitle);
        add(rbEnglish);
        add(rbGerman);
    }

    @Override
    public void createElements(){
        lblTitle = new JLabel("Language:");
        rbEnglish = new JRadioButton("English");
        rbEnglish.setSelected(true);
        rbGerman = new JRadioButton("Deutsch");
        makeRadioButtonGroup();
    }

    private void makeRadioButtonGroup() {
        bgLanguages= new ButtonGroup();
        bgLanguages.add(rbEnglish);
        bgLanguages.add(rbGerman);
    }

    @Override
    public void addStyleToElements() {
        style.subtitle(lblTitle);
        style.radioBtn(rbEnglish);
        style.radioBtn(rbGerman);
    }

}
