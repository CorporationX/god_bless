package faang.school.godbless.BJS2_10757;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class JobStreamProcessor {
    public List<Job> parseJobs(Stream<String> jobsStream) {
        JobScrapper scrapper = new JobScrapper();
        List<Job> jobs = new ArrayList<>();
        jobsStream.forEach(s -> jobs.add(scrapper.convertJsonStringToJob(s)));
        return jobs;
    }

    public Job parseJobStringFromFile(String fileName) throws FileNotFoundException {
        JobScrapper scrapper = new JobScrapper();
        String job = scrapper.convertJsonStringFromFile(fileName);
        return scrapper.convertJsonStringToJob(job);
    }
}
