package faang.school.godbless.stream_api.task3vacancies;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JobScraper {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public Job parseJobFromJson(String json) {
        try {
            return objectMapper.readValue(json, Job.class);
        } catch (IOException e) {
            return null;
        }
    }
}

