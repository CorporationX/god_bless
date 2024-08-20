package faang.school.godbless.BJS2_22788;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;
import java.util.stream.Stream;

public class JobStreamProcessor {
    private JobScraper parser = new JsonJobScraper();

    public List<Job> processJobs(Stream<String> data) {
        return data.filter(string -> string != null && !string.isEmpty())
                .map(string -> {
                    try {
                        return parser.parse(string);
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                })
                .peek(job -> System.out.println("New job posted: " + job))
                .toList();
    }
}
