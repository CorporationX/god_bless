package vacancy.analizator;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class JobStreamProcessor {
    public static List<Job> getJobsFromJson(Stream<String> jsonStream) {
        return jsonStream
                .map(JobScraper::parseJson)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .peek(j -> System.out.printf("Job parsed:%n%s%n", j))
                .toList();
    }
}
