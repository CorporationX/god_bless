package faang.school.godbless.BJS2_10387;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Main {
  public static void main(String[] args) {
    List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);
    System.out.println(sumEvenNums(nums));
    System.out.println(getMaxValue(nums));
    System.out.println(getAverage(nums));

    List<String> strings = List.of("abbc", "acc", "bd", "abbb", "dzccz");
    System.out.println(getCountStringIfStartWitch(strings, "a"));
    System.out.println(getFilterStringsBySubstring(strings, "bb"));
    System.out.println(getSortedListByLength(strings));
    System.out.println(isFiltered(strings, s -> s.length() >= 3));

    System.out.println(getMinValueGreaterGivenNumber(nums, 3));
    System.out.println(getLengthString(strings));
  }

  public static int sumEvenNums(List<Integer> nums) {
    return nums.stream().filter(n -> n % 2 == 0).reduce(Integer::sum).orElse(0);
  }

  public static int getMaxValue(List<Integer> nums) {
    return nums.stream().max(Integer::compareTo).orElse(0);
  }

  public static double getAverage(List<Integer> nums) {
    return nums.stream().reduce(Integer::sum).orElse(0) / (double) nums.size();
  }

  public static long getCountStringIfStartWitch(List<String> strings, String start) {
    return strings.stream().filter(s -> s.startsWith(start)).count();
  }

  public static List<String> getFilterStringsBySubstring(List<String> strings, String substring) {
    return strings.stream().filter(s -> s.contains(substring)).toList();
  }

  public static List<String> getSortedListByLength(List<String> strings) {
    return strings.stream().sorted(Comparator.comparing(String::length)).toList();
  }

  public static boolean isFiltered(List<String> strings, Predicate<String> filter) {
    return strings.stream().allMatch(filter);
  }

  public static int getMinValueGreaterGivenNumber(List<Integer> nums, int grade) {
    return nums.stream().filter(n -> n > grade).sorted(Integer::compareTo).toList().get(0);
  }

  public static List<Integer> getLengthString(List<String> strings) {
    return strings.stream().map(String::length).toList();
  }
}
