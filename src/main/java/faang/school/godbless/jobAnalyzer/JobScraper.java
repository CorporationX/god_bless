package faang.school.godbless.jobAnalyzer;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NonNull;

import java.util.Optional;

public class JobScraper {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    public static Optional<Job> parser(@NonNull String stringJson) {
        try {
            Job job = objectMapper.readValue(stringJson, Job.class);
            return Optional.ofNullable(job);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }
}
