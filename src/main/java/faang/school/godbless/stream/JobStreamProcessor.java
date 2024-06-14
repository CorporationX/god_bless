package faang.school.godbless.stream;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class JobStreamProcessor {

    private final JobScraper jobScraper;

    public List<Job> toListOfJob(Stream<String> stream) {
        return stream
                .filter(Objects::nonNull)
                .map(jobScraper::parseToJob)
                .peek(job -> System.out.println("Vacation is parse: " + job))
                .toList();
    }
}
