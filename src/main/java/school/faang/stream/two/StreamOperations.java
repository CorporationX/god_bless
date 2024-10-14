package school.faang.stream.two;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamOperations {

  public static void main(String[] args) {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
    int sum = 7;
    System.out.println(findPairs(numbers, sum));

    Map<String, String> countriesCapitals = Map.of("Russia", "Moscow", "USA", "Washington",
        "Germany", "Berlin");
    System.out.println(getSortedCapitals(countriesCapitals));

    List<String> strings = List.of("apple", "banana", "avocado", "apricot", "grape", "fig", "date",
        "");
    char ch = 'a';
    System.out.println(filterStartWithSortByLength(strings, ch));

    System.out.println(convertToBinary(numbers));

    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    System.out.println(filterByAlphabetSortByLength(strings, alphabet));
  }

  private static List<String> filterByAlphabetSortByLength(List<String> strings, String alphabet) {
    String regex = "[" + alphabet + "]+";
    return strings.stream()
        .filter(s -> s.matches(regex))
        .sorted(Comparator.comparingInt(String::length))
        .toList();
  }

  private static List<String> convertToBinary(List<Integer> numbers) {
    return numbers.stream()
        .map(Integer::toBinaryString)
        .toList();
  }

  private static List<String> filterStartWithSortByLength(List<String> strings, char ch) {
    return strings.stream()
        .filter(s -> !s.isEmpty() && s.charAt(0) == 'a')
        .sorted(Comparator.comparingInt(String::length))
        .toList();
  }

  public static List<String> getSortedCapitals(Map<String, String> countriesCapitals) {
    Collection<String> capitals = countriesCapitals.values();
    return capitals.stream()
        .sorted()
        .toList();
  }

  public static Set<List<Integer>> findPairs(List<Integer> numbers, int sum) {
    Set<List<Integer>> pairs;
    Set<Integer> set = new HashSet<>(numbers);
    pairs = numbers.stream()
        .filter(num -> set.contains(sum - num))
        .map(num -> Arrays.asList(num, sum - num))
        .peek(Collections::sort)
        .collect(Collectors.toSet());
    return pairs;
  }
}
