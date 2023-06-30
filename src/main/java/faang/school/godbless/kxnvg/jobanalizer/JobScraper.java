package faang.school.godbless.kxnvg.jobanalizer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JobScraper {

    private final ObjectMapper objectMapper;

    public JobScraper() {
        this.objectMapper = new ObjectMapper();
    }

    public Job transformJsonToJob(String json) {
        try {
            return objectMapper.readValue(json, Job.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public String transformJobToJson(Job job) {
        try {
            return objectMapper.writeValueAsString(job);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
