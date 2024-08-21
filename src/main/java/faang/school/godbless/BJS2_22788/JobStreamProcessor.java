package faang.school.godbless.BJS2_22788;

import java.util.List;
import java.util.stream.Stream;

public class JobStreamProcessor {
    private JobScraper parser = new JsonJobScraper();

    public List<Job> processJobs(Stream<String> data) {
        return data.filter(string -> string != null && !string.isEmpty())
                .map(string -> parser.parse(string))
                .peek(job -> System.out.println("New job posted: " + job))
                .toList();
    }
}
