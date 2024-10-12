package school.faang.practiceTheStreamAPI1;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class ListOperations {
  public static int sumOfEvenNumbers(List<Integer> numbers) {
    return numbers.stream()
        .filter(number -> number % 2 == 0)
        .reduce(0, Integer::sum);
  }

  public static Optional<Integer> findMax(List<Integer> numbers) {
    return numbers.stream().max(Integer::compareTo);
  }

  public static double findAverage(List<Integer> numbers) {
    return numbers.stream()
        .mapToInt(Integer::intValue)
        .average()
        .orElse(0.0);
  }

  public static int countStringsStartingWith(List<String> strings, char character) {
    return (int) strings.stream()
        .filter(string -> string.charAt(0) == character)
        .count();
  }

  public static List<String> filterStringsContainingSubstring(List<String> strings, String substring) {
    return strings.stream()
        .filter(string -> string.contains(substring))
        .toList();
  }

  public static List<String> sortByLength(List<String> strings) {
    return strings.stream()
        .sorted((str1, str2) -> str1.length() - str2.length())
        .toList();
  }

  public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> predicate) {
    return numbers.stream()
        .allMatch(predicate);
  }

  public static Optional<Integer> findMinGreaterThan(List<Integer> numbers, int value) {
    return numbers.stream()
        .filter(number -> number > value)
        .min((a, b) -> a - b);
  }

  public static List<Integer> convertToLengths(List<String> strings) {
    return strings.stream()
        .map(String::length)
        .toList();
  }
}
