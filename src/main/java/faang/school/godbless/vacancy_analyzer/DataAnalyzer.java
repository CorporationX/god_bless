package faang.school.godbless.vacancy_analyzer;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataAnalyzer {
    public static List<String> getTopSkills(List<Job> jobs, int limit){
        return jobs.stream()
                .flatMap(job -> job.getRequirements().stream())
                .collect(Collectors.groupingBy(skill -> skill, Collectors.counting()))
                .entrySet().stream()
                .sorted(Comparator.comparingLong(entry -> -entry.getValue()))
                .limit(limit)
                .map(entry -> entry.getKey())
                .toList();
    }

    public static List<String> sortJobsByPopularity(List<Job> jobs){
        return jobs.stream()
                .collect(Collectors.groupingBy(Job::getPosition, Collectors.counting()))
                .entrySet().stream()
                .sorted(Comparator.comparingLong(entry -> -entry.getValue()))
                .map(entry -> entry.getKey())
                .toList();
    }

    public static Map<String, Long> getSalaryRange(List<Job> jobs){
        return jobs.stream()
                .collect(Collectors.groupingBy(e->Math.ceil(e.getSalary()/50000.0), Collectors.counting()))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(entry ->
                                (int) (entry.getKey() * 50_000 - 50_000) + "-" + (int) (entry.getKey() * 50_000),
                        Map.Entry::getValue));
    }

    public static List<String> getPopularLocations(List<Job> jobs, int num){
        return jobs.stream()
                .map(job -> job.getLocation())
                .collect(Collectors.groupingBy(location -> location, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(num)
                .map(Map.Entry::getKey)
                .toList();
    }
}
