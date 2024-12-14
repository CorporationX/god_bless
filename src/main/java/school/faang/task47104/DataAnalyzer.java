package school.faang.task47104;

import java.util.List;
import java.util.Map;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataAnalyzer {
    private static final String NUMBER_OF_MENTIONS = "Количество упоминаний: %s.%n";
    private static final int LOW_SALARY = 50000;
    private static final int MIDDLE_SALARY = 100000;
    private static final int HIGH_SALARY = 200000;


    private static void validateList(List<Job> jobs) {
        if (jobs == null) {
            throw new IllegalArgumentException("jobs can`t be null");
        }
    }

    private static Map<String, List<Job>> salaryRange(List<Job> jobs, int start, int end) {
        validateList(jobs);
        if (start < 0 || end < 0) {
            throw new IllegalArgumentException("start и end не могут быть меньше нуля");
        }
        if (start < end) {
            throw new IllegalArgumentException("start не может быть больше чем end");
        }

        return jobs.stream().filter(job -> job.salary() >= start && job.salary() <= end)
                .collect(Collectors.groupingBy(
                        job -> "Диапозон от " + start + " до " + end + "\n",
                        Collectors.toList()
                ));
    }

    private static Stream<Map.Entry<String, Long>> generateStream(Stream<String> stream) {
        if (stream == null) {
            throw new IllegalArgumentException("stream can`t be null");
        }

        return stream.collect(Collectors.groupingBy(
                        position -> position,
                        Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5);
    }

    public static void topDemandedRequirements(List<Job> jobs) {
        validateList(jobs);

        generateStream(jobs.stream().flatMap(job -> job.requirements().stream()))
                .forEach(entry -> System.out.printf("Навык: %s." + NUMBER_OF_MENTIONS,
                        entry.getKey(), entry.getValue()));
    }

    public static void popularPosition(List<Job> jobs) {
        validateList(jobs);

        generateStream(jobs.stream().map(Job::position))
                .forEach(entry -> System.out.printf("Позиция: %s." + NUMBER_OF_MENTIONS,
                        entry.getKey(), entry.getValue()));
    }

    public static void popularLocation(List<Job> jobs) {
        validateList(jobs);

        generateStream(jobs.stream().map(Job::location))
                .forEach(entry -> System.out.printf("Локация: %s." + NUMBER_OF_MENTIONS,
                        entry.getKey(), entry.getValue()));
    }


    public static void salaryByVacancies(List<Job> jobs) {
        validateList(jobs);

        Map<String, List<Job>> salaryRange = salaryRange(jobs, LOW_SALARY, MIDDLE_SALARY);
        salaryRange.putAll(salaryRange(jobs, MIDDLE_SALARY, HIGH_SALARY));

        salaryRange.forEach((key, value) -> System.out.printf("%s%s%n", key, value));
    }
}
