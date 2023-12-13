package faang.school.godbless.stream_api.task3vacancies;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JobStreamProcessor {
    private final JobScraper jobScraper = new JobScraper();

    public List<Job> processJobStream(Stream<String> jobStream) {
        return jobStream
                .map(jobScraper::parseJobFromJson)
                .filter(Objects::nonNull)
                .peek(job -> System.out.println("Job added: " + job.getPosition()))
                .collect(Collectors.toList());
    }
}
