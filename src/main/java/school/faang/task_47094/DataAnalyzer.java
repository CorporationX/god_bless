package school.faang.task_47094;

import lombok.experimental.UtilityClass;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@UtilityClass
public class DataAnalyzer {
    public void printTop5Skills(List<Job> jobs) {
        List<String> skills = jobs.stream()
                .flatMap(job -> job.requirements().stream()
                        .map(skill -> Map.entry(skill, job)))
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();

        System.out.println("Топ 5 скиллов: ");
        skills.forEach(System.out::println);
    }

    public void printTop5PopularPositions(List<Job> jobs) {
        List<String> positions = jobs.stream()
                .collect(Collectors.groupingBy(Job::position, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();

        System.out.println("Топ 5 популярных позиций: ");
        positions.forEach(System.out::println);
    }


    public static Map<String, List<Job>> groupingBySalary(List<Job> jobs) {
        int rangeStep = 50000;

        return jobs.stream()
                .collect(Collectors.groupingBy(job -> {
                    int lowerBound = (job.salary() / rangeStep) * rangeStep;
                    int upperBound = lowerBound + rangeStep - 1;
                    return String.format("%d-%d", lowerBound, upperBound);
                }));
    }
}
