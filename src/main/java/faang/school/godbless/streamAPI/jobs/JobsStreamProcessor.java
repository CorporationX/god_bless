package faang.school.godbless.streamAPI.jobs;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Slf4j
public class JobsStreamProcessor {
    public Optional<List<Job>> processJobsStream(Stream<String> jobsStream) {
        if (jobsStream == null) {
            log.warn("Jobs stream is null. Returning empty optional.");
            return Optional.empty();
        }

        JobsScraper jobsScraper = new JobsScraper();

        var jobs = jobsStream.map(jobsScraper::parseFile)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .peek(job -> {
                    log.info("New job is available!!!");
                    log.info(job.toString());
                    log.info("Adding it to jobs list.");
                })
                .toList();

        return Optional.of(jobs);
    }
}
