package faang.school.godbless.stream_api.job_analyzer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JobScraper {
    public Job transformJsonToJob(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try {
            return objectMapper.readValue(json, Job.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
