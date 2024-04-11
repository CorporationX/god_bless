package faang.school.godbless.bjs2_5223;

import java.util.List;
import java.util.stream.Stream;

public class JobStreamProcessor {

    public static List<Job> handleStreamToJob(Stream<String> jobStream, JobScraper scraper) {
        return jobStream
                .map(scraper::convertToJob)
                .peek(System.out::println)
                .toList();
    }
}
