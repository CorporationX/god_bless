package faang.school.godbless.BJS2_22788;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JsonJobScraper extends JobScraper{
    private ObjectMapper objectMapper;

    public JsonJobScraper() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Override
    public Job parse(String data) {
        try {
            return objectMapper.readValue(data, Job.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
