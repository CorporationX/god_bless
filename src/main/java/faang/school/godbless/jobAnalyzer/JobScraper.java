package faang.school.godbless.jobAnalyzer;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NonNull;

import java.util.Optional;

public class JobScraper {
    public static Optional<Job> parser(@NonNull String stringJson) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Job job = objectMapper.readValue(stringJson, Job.class);
            return Optional.ofNullable(job);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }
}
