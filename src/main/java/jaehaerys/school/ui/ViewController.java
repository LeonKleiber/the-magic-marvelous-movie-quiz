package jaehaerys.school.ui;

import jaehaerys.school.ui.panels.View;
import jaehaerys.school.ui.views.*;

import java.util.HashMap;
import java.util.Map;

public class ViewController {
    private static MainFrame frame = new MainFrame();
    Map<String, View> views = new HashMap<String, View>();

    public ViewController(){
        Language.load();
        Language.setLanguage("de");
        System.out.println();
        frame.create();
        createViews();
        addViews();
        frame.changeViewTo(views.get("Home").getViewName());
        frame.display();
    }

    private void createViews() {
        HomeView home = new HomeView();
        putInViews(home);
        SettingsView settings = new SettingsView();
        putInViews(settings);
        ConfigView config = new ConfigView();
        putInViews(config);
        QuestionView question = new QuestionView();
        putInViews(question);
        ResultView result = new ResultView();
        putInViews(result);
    }

    private void addViews() {
        for ( View view : views.values())
            frame.addView(view);
    }

    private void putInViews(View view) {
        views.put(view.getViewName(), view);
    }


    public static MainFrame getMainFrame(){
        return frame;
    }
}
