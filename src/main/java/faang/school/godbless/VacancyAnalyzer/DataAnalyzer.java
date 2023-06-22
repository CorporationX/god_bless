package faang.school.godbless.VacancyAnalyzer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class DataAnalyzer {
    public static List<String> mostPopularSkills(List<String> jobs) {
        List<Job> jobList = JobStreamProcessor.process(jobs.stream());
        return jobList.stream()
                .flatMap(job -> job.getRequirements().stream())
                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .limit(5)
                .collect(Collectors.toList());
    }

    public static List<String> mostPopularTitles(List<String> jobs) {
        List<Job> jobList = JobStreamProcessor.process(jobs.stream());
        return jobList.stream()
                .map(Job::getTitle)
                .flatMap(title -> Arrays.stream(title.split(" ")))
                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .limit(5)
                .collect(Collectors.toList());
    }

//    public static Map<String, Integer> rangeOfSalaries(List<String> jobs){
//        List<Job> jobList = JobStreamProcessor.process(jobs.stream());
//
//        jobList.stream()
//                .map(Job::getSalary)
//                .collect(Collectors.groupingBy(String::valueOf, LongStream::range)
//    }


}
