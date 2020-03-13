package jaehaerys.school.ui.panels;

import jaehaerys.school.ui.Language;
import jaehaerys.school.ui.style.Style;
import org.json.simple.JSONObject;

public abstract class View extends Panel {

    private String viewName;


    public View(String name){
        super();
        this.viewName = name;
        if(this.reloadLanguage()){
            setContent();
        }
    }
    public boolean reloadLanguage() {
        JSONObject language = (JSONObject) Language.content.get(viewName);
        if (language.equals(this.language)){
            return false;
        } else {
            this.language = language;
            return true;
        }
    }

    public String getViewName() {
        return viewName;
    }

    protected abstract void setContent();
}
