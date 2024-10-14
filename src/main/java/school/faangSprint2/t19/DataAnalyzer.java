package school.faangSprint2.t19;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataAnalyzer {
    public List<String> getTopSkills(List<Job> jobs, int topN) {
        Map<String, Long> skillCount = jobs.stream()
                .flatMap(job -> job.getRequirements().stream())
                .collect(Collectors.groupingBy(skill -> skill, Collectors.counting()));

        return skillCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(topN)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public List<String> getTopPositions(List<Job> jobs, int topN) {
        Map<String, Long> positionCount = jobs.stream()
                .collect(Collectors.groupingBy(Job::getPosition, Collectors.counting()));

        return positionCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(topN)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public Map<String, List<Job>> getSalaryRanges(List<Job> jobs) {
        return jobs.stream().collect(Collectors.groupingBy(job -> {
            if (job.getSalary() < 50000) return "0-50k";
            else if (job.getSalary() < 100000) return "50k-100k";
            else return "100k+";
        }));
    }

    public List<String> getTopLocations(List<Job> jobs, int topN) {
        Map<String, Long> locationCount = jobs.stream()
                .collect(Collectors.groupingBy(Job::getLocation, Collectors.counting()));

        return locationCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(topN)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public Map<String, Map<String, Long>> analyzeTrends(List<Job> jobs, LocalDate startDate, LocalDate endDate, String granularity) {
        Map<String, Map<String, Long>> trends = new HashMap<>();

        long numUnits = ChronoUnit.DAYS.between(startDate, endDate);
        ChronoUnit unit = ChronoUnit.DAYS;

        if (granularity.equalsIgnoreCase("weekly")) {
            numUnits = ChronoUnit.WEEKS.between(startDate, endDate);
            unit = ChronoUnit.WEEKS;
        } else if (granularity.equalsIgnoreCase("monthly")) {
            numUnits = ChronoUnit.MONTHS.between(startDate, endDate);
            unit = ChronoUnit.MONTHS;
        }

        for (long i = 0; i < numUnits; i++) {
            LocalDate currentDate = startDate.plus(i, unit);
            LocalDate nextDate = currentDate.plus(1, unit);

            List<Job> periodJobs = jobs.stream()
                    .filter(job -> !job.getDatePosted().isBefore(currentDate) && job.getDatePosted().isBefore(nextDate))
                    .collect(Collectors.toList());

            Map<String, Long> periodData = new HashMap<>();
            periodData.put("vacancies", (long) periodJobs.size());
            periodData.put("uniqueSkills", periodJobs.stream()
                    .flatMap(job -> job.getRequirements().stream())
                    .distinct()
                    .count());

            trends.put(currentDate.toString(), periodData);
        }
        return trends;
    }
}