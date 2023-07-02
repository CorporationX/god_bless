package faang.school.godbless.task.jobAnalyzer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DataAnalyzer {

    public static List<String> getTop5RequiredSkills(List<Job> jobs) {
        return jobs.stream()
                .flatMap(job -> job.getRequiredSkills().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> getTop5Positions(List<Job> jobs) {
        return jobs.stream()
                .collect(Collectors.groupingBy(Job::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<String, Long> getSalaryGroupCounting(List<Job> jobs) {
        return jobs.stream()
                .collect(Collectors.groupingBy(job -> (int) Math.ceil(job.getSalary() / 50_000.0), Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        es -> (es.getKey() - 1) * 50_000 + "-" + es.getKey() * 50_000,
                        Map.Entry::getValue
                ));
    }

    public static List<String> getTop5Offices(List<Job> jobs) {
        return jobs.stream()
                .map(Job::getLocation)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static void main(String[] args) {
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job("Java Junior", 60_000, "Kazan", LocalDate.now(),
                List.of("Java 8", "SQL", "jUnit")));

        jobs.add(new Job("Java Middle", 90_000, "Kazan", LocalDate.now(),
                List.of("Java 8", "SQL", "jUnit", "Spring", "Docker", "Kafka")));

        jobs.add(new Job("Java Senior", 190_000, "St. Petersburg", LocalDate.now(),
                List.of("Java 8", "SQL", "jUnit", "Spring", "Kafka", "Kubernetes", "System design")));

        jobs.add(new Job("Java Middle", 155_000, "Moscow", LocalDate.now(),
                List.of("Java 8", "SQL", "Mockito", "Spring", "Docker")));

        jobs.add(new Job("Kotlin Senior", 220_000, "Moscow", LocalDate.now(),
                List.of("Kotlin ", "SQL", "Coroutines", "Vertx", "Redis")));

        System.out.println(getTop5RequiredSkills(jobs));
        System.out.println(getTop5Positions(jobs));
        System.out.println(getTop5Offices(jobs));
        System.out.println(getSalaryGroupCounting(jobs));

    }

}
