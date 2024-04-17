package faang.school.godbless.BJS2_5609;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public class JobStreamProcessor {
    public List<Job> convertStreamFromJsonToJob(List<String> jobs) {
        return jobs.stream().map(job -> {
            try {
                return new JobScrapper().fromJsonToJobObject(job);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }).peek(job -> System.out.println(job.toString())).toList();
    }
}
