package jaehaerys.school.ui.views;

import jaehaerys.school.ui.actionlistener.ChangeView;
import jaehaerys.school.ui.panels.DifficultyPanel;
import jaehaerys.school.ui.panels.TopicPanel;
import jaehaerys.school.ui.panels.View;

import javax.swing.*;
import java.awt.*;

public class ConfigView extends View {

    private TopicPanel pnlTopic;
    private DifficultyPanel pnlDifficulty;
    private JButton btnSubmit;

    public ConfigView() {
        super("Config");
    }

    @Override
    public void configurePanel() {
        setLayout(new GridLayout(3,1));
    }

    @Override
    public void addElementsToPanel() {
        add(pnlTopic);
        add(pnlDifficulty);
        add(btnSubmit);
    }

    @Override
    public void createElements() {
        pnlTopic = new TopicPanel();
        pnlDifficulty = new DifficultyPanel();
        btnSubmit = new JButton();
        btnSubmit.addActionListener(new ChangeView("Question"));

    }

    @Override
    public void addStyleToElements() {
        style.submitBtn(btnSubmit);
    }

    @Override
    protected void setContent() {
        btnSubmit.setText((String)language.get("btnSubmit"));
    }
}