package faang.school.godbless.stream;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JobScraper {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public Job parseToJob(String jsonString) {
        try {
            return objectMapper.readValue(jsonString, Job.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to parse JSON", e);
        }
    }
}
