package faang.school.godbless.lamdbastreamapi.analyzator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataAnalyzer {

    public static final Map<String, List<Integer>> diapasonOfSalary = new HashMap<>(Map.of(
            "50к-100к", new ArrayList<>(List.of(50_000,100_000)),
            "100к-150к", new ArrayList<>(List.of(100_000,150_000)),
            "150к-200к", new ArrayList<>(List.of(150_000,200_000)),
            "200к-250к", new ArrayList<>(List.of(200_000,250_000)),
            "250к-300к", new ArrayList<>(List.of(250_000,300_000))
    ));

    public static List<String> getTopSkills(List<Job> jobs, int limitTop) {
        Map<String, Long> jobCount = jobs.stream()
                .flatMap(job -> job.requirements().stream())
                .collect(Collectors.groupingBy(requirement -> requirement, Collectors.counting()));

        return jobCount.entrySet().stream()
                .sorted((job1, job2) -> job2.getValue().compareTo(job1.getValue()))
                .limit(limitTop)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> getTopPosition(List<Job> jobs, int limitTop) {
        Map<String, Long> jobCount = jobs.stream()
                .map(Job::name)
                .collect(Collectors.groupingBy(name -> name, Collectors.counting()));
        return jobCount.entrySet().stream()
                .sorted((job1, job2) -> job2.getValue().compareTo(job1.getValue()))
                .map(Map.Entry::getKey)
                .toList();
    }

    private static Stream<String> getStreamBorders(Map.Entry<String, List<Integer>> element, Job job) {
        List<Integer> borders = element.getValue();
        if (borders.get(0) <= job.proposedSalary() &&
                job.proposedSalary() < borders.get(1)) {
            return Stream.of(element.getKey());
        } else {
            return Stream.empty();
        }
    }

    public static Map<String, Long> getDistributionOfSalaries(List<Job> jobs) {
        return jobs.stream()
                .flatMap(job -> diapasonOfSalary.entrySet().stream()
                        .flatMap(element -> getStreamBorders(element, job)))
                .collect(Collectors.groupingBy(str -> str,Collectors.counting()));
    }

    public static List<String> getTopLocations(List<Job> jobs, int limitTop) {
        Map<String, Long> locationCount = jobs.stream()
                .map(Job::location)
                .collect(Collectors.groupingBy(loc -> loc, Collectors.counting()));

        return locationCount.entrySet().stream()
                .sorted((e1, e2) -> {
                    return e2.getValue().compareTo(e1.getValue());
                })
                .map(Map.Entry::getKey)
                .limit(limitTop)
                .toList();

    }
}
