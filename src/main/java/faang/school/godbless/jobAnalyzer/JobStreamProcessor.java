package faang.school.godbless.jobAnalyzer;

import lombok.NonNull;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static faang.school.godbless.jobAnalyzer.JobScraper.parser;

public class JobStreamProcessor {
    public List<Job> streamStringToListJob(@NonNull Stream<String> stream) {
        return stream
                .map(JobScraper::parser)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .peek(System.out::println)
                .toList();
    }
}
