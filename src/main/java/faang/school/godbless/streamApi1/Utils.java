package faang.school.godbless.streamApi1;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Evgenii Malkov
 */
public class Utils {
  public static int getSumEvenNumbers(List<Integer> numbers) {
    return numbers.stream()
        .filter((num) -> num % 2 == 0)
        .reduce(Integer::sum)
        .orElseThrow(() -> new IllegalArgumentException("Отсутствуют четные числа в списке"));
  }

  public static int getMaxNumber(List<Integer> numbers) {
    return numbers.stream()
        .max(Comparator.comparing(Integer::intValue))
        .orElseThrow(() -> new RuntimeException("Ошибка получения максимального числа"));
  }

  public static double getAverage(List<Integer> numbers) {
    return numbers.stream()
        .mapToInt(Integer::intValue)
        .average()
        .orElseThrow(() -> new RuntimeException("Ошибка получения среднего значения чисел"));
  }

  public static long getRowCountStartingWith(List<String> rows, char character) {
    return rows.stream()
        .filter((row) -> row.startsWith(String.valueOf(character)))
        .count();
  }

  public static List<String> getRowsWithSubstring(List<String> rows, String substring) {
    return rows.stream()
        .filter((row) -> row.contains(substring))
        .toList();
  }

  public static List<String> sortStringsByLength(List<String> rows, boolean desc) {
    return rows.stream()
        .sorted(desc
            ? Comparator.comparing(String::length).reversed()
            : Comparator.comparing(String::length))
        .toList();
  }

  public static boolean checkElementsForCondition(List<Integer> numbers, Predicate<? super Integer> predicate) {
    return numbers.stream().allMatch(predicate);
  }

  public static int getMinNumberWithGreaterThanGivenNum(List<Integer> numbers, int givenNum) {
    return numbers.stream()
        .filter((num) -> num > givenNum)
        .min(Comparator.comparing(Integer::intValue))
        .orElseThrow(() -> new RuntimeException("Ошибка получения минимального числа"));
  }

  public static List<Integer> convertToLengthList(List<String> rows) {
    return rows.stream().map(String::length).toList();
  }
}
