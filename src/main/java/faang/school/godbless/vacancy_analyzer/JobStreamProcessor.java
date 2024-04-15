package faang.school.godbless.vacancy_analyzer;

import java.util.List;
import java.util.stream.Stream;

public class JobStreamProcessor {

    private JobScraper jobScraper;

    public JobStreamProcessor() {
        this.jobScraper = new JobScraperJson();
    }

    public List<Job> convertToJob(Stream<String> stream) {
        return stream.map(s -> jobScraper.readValue(s))
                .peek(s -> System.out.printf("%s -> successfully converted\n", s))
                .toList();
    }
}