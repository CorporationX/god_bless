package faang.school.godbless.vacancy_analyzer;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JobScraper {
    private ObjectMapper objectMapper;

    public JobScraper() {
        this.objectMapper = new ObjectMapper();
    }

    public Job parseJsonToJob(String json){
        try {
            return objectMapper.readValue(json, Job.class);
        } catch (IOException e) {
            System.out.println("Error parsing JSON: " + e.getMessage());
            throw new RuntimeException();
        }
    }
}
