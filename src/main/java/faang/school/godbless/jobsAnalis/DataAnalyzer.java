package faang.school.godbless.jobsAnalis;

import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@NoArgsConstructor
public class DataAnalyzer {
    public static List<String> top5DemandSkills(List<Job> jobs) {
        var map =  jobs.stream()
                .flatMap(job -> job.getSkills().stream())
                .collect(Collectors.groupingBy(
                        skill -> skill,
                        Collectors.counting()));

        return map.entrySet().stream()
                .sorted(Comparator.comparingLong(value -> -value.getValue()))
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> top5Titles(List<Job> jobs) {
        var map =  jobs.stream()
                .collect(Collectors.groupingBy(
                        Job::getTitle,
                        Collectors.counting()));

        return map.entrySet().stream()
                .sorted(Comparator.comparingLong(value -> -value.getValue()))
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    //как в примере
    //0-50k, 50k-100k, 100k-150k
    public static Map<String, Long> salaryRanges(List<Job> jobs) {
        return jobs.stream()
                .collect(Collectors.groupingBy(
                        DataAnalyzer::getRange,
                        Collectors.counting()
                ));
    }

    private static String getRange(Job job) {
        Integer salary = job.getSalary();
        if (salary >= 0 && salary < 50000) {
            return "0-50k";
        } else if (salary >= 50000 && salary < 100000) {
            return "50k-100k";
        } else if (salary >= 100000 && salary < 150000) {
            return "100k-150k";
        }
        return "UNDEFINED";
    }

    public static List<String> top5Locations(List<Job> jobs) {
        var map =  jobs.stream()
                .collect(Collectors.groupingBy(
                        Job::getLocation,
                        Collectors.counting()));
        return map.entrySet().stream()
                .sorted(Comparator.comparingLong(value -> -value.getValue()))
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }
}
