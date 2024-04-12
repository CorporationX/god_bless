package faang.school.godbless.streamAPI.jobs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class DataAnalyzer {
    private final List<Job> jobsToAnalyze;

    public DataAnalyzer(List<Job> jobs) {
        if (jobs == null) {
            throw new IllegalArgumentException("Jobs list must be non-null!");
        }

        jobsToAnalyze = jobs;
    }

    public List<String> getMostPopularSkills() {
        var skillsPopularityMap = jobsToAnalyze.stream()
                .flatMap(job -> job.requirements().stream())
                .collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()));

        return getMostPopularEntities(skillsPopularityMap, 5);
    }

    public List<String> getMostPopularPositions() {
        var positionsPopularityMap = jobsToAnalyze.stream()
                .map(Job::positionName)
                .collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()));

        return getMostPopularEntities(positionsPopularityMap, 3);
    }

    public Map<String, List<Job>> getJobsBySalaryRange() {
        return jobsToAnalyze.stream()
                .collect(Collectors.groupingBy(job -> {
                    var salary = job.salary();

                    return switch (salary / 50000) {
                        case 0 -> "[0, 49_999]";
                        case 1 -> "[50_000 , 99_999]";
                        case 2 -> "[100_000 , 149_999]";
                        case 3 -> "[150_000 , 199_999]";
                        default -> "[200_000, inf]";
                    };
                }));
    }

    public List<String> getMostPopularPositionLocation() {
        var positionLocationsPopularityMap = jobsToAnalyze.stream()
                .map(Job::location)
                .map(location -> "(" + location + ")")
                .collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()));

        return getMostPopularEntities(positionLocationsPopularityMap, 5);
    }

    private List<String> getMostPopularEntities(HashMap<String, Long> entityPopularityMap, int maxSize) {
        return entityPopularityMap.entrySet().stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                .map(Map.Entry::getKey)
                .limit(maxSize)
                .toList();
    }
}

