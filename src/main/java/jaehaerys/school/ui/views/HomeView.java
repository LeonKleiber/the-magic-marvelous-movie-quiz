package jaehaerys.school.ui.views;

import jaehaerys.school.ui.Language;
import jaehaerys.school.ui.actionlistener.ChangeView;
import jaehaerys.school.ui.panels.View;

import javax.swing.*;
import java.awt.*;

public class HomeView extends View {

    private JButton btnStart;
    private JButton btnSettings;

    public HomeView() {
        super("Home");
        addListeners();
    }

    @Override
    public void configurePanel() {
        setLayout(new GridLayout(2,1));
    }

    @Override
    public void addElementsToPanel() {
        add(btnStart);
        add(btnSettings);
    }

    @Override
    public void createElements() {
        btnStart = new JButton();
        btnSettings = new JButton();
    }

    @Override
    protected void setContent() {
        btnStart.setText((String) language.get("btnStart"));
        btnSettings.setText((String) language.get("btnSettings"));
    }

    @Override
    public void addStyleToElements() {
        style.bigBtn(btnStart);
        style.bigBtn(btnSettings);
    }

    private void addListeners() {
        btnStart.addActionListener(new ChangeView("Config"));
        btnSettings.addActionListener(new ChangeView("Settings"));
    }

}
