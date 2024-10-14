package school.faangSprint2.t19;

import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JobScraper {
    public Job parseJson(String json) {
        try {
            JSONObject jsonObj = new JSONObject(json);

            String position = jsonObj.getString("position");

            List<String> requirements = new ArrayList<>();
            JSONArray reqArray = jsonObj.getJSONArray("requirements");
            for (int i = 0; i < reqArray.length(); i++) {
                requirements.add(reqArray.getString(i));
            }

            int salary = jsonObj.getInt("salary");
            String location = jsonObj.getString("location");
            LocalDate datePosted = LocalDate.parse(jsonObj.getString("datePosted"));

            return new Job(position, requirements, salary, location, datePosted);
        } catch (Exception e) {
            System.err.println("Ошибка при парсинге JSON: " + e.getMessage());
            return null;
        }
    }
}