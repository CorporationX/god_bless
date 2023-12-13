package faang.school.godbless.stream_api.task3vacancies;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

public class JobScraper {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public Job parseJobFromJson(String json) {
        try {
            JsonNode jsonNode = objectMapper.readTree(json);
            String position = jsonNode.get("position").asText();
            List<String> requirements = objectMapper.convertValue(jsonNode.get("requirements"), List.class);
            double salary = jsonNode.get("salary").asDouble();
            String location = jsonNode.get("location").asText();
            String dateAdded = jsonNode.get("dateAdded").asText();
            return new Job(position, requirements, salary, location, dateAdded);
        } catch (IOException e) {
            return null;
        }
    }
}

