package faang.school.godbless.job_alalyzer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JobScraper {
    public static Job convertJsonIntoJob(String json) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(json, Job.class);
        } catch (JsonProcessingException exception) {
            throw new RuntimeException("Could not process JSON to java object");
        }
    }
}
