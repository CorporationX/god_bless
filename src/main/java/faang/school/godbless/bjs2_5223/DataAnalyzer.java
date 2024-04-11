package faang.school.godbless.bjs2_5223;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class DataAnalyzer {

    public static void findTop5Skills(List<Job> jobs) {
        System.out.println("Top-5 skills:");
        jobs.stream()
                .flatMap(job -> job.getRequirements().stream())
                .collect(Collectors.groupingBy(skill -> skill, Collectors.counting()))
                .entrySet()
                .stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

    public static void findTop5Positions(List<Job> jobs) {
        System.out.println("Top-5 positions:");
        jobs.stream()
                .map(Job::getVacancy)
                .collect(Collectors.groupingBy(nameJob -> nameJob, Collectors.counting()))
                .entrySet()
                .stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

    public static Map<RangeSalary, Long> analyzeDistribSalaryByVacations(List<Job> jobs, Set<RangeSalary> rangeSalaries) {
        return jobs.stream()
                .map(Job::getSalary)
                .collect(Collectors.groupingBy(
                        salary -> rangeSalaries.stream()
                                .filter(rangeSalary -> salary > rangeSalary.getStart() && salary < rangeSalary.getEnd())
                                .findFirst().orElse(new RangeSalary("Other", 0, 0)),
                        Collectors.counting()
                ));
    }

    public static void findTop5Locations(List<Job> jobs) {
        System.out.println("Top-5 locations:");
        jobs.stream()
                .map(Job::getLocation)
                .collect(Collectors.groupingBy(nameJob -> nameJob, Collectors.counting()))
                .entrySet()
                .stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}
