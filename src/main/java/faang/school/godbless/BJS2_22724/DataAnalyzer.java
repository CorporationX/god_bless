package faang.school.godbless.BJS2_22724;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DataAnalyzer {

    public List<String> mostPopularOffices(List<Job> jobList, int listSize) {
        return jobList.stream()
                .map(Job::getLocation)
                .collect(Collectors.groupingBy(skill -> skill, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(listSize)
                .map(entry -> entry.getKey() + " - " + entry.getValue())
                .toList();
    }

    public List<String> mostPopularSkillsPositions(List<Job> jobList, Function<List<Job>, Map<String, Long>> action, int listSize) {
        return action.apply(jobList).entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(listSize)
                .map(entry -> entry.getKey() + " - " + entry.getValue())
                .toList();
    }


    public Map<Double, Long> salaryDistribution(List<Job> jobList, double stepSalaryRange) {
        return jobList.stream()
                .collect(Collectors.groupingBy(
                        job -> Math.ceil(job.getSalary() / stepSalaryRange) * stepSalaryRange, Collectors.counting()));
    }
}
