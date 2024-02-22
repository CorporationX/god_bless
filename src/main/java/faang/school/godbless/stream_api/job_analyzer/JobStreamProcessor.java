package faang.school.godbless.stream_api.job_analyzer;


import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Stream;
@RequiredArgsConstructor
public class JobStreamProcessor {

    private final JobScraper jobScraper;
    public List<Job> process(Stream<String> stream) {
        return stream.map(jobScraper::transformJsonToJob)
                .peek(job -> System.out.println(job.getJobTitle() + " parsed"))
                .toList();
    }
}
