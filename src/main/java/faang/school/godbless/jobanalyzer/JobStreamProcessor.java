package faang.school.godbless.jobanalyzer;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class JobStreamProcessor {

    private JobScarper scarper = new JobScarper();

    public List<Job> process(Stream<String> jobStream) {
        return jobStream.map(scarper::parseVacancy)
                .filter(Objects::nonNull)
                .peek(job -> System.out.println("Вакансия " + job.getVacancy() + " - успешно обработана"))
                .toList();
    }
}
