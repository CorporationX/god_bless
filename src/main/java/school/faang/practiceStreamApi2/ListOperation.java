package school.faang.practiceStreamApi2;

import java.util.*;
import java.util.stream.IntStream;

public class ListOperation {
  public static List<List<Integer>> findUniquePairNumbersWithSum(List<Integer> numbers, int value) {
    Map<Integer, Integer> map = new HashMap<>();
    List<List<Integer>> result = new ArrayList<>();

    IntStream.range(0, numbers.size())
        .forEach(i -> {
          if (map.containsKey(value - numbers.get(i))) {
            List<Integer> pair = Arrays.asList(numbers.get(i), map.get(value - numbers.get(i)));
            result.add(pair);
          } else {
            map.put(numbers.get(i), i);
          }
        });
    return result;
  }

  public static List<String> sortCountriesAndGetCapitals(Map<String, String> countriesAndCapitals) {
    return countriesAndCapitals.entrySet().stream()
        .sorted((entry1, entry2) -> entry1.getKey().charAt(0) - entry2.getKey().charAt(0))
        .map(Map.Entry::getValue)
        .toList();
  }

  public static List<String> filterByFirstCharAndSortByLength(List<String> strings, char character) {
    return strings.stream()
        .filter(string -> string.charAt(0) == character)
        .sorted((str1, str2) -> str1.length() - str2.length())
        .toList();
  }

  public static List<String> convertIntegersToBinaryStrings(List<Integer> numbers) {
    return numbers.stream()
        .map(Integer::toBinaryString)
        .toList();

  }

  public static List<String> filterByAlphabetAndSortByLength(List<String> strings, String alphabet) {
    return strings.stream()
        .filter(string -> string.chars().allMatch(c -> alphabet.contains(String.valueOf((char) c))))
        .sorted((str1, str2) -> str1.length() - str2.length())
        .toList();
  }
}
