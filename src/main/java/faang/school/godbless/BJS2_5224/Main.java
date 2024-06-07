package faang.school.godbless.BJS2_5224;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Main {
  public static void main(String[] args) {
    List<Integer> nums = List.of(1, 2, 3, 4, 5);
    List<String> strings = List.of("ccc", "cppp", "ddccd", "cdd", "aaa");
    System.out.println(sumEvenListNums(nums));
    System.out.println(maxNumberList(nums));
    System.out.println(findAverageValue(nums));
    System.out.println(countStringIfStartWithSymb(strings, "d"));
    System.out.println(findStringIfHaveSubstring(strings, "dd"));
    System.out.println(sortingListLength(strings));
    System.out.println(isFiltered(strings, s -> s.length() > 3));
    System.out.println(findMinValue(nums, 3));
    System.out.println(mapListStringsToIntegers(strings));

  }

  public static int sumEvenListNums(List<Integer> nums) {
    return nums.stream()
      .filter(n -> n % 2 == 0)
      .reduce(Integer::sum)
      .orElse(0);
  }

  public static int maxNumberList(List<Integer> nums) {
    return nums.stream()
      .max(Integer::compareTo)
      .orElse(0);
  }

  public static double findAverageValue(List<Integer> nums) {
    return nums.stream()
      .mapToDouble(Integer::doubleValue)
      .average()
      .orElse(0);
  }

  public static long countStringIfStartWithSymb(List<String> strings, String symbol) {
    return strings.stream()
      .filter(s -> s.startsWith(symbol))
      .count();
  }

  public static List<String> findStringIfHaveSubstring(List<String> strings, String substring) {
    return strings.stream()
      .filter(s -> s.contains(substring))
      .toList();
  }

  public static List<String> sortingListLength(List<String> strings) {
    return strings.stream()
      .sorted(Comparator.comparing(String::length))
      .toList();
  }

  public static boolean isFiltered(List<String> strings, Predicate<String> filter) {
    return strings.stream()
      .anyMatch(filter);
  }

  public static int findMinValue(List<Integer> strings, int num) {
    return strings.stream()
      .filter(n -> n > num)
      .min(Integer::compareTo)
      .orElse(0);
  }

  private static List<Integer> mapListStringsToIntegers(List<String> strings) {
    return strings.stream()
      .map(String::length)
      .toList();
  }
}
