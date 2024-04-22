package faang.school.godbless.vacancyAnalyzer;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static final List<Job> jobs = getJobs();

    public static void main(String[] args) {
        DataAnalyzer dataAnalyzer = new DataAnalyzer();
        System.out.println(dataAnalyzer.findTopXRequirements(jobs, 2));
        System.out.println(dataAnalyzer.findTopXPopularPositions(jobs, 2));
        System.out.println(dataAnalyzer.countJobsBySalaryRange(jobs, 50000));
        System.out.println(dataAnalyzer.findTopXLocations(jobs, 2));
        System.out.println(dataAnalyzer.analyzeTrends(jobs, LocalDate.now().minusMonths(1), LocalDate.now(), TrendGranularity.DAY_OF_YEAR));

    }

    private static List<Job> getJobs() {
        Job job1 = new Job("Software Engineer", Arrays.asList("Java", "Python"), 80000, "San Francisco", LocalDate.of(2024, 4, 10));
        Job job2 = new Job("Data Scientist", Arrays.asList("Python", "Machine Learning"), 90000, "New York", LocalDate.of(2023, 4, 9));
        Job job3 = new Job("UX Designer", Arrays.asList("UI/UX Design", "Adobe XD"), 75000, "Los Angeles", LocalDate.of(2024, 1, 8));
        Job job4 = new Job("Project Manager", Arrays.asList("Project Management", "Agile"), 85000, "Chicago", LocalDate.of(2024, 2, 7));
        Job job5 = new Job("Marketing Specialist", Arrays.asList("Digital Marketing", "Social Media"), 70000, "Seattle", LocalDate.of(2024, 4, 6));
        return List.of(job1, job2, job3, job4, job5);
    }

}
