package faang.school.godbless.kxnvg.jobanalizer;

import java.util.List;
import java.util.stream.Stream;

public class JobStreamProcessor {

    private JobScraper jobScraper;

    public JobStreamProcessor(JobScraper jobScraper) {
        this.jobScraper = jobScraper;
    }

    public List<Job> transformJsonToJob(Stream<String> jsonStream) {
        return jsonStream.map(jobScraper::transformJsonToJob)
                .peek(System.out::println)
                .toList();
    }
}
