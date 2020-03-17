package jaehaerys.school.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsView extends View implements ActionListener {

    private JPanel pnlDarkMode, pnlLanguage, pnlToggleBtn;
    private JButton btnHome;
    private JLabel lblLanguage, lblTitle, lblOn, lblOff;
    private JRadioButton rbEnglish, rbGerman;
    private ButtonGroup bgLanguages;
    private ToggleSwitch toggleSwitch;

    public SettingsView(ChangeView changeView) {
        super("Settings", changeView);
        setLayout(new GridLayout(3, 1));

        pnlDarkMode = new JPanel();
        pnlDarkMode.setLayout(new GridLayout(2, 1));
        pnl(pnlDarkMode);

        lblTitle = new JLabel("Dark Mode");
        title(lblTitle);

        pnlToggleBtn = new JPanel();
        pnl(pnlToggleBtn);

        lblOff = new JLabel("Off");
        toggleSwitchLbl(lblOff);

        toggleSwitch = new ToggleSwitch();
        toggleSwitch.addActionListener(toggleSwitch);
        toggleSwitch(toggleSwitch);

        lblOn = new JLabel("On");
        toggleSwitchLbl(lblOn);

        pnlToggleBtn.add(lblOff);
        pnlToggleBtn.add(toggleSwitch);
        pnlToggleBtn.add(lblOn);

        pnlDarkMode.add(lblTitle);
        pnlDarkMode.add(pnlToggleBtn);

        pnlLanguage = new JPanel();
        pnlLanguage.setLayout(new GridLayout(3, 1));
        pnl(pnlLanguage);

        lblLanguage = new JLabel("Language");
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

        btnHome = new JButton("Home");
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
    public void actionPerformed(ActionEvent e) {
        if (rbEnglish.isSelected()) System.out.println("en");
        else System.out.println("de");

        if (toggleSwitch.isDarkMode()) System.out.println("Dark");
        else System.out.println("Light");

        changeView.actionPerformed(e);
    }

}
