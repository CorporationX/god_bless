package faang.school.godbless.secondSprint.JobAnalyzer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JobScraper {
    public static Job transformJsonToJob(String json) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        try {
            return mapper.readValue(json, Job.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
