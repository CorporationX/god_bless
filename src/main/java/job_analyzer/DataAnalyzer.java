package job_analyzer;

import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class DataAnalyzer {
    private static final String FROM_ZERO_TO_FIFTY_THOUSAND = "0-50k";
    private static final String FIFTY_THOUSAND_TO_ONE_HUNDRED_THOUSAND = "50k-100k";
    private static final String ONE_HUNDRED_THOUSAND_PLUS = "100k+";

    /**
     * Print the top 5 skills from the given list of jobs.
     * <p>
     * The skills are ranked by frequency of occurrence.
     *
     * @param jobs the list of jobs
     */
    public void printTop5Skills(List<Job> jobs) {
        Map<String, Long> topSkills = jobs.stream()
                .flatMap(job -> job.getRequirements().stream())
                .collect(Collectors.collectingAndThen(
                        Collectors.groupingBy(skill -> skill, Collectors.counting()),
                        skillCount -> skillCount.entrySet().stream()
                                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                                .limit(5)
                                .collect(Collectors.toMap(
                                        Map.Entry::getKey,
                                        Map.Entry::getValue,
                                        (e1, e2) -> e1,
                                        LinkedHashMap::new))));

        topSkills.forEach((skill, count) -> System.out.println(skill + ": " + count));
    }

    /**
     * Print the top 5 positions from the given list of jobs.
     * <p>
     * The positions are ranked by frequency of occurrence.
     *
     * @param jobs the list of jobs
     */
    public void printTop5Positions(List<Job> jobs) {
        Map<String, Long> topPositions = jobs.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.groupingBy(Job::getPosition, Collectors.counting()),
                        positionCount -> positionCount.entrySet().stream()
                                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                                .limit(5)
                                .collect(Collectors.toMap(
                                        Map.Entry::getKey,
                                        Map.Entry::getValue,
                                        (e1, e2) -> e1,
                                        LinkedHashMap::new))));

        topPositions.forEach((position, count) -> System.out.println(position + ": " + count));
    }

    /**
     * Print the distribution of salary ranges in the given list of jobs.
     * <p>
     * The salary ranges are split into three groups: 0-50k, 50k-100k, and 100k+.
     * <p>
     * The distribution is printed as a series of lines, each in the format
     * <code>range: count</code>, where <code>range</code> is the name of the
     * salary range and <code>count</code> is the number of jobs in that range.
     *
     * @param jobs the list of jobs
     */
    public void printSalaryDistribution(List<Job> jobs) {
        Map<String, Long> salaryDistribution = jobs.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.groupingBy(job -> {
                            if (job.getSalary() < 50000) {
                                return FROM_ZERO_TO_FIFTY_THOUSAND;
                            } else if (job.getSalary() < 100000) {
                                return FIFTY_THOUSAND_TO_ONE_HUNDRED_THOUSAND;
                            } else {
                                return ONE_HUNDRED_THOUSAND_PLUS;
                            }
                        }, Collectors.counting()),
                        distribution -> distribution.entrySet().stream()
                                .sorted(Map.Entry.comparingByKey())
                                .collect(Collectors.toMap(
                                        Map.Entry::getKey,
                                        Map.Entry::getValue,
                                        (e1, e2) -> e1,
                                        LinkedHashMap::new))));

        salaryDistribution.forEach((range, count) -> System.out.println(range + ": " + count));
    }

    /**
     * Print the top 5 locations from the given list of jobs.
     * <p>
     * The locations are ranked by frequency of occurrence.
     *
     * @param jobs the list of jobs
     */
    public void printTop5Locations(List<Job> jobs) {
        Map<String, Long> topLocations = jobs.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.groupingBy(Job::getLocation, Collectors.counting()),
                        locationCount -> locationCount.entrySet().stream()
                                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                                .limit(5)
                                .collect(Collectors.toMap(
                                        Map.Entry::getKey,
                                        Map.Entry::getValue,
                                        (e1, e2) -> e1,
                                        LinkedHashMap::new))));

        topLocations.forEach((location, count) -> System.out.println(location + ": " + count));

    }
}
