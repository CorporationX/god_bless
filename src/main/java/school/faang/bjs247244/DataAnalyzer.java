package school.faang.bjs247244;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataAnalyzer {
    public List<String> getTopSkills(List<Job> jobs) {

        List<String> topSkills = jobs.stream()
                .flatMap(job -> job.getRequirements().stream())
                .collect(Collectors.groupingBy(skill -> skill, Collectors.counting()))
                .entrySet().stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        return topSkills;
    }

    public List<String> getTopItemNames(List<Job> jobs) {

        List<String> topItemNames = jobs.stream()
                .collect(Collectors.groupingBy(job -> job.getPosition(), Collectors.counting()))
                .entrySet().stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        return topItemNames;
    }

    public Map<String, List<Job>> getSalaryDistribByVacancy(List<Job> jobs) {
        int step = 50_000;

        Map<String, List<Job>> groupedBySalary = jobs.stream()
                .distinct()
                .collect(Collectors.groupingBy(job -> {
                    int rangeStart = (Integer.parseInt(job.getSalary()) / step) * step;
                    int rangeEnd = rangeStart + step - 1;
                    return rangeStart + " - " + rangeEnd;
                }));
        return groupedBySalary;
    }

    public List<String> getTopOfficeLocations(List<Job> jobs) {

        List<String> topOfficeLocations = jobs.stream()
                //.flatMap(job -> job.getRequirements().stream())
                .collect(Collectors.groupingBy(job -> job.getLocation(), Collectors.counting()))
                .entrySet().stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        return topOfficeLocations;
    }
}
