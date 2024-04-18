package faang.school.godbless.VacancyAnalyzer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        DataAnalyzer analyzer = new DataAnalyzer();
        List<Job> jobs = getJobs();

        System.out.println("getMostPopularNames:");
        analyzer.getMostPopularNames(jobs, 2).forEach(System.out::println);

        System.out.println("\ngetMostPopularOfficeLocations:");
        analyzer.getMostPopularOfficeLocations(jobs, 2).forEach(System.out::println);

        System.out.println("\ngetMostPopularSkills:");
        analyzer.getMostPopularSkills(jobs, 2).forEach(System.out::println);

        System.out.println("\ngetSalaryIntervalsWithJobs:");
        analyzer.getSalaryIntervalsWithJobs(jobs, Set.of(new SalaryRange("50.000-100.000", 50000, 100000)))
                .forEach((key, val) -> System.out.println(key + "->" + val));

        System.out.println("\nanalyzeTrends:");
        analyzer.analyzeTrends(jobs, LocalDate.now().minusMonths(3), LocalDate.now(), TrendGranularity.DAY)
                .forEach((key, val) -> System.out.println(key + "->" + val));
    }

    private static List<Job> getJobs() {
        Job job1 = new Job("Software Engineer", Arrays.asList("Java", "Python"), 80000, "San Francisco", LocalDateTime.of(2024, 4, 10, 12, 0));
        Job job2 = new Job("Data Scientist", Arrays.asList("Python", "Machine Learning"), 90000, "New York", LocalDateTime.of(2024, 4, 9, 10, 30));
        Job job3 = new Job("UX Designer", Arrays.asList("UI/UX Design", "Adobe XD"), 75000, "Los Angeles", LocalDateTime.of(2024, 4, 8, 9, 15));
        Job job4 = new Job("Project Manager", Arrays.asList("Project Management", "Agile"), 85000, "Chicago", LocalDateTime.of(2024, 4, 7, 14, 45));
        Job job5 = new Job("Marketing Specialist", Arrays.asList("Digital Marketing", "Social Media"), 70000, "Seattle", LocalDateTime.of(2024, 4, 6, 8, 0));
        return List.of(job1, job2, job3, job4, job5);
    }
}
