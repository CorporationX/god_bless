package school.faang.bjs2_80885;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataAnalyzer {

    public Map<String, Long> getTopSkills(List<Job> jobs, int limit) {
        return jobs.stream()
                .filter(Objects::nonNull)
                .flatMap(job -> job.getRequirements() != null ? job.getRequirements().stream() : Stream.empty())
                .collect(Collectors.groupingBy(skill -> skill, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(limit)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a,
                        LinkedHashMap::new
                ));
    }

    public Map<String, Long> getTopPositions(List<Job> jobs, int limit) {
        return jobs.stream()
                .filter(Objects::nonNull)
                .map(Job::getPosition)
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(position -> position, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(limit)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a,
                        LinkedHashMap::new
                ));
    }

    public Map<String, Long> getTopLocations(List<Job> jobs, int limit) {
        return jobs.stream()
                .filter(Objects::nonNull)
                .map(Job::getLocation)
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(location -> location, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(limit)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a,
                        LinkedHashMap::new
                ));
    }

    public Map<String, Long> getSalaryDistribution(List<Job> jobs) {
        return jobs.stream()
                .collect(Collectors.groupingBy(job -> {
                    double salary = job.getSalary();
                    if (salary < 50000) {
                        return "0-50k";
                    }
                    if (salary < 100000) {
                        return "50k-100k";
                    }
                    if (salary < 150000) {
                        return "100k-150k";
                    }
                    return "150k+";
                }, Collectors.counting()));
    }
}
