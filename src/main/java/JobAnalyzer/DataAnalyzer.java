package JobAnalyzer;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataAnalyzer {

    public List<String> searchTopSkills(Stream<String> jsonStream){
        List<Job> jobs = JobStreamProcessor.parseJsonToJob(jsonStream);

        Map<String, Long> sortedRequirements = jobs.stream()
                .flatMap(job -> job.requirements().stream())
                .collect(Collectors.groupingBy(r -> r,Collectors.counting()));

        return sortedRequirements.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }
}
