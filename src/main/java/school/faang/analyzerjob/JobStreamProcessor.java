package school.faang.analyzerjob;

import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
public class JobStreamProcessor {
    private final JobScraper jobScraper;

    public List<Job> processJobs(Stream<String> jsonStream) {
        return jsonStream
                .flatMap(jobScraper::parseJobs)
                .peek(job -> System.out.println("Processed job " + job.getPosition()))
                .collect(Collectors.toList());
    }
}


