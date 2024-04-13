package faang.school.godbless.jobanalyzer;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DataAnalyzer {

    public List<String> getMostFoundSkills(List<Job> jobs, int limit) {
        Map<String, Long> countSkills = jobs.stream()
                .flatMap(job -> job.getRequirements().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return mapToList(countSkills, limit);
    }

    public List<String> getMostPopularVacancyName(List<Job> jobs, int limit) {
        Map<String, Long> countVacancy = jobs.stream()
                .collect(Collectors.groupingBy(Job::getVacancy, Collectors.counting()));

        return mapToList(countVacancy, limit);
    }

    public Map<String, Long> getSortedVacancyBySalaryRange(List<Job> jobs) {
        Set<SalaryRange> salaryRanges = getSalaryRangeSet();

        return salaryRanges.stream()
                .collect(Collectors.toMap(
                        SalaryRange::getName,
                        salaryRange -> jobs.stream()
                                .map(Job::getSalary)
                                .filter(job -> job > salaryRange.getLow() && job < salaryRange.getHigh())
                                .count()
                ));
    }

    private <T> List<T> mapToList(Map<T, Long> map, int limit) {
        return map.entrySet().stream()
                .sorted(((o1, o2) -> (int) (o2.getValue() - o1.getValue())))
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    private Set<SalaryRange> getSalaryRangeSet() {
        return Set.of(
                new SalaryRange("0-50k", 0, 50000),
                new SalaryRange("50-100k", 50001, 100000),
                new SalaryRange("100-150K", 100001, 150000)
        );
    }
}
