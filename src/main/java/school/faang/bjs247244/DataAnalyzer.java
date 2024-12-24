package school.faang.bjs247244;

import lombok.val;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataAnalyzer {
    public List<String> getTopSkills(List<Job> jobs, int limit) {
        val topSkills = jobs.stream()
                .flatMap(job -> job.getRequirements().stream())
                .collect(Collectors.groupingBy(skill -> skill, Collectors.counting()));

        return topSkills.entrySet().stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                .limit(limit)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public List<String> getTopItemNames(List<Job> jobs, int limit) {
        val topItemNames = jobs.stream()
                .collect(Collectors.groupingBy(Job::getPosition, Collectors.counting()));

        return topItemNames.entrySet().stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                .limit(limit)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public Map<String, List<Job>> getSalaryDistribByVacancy(List<Job> jobs, int step) {
        return jobs.stream()
                .distinct()
                .collect(Collectors.groupingBy(job -> {
                    int rangeStart = (Integer.parseInt(job.getSalary()) / step) * step;
                    int rangeEnd = rangeStart + step - 1;
                    return rangeStart + " - " + rangeEnd;
                }));
    }

    public List<String> getTopOfficeLocations(List<Job> jobs, int limit) {
        val topOfficeLocations = jobs.stream()
                .collect(Collectors.groupingBy(Job::getLocation, Collectors.counting()));

        return topOfficeLocations.entrySet().stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }
}
