package school.faang.vacancy;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Danil Pudovkin
 * @since 21.06.2025
 */
@Slf4j(topic = "JobStreamProcessor")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JobStreamProcessor {

    public static Set<Job> process(@NonNull Stream<String> jsonStream) {
        return jsonStream
                .map(JobScraper::parseJob)
                .peek(job -> log.info("Processing job: {}", job))
                .collect(Collectors.toSet());
    }
}
