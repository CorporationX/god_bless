package school.faang.analyzerjob;

import java.time.LocalDate;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class DataAnalyzer {

    public static List<String> top5Skills(List<Job> jobs) {
        return jobs.stream()
                .flatMap(job -> job.getRequirements().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> top5PopularPositions(List<Job> jobs) {
        return jobs.stream()
                .collect(Collectors.groupingBy(Job::getPosition, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static Map<String, Long> salaryDistribution(List<Job> jobs) {
        return jobs.stream()
                .collect(Collectors.groupingBy(
                        job -> {
                            int salary = job.getSalary();
                            if (salary < 50000) return "0-50k";
                            else if (salary < 100000) return "50k-100k";
                            else if (salary < 150000) return "100k-150k";
                            else return "150k+";
                        },
                        Collectors.counting()
                ));
    }

    public static List<String> top5PopularLocations(List<Job> jobs) {
        return jobs.stream()
                .collect(Collectors.groupingBy(Job::getLocation, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static Map<String, Long> analyzeTrends(List<Job> jobs, LocalDate startDate, LocalDate endDate, String granularity) {
        return jobs.stream()
                .filter(job -> !job.getDatePosted().isBefore(startDate) && !job.getDatePosted().isAfter(endDate))
                .collect(Collectors.groupingBy(
                        job -> {
                            switch (granularity.toLowerCase()) {
                                case "daily":
                                    return job.getDatePosted().toString();
                                case "weekly":
                                    return "Week " + job.getDatePosted().getYear() + "-" + job.getDatePosted().getDayOfYear() / 7;
                                case "monthly":
                                    return job.getDatePosted().getMonth().toString() + " " + job.getDatePosted().getYear();
                                default:
                                    return job.getDatePosted().toString();
                            }
                        },
                        Collectors.counting()
                ));
    }
}

