package faang.school.godbless.BJS2_22852;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataAnalyzer {

    public List<String> getTopSkills(List<Job> jobs, int limit) {
        if (jobs == null || jobs.isEmpty() || limit <= 0) {
            throw new IllegalArgumentException("Bad parameters");
        }
        Map<String, Long> groupedSkills = jobs.stream()
                .flatMap(job -> job.getRequirements().stream())
                .collect(Collectors.groupingBy(skill -> skill, Collectors.counting()));

        return groupedSkills.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> getTopVacancies(List<Job> jobs, int limit) {
        if (jobs == null || jobs.isEmpty() || limit <= 0) {
            throw new IllegalArgumentException("Bad parameters");
        }

        Map<String, Long> groupedJobs = jobs.stream()
                .collect(Collectors.groupingBy(Job::getTitle, Collectors.counting()));

        return groupedJobs.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public Map<String, Long> analyzeSalaryCategory(List<Job> jobs, List<SalaryCategory> categories) {
        if (jobs == null || jobs.isEmpty() || categories == null || categories.isEmpty()) {
            throw new IllegalArgumentException("Bad parameters");
        }

        return jobs.stream()
                .flatMap(job -> categories.stream()
                        .filter(salaryCategory -> findJobCategory(job, salaryCategory))
                        .map(SalaryCategory::getCategoryName))
                .collect(Collectors.groupingBy(category -> category, Collectors.counting()));
    }

    public List<String> findMostPopularLocations(List<Job> jobs, int limit) {

        Map<String, Long> groupedLocations = jobs.stream()
                .collect(Collectors.groupingBy(Job::getLocation, Collectors.counting()));

        return groupedLocations.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public Map<LocalDate, Long> analyzeTrends(LocalDate startDate, LocalDate endDate, TrendGranularity granularity, List<Job> jobs) {
        return jobs.stream()
                .filter(job -> job.getDatePosted().isAfter(startDate) && job.getDatePosted().isBefore(endDate))
                .collect(Collectors.groupingBy(job -> {
                    LocalDate currentDate = job.getDatePosted();
                    return switch (granularity) {
                        case DAY -> currentDate;
                        case WEEKLY -> currentDate.with(DayOfWeek.MONDAY);
                        case MONTHLY -> currentDate.withDayOfMonth(1);
                        case YEARLY -> currentDate.withDayOfYear(1);
                    };
                }, Collectors.counting()));
    }

    private boolean findJobCategory(Job job, SalaryCategory salaryCategory) {
        return job.getSalary() >= salaryCategory.getRangeMin() && job.getSalary() < salaryCategory.getRangeMax();
    }


}
