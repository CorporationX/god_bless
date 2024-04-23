package faang.school.godbless.vacancy_analyzer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataAnalyzer {
    public void findTopSkills(List<Job> jobs) {
        Map<String, Long> skillFrequency = jobs.stream()
                .flatMap(job -> job.getRequirements().stream())
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));
        List<Map.Entry<String, Long>> sortedSkills = skillFrequency.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .toList();
        System.out.println("Топ 5 скиллов:");
        sortedSkills.forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

    public List<Map.Entry<String, Long>> getPopularPositions(Map<String, Long> positionFrequency, int limit) {
        return positionFrequency.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(limit)
                .collect(Collectors.toList());
    }

    public static Map<String, Integer> analyzeSalaryDistribution(Map<String, Double> salaryByPosition) {
        Map<String, Integer> salaryDistribution = new HashMap<>();
        for (double salary : salaryByPosition.values()) {
            String range = getSalaryRange(salary);
            salaryDistribution.put(range, salaryDistribution.getOrDefault(range, 0) + 1);
        }
        return salaryDistribution;
    }

    private static String getSalaryRange(double salary) {
        if (salary < 50000) {
            return "0-50k";
        } else if (salary < 100000) {
            return "50k-100k";
        } else if (salary < 150000) {
            return "100k-150k";
        } else {
            return "150k+";
        }
    }

    public List<String> getTop5PopularOfficeLocations(List<String> officeLocations) {
        Map<String, Integer> locationCount = new HashMap<>();
        for (String location : officeLocations) {
            locationCount.put(location, locationCount.getOrDefault(location, 0) + 1);
        }
        List<Map.Entry<String, Integer>> sortedLocations = new ArrayList<>(locationCount.entrySet());
        sortedLocations.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        List<String> top5Locations = new ArrayList<>();
        for (int i = 0; i < Math.min(5, sortedLocations.size()); i++) {
            top5Locations.add(sortedLocations.get(i).getKey());
        }
        return top5Locations;
    }
}

