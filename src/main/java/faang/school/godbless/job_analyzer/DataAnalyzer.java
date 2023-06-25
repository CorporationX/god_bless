package faang.school.godbless.job_analyzer;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataAnalyzer {

    public List<String> getTop5CommonSkillRequirements(List<Job> jobs) {
        Map<String, Long> countedSkills = jobs.stream()
                .flatMap(job -> job.getRequirements().stream())
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));

        return countedSkills.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> getMostCommonJobPositions(List<Job> jobs, int quantity) {
        Map<String, Long> countedJobPositions = jobs.stream()
                .collect(Collectors.groupingBy(Job::getPosition, Collectors.counting()));

        return countedJobPositions.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(quantity)
                .map(Map.Entry::getKey)
                .toList();
    }

    public Map<String, Long> getSalaryDistribution(List<Job> jobs) {
        return jobs.stream()
                .collect(Collectors.groupingBy(job -> {
                    int salary = job.getSalary();
                    if (salary <= 50000) {
                        return "0-50k";
                    } else if (salary <= 100000) {
                        return "50k-100k";
                    } else if (salary <= 150000) {
                        return "100k-150k";
                    } else if (salary <= 200000) {
                        return "150k-200k";
                    } else {
                        return "200k+";
                    }
                }, Collectors.counting()));
    }

    public List<String> getTop5Locations(List<Job> jobs) {
        Map<String, Long> countedJobLocations = jobs.stream()
                .collect(Collectors.groupingBy(Job::getLocation, Collectors.counting()));

        return countedJobLocations.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }
}
