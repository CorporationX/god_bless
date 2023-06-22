package faang.school.godbless.sprint3.streamAPI.task4;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataAnalyzer {

    public List<String> getMostPopularSkills(List<Job> jobs, int limit) {
        return jobs.stream()
                .flatMap(job -> job.getSkills().stream())
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((j1, j2) -> (int) (j2.getValue() - j1.getValue()))
                .limit(limit)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public List<String> getMostPopularPositions(List<Job> jobs, int limit) {
        return jobs.stream()
                .collect(Collectors.groupingBy(Job::getPosition, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((j1, j2) -> (int) (j2.getValue() - j1.getValue()))
                .limit(limit)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public Map<String, Long> getSalaryByVacancies(List<Job> jobs) {
        return jobs.stream()
                .collect(Collectors.groupingBy(e->Math.ceil(e.getSalary()/50000.0), Collectors.counting()))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(entry ->
                        "От " + (int) (entry.getKey() * 50_000 - 50_000) + " до " + (int) (entry.getKey() * 50_000),
                        Map.Entry::getValue));
    }

    public List<String> getMostPopularLocations(List<Job> jobs, int limit) {
        return jobs.stream()
                .collect(Collectors.groupingBy(Job::getLocation, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((j1, j2) -> (int) (j2.getValue() - j1.getValue()))
                .limit(limit)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public Map<String, Map<String, List<String>>> analyzeTrends(List<Job> jobs, LocalDate startDate, LocalDate endDate, TrendGranularity granularity) {
        long plusDays = selectHowDaysToPlus(granularity);
        Map<String, Map<String, List<String>>>  statistics = new LinkedHashMap<>();
        long count = 0;
        LocalDate end;
        do {
            LocalDate start = startDate.plusDays(count * plusDays);
            end = startDate.plusDays((count + 1) * plusDays);
            count++;
            String interval = "Отчет за " + start + " - " + end;
            List<Job> jobsInterval = jobsBetweenStartAndEnd(jobs, start, end);

            Map<String, List<String>> analysis = new HashMap<>();
            analysis.put("Популярные скиллы", getMostPopularSkills(jobsInterval, 3));
            analysis.put("Популярные вакансии", getMostPopularPositions(jobsInterval, 3));
            analysis.put("Популярные локации", getMostPopularLocations(jobsInterval, 3));
            statistics.put(interval, analysis);

        } while (end.isBefore(endDate));

        return statistics;
    }

    private static long selectHowDaysToPlus(TrendGranularity granularity) {
        int plusDays = 0;
        switch (granularity) {
            case DAILY -> plusDays = 1;
            case WEEKLY -> plusDays = 7;
            case MONTHLY -> plusDays = 30;
        }
        return plusDays;
    }

    private List<Job> jobsBetweenStartAndEnd(List<Job> jobs, LocalDate startDate, LocalDate endDate) {
        return jobs.stream()
                .filter(job -> job.getDate().isAfter(startDate.minusDays(1)) && job.getDate().isBefore(endDate))
                .collect(Collectors.toList());
    }
}
