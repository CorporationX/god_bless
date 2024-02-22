package AnalyzatorVakansiy;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Данные в формате JSON
        List<String> jsonJobs = Arrays.asList(
                "{\"position\":\"Data Scientist\",\"candidateRequirements\":[\"Java\",\"Spring\",\"SQL\"],\"salary\":80000,\"location\":\"Moscow\",\"vacancyDate\":\"2024-02-14T12:00:00\"}",
                "{\"position\":\"Java Developer\",\"candidateRequirements\":[\"Python\",\"SQL\",\"Statistics\"],\"salary\":100000,\"location\":\"Berlin\",\"vacancyDate\":\"2024-02-13T14:30:00\"}",
                "{\"position\":\"UI/UX Designer\",\"candidateRequirements\":[\"Java\",\"Adobe Creative Suite\"],\"salary\":70000,\"location\":\"Moscow\",\"vacancyDate\":\"2023-01-12T10:45:00\"}",
                "{\"position\":\"Java Developer\",\"candidateRequirements\":[\"Java\",\"Spring\"],\"salary\":240000,\"location\":\"Moscow\",\"vacancyDate\":\"2023-01-12T10:45:00\"}",
                "{\"position\":\"Java Developer\",\"candidateRequirements\":[\"Java\",\"Spring\"],\"salary\":140000,\"location\":\"Paris\",\"vacancyDate\":\"2024-01-12T10:45:00\"}",
                "{\"position\":\"UI/UX Designer\",\"candidateRequirements\":[\"Java\",\"Spring\"],\"salary\":65000,\"location\":\"Berlin\",\"vacancyDate\":\"2024-01-12T10:45:00\"}"
        );

        // Инициализация JobScraper и JobStreamProcessor
        JobScraper jobScraper = new JobScraper();
        JobStreamProcessor jobStreamProcessor = new JobStreamProcessor(jobScraper);

        // Получение списка вакансий из JSON
        List<Job> jobs = jobStreamProcessor.processJobs(jsonJobs.stream());

        // Инициализация DataAnalyzer
        DataAnalyzer dataAnalyzer = new DataAnalyzer(jobs);

        // Вызов методов DataAnalyzer для анализа данных
        List<String> topSkills = dataAnalyzer.getTopSkills(jobs, 4);
        List<String> topPositions = dataAnalyzer.getTopPositions(jobs, 3);
        List<String> topLocations = dataAnalyzer.getTopLocations(jobs, 3);
        int salaryRange = 50000;
        var salaryDistribution = dataAnalyzer.getSalaryDistribution(jobs, salaryRange);

        // Вывод результатов анализа
        System.out.println("Top Skills: " + topSkills);
        System.out.println("Top Positions: " + topPositions);
        System.out.println("Top Locations: " + topLocations);
        System.out.println("Salary Distribution: " + salaryDistribution);

        // Тестирование анализа трендов
        LocalDate startDate = LocalDate.parse("2024-02-01");
        LocalDate endDate = LocalDate.parse("2024-02-15");

        TrendGranularity granularity = TrendGranularity.DAILY;
        TrendGranularity granularity2 = TrendGranularity.MONTHLY;

        Map<LocalDate, Long> jobCountTrend = dataAnalyzer.analyzeTrends(startDate, endDate, granularity);
        System.out.println("Job Count Trend: " + jobCountTrend);

        Map<String, Long> skillsTrend = dataAnalyzer.getTopSkillsTrends(jobs, granularity2, startDate, endDate);
        System.out.println("Job Skills Trend: " + skillsTrend);
    }
}