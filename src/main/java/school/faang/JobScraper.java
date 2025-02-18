package school.faang;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;

public class JobScraper {
    private final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule());

    public Job parseJob(String jsonString) {
        try {
            return objectMapper.readValue(jsonString, Job.class);
        } catch (IOException e) {
            throw new RuntimeException("Error when parsing JSON: " + e.getMessage(), e);
        }
    }
}
