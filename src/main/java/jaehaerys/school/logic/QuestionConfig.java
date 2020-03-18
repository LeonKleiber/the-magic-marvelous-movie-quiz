package jaehaerys.school.logic;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class QuestionConfig {
    private static String topic = "mcu";
    private static long level = 1;
    private static String language = "en";

    public static void setTopic(String t) {
        if (t.equals("mcu") || t.equals("sw") || t.equals("hp")) topic = t;

    }

    public static void setLevel(int difficulty) {
        if (difficulty <= 3 && difficulty >= 1) level = difficulty;
    }

    public static void setLanguage(String l) {
        if (l.equals("en") || l.equals("de")) language = l;
    }

    public List<JSONObject> loadQuestion() {
        JSONObject allQuestions = JsonParser.getFileContent("/Users/jaehaerys/src/school/modul_120/Projektarbeit/Teil 3/theMagicMarvelousMovieQuiz/src/main/resources/questions/" + topic + ".json");
        JSONArray questions = (JSONArray) allQuestions.get(language);
        List<JSONObject> questionOfOneLevel = new ArrayList<>();
        for (Object o : questions) {
            JSONObject question = (JSONObject) o;
            if (level == (long) question.get("level")) {
                questionOfOneLevel.add(question);
            }
        }
        return questionOfOneLevel;
    }
}
