package faang.school.godbless.AnalysisVacantion;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.SneakyThrows;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class JobStreamProcessor {
    public List<Job> process(Stream<String> strings) {

        JobScraper jobScraper = new JobScraper();
        List<Job> results = strings.map(string -> {
            try {
                return jobScraper.parseJson(string);
            }
            catch (JsonProcessingException e)
            {
                e.printStackTrace();
                return null;
            }
        }).peek(System.out::println).toList();
        return results;

    }
}


