package jaehaerys.school.logic;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class JsonParser {


    private static JSONParser jsonParser = new JSONParser();

    public static JSONObject getFileContent(String filename){


        try (FileReader reader = new FileReader(filename)) {

            return (JSONObject) jsonParser.parse(reader);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
