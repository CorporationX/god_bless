package school.faang.job.analyzer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DataAnalyzer {

    public static final Integer SALARY_RANGE_STEP = 50000;

    public List<String> getTopNecessarySkills(List<Job> jobs) {
        Map<String, Long> requirements = jobs.stream()
                .flatMap(job -> job.getRequirements()
                        .stream())
                .collect(Collectors.groupingBy(req -> req, Collectors.counting()));
        return getTopJobs(requirements, 5);
    }

    public List<String> getTopPosition(List<Job> jobs) {
        Map<String, Long> requirements = jobs.stream()
                .map(Job::getPosition)
                .collect(Collectors.groupingBy(req -> req, Collectors.counting()));
        return getTopJobs(requirements, 5);
    }

    public List<String> getTopLocations(List<Job> jobs) {
        Map<String, Long> requirements = jobs.stream()
                .map(Job::getLocation)
                .collect(Collectors.groupingBy(req -> req, Collectors.counting()));
        return getTopJobs(requirements, 5);
    }

    private List<String> getTopJobs(Map<String, Long> jobMap, int n) {
        return jobMap.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(n)
                .map(Map.Entry::getKey)
                .toList();
    }

    public Map<Integer, List<Job>> groupingSalariesRanges(List<Job> jobs) {
        Integer maxSalary = getMaxSalaryFromJobs(jobs);
        Map<Integer, List<Job>> salaryByRange = generateSalaryCategory(maxSalary);
        jobs
                .forEach(job -> {
                    Optional<Integer> range = findRangeBySalary(salaryByRange, job.getSalary());
                    range.ifPresent(r ->
                            salaryByRange.computeIfAbsent(r, k -> new ArrayList<>()).add(job));
                });
        return salaryByRange;
    }

    private Integer getMaxSalaryFromJobs(List<Job> jobs) {
        return jobs
                .stream()
                .map(Job::getSalary)
                .max(Comparator.comparingInt(salary -> salary))
                .orElseThrow(() -> new RuntimeException("MaxSalary counting error"));
    }

    private Map<Integer, List<Job>> generateSalaryCategory(Integer maxSalary) {
        Map<Integer, List<Job>> salaryByRange = new HashMap<>();
        IntStream.iterate(0, n -> n + SALARY_RANGE_STEP)
                .limit((long) Math.ceil((double) maxSalary / SALARY_RANGE_STEP))
                .forEach(range -> {
                    salaryByRange.putIfAbsent(range, new ArrayList<>());
                });
        return salaryByRange;
    }

    private Optional<Integer> findRangeBySalary(Map<Integer, List<Job>> salaryByRange, Integer salary) {
        return salaryByRange.keySet()
                .stream()
                .filter(salaryMinInRange -> salary >= salaryMinInRange
                        && salary < salaryMinInRange + SALARY_RANGE_STEP)
                .findFirst();
    }
}
