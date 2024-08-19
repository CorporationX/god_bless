package faang.school.godbless.BJS222750;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataAnalyzer {
    public List<String> getTopSkills(List<Job> jobs, int limit) {
        return jobs.stream()
                .map(Job::getRequirements)
                .flatMap(List::stream)
                .collect(Collectors.groupingBy(skill -> skill, Collectors.counting()))
                .entrySet().stream()
                .sorted(Comparator.comparingLong(Map.Entry<String, Long>::getValue).reversed())
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }


    public List<String> getTopJobTitles(List<Job> jobs, int limit){
        return jobs.stream()
                .map(Job::getJobTitle)
                .collect(Collectors.groupingBy(title -> title, Collectors.counting()))
                .entrySet().stream()
                .sorted(Comparator.comparingLong(Map.Entry<String, Long>::getValue).reversed())
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public Map<Integer, Long> analyzeSalaryDistribution(List<Job> jobs, Integer round){
        return jobs.stream()
                .collect(Collectors.groupingBy(
                        job -> (int) (Math.floor(job.getSalary() / round) * round),
                        Collectors.counting()
                ));
    }

    public List<String> getTopLocations(List<Job> jobs, int limit){
        return jobs.stream()
                .collect(Collectors.groupingBy(Job::getLocation, Collectors.counting()))
                .entrySet().stream()
                .sorted(Comparator.comparingLong(Map.Entry<String, Long>::getValue).reversed())
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<LocalDate, Long> analizeTrends(LocalDate startDate, LocalDate endDate, TrendGranularity granularity, List<Job> jobs) {
        return jobs.stream()
                .filter(job -> job.getPostingDate().isAfter(startDate) && job.getPostingDate().isBefore(endDate))
                .collect(Collectors.groupingBy(job -> {
                    LocalDate currDate = job.getPostingDate();
                    return switch (granularity) {
                        case DAY -> currDate;
                        case WEEK -> currDate.with(DayOfWeek.MONDAY);
                        case MONTH -> currDate.withDayOfMonth(1);
                        case YEAR -> currDate.withDayOfYear(1);
                    };
                }, Collectors.counting()));
    }

}
