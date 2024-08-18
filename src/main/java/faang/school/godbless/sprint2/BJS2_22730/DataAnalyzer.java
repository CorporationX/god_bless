package faang.school.godbless.sprint2.BJS2_22730;

import lombok.NonNull;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataAnalyzer {
    public static void printTop5Skills(List<Job> jobs) {
        jobs.stream()
                .flatMap(job -> job.getSkills().stream())
                .collect(Collectors.groupingBy(j -> j, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .forEach(entry -> System.out.println(entry.getKey()));
    }

    public static void printTopJobTitles(@NonNull List<Job> jobs, @NonNull Integer topOf) {
        jobs.stream()
                .map(Job::getJobTitle)
                .collect(Collectors.groupingBy(j -> j, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(topOf)
                .forEach(entry -> System.out.println(entry.getKey()));
    }

    public static Map<String, Long> getSalaryRangeDistribution(@NonNull List<Job> jobs) {
        return jobs.stream()
                .collect(Collectors.groupingBy(DataAnalyzer::getSalaryRange, Collectors.counting()));
    }

    public static void printTop5OfficeLocations(@NonNull List<Job> jobs) {
        jobs.stream()
                .map(Job::getLocation)
                .collect(Collectors.groupingBy(j -> j, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .forEach(entry -> System.out.print(entry.getKey() + ", "));
    }

    public static void analyzeTrends(LocalDate startDate, LocalDate endDate, TrendGranularity granularity, List<Job> jobs) {
        jobs.stream()
                .filter(job ->
                        job.getVacancyPublishingDate().isBefore(endDate) && job.getVacancyPublishingDate().isAfter(startDate))
                .collect(Collectors.groupingBy(
                        j -> formatDateByGranularity(j.getVacancyPublishingDate(), granularity)
                ))
                .forEach((period, jobList) -> analyzeAndPrintGroup(jobList));
    }

    private static String formatDateByGranularity(LocalDate date, TrendGranularity granularity) {
        switch (granularity) {
            case DAILY:
                return date.toString();
            case WEEKLY:
                return date.with(TemporalAdjusters.previousOrSame(java.time.DayOfWeek.MONDAY)).toString();
            case MONTHLY:
                return date.with(TemporalAdjusters.firstDayOfMonth()).toString();
            default:
                throw new IllegalArgumentException("Unknown granularity: " + granularity);
        }
    }

    private static void analyzeAndPrintGroup(List<Job> jobs) {
        if (jobs.isEmpty()) {
            return;
        }

        String period = formatDateByGranularity(jobs.get(0).getVacancyPublishingDate(), TrendGranularity.WEEKLY);

        // Print the period
        System.out.println("Period: " + period);

        // Count the number of jobs
        System.out.println("Job Count: " + jobs.size());

        System.out.print("Top 10 jobs: ");
        DataAnalyzer.printTopJobTitles(jobs, 10);

        System.out.print("Top 5 skills: ");
        DataAnalyzer.printTop5Skills(jobs);

        System.out.print("Top 5 office locations: ");
        DataAnalyzer.printTop5OfficeLocations(jobs);

        System.out.println();
    }

    private static String getSalaryRange(Job job) {
        int salary = job.getProposedSalary();
        if (salary < 50000) {
            return "0-50k";
        } else if (salary < 100000) {
            return "50k-100k";
        } else if (salary < 150000) {
            return "100k-150k";
        } else if (salary < 200000) {
            return "150k-200k";
        } else if (salary < 250000) {
            return "200k-250k";
        } else {
            return "250k+";
        }
    }
}
