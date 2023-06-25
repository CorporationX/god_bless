package faang.school.godbless.VacancyAnalysing;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataAnalyzer {


    public List<String> getThreePopularSkills(List<Job> jobs) {
        return jobs.stream()
                .flatMap(job -> job.getSkills().stream())
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((x1, x2) -> (int) (x2.getValue() - x1.getValue()))
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> getThreePopularJobs(List<Job> jobs) {
        return jobs.stream()
                .collect(Collectors.groupingBy(Job::getPosition, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((x1, x2) -> (int) (x2.getValue() - x1.getValue()))
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }

    public Map<String, Long> getSalaryRange(List<Job> jobs) {

        Map<Double, Long> collect = jobs.stream()
                .collect(Collectors.groupingBy(e -> Math.ceil(e.getSalary() / 50000.0), Collectors.counting()));

        return collect
                .entrySet()
                .stream()
                .collect(Collectors.toMap(x -> "From " + (x.getKey() * 50000 - 50000)
                        + " To " + x.getKey() * 50000, Map.Entry::getValue));
    }

    public List<String> getThreePopularLocations(List<Job> jobs) {
        return jobs.stream()
                .collect(Collectors.groupingBy(Job::getLocation, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((x1, x2) -> (int) (x2.getValue() - x1.getValue()))
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }
}
