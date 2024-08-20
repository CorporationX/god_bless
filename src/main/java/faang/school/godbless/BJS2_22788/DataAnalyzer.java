package faang.school.godbless.BJS2_22788;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class DataAnalyzer {
    private static List<SalaryRange> salaryRanges = new ArrayList<>();

    static {
        salaryRanges.add(new SalaryRange(BigDecimal.valueOf(0), BigDecimal.valueOf(50000), "0-50k"));
        salaryRanges.add(new SalaryRange(BigDecimal.valueOf(50000), BigDecimal.valueOf(100000), "50k-100k"));
        salaryRanges.add(new SalaryRange(BigDecimal.valueOf(100000), BigDecimal.valueOf(150000), "100k-150k"));
        salaryRanges.add(new SalaryRange(BigDecimal.valueOf(150000), BigDecimal.valueOf(200000), "150k-200k"));
        salaryRanges.add(new SalaryRange(BigDecimal.valueOf(200000), BigDecimal.valueOf(Double.MAX_VALUE), "200k+"));
    }

    public static List<String> findTop5TheMostPopularSkills(List<Job> jobs) {
        Map<String, Long> requirementFrequency = jobs.stream()
                .flatMap(job -> job.getRequirements().stream())
                .collect(groupingBy(Function.identity(), counting()));
        return requirementFrequency.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> findTop5TheMostPopularPositions(List<Job> jobs) {
        Map<String, Long> positionFrequency = jobs.stream()
                .collect(groupingBy(Job::getPosition, counting()));
        return positionFrequency.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<SalaryRange, Long> analyzeSalariesDistributionByJob(List<Job> jobs) {
        return jobs.stream()
                .map(job -> salaryRanges.stream()
                        .filter(salaryRange -> salaryRange.isInRange(job.getSalary()))
                        .findFirst()
                        .orElse(null))
                .filter(Objects::nonNull)
                .collect(groupingBy(Function.identity(), counting()));
    }

    public static List<String> findTop5TheMostPopularJobLocations(List<Job> jobs) {
        Map<String, Long> locationFrequency = jobs.stream()
                .collect(groupingBy(Job::getLocation, counting()));
        return locationFrequency.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }
}
