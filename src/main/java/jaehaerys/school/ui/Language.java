package jaehaerys.school.ui;


import jaehaerys.school.logic.JsonParser;
import org.json.simple.JSONObject;

public class Language {

    public static JSONObject content;

    private static JSONObject de;
    private static JSONObject en;

    public static void load(){
        de = JsonParser.getFileContent("/Users/jaehaerys/src/school/modul_120/Projektarbeit/Teil 3/quiz/src/main/resources/language/de.json");
        en = JsonParser.getFileContent("/Users/jaehaerys/src/school/modul_120/Projektarbeit/Teil 3/quiz/src/main/resources/language/en.json");
    }

    public static void setLanguage(String language){
                if (language.equals("en")){
                    content = en;
                } else if (language.equals("de")){
                    content = de;
                }
    }
}
