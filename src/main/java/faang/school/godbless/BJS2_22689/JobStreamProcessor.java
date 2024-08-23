package faang.school.godbless.BJS2_22689;

import lombok.SneakyThrows;

import java.util.List;
import java.util.stream.Stream;

public class JobStreamProcessor {

    @SneakyThrows
    public static List<Job> getJobs(Stream<String> vacancies){
        return vacancies
                .map(JobScraper::convertJob)
                .toList();
    }
}
