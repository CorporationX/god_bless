package school.faang.jobanalysis;

import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

@Data
public class DataAnalyzer {
    private final List<Job> jobs;

    public void printTop5Skills() {
        Map<String, Long> skillCount = jobs.stream()
                .flatMap(job -> job.getRequirements().stream())
                .collect(Collectors.groupingBy(skill -> skill, Collectors.counting()));

        skillCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

    public void printTop5Positions() {
        Map<String, Long> positionCount = jobs.stream()
                .collect(Collectors.groupingBy(job -> job.getPosition(), Collectors.counting()));

        positionCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

    public void printSalaryDistribution() {
        Map<String, Long> salaryDistribution = jobs.stream()
                .collect(Collectors.groupingBy(job -> {
                    if (job.getSalary() < 50000) return "0-50k";
                    else if (job.getSalary() < 100000) return "50k-100k";
                    else if (job.getSalary() >= 100000 &&
                            job.getSalary() <= 150000) return "100k-150k";
                    else return "150k+";
                }, Collectors.counting()));
        salaryDistribution.forEach((range, count) -> System.out.println(range + ": " + count));
    }

    public void printTop5Locations() {
        Map<String, Long> locationCount = jobs.stream()
                .collect(Collectors.groupingBy(Job::getLocation, Collectors.counting()));

        locationCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}
