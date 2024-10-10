package job_analyzer;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JobStreamProcessor {
    private final JobScraper jobScraper = new JobScraper();

    public List<Job> processJobs(Stream<String> jsonStream) {
        String json = jsonStream.collect(Collectors.joining("\n")).trim();

        if (!json.startsWith("[") || !json.endsWith("]")) {
            System.err.println("Некорректный JSON: " + json);
            return new ArrayList<>();
        }

        try {
            List<Job> jobs = jobScraper.parseJobs(json);
            System.out.println(jobs);
            jobs.forEach(job -> System.out.println("Обработана вакансия: " + job.getPosition()));
            return jobs;
        } catch (JsonProcessingException e) {
            System.err.println("Ошибка при обработке JSON: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
