package school.faang.bjs2_80885;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class DataAnalyzer {

    public void printTopSkills(List<Job> jobs) {
        Map<String, Long> skillCounts = jobs.stream()
                .filter(Objects::nonNull)
                .flatMap(job -> job.getRequirements() != null ? job.getRequirements().stream() : Stream.empty())
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(skill -> skill, Collectors.counting()));

        skillCounts.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .forEach(entry -> log.info("{}: {}", entry.getKey(), entry.getValue()));
    }

    public void printTopPositions(List<Job> jobs) {
        Map<String, Long> positionsCounts = jobs.stream()
                .filter(Objects::nonNull)
                .map(Job::getPosition)
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(position -> position, Collectors.counting()));

        positionsCounts.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .forEach(entry -> log.info("{}: {}", entry.getKey(), entry.getValue()));
    }

    public void printSalaryDistribution(List<Job> jobs) {
        Map<String, Long> salaryBuckets = jobs.stream()
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

        salaryBuckets.forEach((range, count) -> log.info("{}: {}", range, count));
    }

    public void printTopLocations(List<Job> jobs) {
        Map<String, Long> locationsCounts = jobs.stream()
                .filter(Objects::nonNull)
                .map(Job::getLocation)
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(location -> location, Collectors.counting()));

        locationsCounts.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .forEach(entry -> log.info("{}: {}", entry.getKey(), entry.getValue()));
    }
}
