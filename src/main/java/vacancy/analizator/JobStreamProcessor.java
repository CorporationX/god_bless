package vacancy.analizator;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class JobStreamProcessor {
    public static List<Job> getJobsFromJson(Stream<String> jsonStream) {
        return jsonStream.
                map(JobScraper::parseJson)
                .peek(jo -> System.out.printf("Job parsed : %s%n", jo.isPresent()))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }
}
