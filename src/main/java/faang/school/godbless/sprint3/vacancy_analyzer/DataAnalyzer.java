package faang.school.godbless.sprint3.vacancy_analyzer;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class DataAnalyzer {
    public List<String> getTopFiveJobSkills(List<Job> jobs) {
        return jobs.stream()
                .flatMap(job -> job.getRequirements().stream())
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .peek(System.out::println)
                .toList();
    }

    public List<String> getTopThreeVacancies(List<Job> jobs) {
        return jobs.stream()
                .map(Job::getName)
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .peek(System.out::println)
                .toList();
    }

    public Map<String, Long> getSalaryByRange(List<Job> jobs, int range, int bound) {
        // Не смог ничего более оптимального придумать, к сожалению...
        Map<String, Long> salaryMap = new LinkedHashMap<>();
        for (int i = 0; i < bound; i += range) {
            int finalI = i;
            salaryMap.put(
                    String.valueOf(String.format("%dk-%dk", i / 1000, (i + range - 1) / 1000)),
                    jobs.stream()
                            .map(Job::getSalary)
                            .filter(s -> s >= finalI && s <= finalI + range - 1000)
                            .count()
            );
        }

        return salaryMap;
    }

    public List<String> getTopFiveLocations(List<Job> jobs) {
        return jobs.stream()
                .map(Job::getLocation)
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }
}
