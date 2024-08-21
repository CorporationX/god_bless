package faang.school.godbless.BJS2_23000;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataAnalyzer {

    public static List<String> findTopNMostPopularSkills(List<Job> jobs, int topN) {
        Map<String, Long> skillByCountSkill = jobs.stream()
                .flatMap(job -> job.getRequirements().stream())
                .collect(Collectors.groupingBy(skill -> skill, Collectors.counting()));

        return skillByCountSkill.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(topN)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> findTopNMostPopularPositions(List<Job> jobs, int topN) {
        Map<String, Long> jobNameByCountJob = jobs.stream()
                .collect(Collectors.groupingBy(Job::getName, Collectors.counting()));

        return jobNameByCountJob.entrySet().stream()
                .peek(System.out::println)
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(topN)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<String, Long> mapSalaryRangeByCount(List<Job> jobs) {
        int range = 50_000;
        return jobs.stream()
                .collect(Collectors.groupingBy(
                        job -> {
                            int lowerBound = job.getSalary() / range * range;
                            int upperBound = lowerBound - 1 + range;
                            return lowerBound + " - " + upperBound;
                        },
                        Collectors.counting())
                );
    }

    public static List<String> findTop5MostPopularLocations(List<Job> jobs) {
        Map<String, Long> locationByCountLocation = jobs.stream()
                .collect(Collectors.groupingBy(Job::getLocation, Collectors.counting()));

        return locationByCountLocation.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<LocalDate, Difference> analyzeTrends(List<Job> jobs, LocalDate startDate, LocalDate endDate, JobDifference jobDifference) {
        jobs = jobs.stream()
                .filter(job -> {
                    LocalDate date = job.getDateAddition();
                    return date.isAfter(startDate) && date.isBefore(endDate);
                })
                .toList();

        return jobDifference.calculateDifference(
                startDate, endDate, calculateDifferencePerDay(jobs));
    }

    private static Map<LocalDate, Difference> calculateDifferencePerDay(List<Job> jobs) {
        Map<LocalDate, List<Job>> dateByJobs = jobs.stream()
                .collect(Collectors.groupingBy(Job::getDateAddition));

        return dateByJobs.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> new Difference(
                                entry.getKey(),
                                entry.getValue().stream().mapToInt(Job::getSalary).sum()
                        )
                ));
    }
}
