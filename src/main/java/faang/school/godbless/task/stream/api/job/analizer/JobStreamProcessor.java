package faang.school.godbless.task.stream.api.job.analizer;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class JobStreamProcessor {
    private final JobScraper jobScraper;

    public List<Job> jsonToJob(Stream<String> strStream) {
        return strStream
                .map(json -> jobScraper.parse(json).get())
                .takeWhile(Objects::nonNull)
                .peek(job -> System.out.println("Вакансия: " + job))
                .toList();
    }
}
