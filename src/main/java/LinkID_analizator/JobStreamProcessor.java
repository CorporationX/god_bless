package LinkID_analizator;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Stream;
@RequiredArgsConstructor
public class JobStreamProcessor {

    private static JobScraper jobScraper;
    public static List<Job> process(Stream<String> stream) {
        return stream.map(jobScraper::fromJson)
                .peek(job -> System.out.println(job.getTitle() + " parsed"))
                .toList();
    }
}

