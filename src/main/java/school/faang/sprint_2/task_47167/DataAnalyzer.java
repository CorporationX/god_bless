package school.faang.sprint_2.task_47167;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class DataAnalyzer {
    @NonNull
    private final List<Job> jobs;

    public void printTopRequirements() {
        System.out.println("Top requirements:");
        jobs.stream()
                .flatMap(job -> job.requirements().stream())
                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .forEach(System.out::println);
        System.out.println();
    }

    public void printTopPositionNames() {
        System.out.println("Top position names:");
        jobs.stream()
                .collect(Collectors.groupingBy(Job::position, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .forEach(System.out::println);
        System.out.println();
    }

    public void printSalarySpreadWithJobs() {
        System.out.println("Salary spread with jobs:");

        List<int[]> salaryRanges = generateSalaryRanges(50000);

        Map<String, Map<String, Long>> groupedData = jobs.stream()
                .collect(Collectors.groupingBy(
                        Job::position, // Ключ 1: Позиция
                        Collectors.groupingBy(
                                job -> determineSalaryRange(job.salary(), salaryRanges), // Ключ 2: Диапазон
                                Collectors.counting() // Количество вакансий
                        )
                ));

        groupedData.forEach((position, salarySpread) -> {
            System.out.println("Position: " + position);
            salarySpread.forEach((range, count) ->
                    System.out.printf("  Salary range %s: %d jobs%n", range, count));
        });
        System.out.println();
    }

    private List<int[]> generateSalaryRanges(int step) {
        int maxSalary = getMaxSalary();

        List<int[]> ranges = new ArrayList<>();
        int lowerBound = 0;
        while (lowerBound <= maxSalary) {
            int upperBound = lowerBound + step;
            ranges.add(new int[]{lowerBound, upperBound});
            lowerBound += step;
        }
        ranges.add(new int[]{lowerBound, Integer.MAX_VALUE});
        return ranges;
    }

    private int getMaxSalary() {
        return jobs.stream()
                .mapToInt(Job::salary)
                .max()
                .orElse(0);
    }

    private static String determineSalaryRange(int salary, List<int[]> ranges) {
        for (int[] range : ranges) {
            if (salary >= range[0] && salary <= range[1]) {
                return range[1] == Integer.MAX_VALUE
                        ? range[0] / 1_000 + "k+" // Последний диапазон
                        : range[0] / 1_000 + "-" + range[1] / 1_000 + "k";
            }
        }
        throw new IllegalArgumentException("Salary out of all defined ranges: " + salary);
    }


    public void printTopOfficeLocations() {
        System.out.println("Top office locations:");
        jobs.stream()
                .collect(Collectors.groupingBy(Job::location, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .forEach(System.out::println);
        System.out.println();
    }
}
