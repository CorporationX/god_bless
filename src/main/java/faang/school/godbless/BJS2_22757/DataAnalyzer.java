package faang.school.godbless.BJS2_22757;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataAnalyzer {
    private static final int LIMIT = 5;

    public void viewMostPopularJobSkills(List<Job> jobs) {
        Stream<String> skills = jobs.stream()
                .flatMap(job -> job.getSkills().stream());
        viewMostRepeated(skills, skill -> skill, LIMIT);
    }

    public void viewMostPopularJobNames(List<Job> jobs) {
        viewMostRepeated(jobs.stream(), Job::getJobName, LIMIT);
    }

    public void viewMostPopularLocation(List<Job> jobs) {
        viewMostRepeated(jobs.stream(), Job::getLocation, LIMIT);
    }

    public void viewJobDistributionBySalary(List<Job> jobs) {
        jobs.stream()
                .collect(Collectors.groupingBy(this::getSalaryRange, Collectors.counting()))
                .forEach((range, count) -> System.out.println(range + ": " + count));
    }

    private <T, K> void viewMostRepeated(Stream<T> stream, Function<? super T, ? extends K> classifier, int size) {
        stream.collect(Collectors.groupingBy(classifier, Collectors.counting()))
                .entrySet().stream()
                .sorted((entryOne, entryTwo) -> entryTwo.getValue().compareTo(entryOne.getValue()))
                .limit(size)
                .forEach(entry -> System.out.println(entry.getKey()));
    }

    private String getSalaryRange(Job job) {
        int range = job.getSalary() / 50000;
        return String.format("%dk-%dk", range * 50, range * 50 + 50);
    }
}
