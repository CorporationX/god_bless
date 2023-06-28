package faang.school.godbless.jobAnalyzer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class JobStreamProcessor {
    public List<Job> processJobStream(Stream<String> jobStream) {
        return jobStream
                .map(new JobScraper()::convertJsonToJob)
                .peek(System.out::println)
                .collect(Collectors.toList());
    }
}
