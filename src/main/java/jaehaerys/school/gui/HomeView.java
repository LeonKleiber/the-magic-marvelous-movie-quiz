package jaehaerys.school.gui;

import org.json.simple.JSONObject;

import javax.swing.*;
import java.awt.*;

public class HomeView extends View {

    private JButton btnStart;
    private JButton btnSettings;

    public HomeView(ChangeView changeView) {
        super("Home", changeView);
        setLayout(new GridLayout(2, 1));

        btnStart = new JButton("Start");
        btnSettings = new JButton();

        bigBtn(btnStart);
        bigBtn(btnSettings);

        btnStart.addActionListener(this.changeView);
        btnSettings.addActionListener(this.changeView);

        add(btnStart);
        add(btnSettings);
    }

    @Override
    public void setContent(Language language) {
        JSONObject content = getContent(language);
        btnSettings.setText((String) content.get("settings"));
    }
}
