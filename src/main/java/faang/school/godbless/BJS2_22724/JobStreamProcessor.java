package faang.school.godbless.BJS2_22724;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class JobStreamProcessor {
    public List<Job> process(Stream<String> streamStrings) {
        JobScraper jobScraper = new JobScraper();
        return streamStrings
                .filter(Objects::nonNull)
                .map(jobScraper::parseJsonToJob)
                .peek(System.out::println)
                .toList();
    }
}
