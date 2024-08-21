package faang.school.godbless.bjs2_22762;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class DataAnalyzer {
    // 1
    public List<String> getTopSkills(List<Job> jobs, int count) {
        return jobs.stream()
                .flatMap(job -> job.getRequirements().stream())
                .collect(Collectors.groupingBy(skill -> skill, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(count)
                .map(Map.Entry::getKey)
                .toList();
    }

    // 2
    public List<String> getTopJobTitles(List<Job> jobs, int count) {
        return jobs.stream()
                .collect(Collectors.groupingBy(Job::getTitle, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(count)
                .map(Map.Entry::getKey)
                .toList();
    }

    // 3
    public Map<String, Long> getSalaryDistribution(List<Job> jobs, List<Integer> intervals) {
        return jobs.stream()
                .collect(Collectors.groupingBy(
                        job -> defineIntervalAsString(job.getSalary(), intervals),
                        Collectors.counting()
                ));
    }

    private String defineIntervalAsString(double salary, List<Integer> intervals) {
        Integer interval = intervals.stream()
                .filter(value -> salary < value)
                .findFirst()
                .orElse(0);

        if (interval == 0) {
            return intervals.get(intervals.size() - 1).toString() + "+";
        }

        int index = intervals.indexOf(interval);
        int rightSide = interval - 1;
        if (index == 0) {
            return "0 - " + rightSide;
        } else {
            return intervals.get(index - 1).toString() + " - " + rightSide;
        }
    }

    // 4
    public List<String> getTopLocations(List<Job> jobs, int count) {
        return jobs.stream()
                .collect(Collectors.groupingBy(Job::getLocation, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(count)
                .map(Map.Entry::getKey)
                .toList();
    }

    // 5
    public Map<LocalDate, JobChangesDto> analyzeTrends(List<Job> jobs, LocalDate startDate, LocalDate endDate, TrendGranularity granularity) {
        List<Job> filteredJobs = jobs.stream()
                .filter(job -> job.isPostedBetweenInclusive(startDate, endDate))
                .filter(job -> {
                    switch (granularity) {
                        case DAILY -> {
                            return true;
                        }
                        case WEEKLY -> {
                            return isDatePlusWeeks(startDate, job.getDatePosted());
                        }
                        case MONTHLY -> {
                            return isDatePlusMonths(startDate, job.getDatePosted());
                        }
                        default -> throw new IllegalArgumentException("Unsupported granularity: " + granularity);
                    }
                })
                .toList();

        Map<LocalDate, Long> jobsByDateCountSortedByDate = filteredJobs.stream()
                .collect(Collectors.groupingBy(
                        Job::getDatePosted,
                        TreeMap::new,
                        Collectors.counting()
                ));

        AtomicReference<Long> previousCount = new AtomicReference<>(null);
        Map<LocalDate, JobChangesDto> jobTrendsByDate = jobsByDateCountSortedByDate.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> {
                            Long currentCount = entry.getValue();
                            Long change = previousCount.get() == null ? 0L : currentCount - previousCount.get();
                            previousCount.set(currentCount);
                            return new JobChangesDto(currentCount, change);
                        }
                ));

        return new TreeMap<>(jobTrendsByDate);
    }

    private static boolean isDatePlusWeeks(LocalDate date, LocalDate otherDate) {
        return otherDate.isEqual(date) || ChronoUnit.DAYS.between(date, otherDate) % 7 == 0;
    }

    private static boolean isDatePlusMonths(LocalDate date, LocalDate otherDate) {
        if (otherDate.equals(date)) {
            return true;
        }

        boolean check = false;
        while (date.isBefore(otherDate) || date.isEqual(otherDate)) {
            date = date.plusMonths(1);
            if (date.isEqual(otherDate)) {
                check = true;
                break;
            }
        }

        return check;
    }
}
