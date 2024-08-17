package faang.school.godbless.stream.jobanalyzer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JobScraper {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public JobScraper() {
        objectMapper.registerModule(new JavaTimeModule());
    }

    public Job parseJson(String json) {

        try {
            return objectMapper.readValue(json, Job.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Exception while parse json to Job", e);
        }
    }
}
