package faang.school.godbless.vacancy_analyzer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Main {
    private static final List<Job> JOBS = getJobs();

    public static void main(String[] args) {
        DataAnalyzer dataAnalyzer = new DataAnalyzer();
        System.out.println(dataAnalyzer.findTopKRequirements(JOBS, 2));
        System.out.println(dataAnalyzer.findTopKPopularPositions(JOBS, 2));
        System.out.println(dataAnalyzer.countJobsBySalaryRange(JOBS, 50000));
        System.out.println(dataAnalyzer.findTopKLocations(JOBS, 2));
        System.out.println(dataAnalyzer.analyzeTrends(JOBS, LocalDate.now().minusMonths(1), LocalDate.now(), TrendGranularity.DAY));
    }

    public static List<Job> getJobs() {
        JobStreamProcessor jobStreamProcessor = new JobStreamProcessor();
        List<Job> jobs;
        try(Stream<String> data = Files.lines(Path.of(Objects.requireNonNull(Main.class.getResource("/vacancies.txt")).getPath()))) {
            jobs = jobStreamProcessor.convertToJob(data);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

        return jobs;
    }
}