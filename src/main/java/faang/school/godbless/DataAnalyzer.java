package faang.school.godbless;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataAnalyzer {

    public List<String> getTopSkills(List<Job> jobs) {
        List<String> allSkills = jobs.stream().flatMap(job -> job.getCandidateRequirements().stream()).collect(Collectors.toList());

        Map<String, Long> skillsCount = allSkills.stream().collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));

        return skillsCount.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(5).map(Map.Entry::getKey).collect(Collectors.toList());
    }

    public List<String> getTopPositions(List<Job> jobs, int topCount) {
        Map<String, Long> positionsCount = jobs.stream().collect(Collectors.groupingBy(Job::getPositionName, Collectors.counting()));

        return positionsCount.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(topCount).map(Map.Entry::getKey).collect(Collectors.toList());
    }

    public Map<String, Integer> analyzeSalary(List<Job> jobs, int salaryRange) {
        int rangeSize = 50000;
        int minSalary = 0;

        Map<String, Integer> salaryDist = new LinkedHashMap<>();

        while (minSalary < salaryRange) {
            int maxSalary = minSalary + rangeSize - 1;
            int tempMinSalary = minSalary;
            String salaryRangeLabel = minSalary/1000 + "k-" + maxSalary/1000 + "k";
            int jobCount = (int) jobs.stream().filter(job -> job.getSalary() >= tempMinSalary && job.getSalary() <= maxSalary).count();

            salaryDist.put(salaryRangeLabel, jobCount);
            minSalary += rangeSize;
        }
        return salaryDist;
    }

    public List<String> getTopLocations (List<Job> jobs){
        Map<String, Long> locationMap = jobs.stream()
                .collect(Collectors.groupingBy(Job::getLocation, Collectors.counting()));

        return locationMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }


}
