package faang.school.godbless.stream.jobs;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public record JsonJobScraper() implements JobScraper {

    @Override
    public Job parse(String data) {
        if (data == null || data.isBlank()) {
            throw new IllegalArgumentException("Source data cannot be null.");
        }
        var mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        Job job = null;
        try {
            job = mapper.readValue(data, Job.class);
        } catch (JacksonException e) {
            log.error("Json parsing didn't go as planned", e);
        }
        return job;
    }
}
