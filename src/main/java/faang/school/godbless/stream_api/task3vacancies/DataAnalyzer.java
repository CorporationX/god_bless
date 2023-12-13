package faang.school.godbless.stream_api.task3vacancies;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class DataAnalyzer {
    private final List<Job> jobs;

    public DataAnalyzer(List<Job> jobs) {
        this.jobs = jobs;
    }

    public List<String> getTopSkills(int limit) {
        return jobs.stream().
                flatMap(job -> job.getRequirements().stream()).
                collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting())).
                entrySet().stream().
                sorted(Map.Entry.<String, Long>comparingByValue().reversed()).
                limit(limit).
                map(Map.Entry::getKey).
                collect(Collectors.toList()); // эту часть кода чаще чем своего брата вижу
    }

    public List<String> getTopPositions(int limit) {
        return jobs.stream().
                collect(Collectors.groupingBy(Job::getPosition, Collectors.counting())).
                entrySet().stream().
                sorted(Map.Entry.<String, Long>comparingByValue().reversed()).
                limit(limit).
                map(Map.Entry::getKey).
                collect(Collectors.toList()); // опять оно
    }

    public Map<String, Long> getSalaryDistribution() {
        return jobs.stream()
                .collect(Collectors.groupingBy(
                        job -> {
                            double salary = job.getSalary();
                            if (salary < 50000) return "0-50k";
                            else if (salary < 100000) return "50k-100k";
                            else if (salary < 150000) return "100k-150k";
                            else return "150k+";
                        }, Collectors.counting()
                ));
    }

    public List<String> getTopLocations(int limit) {
        return jobs.stream().
                collect(Collectors.groupingBy(Job::getLocation, Collectors.counting())).
                entrySet().stream().
                sorted(Map.Entry.<String, Long>comparingByValue().reversed()).
                limit(limit).
                map(Map.Entry::getKey).
                collect(Collectors.toList()); // ctrl + v
    }
}



