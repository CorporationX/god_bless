package job.analyzer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<String> jobDataStream = Stream.of(
                "{\"name\":\"Software Engineer\",\"requirements\":[\"Java\",\"Spring\",\"REST\"],\"salary\":120000,\"location\":\"San Francisco\",\"createdAt\":\"2024-01-02\"}",
                "{\"name\":\"Data Scientist\",\"requirements\":[\"Python\",\"Machine Learning\",\"Data Analysis\"],\"salary\":130000,\"location\":\"New York\",\"createdAt\":\"2024-01-17\"}",
                "{\"name\":\"DevOps Engineer\",\"requirements\":[\"AWS\",\"Docker\",\"CI/CD\", \"Java\"],\"salary\":115000,\"location\":\"Los Angeles\",\"createdAt\":\"2024-03-15\"}",
                "{\"name\":\"DevOps Engineer\",\"requirements\":[\"AWS\",\"Docker\",\"CI/CD\", \"Java\"],\"salary\":315000,\"location\":\"Los Angeles\",\"createdAt\":\"2024-03-15\"}",
                "{\"name\":\"Frontend Developer\",\"requirements\":[\"JavaScript\",\"React\",\"HTML\"],\"salary\":90000,\"location\":\"San Francisco\",\"createdAt\":\"2024-04-05\"}",
                "{\"name\":\"Backend Developer\",\"requirements\":[\"Java\",\"Spring\",\"Microservices\"],\"salary\":110000,\"location\":\"New York\",\"createdAt\":\"2024-04-07\"}",
                "{\"name\":\"Backend Developer\",\"requirements\":[\"Java\",\"Spring\"],\"salary\":300000,\"location\":\"New York\",\"createdAt\":\"2024-04-07\"}",
                "{}",
                "{\""
        );

        JobStreamProcessor jobStreamProcessor = new JobStreamProcessor(new JsonJobScraper());
        List<Job> jobs = jobStreamProcessor.process(jobDataStream);

        List<SalaryRange> salaryRange = Arrays.asList(
            new SalaryRange(0, 50_000),
            new SalaryRange(50_000, 100_000),
            new SalaryRange(100_000, 200_000),
            new SalaryRange(200_000, 300_000)
        );

        System.out.printf("1. Most popular skills: %s\n", DataAnalyzer.mostPopularSkills(jobs, 2));
        System.out.printf("2. Most popular positions: %s\n", DataAnalyzer.mostPopularPositions(jobs, 2));
        System.out.printf("3. Salary range by position: %s\n", DataAnalyzer.salaryCountVacanciesAnalyze(jobs, salaryRange));
        System.out.printf("4. Most popular location: %s\n", DataAnalyzer.mostPopularLocation(jobs, 2));
    }
}
