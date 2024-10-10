package job_analyzer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataAnalyzer {
    public void printTop5Skills(List<Job> jobs) {
        Map<String, Long> skillCount = jobs.stream()
                .flatMap(job -> job.getRequirements().stream())
                .collect(Collectors.groupingBy(skill -> skill, Collectors.counting()));

        skillCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

    public void printTop5Positions(List<Job> jobs) {
        Map<String, Long> positionCount = jobs.stream()
                .collect(Collectors.groupingBy(Job::getPosition, Collectors.counting()));

        positionCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

    public void printSalaryDistribution(List<Job> jobs) {
        Map<String, Long> salaryDistribution = jobs.stream()
                .collect(Collectors.groupingBy(job -> {
                    if (job.getSalary() < 50000) return "0-50k";
                    else if (job.getSalary() < 100000) return "50k-100k";
                    else return "100k+";
                }, Collectors.counting()));

        salaryDistribution.forEach((range, count) -> System.out.println(range + ": " + count));
    }

    public void printTop5Locations(List<Job> jobs) {
        Map<String, Long> locationCount = jobs.stream()
                .collect(Collectors.groupingBy(Job::getLocation, Collectors.counting()));

        locationCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}
