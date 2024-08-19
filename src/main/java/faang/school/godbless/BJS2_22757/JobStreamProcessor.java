package faang.school.godbless.BJS2_22757;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Stream;

@AllArgsConstructor
public class JobStreamProcessor {
    private final JobScraper scraper;

    public List<Job> convertStream(Stream<String> jsonStream) {
        return jsonStream
                .map(scraper::convert)
                .peek(System.out::println)
                .toList();
    }
}
