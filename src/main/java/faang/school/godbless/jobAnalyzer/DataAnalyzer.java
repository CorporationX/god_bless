package faang.school.godbless.jobAnalyzer;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DataAnalyzer {

    public static void main(String[] args) {
        List<Job> jobs = List.of(
                new Job("Software Engineer", "New York", 95000, List.of("Java", "Spring", "SQL")),
                new Job("Data Scientist", "San Francisco", 120000, List.of("Python", "Machine Learning", "SQL")),
                new Job("Web Developer", "Los Angeles", 70000, List.of("HTML", "CSS", "JavaScript")),
                new Job("Project Manager", "New York", 110000, List.of("Project Management", "Agile", "Scrum")),
                new Job("Software Engineer", "San Francisco", 105000, List.of("Java", "Spring", "Docker")),
                new Job("Data Analyst", "Los Angeles", 85000, List.of("Excel", "SQL", "Data Visualization")),
                new Job("UX Designer", "Chicago", 90000, List.of("UX Design", "Wireframing", "User Research")),
                new Job("Software Engineer", "San Francisco", 115000, List.of("Java", "Kotlin", "Spring")),
                new Job("Product Manager", "Chicago", 120000, List.of("Product Management", "Agile", "Market Research")),
                new Job("Business Analyst", "New York", 95000, List.of("Business Analysis", "SQL", "Data Modeling"))
        );

        // Example usage of the methods
        System.out.println("Top 5 Requirements: " + findTOPJobEntities(jobs,job->job.getRequirements().stream(),5));
        System.out.println("Top 5 Vacancies: " + findTOPJobEntities(jobs,job-> Stream.of(job.getVacancy()),5));
        System.out.println("Top 5 Locations: " + findTOPJobEntities(jobs,job-> Stream.of(job.getLocation()),5));
        System.out.println("Salary Graph: " + getSalaryGraph(jobs, 50000));
    }

    public static <T> List<T> findTOPJobEntities(List<Job> jobs, Function<Job, Stream<T>> entityExtractor, int topCount) {
        return jobs.stream()
                .flatMap(entityExtractor)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((Map.Entry.<T, Long>comparingByValue().reversed()))
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<String, Integer> getSalaryGraph(List<Job> jobs, int step) {
        double maxSalary = jobs.stream()
                .mapToDouble(Job::getSalary)
                .max()
                .orElse(0);
        double maxSalaryOnGraph = Math.ceil(maxSalary / step) * step;

        return IntStream.rangeClosed(0, (int) maxSalaryOnGraph / step)
                .mapToObj(i -> new Range(i * step, (i + 1) * step))
                .collect(Collectors.toMap(
                                Range::toString,
                                range -> (int) jobs.stream()
                                        .filter(job -> range.isInRange(job.getSalary()))
                                        .count(),
                                (existing, replacement) -> existing,
                                LinkedHashMap::new
                        )
                );
    }

    record Range(double lowerBound, double upperBound) {
        public boolean isInRange(double salary) {
            return lowerBound <= salary && salary < upperBound;
        }

        @Override
        public String toString() {
            return String.format("%.0f-%.0f", lowerBound, upperBound);
        }
    }
}
