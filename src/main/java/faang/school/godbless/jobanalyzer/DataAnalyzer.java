package faang.school.godbless.jobanalyzer;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataAnalyzer {
    public List<String> getTopSkills(List<Job> jobs) {
        Map<String, Long> collect = jobs.stream()
                .flatMap(job -> job.getRequirements().stream())
                .collect(Collectors.groupingBy(skill -> skill, Collectors.counting()));
        Stream<Map.Entry<String, Long>> sorted = collect
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed());
        return sorted
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> getTopJobTitles(List<Job> jobs) {
        Map<String, Long> collect = jobs.stream()
                .collect(Collectors.groupingBy(Job::getTitle, Collectors.counting()));
        Stream<Map.Entry<String, Long>> sorted = collect
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed());
        return sorted
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public Map<String, Long> getSalaryDistribution(List<Job> jobs) {
        return jobs.stream()
                .collect(Collectors.groupingBy(job -> {
                    double salary = job.getSalary();
                    if (salary < 50000) {
                        return "0 - 50k";
                    } else if (salary < 100000) {
                        return "50k - 100k";
                    } else if (salary < 150000) {
                        return "100k - 150k";
                    } else {
                        return "150k+";
                    }
                }, Collectors.counting()));
    }

    public List<String> getTopLocations(List<Job> jobs) {
        Map<String, Long> collect = jobs.stream()
                .collect(Collectors.groupingBy(Job::getLocation, Collectors.counting()));
        Stream<Map.Entry<String, Long>> sorted = collect
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed());
        return sorted
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public Map<String, Long> analyzeTrends(List<Job> jobs, LocalDate startDate, LocalDate endDate, TrendGranularity granularity) {
        return jobs.stream()
                .filter(job -> job.getDatePosted().isAfter(startDate)
                        && job.getDatePosted().isBefore(endDate))
                .collect(Collectors.groupingBy(job -> {
                    LocalDate date = job.getDatePosted();
                    return switch (granularity) {
                        case DAILY -> date.toString();
                        case WEEKLY -> date.with(DayOfWeek.MONDAY).toString();
                        case MONTHLY -> date.withDayOfMonth(1).toString();
                    };
                }, Collectors.counting()));
    }
}