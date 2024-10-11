package job_analyzer;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataAnalyzer {
    /**
     * Print the top 5 skills from the given list of jobs.
     * <p>
     * The skills are ranked by frequency of occurrence.
     *
     * @param jobs the list of jobs
     */
    public void printTop5Skills(List<Job> jobs) {
        Map<String, Long> skillCount = jobs.stream()
                .flatMap(job -> job.getRequirements().stream())
                .collect(Collectors.groupingBy(skill -> skill, Collectors.counting()));

        skillCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

    /**
     * Print the top 5 positions from the given list of jobs.
     * <p>
     * The positions are ranked by frequency of occurrence.
     *
     * @param jobs the list of jobs
     */
    public void printTop5Positions(List<Job> jobs) {
        Map<String, Long> positionCount = jobs.stream()
                .collect(Collectors.groupingBy(Job::getPosition, Collectors.counting()));

        positionCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
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
                .collect(Collectors.groupingBy(job -> {
                    if (job.getSalary() < 50000) return "0-50k";
                    else if (job.getSalary() < 100000) return "50k-100k";
                    else return "100k+";
                }, Collectors.counting()));

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
        Map<String, Long> locationCount = jobs.stream()
                .collect(Collectors.groupingBy(Job::getLocation, Collectors.counting()));

        locationCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}
