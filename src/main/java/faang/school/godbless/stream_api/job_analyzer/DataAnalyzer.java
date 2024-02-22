package faang.school.godbless.stream_api.job_analyzer;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DataAnalyzer {
    public static List<String> getFivePopularSkill(List<Job> listJob) {
        return listJob.stream()
                .flatMap(job -> job.getRequirementsSkill().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(5)
                .map(skill -> skill.getKey())
                .toList();
    }

    public static List<String> getFivePopularJob(List<Job> listJob){
        return listJob.stream()
                .map(Job::getJobTitle)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<String, Long> getSalaryFork(List<Job> listJob){
        return listJob.stream()
                .collect(Collectors.groupingBy(
                        job -> getSalaryRange(job.getSalary()), Collectors.counting()));


    }

    public static List<String> getPopularLocation(List<Job> listJob){
        return listJob.stream()
                .map(job -> job.getLocation())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(5)
                .map(skill -> skill.getKey())
                .toList();
    }

    private static String getSalaryRange(int salary) {
        if (salary < 50000) {
            return "0-50k";
        } else if (salary < 100000) {
            return "50k-100k";
        } else if (salary < 150000) {
            return "100k-150k";
        } else {
            return "150k and above";
        }
    }
}
