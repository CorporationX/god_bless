package faang.school.godbless.sprint3.vacancy_analyzer;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class JobStreamProcessor {
    private final JobScraper jobScraper;

    public JobStreamProcessor() {
        jobScraper = new JobScraper();
    }

    public List<Job> process(Stream<String> jobs) {
        return jobs
                .map(jobScraper::jsonToPojo)
                .filter(Objects::nonNull)
                .peek(System.out::println)
                .toList();
    }
}
