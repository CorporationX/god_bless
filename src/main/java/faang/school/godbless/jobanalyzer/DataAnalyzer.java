package faang.school.godbless.jobanalyzer;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataAnalyzer {

    public static void getMostPopularSkills(List<Job> jobs) {
        jobs.stream().
                flatMap(job -> job.getRequirementsForCandidates().stream())
                .collect(Collectors.groupingBy(requirement -> requirement, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5).forEach(entry -> System.out.println(entry.getKey()));
    }

    public static void getMostPopularVacancy(List<Job> jobs) {
        jobs.stream()
                .map(Job::getName)
                .collect(Collectors.groupingBy(vacancy -> vacancy, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5).forEach(entry -> System.out.println(entry.getKey()));
    }

    public static Map<String, Long> distributeSalariesAcrossDifferentRanges(List<Job> jobs) {
        return jobs.stream()
                .map(Job::getRangeSalary)
                .collect(Collectors.groupingBy(rangeSalary -> rangeSalary, Collectors.counting()));
    }

    public static void getMostPopularLocations(List<Job> jobs) {
        jobs.stream()
                .map(Job::getLocation)
                .collect(Collectors.groupingBy(adress -> adress, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5).forEach(entry -> System.out.println(entry.getKey()));
    }

}
