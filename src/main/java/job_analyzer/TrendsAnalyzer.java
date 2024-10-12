package job_analyzer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TrendsAnalyzer {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final JobGrouper JOB_GROUPER = new JobGrouper();
    /**
     * Analyzes trends in a list of jobs based on the given start and end dates.
     *
     * @param jobs The list of jobs to analyze
     * @param startDate The start date of the period of interest
     * @param endDate The end date of the period of interest
     * @param granularity The level of granularity for grouping jobs by date
     */
    public void analyzeTrends(List<Job> jobs, String startDate, String endDate, Trends granularity) {
        LocalDate start = parseDate(startDate);
        LocalDate end = parseDate(endDate);

        List<Job> filteredJobs = filterJobsByDate(jobs, start, end);
        Map<String, List<Job>> groupedJobs = groupJobsByGranularity(filteredJobs, granularity);

        analyzeGroupedJobs(groupedJobs);
    }

    /**
     * Parses a string representation of a date into a LocalDate.
     *
     * @param date the string representation of the date
     * @return the parsed LocalDate
     */
    private LocalDate parseDate(String date) {
        return LocalDate.parse(date, FORMATTER);
    }

    /**
     * Filters a list of jobs based on the given start and end dates.
     *
     * @param jobs The list of jobs to filter
     * @param start The start date of the period of interest
     * @param end The end date of the period of interest
     * @return A list of jobs that fall within the given period
     */
    private List<Job> filterJobsByDate(List<Job> jobs, LocalDate start, LocalDate end) {
        return jobs.stream()
                .filter(job -> {
                    LocalDate jobDate = job.getDatePostedAsLocalDate();
                    return (jobDate.isEqual(start) || jobDate.isAfter(start)) &&
                            (jobDate.isEqual(end) || jobDate.isBefore(end));
                })
                .toList();
    }

    /**
     * Groups a list of jobs by the given granularity.
     *
     * @param jobs        The list of jobs to group
     * @param granularity The level of granularity for grouping
     * @return A map of periods to lists of jobs for each period
     */
    private Map<String, List<Job>> groupJobsByGranularity(List<Job> jobs, Trends granularity) {
        return JOB_GROUPER.groupJobs(granularity, jobs);
    }

    /**
     * Analyzes the given map of periods to lists of jobs for each period.
     * Prints out the number of jobs in each period and the top 5 skills mentioned
     * in the job postings for each period.
     *
     * @param groupedJobs A map of periods to lists of jobs for each period
     */
    private void analyzeGroupedJobs(Map<String, List<Job>> groupedJobs) {
        for (Map.Entry<String, List<Job>> entry : groupedJobs.entrySet()) {
            String period = entry.getKey();
            List<Job> jobsInPeriod = entry.getValue();

            System.out.println("Период: " + period);
            System.out.println("Количество вакансий: " + jobsInPeriod.size());

            Map<String, Long> skillCount = analyzeSkills(jobsInPeriod);

            System.out.println("Топ навыков за период:");
            skillCount.entrySet().stream()
                    .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                    .limit(5)
                    .forEach(entrySkill ->
                            System.out.println(entrySkill.getKey() + ": " + entrySkill.getValue() + " упоминаний"));
            System.out.println();
        }
    }

    /**
     * Analyzes the skills required for the given list of jobs.
     * <p>
     * Returns a map of each skill to the number of times it is mentioned in the
     * job postings.
     *
     * @param jobsInPeriod The list of jobs to analyze
     * @return A map of skills to their respective counts
     */
    private Map<String, Long> analyzeSkills(List<Job> jobsInPeriod) {
        return jobsInPeriod.stream()
                .flatMap(job -> job.getRequirements().stream())
                .collect(Collectors.groupingBy(skill -> skill, Collectors.counting()));
    }
}
