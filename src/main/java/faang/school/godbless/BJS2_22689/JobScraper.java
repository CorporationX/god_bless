package faang.school.godbless.BJS2_22689;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JobScraper {

    private static ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());


    public static Job convertJob(String job) {
        try {
            return objectMapper.readValue(job, Job.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
