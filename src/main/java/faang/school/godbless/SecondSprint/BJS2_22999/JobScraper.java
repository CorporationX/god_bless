package faang.school.godbless.SecondSprint.BJS2_22999;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JobScraper {
    public static Job parse(String string) {
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

        try {
            return objectMapper.readValue(string, Job.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
