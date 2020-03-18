package jaehaerys.school.gui;

import org.json.simple.JSONObject;

import javax.swing.*;

public abstract class View extends JPanel {


    String name;
    ChangeView changeView;

    public View(String name, ChangeView changeView) {
        this.name = name;
        this.changeView = changeView;
    }

    public String getName() {
        return name;
    }

    public abstract void setContent(Language language);


    public JSONObject getContent(Language language) {
        return language.getViewContent(this.name);
    }

    public abstract void setStyle(Style style);
}

