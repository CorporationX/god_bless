package faang.school.godbless.BJS2_10757;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataAnalyzer {
    public void findTopFiveSkills(List<Job> jobs) {
        jobs.stream()
                .flatMap(job -> job.getSkills().stream())
                .collect(Collectors.groupingBy(skill -> skill, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .forEach(entry -> System.out.println("скил " + entry.getKey() + " встречается " + entry.getValue() + " раз"));
    }

    public void findTopFiveJobNames(List<Job> jobs) {
        jobs.stream()
                .map(Job::getPositionName)
                .collect(Collectors.groupingBy(jobName -> jobName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .forEach(entry -> System.out.println("позиция " + entry.getKey() + " встречается " + entry.getValue() + " раз"));
    }

    public Map<String, Long> analyzeSalary(List<Job> jobs) {
        return jobs.stream()
                .map(Job::getSalary)
                .map(salary -> {
                    if (salary < 50000) {
                        return " 0-50к ";
                    } else if (salary < 100000) {
                        return " 50к-100к ";
                    } else if (salary < 150000) {
                        return " 100к-150к ";
                    } else return " > 150к ";
                })
                .collect(Collectors.groupingBy(salary -> salary, Collectors.counting()));
    }

    public void findTopFiveJobLocations(List<Job> jobs) {
        jobs.stream()
                .map(Job::getLocation)
                .collect(Collectors.groupingBy(jobLocation -> jobLocation, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .forEach(entry -> System.out.println("локация " + entry.getKey() + " встречается " + entry.getValue() + " раз"));
    }
}
