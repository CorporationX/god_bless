package faang.school.godbless.BJS222750;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Stream;

@AllArgsConstructor
public class JobStreamProcessor {
    private final JobScraper jobScraper;

    public List<Job> process(Stream<String> jobsStream) {
        return jobsStream
                .map(this.jobScraper::parse)
                .filter((job -> job != null && job.getJobTitle() != null))
                .peek(job -> System.out.println("Открыта следующая вакансия: " + job))
                .toList();
    }
}
