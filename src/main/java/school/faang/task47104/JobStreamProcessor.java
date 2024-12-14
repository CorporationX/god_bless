package school.faang.task47104;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class JobStreamProcessor {
    private final JobScraper jobScraper = new JobScraper();

    public List<Job> dataProcessing(Stream<String> stream) throws JobProcessorException {

        return stream.map(string -> {
            try {
                return jobScraper.stringConversion(string);
            } catch (IOException e) {
                throw new JobProcessorException("Ошибка при обработке строки: " + string);
            }
        }).filter(Objects::nonNull).peek(job -> System.out.println("Обработана вакансия: " + job.position())).toList();
    }
}
