package faang.school.godbless.job_alalyzer;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataAnalyzer {
    public final long SCALE_INTERVAL = 50000;

    public List<String> topMostRelevantSkills(List<Job> jobList, int top) {
        return jobList.stream()
                .flatMap(job -> job.getRequirements().stream())
                .collect(Collectors.groupingBy(requirement -> requirement, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((entry1, entry2) -> Long.compare(entry2.getValue(), entry1.getValue()))
                .limit(top)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> topMostPopularPositions(List<Job> jobList, int top) {
        return jobList.stream()
                .collect(Collectors.groupingBy(Job::getPosition, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((entry1, entry2) -> Long.compare(entry2.getValue(), entry1.getValue()))
                .limit(top)
                .map(Map.Entry::getKey)
                .toList();
    }

    public Map<String, Long> countJobSalaries(List<Job> jobList) {
        return jobList.stream()
                .map(Job::getSalary)
                .collect(Collectors.groupingBy(salary -> {
                    long lowerBound = (salary / SCALE_INTERVAL) * SCALE_INTERVAL;
                    long upperBound = lowerBound + SCALE_INTERVAL;
                    return lowerBound + "k - " + upperBound + "k";
                }, Collectors.counting()));
    }

    public List<String> topMostPopularOfficeLocations(List<Job> jobList, int top) {
        return jobList.stream()
                .map(Job::getLocation)
                .collect(Collectors.groupingBy(location -> location, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((entry1, entry2) -> Long.compare(entry2.getValue(), entry1.getValue()))
                .limit(top)
                .map(Map.Entry::getKey)
                .toList();
    }

    public Map<LocalDate, JobChanges> analyzeTrends(List<Job> jobList, LocalDate startDate, LocalDate endDate, TrendGranularity granularity) {
        Map<LocalDate, JobChanges> result = new HashMap<>();

        while (startDate.isBefore(endDate)) {
            LocalDate currentDate = startDate;
            System.out.println(currentDate);

            long numberOfJobs = checkPeriodsOfJob(jobList, currentDate, granularity)
                    .count();

            Map<String, Long> jobRequirementSkills = checkPeriodsOfJob(jobList, currentDate, granularity)
                    .flatMap(job -> job.getRequirements().stream())
                    .collect(Collectors.groupingBy(requirement -> requirement, Collectors.counting()));

            Map<String, Long> jobLocation = checkPeriodsOfJob(jobList, currentDate, granularity)
                    .map(Job::getLocation)
                    .collect(Collectors.groupingBy(location -> location, Collectors.counting()));

            result.put(currentDate, new JobChanges(numberOfJobs, jobRequirementSkills, jobLocation));

            startDate = granularity.getFunction().apply(startDate);
        }
        return result;
    }

    public Stream<Job> checkPeriodsOfJob(List<Job> jobList, LocalDate currentDate, TrendGranularity granularity) {
        return jobList.stream()
                .filter(job -> {
                    LocalDate jobPublication = job.getJobPublicationTimestamp();
                    return currentDate.isBefore(jobPublication) || currentDate.isEqual(jobPublication);
                })
                .filter(job -> {
                    LocalDate endOfPeriod = granularity.getFunction().apply(currentDate).minusDays(1);
                    LocalDate jobPublication = job.getJobPublicationTimestamp();
                    return endOfPeriod.isAfter(jobPublication) || endOfPeriod.isEqual(jobPublication);
                });
    }
}
