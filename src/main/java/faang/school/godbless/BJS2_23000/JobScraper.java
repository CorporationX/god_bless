package faang.school.godbless.BJS2_23000;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class JobScraper {

    private static ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

    public static List<Job> parseJsonToJobs(Stream<String> jobsStream) {
        return jobsStream
                .map(JobScraper::parseJsonToJob)
                .map(Optional::orElseThrow)
                .toList();
    }

    private static Optional<Job> parseJsonToJob(String json) {
        try {
            Job job = mapper.readValue(json, Job.class);
            return Optional.ofNullable(job);
        } catch (JsonProcessingException e) {
            System.out.println("JsonProcessingException: " + e.getMessage());
            return Optional.empty();
        }
    }
}
