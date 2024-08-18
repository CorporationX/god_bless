package faang.school.godbless.sprint2.BJS2_22730;

import lombok.NonNull;

import java.util.List;
import java.util.stream.Stream;

public class JobStreamProcessor {
    public List<Job> process(@NonNull Stream<String> jobs) {
        return jobs.map(JobScraper::jsonToJobConverter)
                .peek(j -> System.out.printf("Vacancy %1 was created successfuly%n", j.getJobTitle()))
                .toList();
    }
}
