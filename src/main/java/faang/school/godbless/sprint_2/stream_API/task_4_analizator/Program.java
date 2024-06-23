package faang.school.godbless.sprint_2.stream_API.task_4_analizator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import faang.school.godbless.sprint_2.stream_API.task_4_analizator.models.Job;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Program {
    public static void main(String[] args) throws IOException {
        DataAnalyzer analyzer = new DataAnalyzer();

        LocalDate date = LocalDate.now();
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.enable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        Path jsonJobsPath = Path.of("src/main/java/faang/school/godbless/task_4_analizator/jsonJobs.txt");

        // Парсим строки и выводим информацию по каждому Job
        JobStreamProcessor processor = new JobStreamProcessor();
        List<Job> jobs = processor.process(Files.lines(jsonJobsPath));

        // топ 5 умений
        int countSkills = 5;
        List<String> topSkills = analyzer.findTopSkills(jobs.stream(), countSkills);

        // топ вакансий
        int countPosition = 3;
        List<String> topPositions = analyzer.findTopPositions(jobs.stream(), countPosition);


        // Группировка зарплат по диапазонам
        int stepRange = 50000;
        Map<String, Long> groupByRangeSalary = analyzer.groupByRangeSalary(jobs.stream(), stepRange);

        // топ по локациям
        int countLocation = 3;
        List<String> topLocations = analyzer.findTopLocations(jobs.stream(), countLocation);
    }
}
