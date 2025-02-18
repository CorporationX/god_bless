package school.faang.analyzevacancies;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;

public class JobScraper {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public Job parsingVacancy(JsonParser jsonParser) throws IOException {
        MAPPER.registerModule(new JavaTimeModule());
        return MAPPER.readValue(jsonParser, Job.class);
    }
}
