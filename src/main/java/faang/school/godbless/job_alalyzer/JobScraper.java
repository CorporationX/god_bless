package faang.school.godbless.job_alalyzer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public class JobScraper {
    public static Optional<Job> convertJsonIntoJob(String json) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Job job = objectMapper.readValue(json, Job.class);
            return Optional.of(job);
        } catch (JsonProcessingException exception) {
            log.error("Could not parse JSON into Job Object");
            return Optional.empty();
        }
    }
}
