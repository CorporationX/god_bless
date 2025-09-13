package school.faang.bjs2_87918;

import java.util.Set;
import java.util.List;
import java.util.Map;
import java.util.Comparator;
import java.util.stream.Collectors;

public class ListOperations {
    public static Set<List<Integer>> findPairs(List<Integer> numbers, int target) {
        Set<List<Integer>> set =  numbers.stream()
                        .flatMap(n -> numbers.stream()
                        .filter(m -> m > n && m + n == target)
                        .map(m -> List.of(m, n))).collect(Collectors.toSet());
        return set;
    }

    public static List<String> getCapitalsInOrder(Map<String, String> capitals) {
        return capitals.keySet().stream().sorted().map(capitals::get).toList();
    }

    public static List<String> filterAndSortStrings(List<String> oldList, char ch) {
        return oldList.stream()
                .filter(str -> str.charAt(0) == ch)
                .sorted((str1, str2) -> str1.length() - str2.length())
                .toList();
    }

    public static List<String> convertToBinaryFormat(List<Integer> numbers) {
        return numbers.stream().map(Integer::toBinaryString).toList();
    }

    public static List<String> filterAndSortWords(List<String> words, String alphabet) {
        Set<Character> allowed = alphabet.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

        List<String> result = words.stream()
                .filter(word -> word.chars().allMatch(c -> allowed.contains((char) c)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();

        return result;
    }
}
