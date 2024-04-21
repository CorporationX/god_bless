package faang.school.godbless.vacancy_analyzer;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class JobScraper {
    public static Job parseJsonToJob(String json){
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
        String title = jsonObject.get("title").getAsString();
        List<String> requirements = new ArrayList<>();
        JsonArray requirementsArray = jsonObject.getAsJsonArray("requirements");
        for (int i = 0; i < requirementsArray.size(); i++) {
            requirements.add(requirementsArray.get(i).getAsString());
        }
        int salary = jsonObject.get("salary").getAsInt();
        String location = jsonObject.get("location").getAsString();
        String dateAddedString = jsonObject.get("dateAdded").getAsString();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateAdded = LocalDate.parse(dateAddedString, formatter);
        return new Job(title, requirements, salary, location, dateAdded);
    }
}
