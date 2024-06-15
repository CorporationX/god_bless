package faang.school.godbless.job_alalyzer;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataAnalyzer {
    public final long SALARY_SCALE_INTERVAL = 50000L;

    public List<String> topNMostRelevantSkills(@NonNull List<Job> jobList, int top) {
        Map<String, Long> skillAndCountMap = jobList.stream()
                .flatMap(job -> job.getRequirements().stream())
                .collect(Collectors.groupingBy(requirement -> requirement, Collectors.counting()));

        return skillAndCountMap.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(top)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> topMostPopularPositions(@NonNull List<Job> jobList, int top) {
        Map<String, Long> positionAndCountMap = jobList.stream()
                .collect(Collectors.groupingBy(Job::getPosition, Collectors.counting()));

        return positionAndCountMap.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(top)
                .map(Map.Entry::getKey)
                .toList();
    }

    public Map<String, Long> countJobSalaries(@NonNull List<Job> jobList) {
        return jobList.stream()
                .map(Job::getSalary)
                .collect(Collectors.groupingBy(salary -> {
                    long lowerBound = (salary / SALARY_SCALE_INTERVAL) * SALARY_SCALE_INTERVAL;
                    long upperBound = lowerBound + SALARY_SCALE_INTERVAL;
                    return lowerBound + "k - " + upperBound + "k";
                }, Collectors.counting()));
    }

    public List<String> topMostPopularOfficeLocations(@NonNull List<Job> jobList, int top) {
        Map<String, Long> locationAndCountMap = jobList.stream()
                .map(Job::getLocation)
                .collect(Collectors.groupingBy(location -> location, Collectors.counting()));

        return locationAndCountMap.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(top)
                .map(Map.Entry::getKey)
                .toList();
    }

    public Map<LocalDate, JobChanges> analyzeTrends(@NonNull List<Job> jobList,
                                                    @NonNull LocalDate startDate,
                                                    @NonNull LocalDate endDate,
                                                    TrendGranularity granularity) {
        Map<LocalDate, JobChanges> result = new HashMap<>();

        while (startDate.isBefore(endDate)) {
            LocalDate currentDate = startDate;

            long numberOfJobs = getJobsInTimeRange(jobList, currentDate, granularity)
                    .count();

            Map<String, Long> jobRequirementSkills = getJobsInTimeRange(jobList, currentDate, granularity)
                    .flatMap(job -> job.getRequirements().stream())
                    .collect(Collectors.groupingBy(requirement -> requirement, Collectors.counting()));

            Map<String, Long> jobLocation = getJobsInTimeRange(jobList, currentDate, granularity)
                    .map(Job::getLocation)
                    .collect(Collectors.groupingBy(location -> location, Collectors.counting()));

            result.put(currentDate, new JobChanges(numberOfJobs, jobRequirementSkills, jobLocation));

            startDate = granularity.getFunction().apply(startDate);
        }
        return result;
    }

    private Stream<Job> getJobsInTimeRange(@NonNull List<Job> jobList,
                                           @NonNull LocalDate timeStart,
                                           TrendGranularity period) {
        return jobList.stream()
                .filter(job -> {
                    LocalDate jobPublication = job.getJobPublicationTimestamp();
                    return timeStart.isBefore(jobPublication) || timeStart.isEqual(jobPublication);
                })
                .filter(job -> {
                    LocalDate endOfPeriod = period.getFunction().apply(timeStart).minusDays(1);
                    LocalDate jobPublication = job.getJobPublicationTimestamp();
                    return endOfPeriod.isAfter(jobPublication) || endOfPeriod.isEqual(jobPublication);
                });
    }
}
