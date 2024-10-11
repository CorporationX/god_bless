package job_analyzer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TrendsAnalyzer {
    /**
     * Analyzes trends in a list of jobs based on the given start and end dates.
     *
     * @param jobs The list of jobs to analyze
     * @param startDate The start date of the period of interest
     * @param endDate The end date of the period of interest
     * @param granularity The level of granularity for grouping jobs by date
     */
    public void analyzeTrends(List<Job> jobs, String startDate, String endDate, Trends granularity) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate start = LocalDate.parse(startDate, formatter);
        LocalDate end = LocalDate.parse(endDate, formatter);

        List<Job> filteredJobs = jobs.stream()
                .filter(job -> {
                    LocalDate jobDate = job.getDatePostedAsLocalDate();
                    return (jobDate.isEqual(start) || jobDate.isAfter(start)) &&
                            (jobDate.isEqual(end) || jobDate.isBefore(end));
                })
                .toList();

        Map<String, List<Job>> groupedJobs = switch (granularity) {
            case DAILY -> filteredJobs.stream()
                    .collect(Collectors.groupingBy(job -> job.getDatePostedAsLocalDate().toString()));
            case MONTHLY -> filteredJobs.stream()
                    .collect(Collectors.groupingBy(job -> job.getYear() + "-" + job.getMonthValue()));
            case YEARLY -> filteredJobs.stream()
                    .collect(Collectors.groupingBy(job -> String.valueOf(job.getYear())));
        };

        for (Map.Entry<String, List<Job>> entry : groupedJobs.entrySet()) {
            String period = entry.getKey();
            List<Job> jobsInPeriod = entry.getValue();

            System.out.println("Период: " + period);
            System.out.println("Количество вакансий: " + jobsInPeriod.size());

            Map<String, Long> skillCount = jobsInPeriod.stream()
                    .flatMap(job -> job.getRequirements().stream())
                    .collect(Collectors.groupingBy(skill -> skill, Collectors.counting()));

            System.out.println("Топ навыков за период:");
            skillCount.entrySet().stream()
                    .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                    .limit(5)
                    .forEach(entrySkill ->
                            System.out.println(entrySkill.getKey() + ": " + entrySkill.getValue() + " упоминаний"));
            System.out.println();
        }
    }
}
