package LinkID_analizator;

import javax.xml.stream.Location;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DataAnalyzer {
    public static List<String> getTopSkill(List<Job> jobs) {
        Map<String, Long> skills = jobs.stream()
                .flatMap(job -> job.getRequirements().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<Map.Entry<String, Long>> sorted = new ArrayList<>(skills.entrySet());
        sorted.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        return sorted.stream()
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> getTopJobTitles(List<Job> jobs) {

        Map<String, Long> jobTitleCounts = jobs.stream()
                .collect(Collectors.groupingBy(Job::getTitle, Collectors.counting()));
        List<Map.Entry<String, Long>> sortedJobTitles = new ArrayList<>(jobTitleCounts.entrySet());
        sortedJobTitles.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        return sortedJobTitles.stream()
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static Map<SalaryRange, Integer> getSalaryDistribution(List<Job> jobs) {
        Map<SalaryRange, Integer> salaryDistribution = new HashMap<>();
        for (Job job : jobs) {
            SalaryRange range = SalaryRange.getRangeForSalary(job.getSalary());
            salaryDistribution.put(range, salaryDistribution.getOrDefault(range, 0) + 1);
        }
        return salaryDistribution;
    }

    enum SalaryRange {
        BELOW_50K(0, 50000),
        BETWEEN_50K_100K(50000, 100000),
        BETWEEN_100K_150K(100000, 150000),
        ABOVE_150K(150000, Integer.MAX_VALUE);

        private final int minSalary;
        private final int maxSalary;

        SalaryRange(int minSalary, int maxSalary) {
            this.minSalary = minSalary;
            this.maxSalary = maxSalary;
        }

        static SalaryRange getRangeForSalary(int salary) {
            for (SalaryRange range : SalaryRange.values()) {
                if (salary >= range.minSalary && salary < range.maxSalary) {
                    return range;
                }
            }
            throw new IllegalArgumentException("Не в диапазоне: " + salary);
        }
    }

    public static List<Location> getTopLocations(List<Job> jobs) {
        return jobs.stream()
                .map(Job::getLocation)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

}
