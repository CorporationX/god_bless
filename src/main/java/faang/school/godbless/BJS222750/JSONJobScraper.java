package faang.school.godbless.BJS222750;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;

public class JSONJobScraper extends JobScraper {
    private final ObjectMapper objectMapper;

    public JSONJobScraper() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.registerModule(new JavaTimeModule());
        this.objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    @Override
    public Job parse(String json) {
        try {
            return objectMapper.readValue(json, Job.class);
        } catch (IOException exception) {
            System.err.println("Ошибка обработки JSON: " + exception.getMessage());
            return null;
        }
    }
}
