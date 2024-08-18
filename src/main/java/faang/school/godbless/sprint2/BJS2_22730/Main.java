package faang.school.godbless.sprint2.BJS2_22730;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job("Software Engineer", Arrays.asList("Java", "Spring"), 80000, "New York", LocalDate.of(2024, 8, 1)),
                new Job("Backend Developer", Arrays.asList("Python", "Django"), 75000, "San Francisco", LocalDate.of(2024, 8, 2)),
                new Job("DevOps Engineer", Arrays.asList("Docker", "Kubernetes"), 90000, "Austin", LocalDate.of(2024, 8, 10)),
                new Job("Frontend Developer", Arrays.asList("JavaScript", "React"), 70000, "Seattle", LocalDate.of(2024, 8, 15)),
                new Job("Full Stack Developer", Arrays.asList("Java", "React"), 85000, "Boston", LocalDate.of(2024, 8, 20)),
                new Job("Data Scientist", Arrays.asList("Python", "Machine Learning"), 95000, "Chicago", LocalDate.of(2024, 9, 1))
        );

        DataAnalyzer.analyzeTrends(
                LocalDate.of(2024, 8, 1), LocalDate.of(2024, 9, 30), TrendGranularity.WEEKLY, jobs
        );
    }
}
