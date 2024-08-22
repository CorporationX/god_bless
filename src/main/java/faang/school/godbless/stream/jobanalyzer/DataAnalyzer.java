package faang.school.godbless.stream.jobanalyzer;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DataAnalyzer {

    public void printMostPopularSkills(List<Job> jobs, int limit) {

        Map<String, Long> amountBySkills = jobs.stream()
                .flatMap(job -> job.getRequirements().stream())
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()));

        amountBySkills.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(limit)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

    public void printMostPopularJobTitles(List<Job> jobs, int limit) {
        Map<String, Long> amountByTitles = jobs.stream()
                .map(Job::getTitle)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()));

        amountByTitles.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(limit)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

    public LinkedHashMap<String, Integer> distributionOfSalariesByVacancies(List<Job> jobs, int salaryStep) {
        Optional<Integer> maxSalary = jobs.stream().map(Job::getSalary).max(Integer::compareTo);
        if (maxSalary.isEmpty()) {
            return new LinkedHashMap<>();
        }

        int maxSalaryValue = maxSalary.get();
        Map<Job, Integer> salaryByJob = jobs.stream().collect(Collectors.toMap(Function.identity(), Job::getSalary));
        LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
        int segmentsAmount = (maxSalaryValue + salaryStep - 1) / salaryStep + 1;

        IntStream.iterate(0, n -> n + salaryStep).limit(segmentsAmount).forEach(salary -> {
            String salaryRange = salary + "-" + (salary + salaryStep - 1);
            int count = (int) salaryByJob.entrySet().stream()
                    .filter(entry -> entry.getValue() >= salary && entry.getValue() < salary + salaryStep)
                    .count();
            result.put(salaryRange, count);
        });

        return result;
    }

    public List<String> getTop5MostPopularLocations(List<Job> jobs) {
        Map<String, Long> amountByLocations = jobs.stream()
                .map(Job::getLocation)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()));
        return amountByLocations.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
