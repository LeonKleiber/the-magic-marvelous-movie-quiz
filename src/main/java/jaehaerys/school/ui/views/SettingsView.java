package jaehaerys.school.ui.views;

import jaehaerys.school.ui.actionlistener.SubmitSettings;
import jaehaerys.school.ui.panels.DarkModePanel;
import jaehaerys.school.ui.panels.LanguagePanel;
import jaehaerys.school.ui.panels.View;

import javax.swing.*;
import java.awt.*;

public class SettingsView extends View {

    private DarkModePanel pnlDarkMode;
    private LanguagePanel pnlLanguage;
    private JButton btnSubmit;

    public SettingsView() {
        super("Settings");
    }

    @Override
    public void configurePanel() {
        setLayout(new GridLayout(3,1));
    }

    @Override
    public void addElementsToPanel() {
        add(pnlDarkMode);
        add(pnlLanguage);
        add(btnSubmit);
    }

    @Override
    public void createElements(){
        pnlDarkMode = new DarkModePanel();
        pnlLanguage = new LanguagePanel();
        btnSubmit = new JButton();
        btnSubmit.addActionListener(new SubmitSettings());
    }

    @Override
    public void setContent() {
        btnSubmit.setText((String) language.get("btnSubmit"));
    }

    @Override
    public void addStyleToElements() {
        style.submitBtn(btnSubmit);
    }
}

