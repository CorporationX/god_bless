package faang.school.godbless.vacancyAnalyzator;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Evgenii Malkov
 */
public class DataAnalyzer {

  public static List<String> mostPopularSkills(List<Job> data, int limit) {
    return data.stream()
        .map(Job::getSkills)
        .flatMap(Collection::stream)
        .collect(Collectors.groupingBy((skill) -> skill, Collectors.counting()))
        .entrySet().stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .limit(limit)
        .map(Map.Entry::getKey)
        .toList();
  }

  public static List<String> mostPopularPositions(List<Job> data, int limit) {
    return data.stream()
        .map(Job::getPosition)
        .collect(Collectors.groupingBy((pos) -> pos, Collectors.counting()))
        .entrySet().stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .limit(limit)
        .map(Map.Entry::getKey)
        .toList();
  }

  public static Map<String, Long> salaryCountVacanciesAnalyze(List<Job> data, int range) {
    return data.stream()
        .map(Job::getSalary)
        .collect(Collectors.groupingBy((salary) -> getSalaryRange(salary, range), Collectors.counting()));
  }

  private static String getSalaryRange(int salary, int rangeSize) {
    int lowerBound = (salary / rangeSize) * rangeSize;
    int upperBound = lowerBound + rangeSize - 1;
    return lowerBound + " - " + upperBound;
  }

  public static List<String> mostPopularLocation(List<Job> data, int limit) {
    return data.stream()
        .map(Job::getLocation)
        .collect(Collectors.groupingBy((loc) -> loc, Collectors.counting()))
        .entrySet().stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .limit(limit)
        .map(Map.Entry::getKey)
        .toList();
  }
}
