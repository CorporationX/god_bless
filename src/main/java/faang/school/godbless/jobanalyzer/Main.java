package faang.school.godbless.jobanalyzer;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<String> jobDataStream = Stream.of(
                "{\"title\":\"Software Engineer\",\"requirements\":[\"Java\",\"Spring\",\"REST\"],\"salary\":120000,\"location\":\"San Francisco\",\"datePosted\":\"2024-01-02\"}",
                "{\"title\":\"Data Scientist\",\"requirements\":[\"Python\",\"Machine Learning\",\"Data Analysis\"],\"salary\":130000,\"location\":\"New York\",\"datePosted\":\"2024-01-17\"}",
                "{\"title\":\"DevOps Engineer\",\"requirements\":[\"AWS\",\"Docker\",\"CI/CD\"],\"salary\":115000,\"location\":\"Los Angeles\",\"datePosted\":\"2024-03-15\"}",
                "{\"title\":\"Frontend Developer\",\"requirements\":[\"JavaScript\",\"React\",\"HTML\"],\"salary\":90000,\"location\":\"San Francisco\",\"datePosted\":\"2024-04-05\"}",
                "{\"title\":\"Backend Developer\",\"requirements\":[\"Java\",\"Spring\",\"Microservices\"],\"salary\":110000,\"location\":\"New York\",\"datePosted\":\"2024-04-07\"}"
        );

        JobStreamProcessor processor = new JobStreamProcessor();
        List<Job> jobs = processor.processJobs(jobDataStream);

        DataAnalyzer analyzer = new DataAnalyzer();

        System.out.println("Top 5 Skills: " + analyzer.getTopSkills(jobs));
        System.out.println("Top 5 Job Titles: " + analyzer.getTopJobTitles(jobs));
        System.out.println("Salary Distribution: " + analyzer.getSalaryDistribution(jobs));
        System.out.println("Top 5 Locations: " + analyzer.getTopLocations(jobs));

        LocalDate startDate = LocalDate.of(2024, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 6, 1);
        System.out.println("Trends: " + analyzer.analyzeTrends(jobs, startDate, endDate, TrendGranularity.MONTHLY));
    }
}