package faang.school.godbless.SecondSprint.BJS2_22999;

import java.util.List;
import java.util.stream.Stream;

public class JobStreamProcessor {
    public static List<Job> parseJobs(Stream<String> input) {
        return input.map(k -> JobScraper.parse(k))
                .peek(job -> System.out.println("New job posted: " + job))
                .toList();
    }
}
