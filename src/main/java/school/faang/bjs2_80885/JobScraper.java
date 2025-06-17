package school.faang.bjs2_80885;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.util.List;

@Slf4j
public class JobScraper {

    private final ObjectMapper mapper;

    public JobScraper() {
        this.mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
    }

    public List<Job> parseList(InputStream inputStream) {
        try {
            return List.of(mapper.readValue(inputStream, Job[].class));
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to parse job list from JSON", e);
        }
    }
}
