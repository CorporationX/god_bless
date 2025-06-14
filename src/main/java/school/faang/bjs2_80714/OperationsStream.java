package school.faang.bjs2_80714;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class OperationsStream {

    public static List<Pair> findUniquePairs(Set<Integer> numbers, int target) {
        return numbers.stream()
                .filter(a -> numbers.contains(target - a))
                .filter(a -> a <= target - a)
                .map(a -> new Pair(a, target - a))
                .collect(Collectors.toList());
    }

    public static List<String> getSortedCapitals(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public static List<String> filterAndSort(List<String> strings, char prefix) {
        return strings.stream()
                .filter(s -> !s.isEmpty() && s.charAt(0) == prefix)
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static List<String> toBinaryStrings(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }

    public static List<String> filterByAlphabetAndSort(List<String> input, String alphabet) {
        Set<Character> allowed = alphabet.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

        return input.stream()
                .filter(s -> s.chars().allMatch(c -> allowed.contains((char) c)))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
}