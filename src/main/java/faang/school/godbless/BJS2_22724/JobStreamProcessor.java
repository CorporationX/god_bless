package faang.school.godbless.BJS2_22724;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class JobStreamProcessor {
    public List<Job> process(Stream<String> streamStrings) {
        JobScraper jobScraper = new JobScraper();
        return streamStrings
                .map(Optional::ofNullable)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(jobScraper::parseJsonToJob)
                .peek(System.out::println)
                .toList();
    }
}
