package jaehaerys.school.gui;


import jaehaerys.school.logic.JsonParser;
import org.json.simple.JSONObject;

public class Language {

    private JSONObject content;
    private String language;

    private JSONObject de;
    private JSONObject en;

    private MainFrame mF;

    public Language(MainFrame mF) {
        load();
        language = "en";
        content = en;
        this.mF = mF;
    }

    private void load() {
        de = JsonParser.getFileContent("/Users/jaehaerys/src/school/modul_120/Projektarbeit/Teil 3/theMagicMarvelousMovieQuiz/src/main/resources/language/de.json");
        en = JsonParser.getFileContent("/Users/jaehaerys/src/school/modul_120/Projektarbeit/Teil 3/theMagicMarvelousMovieQuiz/src/main/resources/language/en.json");
    }

    private void changeLanguage() {
        if (language.equals("en")) {
            content = de;
            language = "de";
        } else {
            content = en;
            language = "en";
        }
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        if (!this.language.equals(language)) {
            changeLanguage();
            mF.updateLanguage();
        }
    }

    public JSONObject getViewContent(String viewName) {
        return (JSONObject) content.get(viewName);
    }


}
