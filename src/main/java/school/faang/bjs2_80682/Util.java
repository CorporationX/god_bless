package school.faang.bjs2_80682;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Util {
    public static Set<List<Integer>> findAllSubsets(Set<Integer> numbers, int targetSum) {
        Set<List<Integer>> subsets = new HashSet<>();
        numbers.stream()
                .filter(number -> numbers.contains(targetSum - number) && number != targetSum - number)
                .forEach(number -> {
                    if (!subsets.contains(List.of(targetSum - number, number))) {
                        subsets.add(List.of(number, targetSum - number));
                    }
                });
        return subsets;
    }

    public static List<String> getCapitals(Map<String, String> countriesAndCapitals) {
        return countriesAndCapitals.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterAndSortStringsStartingWith(List<String> strings, char c) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(c)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> convertToBinary(List<Integer> numbers) {
        return numbers.stream().map(Integer::toBinaryString).toList();
    }

    public static List<String> sortByAlphabetAndLength(List<String> strings, String alphabet) {
        return strings.stream()
                .filter(str -> str.chars().allMatch(c -> alphabet.contains(String.valueOf((char) c))))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
