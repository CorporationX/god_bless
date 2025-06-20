package school.faang.bjs2_80885;

import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.util.List;

@Slf4j
public class JobStreamProcessor {
    private final JobScraper jobScraper = new JobScraper();

    public List<Job> processJobs(InputStream inputStream) {
        List<Job> jobs = jobScraper.parseList(inputStream);
        jobs.forEach(job -> log.info("The vacancy has been processed: {}", job.getPosition()));
        return jobs;
    }
}