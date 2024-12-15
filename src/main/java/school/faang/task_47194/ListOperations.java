package school.faang.task_47194;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class ListOperations {

    public static Set<Set<Integer>> findUniquePairsOfNumbers(List<Integer> integers, int sumOfNumbers) {
        if (integers == null) {
            throw new IllegalArgumentException("Input parameters can't be null!");
        }

        Set<Set<Integer>> pairsOfNumbers;
        Set<Integer> setOfNumbers = new HashSet<>(integers);

        pairsOfNumbers = setOfNumbers.stream()
                .filter(num -> num != null && setOfNumbers.contains(sumOfNumbers - num))
                .map(num -> Set.of(num, sumOfNumbers - num))
                .collect(Collectors.toSet());

        return pairsOfNumbers;
    }

    public static List<String> getCapitals(Map<String, String> countriesWithCapitals) {
        if (countriesWithCapitals == null) {
            throw new IllegalArgumentException("Input parameters can't be null!");
        }

        return countriesWithCapitals.keySet().stream()
                .sorted(String::compareTo)
                .map(countriesWithCapitals::get)
                .toList();
    }

    public static List<String> filterAndSortByLength(List<String> strings, char c) {
        if (strings == null) {
            throw new IllegalArgumentException("Input parameters can't be null!");
        }

        return strings.stream()
                .filter(s -> s != null && s.startsWith(String.valueOf(c)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> mapToBinaryCode(List<Integer> integers) {
        if (integers == null) {
            throw new IllegalArgumentException("Input parameters can't be null!");
        }

        return integers.stream()
                .filter(Objects::nonNull)
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterByAlphabetAndSortByLength(List<String> strings, String alphabet) {
        if (strings == null || alphabet == null || alphabet.isBlank()) {
            throw new IllegalArgumentException("Input parameters can't be null!");
        }
        var pattern = "[" + alphabet + "]+";

        return strings.stream()
                .filter(s -> s != null && s.matches(pattern))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
