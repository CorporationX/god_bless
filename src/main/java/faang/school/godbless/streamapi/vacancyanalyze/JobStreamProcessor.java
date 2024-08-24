package faang.school.godbless.streamapi.vacancyanalyze;

import lombok.SneakyThrows;

import java.util.List;
import java.util.stream.Stream;

public class JobStreamProcessor {

    @SneakyThrows
    public static List<Job> getJobs(Stream<String> vacancies){
        return vacancies.map(JobScrapper::convertJob).toList();
    }

}
