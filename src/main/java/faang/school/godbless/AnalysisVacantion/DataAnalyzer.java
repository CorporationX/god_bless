package faang.school.godbless.AnalysisVacantion;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DataAnalyzer {
    public List<String> topFiveSkills(List<Job> jobList) {
        return jobList.stream()
                .flatMap(job -> job.getRequirements().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.collectingAndThen(Collectors.counting(), Long::intValue)))
                .entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getValue() - entry1.getValue())
                .map(Map.Entry::getKey).limit(5).toList();
    }

    public List<String> topFiveVacantNames(List<Job> jobList) {
        return jobList.stream().collect(Collectors.groupingBy(Job::getName, Collectors.collectingAndThen(Collectors.counting(), Long::intValue)))
                .entrySet().stream().sorted((entry1, entry2) -> entry2.getValue() - entry1.getValue())
                .map(Map.Entry::getKey).limit(5).toList();
    }

    public List<String> topFiveVacantOffices(List<Job> jobList) {
        return jobList.stream().collect(Collectors.groupingBy(Job::getLocation, Collectors.collectingAndThen(Collectors.counting(), Long::intValue)))
                .entrySet().stream().sorted((entry1, entry2) -> entry2.getValue() - entry1.getValue())
                .map(Map.Entry::getKey).limit(5).toList();
    }

    public Map<String, Integer> salaryRange(List<Job> jobList) {
        Map<String, List<Job>> jobsBySalariesRange = jobList.stream().collect(Collectors.groupingBy(Job::getSalaryRange));
        return jobsBySalariesRange.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().size()));
    }

}
