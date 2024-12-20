package school.faang.bjs247244;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JobStreamProcessor {
    private JobScraper jobScraper = new JobScraper();

    public List<Job> processJobs(Stream<String> jsonStream) {
        return jsonStream
                .map(jobScraper::parseJob) // Преобразование JSON строки в объект Job
                .peek(job -> System.out.println("Обработана вакансия: " + job.getPosition())) // Уведомление
                .collect(Collectors.toList()); // Сохранение вакансий в список
    }
}
