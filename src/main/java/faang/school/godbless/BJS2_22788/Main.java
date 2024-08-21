package faang.school.godbless.BJS2_22788;

import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String javaDeveloper = """
        {
            "position": "Java Developer",
            "requirements": ["Java", "Spring", "REST APIs"],
            "salary": 160000,
            "location": "Remote",
            "datePosted": "2024-08-15"
        }
        """;
        String dataScientist = """
        {
            "position": "Data Scientist",
            "requirements": ["Python", "Machine Learning", "REST APIs"],
            "salary": 150000,
            "location": "New York",
            "datePosted": "2024-08-16"
        }
        """;
        String frontendDeveloper = """
        {
            "position": "Frontend Developer",
            "requirements": ["JavaScript", "Angular", "React", "HTML", "CSS"],
            "salary": 110000,
            "location": "San Francisco",
            "datePosted": "2024-08-17"
        }
        """;
        Stream<String> jsonStream = Stream.of(javaDeveloper, dataScientist, frontendDeveloper);
        JobStreamProcessor processor = new JobStreamProcessor();
        List<Job> jobs = processor.processJobs(jsonStream);

        System.out.println("Top 5 the most popular skills in jobs:");
        DataAnalyzer.findTop5TheMostPopularSkills(jobs).forEach(System.out::println);

        System.out.println("Top 5 the most popular positions in jobs:");
        DataAnalyzer.findTop5TheMostPopularPositions(jobs).forEach(System.out::println);

        System.out.println("Analyze salaries distribution by job:");
        DataAnalyzer.analyzeSalariesDistributionByJob(jobs).forEach((salaryRange, jobsAmount) ->
                System.out.println("Range: " + salaryRange.getRangeName() + " - " + jobsAmount + " jobs"));

        System.out.println("Top 5 the most popular job locations:");
        DataAnalyzer.findTop5TheMostPopularJobLocations(jobs).forEach(System.out::println);
    }
}
