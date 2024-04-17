package faang.school.godbless.BJS2_5609;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class DataAnalyzer {
    private static List<String> topFiveSkills(List<Job> jobs) {
        return jobs.stream().flatMap(job -> job.getRequirementForCandidates().stream()).
                collect(Collectors.groupingBy(skill -> skill, Collectors.counting())).
                entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).
                limit(5).map(Map.Entry::getKey).toList();
    }
}
