package faang.school.godbless.AnalysisVacantion;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DataAnalyzer {
    public List<String> topFiveSkills(List<Job> jobList) {
        Map<String, Integer> skillsByRatio = jobList.stream()
                .flatMap(job -> job.getRequirements().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));

        return skillsByRatio.entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getValue() - entry1.getValue())
                .map(Map.Entry::getKey).limit(5).toList();
    }

    public List<String> topFiveVacantNames(List<Job> jobList) {
        return simpleTopFive(jobList, Job::getName);
    }

    public List<String> topFiveVacantOffices(List<Job> jobList) {
        return simpleTopFive(jobList, Job::getLocation);
    }

    public Map<String, Integer> salaryRange(List<Job> jobList) {
        Map<String, List<Job>> jobsBySalariesRange = jobList.stream()
                .collect(Collectors.groupingBy(Job::getSalaryRange));

        return jobsBySalariesRange.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().size()));
    }

    public List<String> simpleTopFive(List<Job> jobList, Function<Job, String> function) {
        Map<String, Integer> stringsByRatio = jobList.stream().
                collect(Collectors.groupingBy(function, Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));

        return stringsByRatio.entrySet()
                .stream()
                .sorted((entry1, entry2) -> entry2.getValue() - entry1.getValue())
                .map(Map.Entry::getKey)
                .limit(5).toList();
    }

}
