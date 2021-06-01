package jaehaerys.school.gui;

import jaehaerys.school.logic.SelectRb;
import org.json.simple.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsView extends View implements ActionListener {

    private JPanel pnlDarkMode, pnlLanguage, pnlToggleBtn;
    private JButton btnHome;
    private JLabel lblLanguage, lblDarkMode, lblOn, lblOff;
    private JRadioButton rbEnglish, rbGerman;
    private ButtonGroup bgLanguages;
    private ToggleSwitch toggleSwitch;
    private Language language;
    private Style style;

    public SettingsView(ChangeView changeView, Language l, Style style) {
        super("Settings", changeView);
        setLayout(new GridLayout(3, 1));
        language = l;
        this.style = style;

        pnlDarkMode = new JPanel();
        pnlDarkMode.setLayout(new GridLayout(2, 1));


        lblDarkMode = new JLabel("Dark Mode");


        pnlToggleBtn = new JPanel();


        lblOff = new JLabel();


        toggleSwitch = new ToggleSwitch();
        toggleSwitch.addActionListener(toggleSwitch);


        lblOn = new JLabel();


        pnlToggleBtn.add(lblOff);
        pnlToggleBtn.add(toggleSwitch);
        pnlToggleBtn.add(lblOn);

        pnlDarkMode.add(lblDarkMode);
        pnlDarkMode.add(pnlToggleBtn);

        pnlLanguage = new JPanel();
        pnlLanguage.setLayout(new GridLayout(3, 1));


        lblLanguage = new JLabel();


        rbEnglish = new JRadioButton("English");
        rbEnglish.setSelected(true);
        rbEnglish.addActionListener(new SelectRb(this.style, this));

        rbGerman = new JRadioButton("Deutsch");
        rbGerman.addActionListener(new SelectRb(this.style, this));

        makeRadioButtonGroup();

        pnlLanguage.add(lblLanguage);
        pnlLanguage.add(rbEnglish);
        pnlLanguage.add(rbGerman);

        btnHome = new JButton();
        btnHome.addActionListener(this);


        add(pnlDarkMode);
        add(pnlLanguage);
        add(btnHome);
    }

    private void makeRadioButtonGroup() {
        bgLanguages = new ButtonGroup();
        bgLanguages.add(rbEnglish);
        bgLanguages.add(rbGerman);
    }


    @Override
    public void setContent(Language language) {
        JSONObject content = getContent(language);
        lblLanguage.setText((String) content.get("language"));
        lblOff.setText((String) content.get("off"));
        lblOn.setText((String) content.get("on"));
        btnHome.setText((String) content.get("home"));
    }

    @Override
    public void setStyle(Style style) {
        style.pnl(this);
        style.pnl(pnlDarkMode);
        style.title(lblDarkMode);
        style.pnl(pnlToggleBtn);
        style.onOff(lblOff);
        style.toggleSwitch(toggleSwitch);
        style.onOff(lblOn);
        style.pnl(pnlLanguage);
        style.title(lblLanguage);
        style.rb(rbEnglish);
        style.rb(rbGerman);
        style.submit(btnHome);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String language;
        if (rbEnglish.isSelected()) language = "en";
        else language = "de";


        this.language.setLanguage(language);

        if (toggleSwitch.isDarkMode()) style.setMode(true);
        else style.setMode(false);

        changeView.actionPerformed(e);
    }


}
