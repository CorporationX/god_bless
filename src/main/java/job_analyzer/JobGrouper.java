package job_analyzer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JobGrouper {
    private final Map<Trends, JobGroupingStrategy> strategies = new HashMap<>();

    public JobGrouper() {
        strategies.put(Trends.DAILY, jobs ->
                jobs.stream()
                        .collect(Collectors.groupingBy(job -> job.getDatePostedAsLocalDate().toString()))
        );

        strategies.put(Trends.MONTHLY, jobs ->
                jobs.stream()
                        .collect(Collectors.groupingBy(job -> job.getYear() + "-" + job.getMonthValue()))
        );

        strategies.put(Trends.YEARLY, jobs ->
                jobs.stream()
                        .collect(Collectors.groupingBy(job -> String.valueOf(job.getYear())))
        );
    }

    /**
     * Group jobs by the specified granularity.
     *
     * @param granularity The desired granularity.  Valid values are {@link Trends#DAILY},
     *                    {@link Trends#MONTHLY}, and {@link Trends#YEARLY}.
     * @param jobs        The jobs to group.
     * @return A map of periods to lists of jobs for that period.
     * @throws IllegalArgumentException if the specified granularity is unknown.
     */
    public Map<String, List<Job>> groupJobs(Trends granularity, List<Job> jobs) {
        JobGroupingStrategy strategy = strategies.get(granularity);
        if (strategy == null) {
            throw new IllegalArgumentException("Unknown granularity: " + granularity);
        }
        return strategy.groupJobs(jobs);
    }

    /**
     * Registers a custom strategy for grouping jobs by the given granularity.
     *
     * @param granularity The granularity to register the strategy for.
     * @param strategy    The strategy to register.
     */
    public void addStrategy(Trends granularity, JobGroupingStrategy strategy) {
        strategies.put(granularity, strategy);
    }
}
