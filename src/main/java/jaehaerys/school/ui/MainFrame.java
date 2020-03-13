package jaehaerys.school.ui;

import jaehaerys.school.ui.panels.View;
import jaehaerys.school.ui.style.Style;

import javax.swing.*;
import java.awt.*;

public class MainFrame  extends JFrame {

    private JPanel controlPanel;
    private CardLayout layout = new CardLayout();



    public MainFrame(){
        create();
    }

    public void create(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createControlPanel();
        setContentPane(controlPanel);
        setPreferredSize(Style.DEFAULT_FRAME_SIZE);
        setResizable(false);
    }

    private void createControlPanel() {
        controlPanel = new JPanel();
        controlPanel.setBackground(new Color(90,30,30));
        controlPanel.setLayout(layout);
    }

    public void display(){
        pack();
        setVisible(true);
    }

    public void changeViewTo(String view){
        layout.show(controlPanel, view);
        setTitle(view);
        pack();
        setLocationRelativeTo(null);
    }

    public void addView(View view){
        controlPanel.add(view.getViewName(), view);
    }
}