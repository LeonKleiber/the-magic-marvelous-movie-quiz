package jaehaerys.school.ui.panels;

import jaehaerys.school.ui.style.Style;
import org.json.simple.JSONObject;

import javax.swing.*;

public abstract class Panel extends JPanel {


    protected Style style = new Style();
    protected JSONObject language;

    public Panel(){
        configureDefaultPanel();
        configurePanel();
        createElements();
        addStyleToElements();
        addElementsToPanel();
    }



    public void configureDefaultPanel() {
        setBackground(style.BLACK);
    }

    public abstract void addStyleToElements();

    public abstract void configurePanel();

    public abstract void addElementsToPanel();

    public abstract void createElements() ;
}
