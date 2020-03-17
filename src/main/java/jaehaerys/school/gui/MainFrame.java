package jaehaerys.school.gui;


import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame {

    Map<String, View> views = new HashMap<>();
    private JPanel controlPanel;
    private CardLayout layout = new CardLayout();
    private Language language;


    public MainFrame() {
        create();
    }

    public void create() {
        this.language = new Language(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createControlPanel();
        createViews();
        setSize(500, 500);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void createControlPanel() {
        controlPanel = new JPanel();
        controlPanel.setBackground(new Color(90, 30, 30));
        controlPanel.setLayout(layout);
        setContentPane(controlPanel);
    }

    public void display() {
        setVisible(true);
    }

    private void createViews() {
        ChangeView changeView = new ChangeView(this);
        putViewInMap(new HomeView(changeView));
        putViewInMap(new SettingsView(changeView, language));
        putViewInMap(new ConfigView(changeView));
        putViewInMap(new QuestionView(changeView));
        putViewInMap(new ResultView(changeView));
        addAllViewsToControlPanel();
        changeViewTo("Home");
        updateLanguage();
    }


    public void changeViewTo(String view) {
        layout.show(controlPanel, view);
        setTitle("The Magic Marvelous Movie Quiz - " + language.getViewContent("Title").get(view));
        setLocationRelativeTo(null);
    }


    private void putViewInMap(View view) {
        views.put(view.getName(), view);
    }

    private void addAllViewsToControlPanel() {
        for (View view : views.values()) addViewToControlPanel(view);
    }

    private void addViewToControlPanel(View view) {
        controlPanel.add(view.getName(), view);
    }

    public void updateLanguage() {
        for (View view : views.values()) view.setContent(language);
    }
}