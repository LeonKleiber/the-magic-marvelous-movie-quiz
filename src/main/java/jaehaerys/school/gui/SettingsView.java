package jaehaerys.school.gui;

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

    public SettingsView(ChangeView changeView, Language l) {
        super("Settings", changeView);
        setLayout(new GridLayout(3, 1));
        language = l;

        pnlDarkMode = new JPanel();
        pnlDarkMode.setLayout(new GridLayout(2, 1));
        pnl(pnlDarkMode);

        lblDarkMode = new JLabel("Dark Mode");
        title(lblDarkMode);

        pnlToggleBtn = new JPanel();
        pnl(pnlToggleBtn);

        lblOff = new JLabel();
        toggleSwitchLbl(lblOff);

        toggleSwitch = new ToggleSwitch();
        toggleSwitch.addActionListener(toggleSwitch);
        toggleSwitch(toggleSwitch);

        lblOn = new JLabel();
        toggleSwitchLbl(lblOn);

        pnlToggleBtn.add(lblOff);
        pnlToggleBtn.add(toggleSwitch);
        pnlToggleBtn.add(lblOn);

        pnlDarkMode.add(lblDarkMode);
        pnlDarkMode.add(pnlToggleBtn);

        pnlLanguage = new JPanel();
        pnlLanguage.setLayout(new GridLayout(3, 1));
        pnl(pnlLanguage);

        lblLanguage = new JLabel();
        title(lblLanguage);

        rbEnglish = new JRadioButton("English");
        rbEnglish.setSelected(true);
        radioBtn(rbEnglish);

        rbGerman = new JRadioButton("Deutsch");
        radioBtn(rbGerman);

        makeRadioButtonGroup();

        pnlLanguage.add(lblLanguage);
        pnlLanguage.add(rbEnglish);
        pnlLanguage.add(rbGerman);

        btnHome = new JButton();
        submitBtn(btnHome);
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
    public void actionPerformed(ActionEvent e) {
        String language;
        if (rbEnglish.isSelected()) language = "en";
        else language = "de";

        this.language.setLanguage(language);

        if (toggleSwitch.isDarkMode()) System.out.println("Dark");
        else System.out.println("Light");

        changeView.actionPerformed(e);
    }


}
