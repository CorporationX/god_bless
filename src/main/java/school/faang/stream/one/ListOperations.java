package school.faang.stream.one;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ListOperations {

  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 0, -10);
    List<Integer> numbersSecond = Arrays.asList(7, 5, 3, 9, 5, 21, 7);
    List<String> strings = Arrays.asList("telegram", "apple", "banana", "date", "cherry");

    System.out.println("Sum of even elements: " + sumOfEvenNumbers(numbers));
    System.out.println("Max number: " + findMax(numbers));
    System.out.println("Average number: " + findAverage(numbers));
    System.out.println(
        "Number of strings starts with 'a': " + countStringsStartingWith(strings, 'a'));
    System.out.println("Strings contains 'te': " + filterStringsContainingSubstring(strings, "te"));
    System.out.println("Sorted by length: " + sortByLength(strings));
    System.out.println("Are all numbers positive?: " + allMatchCondition(numbers, n -> n > 0));
    System.out.println(
        "Are all numbers even?: " + allMatchCondition(numbersSecond, n -> n % 2 != 0));
    System.out.println("Least number greater then 5: " + findMinGreaterThen(numbers, 5));
    System.out.println("Least number greater then 7: " + findMinGreaterThen(numbers, 7));
    System.out.println("Strings' length: " + convertToLengths(strings));

  }

  public static int sumOfEvenNumbers(List<Integer> numbers) {
    return numbers.stream().filter(num -> num % 2 == 0).mapToInt(Integer::intValue).sum();
  }

  public static int findMax(List<Integer> numbers) {
    return numbers.stream()
        .max(Integer::compareTo)
        .orElseThrow(() -> new NoSuchElementException("Empty list"));
  }

  public static double findAverage(List<Integer> numbers) {
    return numbers.stream().mapToInt(Integer::intValue).average().orElse(0.0);
  }

  public static int countStringsStartingWith(List<String> strings, char ch) {
    return (int) strings.stream()
        .filter(s -> !s.isEmpty() && s.charAt(0) == ch)
        .count();
  }

  public static List<String> filterStringsContainingSubstring(List<String> strings,
      String substring) {
    return strings.stream()
        .filter(s -> s.contains(substring))
        .toList();
  }

  public static List<String> sortByLength(List<String> strings) {
    return strings.stream()
        .sorted(Comparator.comparingInt(String::length))
        .toList();
  }

  public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> condition) {
    return numbers.stream()
        .allMatch(condition);
  }

  public static int findMinGreaterThen(List<Integer> numbers, int threshold) {
    return numbers.stream()
        .filter(num -> num > threshold)
        .min(Integer::compareTo)
        .orElseThrow(() -> new NoSuchElementException("no element greater then " + threshold));
  }

  public static List<Integer> convertToLengths(List<String> strings) {
    return strings.stream()
        .map(String::length)
        .toList();
  }

}
