package faang.school.godbless.vacancy_analyzer;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String job1 = "{ \"title\": \"Java Developer\", \"requirements\": [\"Java\", \"Spring\", \"Hibernate\"], \"salary\": 80000, \"location\": \"New York\", \"dateAdded\": \"2022-07-15\" }";
        String job2 = "{ \"title\": \"Frontend Developer\", \"requirements\": [\"JavaScript\", \"React\", \"HTML\", \"CSS\"], \"salary\": 75000, \"location\": \"San Francisco\", \"dateAdded\": \"2022-07-16\" }";
        String job3 = "{ \"title\": \"Data Scientist\", \"requirements\": [\"Python\", \"Machine Learning\", \"Statistics\"], \"salary\": 90000, \"location\": \"Chicago\", \"dateAdded\": \"2022-07-17\" }";
        String job4 = "{ \"title\": \"UX Designer\", \"requirements\": [\"UI/UX Design\", \"Prototyping Tools\", \"User Research\"], \"salary\": 70000, \"location\": \"Seattle\", \"dateAdded\": \"2022-07-18\" }";
        String job5 = "{ \"title\": \"Backend Engineer\", \"requirements\": [\"Python\", \"Django\", \"REST API\"], \"salary\": 85000, \"location\": \"Boston\", \"dateAdded\": \"2022-07-19\" }";
        String job6 = "{ \"title\": \"Frontend Developer\", \"requirements\": [\"Product Strategy\", \"Market Research\", \"Agile Development\"], \"salary\": 100000, \"location\": \"Austin\", \"dateAdded\": \"2022-07-20\" }";
        String job7 = "{ \"title\": \"Java Developer\", \"requirements\": [\"Linux\", \"Docker\", \"Kubernetes\"], \"salary\": 95000, \"location\": \"Denver\", \"dateAdded\": \"2022-07-21\" }";
        String job8 = "{ \"title\": \"Java Developer\", \"requirements\": [\"Java\", \"Spring Boot\", \"Microservices\"], \"salary\": 82000, \"location\": \"Los Angeles\", \"dateAdded\": \"2022-07-22\" }";
        Stream<String> jobStream = Stream.of(job1, job2, job3, job4, job5, job6, job7, job8);
        JobStreamProcessor jobStreamProcessor = new JobStreamProcessor();
        List<Job> jobs = jobStreamProcessor.processJobStream(jobStream);
        DataAnalyzer dataAnalyzer = new DataAnalyzer();
        dataAnalyzer.findTopSkills(jobs);
        Map<String, Long> positionFrequency = jobs.stream()
                .collect(Collectors.groupingBy(Job::getPosition, Collectors.counting()));
        List<Map.Entry<String, Long>> popularPositions = dataAnalyzer.getPopularPositions(positionFrequency, 3);
        System.out.println("Популярные вакансии: " + popularPositions);
        Map<String, Double> salaryByPosition = jobs.stream()
                .collect(Collectors.groupingBy(Job::getPosition, Collectors.averagingInt(Job::getSalary)));
        Map<String, Integer> salaryDistribution = DataAnalyzer.analyzeSalaryDistribution(salaryByPosition);
        System.out.println("Зарплата: " + salaryDistribution);
        List<String> top5Locations = dataAnalyzer.getTop5PopularOfficeLocations(jobs.stream()
                .map(Job::getLocation)
                .collect(Collectors.toList()));
        System.out.println("Топ 5 городов: " + top5Locations);
    }
}