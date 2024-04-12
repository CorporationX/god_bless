package faang.school.godbless.streamAPI.jobs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Optional;

@Slf4j
public class JobsScraper {
    private final ObjectMapper mapper;

    public JobsScraper() {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm");
        mapper = new ObjectMapper();
        mapper.setDateFormat(df);
        mapper.registerModule(new JavaTimeModule());
    }

    public Optional<String> serialize(Job job) {
        if (job == null) {
            log.warn("Job is null. Returning empty optional.");
            return Optional.empty();
        }

        try {
            return Optional.ofNullable(mapper.writeValueAsString(job));
        } catch (JsonProcessingException e) {
            log.error("Json processing exception was caught. Returning empty optional.", e);
            return Optional.empty();
        }
    }

    public Optional<Job> parseString(String json) {
        if (json == null || json.isBlank()) {
            return Optional.empty();
        }

        try {
            return Optional.ofNullable(mapper.readValue(json, Job.class));
        } catch (JsonProcessingException e) {
            log.error("Json processing exception was caught. Returning empty optional.", e);
            return Optional.empty();
        }
    }
}
