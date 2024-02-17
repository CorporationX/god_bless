package faang.school.godbless.vacancyanalysis;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class JobStreamProcessor {
    
    private final JsonScraper jobScraper;

    public List<Job> process(Stream<String> stream) {
        return stream
                .map(jobScraper::parse)
                .peek(job -> System.out.println(job.getName() + " parsed"))
                .toList();
    }
}
