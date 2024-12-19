package school.faang.task_47241;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class SteamApi2Testing {

    public static Set<List<Integer>> uniquePairsNumbers(List<Integer> numbers, int targetSum) {

        Set<Integer> set = new HashSet<>(numbers);
        return numbers.stream()
          .filter(num -> set.contains(targetSum - num))
          .map(num -> Arrays.asList(num, targetSum - num))
          .peek(Collections::sort)
          .collect(Collectors.toSet());
    }

    public static List<String> sortedCapitals(Map<String, String> countries) {
        return countries.entrySet().stream()
        .sorted(Map.Entry.comparingByKey())
        .map(Map.Entry::getValue)
        .collect(Collectors.toList());
    }

    public static List<String> filtredWords(List<String> words, String w) {
        return words.stream()
        .filter(word -> word.startsWith(w))
        .sorted(Comparator.comparing(String::length))
        .toList();
    }

    public static List<String> convertNumberBinary(List<Integer> numbersTwo) {
        return numbersTwo.stream().map(Integer::toBinaryString).toList();
    }

    public static List<String> filterAlphabeticallySortLength(List<String> list, String alphabet) {
        return list.stream()
          .filter(
              x -> {
                  return x.equals(alphabet);
              })
          .sorted(Comparator.comparing(String::length))
          .collect(Collectors.toList());
    }
}
