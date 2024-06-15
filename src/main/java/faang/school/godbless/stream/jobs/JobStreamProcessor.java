package faang.school.godbless.stream.jobs;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Stream;

@Slf4j
public record JobStreamProcessor(JobScraper jobScraper) {

    public List<Job> processJobs(Stream<String> jobsStream) {
        return jobsStream
                .peek(job -> log.info("Another job opening inc.: {}", job))
                .map(jobScraper::parse)
                .toList();
    }
}
