package faang.school.godbless.bjs2_22762;

import java.util.List;
import java.util.stream.Stream;

public class JobStreamProcessor {
    private JobScraper jobScraper;

    public JobStreamProcessor() {
        jobScraper = new JobScraperJson();
    }

    public List<Job> process(Stream<String> stream) {
        return stream.map(s -> jobScraper.parse(s))
                .peek(System.out::println)
                .toList();
    }
}
