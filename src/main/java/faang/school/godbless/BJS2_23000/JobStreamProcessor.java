package faang.school.godbless.BJS2_23000;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Slf4j
public class JobStreamProcessor {

    public static List<Job> parseJsonToJobs(Stream<String> jobsStream) {
        return jobsStream
                .map(JobScraper::parseJsonToJob)
                .map(Optional::orElseThrow)
                .peek(System.out::println)
                .toList();
    }
}
