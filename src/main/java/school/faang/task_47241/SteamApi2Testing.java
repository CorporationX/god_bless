package school.faang.task_47241;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
        .toList();
    }

    public static List<String> filteredWords(List<String> words, String startingChar) {
        return words.stream()
        .filter(word -> word.startsWith(startingChar))
        .sorted(Comparator.comparingInt(String::length))
        .toList();
    }

    public static List<String> convertNumberBinary(List<Integer> numbersTwo) {
        return numbersTwo.stream().map(Integer::toBinaryString).toList();
    }

    public static List<String> filterAlphabeticallySortLength(List<String> list, String alphabet) {
        Pattern pattern = Pattern.compile('[' + alphabet + "]+");
        return list.stream()
          .filter(x -> {
              Matcher matcher = pattern.matcher(x);
              return matcher.matches();
          })
          .sorted(Comparator.comparing(String::length))
          .collect(Collectors.toList());
    }
}
