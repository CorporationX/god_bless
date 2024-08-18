package faang.school.godbless.BJS2_22724;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DataAnalyzer {

    public List<String> mostPopularOffices(List<Job> jobList) {
        return jobList.stream()
                .map(Job::getLocation)
                .collect(Collectors.groupingBy(skill -> skill, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .map(entry -> entry.getKey() + " - " + entry.getValue())
                .toList();
    }

    public List<String> mostPopularSkillsPositions(List<Job> jobList, Function<List<Job>, Map<String, Long>> action) {
        return action.apply(jobList).entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(5)
                .map(entry -> entry.getKey() + " - " + entry.getValue())
                .toList();
    }

    public Map<String, Long> salaryDistribution(List<Job> jobList) {
        return jobList.stream()
                .collect(Collectors.groupingBy(job -> {
                    int salary = job.getSalary();
                    if (salary <= 50000) return "0-50k";
                    else if (salary <= 100000) return "0-100k";
                    else return "over100k";
                }, Collectors.counting()));
    }
}
