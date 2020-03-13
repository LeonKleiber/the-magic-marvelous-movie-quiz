package jaehaerys.school.logic;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;

import org.json.simple.JSONObject;
import java.io.FileReader;
import java.io.IOException;

public class JsonParser {


    private static JSONParser jsonParser = new JSONParser();

    public static JSONObject getFileContent(String filename){


        try (FileReader reader = new FileReader(filename))
        {

            JSONObject content = (JSONObject) jsonParser.parse(reader);
            return content;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }
}
