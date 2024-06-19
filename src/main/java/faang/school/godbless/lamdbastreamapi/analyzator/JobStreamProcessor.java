package faang.school.godbless.lamdbastreamapi.analyzator;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;
import java.util.stream.Stream;

public class JobStreamProcessor {

    private Stream<Job> getSteamJob(String string) {
        try {
            return Stream.of(JobScraper.parseJsonToJob(string));
        } catch(JsonProcessingException e) {
            return Stream.empty();
        }
    }

    public List<Job> getJobs(Stream<String> stringJobs) {
        return stringJobs
                .flatMap(this::getSteamJob)
                .peek(System.out::println)
                .toList();
    }
}
