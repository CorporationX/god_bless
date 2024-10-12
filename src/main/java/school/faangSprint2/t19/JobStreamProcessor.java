package school.faangSprint2.t19;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JobStreamProcessor {
    private JobScraper scraper;

    public JobStreamProcessor(JobScraper scraper) {
        this.scraper = scraper;
    }

    public List<Job> processStream(Stream<String> jsonStream) {
        return jsonStream
                .map(scraper::parseJson)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}