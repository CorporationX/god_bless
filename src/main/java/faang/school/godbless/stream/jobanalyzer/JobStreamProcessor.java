package faang.school.godbless.stream.jobanalyzer;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Stream;

@AllArgsConstructor
public class JobStreamProcessor {

    private JobScraper jobScraper;

    public List<Job> processJobStream(Stream<String> jobStream) {
        return jobStream.map(jobScraper::parseJson)
                .peek(job -> System.out.println("Parsed job: " + job))
                .toList();
    }

}
