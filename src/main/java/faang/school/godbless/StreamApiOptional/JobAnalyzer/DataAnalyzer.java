package faang.school.godbless.StreamApiOptional.JobAnalyzer;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

public class DataAnalyzer {
    public Map<String, Long> getTop5Skills(List<Job> jobs) {

        return jobs.stream()
                .flatMap(job -> job.getRequirements().stream().filter(Objects::nonNull))
                .collect(Collectors.groupingBy(skill -> skill, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }
    public Map<String, Long> getTop5Jobs(List<Job> jobs) {

        return jobs.stream()
                .flatMap(job -> Stream.of(job.getName()))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }


    public Map<String, String> getJobListOrganizedByMargin(List<Job> jobs) {
        return jobs.stream()
                .collect(Collectors.groupingBy(job -> {
                    int margin = job.getMargin();
                    return switch (margin / 50000) {
                        case 0 -> "[0, 49_999]";
                        case 1 -> "[50_000 , 99_999]";
                        case 2 -> "[100_000 , 149_999]";
                        case 3 -> "[150_000 , 199_999]";
                        default -> "[200_000, inf]";
                    };
                }, Collectors.mapping(job -> "\t" + job.getName() +
                        ", Salary: " + job.getMargin() + "$",
                        Collectors.joining("; \n"))));
    }
    public Map<String, Long> getTop5Locations(List<Job> jobs) {
        return jobs.stream()
                .flatMap(job -> Stream.of(job.getLocation()))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }
}
