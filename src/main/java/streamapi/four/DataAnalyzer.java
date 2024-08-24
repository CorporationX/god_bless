package streamapi.four;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DataAnalyzer {

    public static void checkList(List<?> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("Список пуст");
        }
    }

    public static List<String> getTopSkills(List<Job> jobs, int top) {
        checkList(jobs);

        Map<String, Long> skillCountMap = jobs.stream()
                .flatMap(job -> job.getRequirements().stream())
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));

        return skillCountMap
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(top)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> getTopJobTitles(List<Job> jobs, int top) {

        checkList(jobs);

        Map<String, Long> mostPupularJobTitleMap = jobs.stream()
                .collect(Collectors.groupingBy(Job::getJobTitle, Collectors.counting()));

        return mostPupularJobTitleMap
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(top)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static Map<String, Long> analyzeSalaryDistribution(List<Job> jobs) {
        checkList(jobs);

        return jobs.stream()
                .collect(Collectors.groupingBy(job -> getSalaryRange(job.getSalary()),
                        Collectors.counting()));

    }

    private static String getSalaryRange(Double salary) {

        if (salary < 0) {
            throw new IllegalArgumentException("Передали отрицательное значение");
        }

        if (salary < 50000) {
            return "0-50k";
        } else if (salary < 100000) {
            return "50k-100k";
        } else if (salary < 150000) {
            return "100k-150k";
        } else {
            return "150k+";
        }
    }

    public static List<String> getMostPopularLocations(List<Job> jobs, int top) {
        checkList(jobs);

        return jobs.stream()
                .collect(Collectors.groupingBy(Job::getLocation, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(top)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

}
