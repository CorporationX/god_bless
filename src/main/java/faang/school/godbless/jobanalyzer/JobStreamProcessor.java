package faang.school.godbless.jobanalyzer;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class JobStreamProcessor {
    private final JobScrapper jobScrapper = new JobScrapper();

    public List<Job> processJobs(Stream<String> jobDataStream) {
        return jobDataStream
                .map(jobData -> {
                    Job job = jobScrapper.parseJsonToJob(jobData);
                    if (job != null) {
                        System.out.println("Processed Job: " + job);
                    }
                    return job;
                })
                .filter(Objects::nonNull)
                .toList();
    }
}