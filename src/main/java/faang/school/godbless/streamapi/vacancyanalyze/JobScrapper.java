package faang.school.godbless.streamapi.vacancyanalyze;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JobScrapper {

    private static final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

    public static Job convertJob(String job) {
        try {
            return objectMapper.readValue(job, Job.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
