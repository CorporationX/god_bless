package faang.school.godbless.BJS2_22689;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DataAnalyzer {
    private static final int POSITIONS_AMOUNT = 3;
    private static final int TOP_SKILLS_AMOUNT = 5;
    private static final int OFFICES_AMOUNT = 5;


    public static List<String> getTop5SkillsForCandidates(List<Job> jobs) {
        return jobs
                .stream()
                .flatMap(job -> job.requirements().stream())
                .collect(Collectors
                        .groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(TOP_SKILLS_AMOUNT)
                .map(x -> x.getKey() + "= " + x.getValue())
                .toList();
    }

    public static Map<String, Long> getTop3Positions(List<Job> jobs) {
        return jobs
                .stream()
                .map(Job::position)
                .collect(Collectors
                        .groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(POSITIONS_AMOUNT)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

    public static Map<String, Long> getVacanciesBySalaries(List<Job> jobs, Function<Job, String> doSalaryRange) {
        return jobs
                .stream()
                .collect(Collectors
                        .groupingBy(doSalaryRange, Collectors.counting()));
    }

    public static List<String> getTop5Offices(List<Job> jobs) {
        return jobs
                .stream()
                .collect(Collectors.groupingBy(Job::location, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(OFFICES_AMOUNT)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<LocalDate, Long> analizeTrends(LocalDate startDate, LocalDate endDate, TrendGranularity granularity, List<Job> jobs) {
        return jobs
                .stream()
                .filter(job -> job.createdAt().isAfter(startDate) && job.createdAt().isBefore(endDate))
                .collect(Collectors.groupingBy(job -> {
                    LocalDate currDate = job.createdAt();
                    return switch (granularity) {
                        case DAY -> currDate;
                        case WEEK -> currDate.with(DayOfWeek.MONDAY);
                        case MONTH -> currDate.withDayOfMonth(1);
                        case YEAR -> currDate.withDayOfYear(1);
                    };
                }, Collectors.counting()));
    }
}
