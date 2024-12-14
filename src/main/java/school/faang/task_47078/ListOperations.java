package school.faang.task_47078;

import java.util.Comparator;
import java.util.List;

public class ListOperations {
  static Integer sumOfEvenNumbers(List<Integer> listIntegers) {
    return listIntegers.stream().mapToInt(x -> x).sum();
  }

  static Integer findMax(List<Integer> listIntegers) {
    return listIntegers.stream().max(Integer::compareTo).get();
  }

  public static Integer findAverage(List<Integer> numbers) {
    return numbers.stream().mapToInt(Integer::intValue).sum() / numbers.size();
  }

  public static String countStringsStartingWith(List<String> strings, Character prefix) {
    return strings.stream().filter(x -> x.startsWith(String.valueOf(prefix))).count() + "";
  }

  public static String filterStringsContainingSubstring(List<String> strings, String w) {
    return strings.stream().filter(x -> x.contains(w)).count() + "";
  }

  public static String sortByLength(List<String> strings) {
    return strings.stream().sorted(Comparator.comparing(String::length)).toList().toString();
  }

  public static String allMatchCondition(List<Integer> numbers, Object o) {
    return numbers.stream().filter(x -> o.equals(x)).count() + "";
  }

  public static String findMinGreaterThan(List<Integer> numbers, int i) {
    return null;
  }
}
