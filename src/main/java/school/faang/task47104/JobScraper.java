package school.faang.task47104;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JobScraper {
    private static final ObjectMapper mapper = new ObjectMapper();

    public Job stringConversion(String json) throws IOException {
        return mapper.readValue(json, Job.class);
    }
}
