package faang.school.godbless;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class JobStreamProcessor {
    public List<Job> processJobStream(Stream<String> jobStream) {
        return jobStream
                .map(JobScraper::parseJobFromJson)
                .peek(System.out::println)
                .collect(Collectors.toList());
    }
}
