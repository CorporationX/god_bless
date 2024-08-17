package faang.school.godbless.task.stream.api.job.analizer;

import java.time.LocalDate;
import java.util.List;

public class Main {
    private final static JobStreamProcessor jobStreamProcessor;
    private final static DataAnalyzer dataAnalyzer;

    static {
        jobStreamProcessor = new JobStreamProcessor(new JobScraper());
        dataAnalyzer = new DataAnalyzer();
    }

    public static void main(String[] args) {
        List<Job> jobs = jobStreamProcessor.jsonToJob(GetJsons.get());

        System.out.println("\nТоп 5 популярных навыков:");
        dataAnalyzer.mostPopularSkills(jobs).forEach(System.out::println);

        System.out.println("\nТоп 5 популярных позиций:");
        dataAnalyzer.mostPopularPositions(jobs).forEach(System.out::println);

        double salaryDiapason = 10000.0;
        System.out.println("\nСписок зарплат с шагом в '%s' и количество вакансий:".formatted(salaryDiapason));
        dataAnalyzer.analysisSalaryDistribution(jobs, salaryDiapason)
                .entrySet().forEach(e -> System.out.println("От " + (e.getKey() - salaryDiapason) +
                        " до " + e.getKey() + " - " + e.getValue() + " вакансий"));

        System.out.println("\nТоп 5 популярных местоположений вакансий:");
        dataAnalyzer.mostPopularLocation(jobs).forEach(System.out::println);

        LocalDate startDate = LocalDate.of(2024, 8, 1);
        LocalDate endDate = LocalDate.of(2024, 9, 17);
        TrendGranularity trendGranularity = new GranularityWeekly();
        System.out.println("\nНовые вакансии с %s по %s с детализацией по %s:"
                .formatted(startDate, endDate, trendGranularity));
        dataAnalyzer.analyzeTrends(jobs, startDate, endDate, trendGranularity)
                .entrySet().forEach(e -> System.out.println(e.getKey() + " - " + e.getValue() + " вакансий"));
    }
}
