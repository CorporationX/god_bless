package faang.school.godbless.vacancy_analyzer;

import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class JobScraper {
    public static Job parseJsonToJob(String json){
        JSONObject jsonObject = new JSONObject(json);

        String title = jsonObject.getString("title");
        List<String> requirements = ((JSONArray) jsonObject.get("requirements"))
                .toList()
                .stream()
                .map(Object::toString)
                .collect(Collectors.toList());
        int salary = jsonObject.getInt("salary");
        String location = jsonObject.getString("location");
        String dateAddedString = jsonObject.getString("dateAdded");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateAdded = LocalDate.parse(dateAddedString, formatter);
        return new Job(title, requirements, salary, location, dateAdded);
    }
}
