package faang.school.godbless;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JobScraper {
    private static ObjectMapper objectMapper;

    public JobScraper() {
        this.objectMapper = new ObjectMapper();
    }
    public static Job parseJobFromJson(String json)  {
        try {
            return objectMapper.readValue(json, Job.class);
        } catch (IOException e) {
            System.out.println("Error parsing JSON: " + e.getMessage());
            throw new RuntimeException();
        }
    }
}





