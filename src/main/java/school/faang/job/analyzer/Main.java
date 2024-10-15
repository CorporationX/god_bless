package school.faang.job.analyzer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static final String PATH_TO_VACANCIES = "src/main/resources/data_input/vacancies.json";
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws IOException {
        Path path = Paths.get(PATH_TO_VACANCIES);
        try (Stream<String> lines = Files.lines(path)) {
            String inputStrings = lines
                    .collect(Collectors.joining());
            List<Job> jobs = JobStreamProcessor.convertToJobs(Arrays.asList(
                    inputStrings.split("\\s*,\\s*\\{")));

            DataAnalyzer dataAnalyzer = new DataAnalyzer();

            System.out.println("\nтоп-5 наиболее востребованных навыков");
            System.out.println(dataAnalyzer.mostPopularRequirements(jobs));

            System.out.println("\nтоп-5 популярных названий позиций");
            System.out.println(dataAnalyzer.mostPopularPositions(jobs));

            System.out.println("\nраспределения зарплат по вакансиям");
            Map<Range, List<Job>> salaryRangeToJobs = dataAnalyzer.groupingBySalaryRange(jobs);
            salaryRangeToJobs.forEach((key, value) -> System.out.println(key + ": " +
                    value.stream()
                            .map(job -> job.getPosition() + " " + job.getSalary())
                            .toList()));

            System.out.println("\nтоп-5 популярных местоположений офисов");
            System.out.println(dataAnalyzer.mostPopularLocations(jobs));

            System.out.println("\nАнализ трендов по дням");
            Map<DateRange, JobStatistic> trendsByDay = dataAnalyzer.analyzeTrends(jobs,
                    LocalDate.of(2022, 2, 20),
                    LocalDate.of(2022, 2, 26),
                    Granularity.DAILY);
            trendsByDay.forEach((key, value) -> System.out.println(key + ": " + value));

            System.out.println("\nАнализ трендов по неделям");
            Map<DateRange, JobStatistic> trendsByWeek = dataAnalyzer.analyzeTrends(jobs,
                    LocalDate.of(2022, 2, 2),
                    LocalDate.of(2022, 2, 26),
                    Granularity.WEEKLY);
            trendsByWeek.forEach((key, value) -> System.out.println(key + ": " + value));

            System.out.println("\nАнализ трендов по месяцам");
            Map<DateRange, JobStatistic> trendsByMonth = dataAnalyzer.analyzeTrends(jobs,
                    LocalDate.of(2022, 1, 2),
                    LocalDate.of(2023, 2, 26),
                    Granularity.MONTHLY);
            trendsByMonth.forEach((key, value) -> System.out.println(key + ": " + value));
        } catch (IOException e) {
            logger.error("Ошибка при чтении файла" + e.getMessage());
        }
    }
}
