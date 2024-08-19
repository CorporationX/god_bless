package faang.school.godbless.BJS2_22757;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JacksonJobScraper implements JobScraper {
    private final ObjectMapper mapper = new ObjectMapper().findAndRegisterModules();

    @Override
    public Job convert(String json) {
        try {
            return mapper.readValue(json, Job.class);
        } catch (IOException e) {
            throw new RuntimeException("Error converting json to an object");
        }
    }
}
