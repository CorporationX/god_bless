package vacancy.analizator;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DataAnalyzer {
    public static List<String> getMostValuableSkills(@NonNull List<Job> jobs, int topSize) {
        Map<String, Long> skills = jobs.stream()
                .flatMap(j -> j.getRequirements().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return skills.entrySet().stream()
                .sorted(Comparator.comparing((Map.Entry<String, Long> e) -> e.getValue()).reversed())
                .limit(topSize)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> getMostPopularVacancies(@NonNull List<Job> jobs, int topSize) {
        Map<String, Long> vacanciesName = jobs.stream()
                .collect(Collectors.groupingBy(Job::getVacancyName, Collectors.counting()));

        return vacanciesName.entrySet().stream()
                .sorted(Comparator.comparing((Map.Entry<String, Long> e) -> e.getValue()).reversed())
                .limit(topSize)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<Range, List<Job>> getSalariesRanges(@NonNull List<Job> jobs, double rangeSize) {
        double from = jobs.stream().min(Comparator.comparing(Job::getSalary)).orElseThrow().getSalary();
        double to = jobs.stream().max(Comparator.comparing(Job::getSalary)).orElseThrow().getSalary();
        var ranges = getRanges(from, to, rangeSize);
        return jobs.stream()
                .collect(Collectors.groupingBy(j -> ranges.stream()
                        .filter(r -> r.isInRange(j.getSalary()))
                        .findFirst()
                        .orElseThrow()));
    }

    public static List<String> getMostPopularWorkPlaces(@NonNull List<Job> jobs, int topSize) {
        Map<String, Long> workPlaces = jobs.stream()
                .collect(Collectors.groupingBy(Job::getWorkPlace, Collectors.counting()));
        return workPlaces.entrySet().stream()
                .sorted(Comparator.comparing((Map.Entry<String, Long> e) -> e.getValue()).reversed())
                .limit(topSize)
                .map(Map.Entry::getKey)
                .toList();
    }

    private static List<Range> getRanges(double start, double end, double rangeSize) {
        List<Range> ranges = new ArrayList<>();
        double upBorder = rangeSize;
        while (upBorder <= start) {
            upBorder += rangeSize;
        }
        ranges.add(new Range(upBorder - rangeSize, upBorder));
        while (upBorder <= end) {
            upBorder += rangeSize;
            ranges.add(new Range(upBorder - rangeSize, upBorder));
        }

        return ranges;
    }
}
