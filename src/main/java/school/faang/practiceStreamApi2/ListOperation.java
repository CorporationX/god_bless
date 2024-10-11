package school.faang.practiceStreamApi2;

import java.util.*;
import java.util.stream.IntStream;

public class ListOperation {
  public static List<List<Integer>> findUniquePairNumbersWithSum(List<Integer> numbers, int value) {
    Map<Integer, Integer> map = new HashMap<>();

    return IntStream.range(0, numbers.size())
        .mapToObj(i -> {
          if (map.containsKey(value - numbers.get(i))) {
            List<Integer> list = new ArrayList<>();
            list.add(numbers.get(i));
            list.add(numbers.get(map.get(value - numbers.get(i))));
            return list;
          } else {
            map.put(numbers.get(i), i);
          }
          return null;
        })
        .filter(Objects::nonNull)
        .toList();
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
