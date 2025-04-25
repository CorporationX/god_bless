package s.f.BJS2_70867;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ListOperations {
    public static Set<String> findPairs(Set<Integer> numbers, int targetSum) {
        return numbers.stream()
                .flatMap(a -> numbers.stream()
                        .filter(b -> a < b && a + b == targetSum)
                        .map(b -> "(%d, %d)".formatted(a, b)))
                .collect(Collectors.toSet());
    }

    public static List<String> getSortedCapitals(Map<String, String> countryCapitalMap) {
        return countryCapitalMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterAndSortByLength(List<String> strings, char startsWith) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(startsWith)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> convertToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterAndSortByAlphabet(List<String> words, String alphabet) {
        Set<Character> allowed = alphabet.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
        return words.stream()
                .filter(word -> word.chars().allMatch(c -> allowed.contains((char) c)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
