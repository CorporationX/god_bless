package faang.school.godbless.lambda_stream.job_analyzer;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class DataAnalyzer {
    private List<Job> jobs;

    public DataAnalyzer(List<Job> jobs) {
        this.jobs = jobs;
    }

    private List<String> popularSkills(int limit, boolean haveDateRange, LocalDate startDate, LocalDate endDate) {
        Predicate<Job> dateRange;
        if (haveDateRange) {
            dateRange = job -> !job.getDate().isBefore(startDate) && job.getDate().isBefore(endDate);
        } else {
            dateRange = job -> true;
        }
        return jobs.stream()
                .filter(dateRange)
                .map(Job::getSkills)
                .flatMap(List::stream)
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> popularSkills(int limit) {
        return popularSkills(limit, false, null, null);
    }

    private List<String> popularPositions(int limit, boolean haveDateRange, LocalDate startDate, LocalDate endDate) {
        Predicate<Job> dateRange;
        if (haveDateRange) {
            dateRange = job -> !job.getDate().isBefore(startDate) && job.getDate().isBefore(endDate);
        } else {
            dateRange = job -> true;
        }
        return jobs.stream()
                .filter(dateRange)
                .collect(Collectors.groupingBy(Job::getPosition, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> popularPositions(int limit) {
        return popularPositions(limit, false, null, null);
    }

    public Map<String, Integer> salaryDistribution(int start, int end, int step) {
        Map<String, Integer> result = new HashMap<>();
        int[] ranges = IntStream.iterate(start, i -> i + step)
                .limit((end - start) / step + 1)
                .toArray();
        int i = 1;
        for (; i < ranges.length; i++) {
            int rangeStart = ranges[i - 1];
            int rangeEnd = ranges[i];
            String range = String.format("%s-%s", rangeStart, rangeEnd);
            int jobsCount = (int) jobs.stream()
                    .filter(job -> rangeStart < job.getSalary() && job.getSalary() <= rangeEnd)
                    .count();
            result.put(range, jobsCount);
        }
        return result;
    }

    private List<String> popularLocations(int limit, boolean haveDateRange, LocalDate startDate, LocalDate endDate) {
        Predicate<Job> dateRange;
        if (haveDateRange) {
            dateRange = job -> !job.getDate().isBefore(startDate) && job.getDate().isBefore(endDate);
        } else {
            dateRange = job -> true;
        }
        return jobs.stream()
                .filter(dateRange)
                .collect(Collectors.groupingBy(Job::getLocation, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> popularLocations(int limit) {
        return popularLocations(limit, false, null, null);
    }

    public Map<String, List<String>> analyzeTrends(LocalDate startDate, LocalDate endDate, TrendGranularity granularity) {
        Map<String, List<String>> result = new HashMap<>();
        LocalDate currentDate = startDate;
        while (currentDate.isBefore(endDate)) {
            LocalDate nextDate = getNextDate(currentDate, granularity);
            List<String> popularSkill = popularSkills(1, true, currentDate, nextDate);
            List<String> popularPosition = popularPositions(1, true, currentDate, nextDate);
            List<String> popularLocation = popularLocations(1, true, currentDate, nextDate);
            List<String> allData = new ArrayList<>();
            allData.add("Most popular skill: " + popularSkill);
            allData.add("Most popular position: " + popularPosition);
            allData.add("Most popular location: " + popularLocation);
            String date = String.format("%s - %s", currentDate, nextDate);
            result.put(date, allData);
            currentDate = nextDate;
        }
        return result;
    }

    private LocalDate getNextDate(LocalDate currentDate, TrendGranularity granularity) {
        return switch (granularity) {
            case DAILY -> currentDate.plusDays(1);
            case WEEKLY -> currentDate.plusWeeks(1);
            case MONTHLY -> currentDate.plusMonths(1);
            default -> throw new IllegalArgumentException("Invalid granularity: " + granularity);
        };
    }
}