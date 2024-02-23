package faang.school.godbless.vacancyanalysis;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class JobStreamProcessor {
    
    private final JobScraper jobScraper;

    public List<Job> process(Stream<String> stream) {
        return stream
                .map(jobScraper::parse)
                .filter(Objects::nonNull)
                .peek(job -> System.out.println(job.getName() + " parsed"))
                .toList();
    }
}
