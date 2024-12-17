package school.faang.task_47194;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class ListOperations {
    private static final String ERROR_MESSAGE = "Input parameters can't be null!";

    public static Set<List<Integer>> findUniquePairsOfNumbers(List<Integer> integers, int sumOfNumbers) {
        if (integers == null) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }

        Set<List<Integer>> pairsOfNumbers;
        Set<Integer> setOfNumbers = new HashSet<>(integers);

        pairsOfNumbers = setOfNumbers.stream()
                .filter(num -> num != null && setOfNumbers.contains(sumOfNumbers - num))
                .map(num -> Arrays.asList(num, sumOfNumbers - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());

        return pairsOfNumbers;
    }

    public static List<String> getCapitals(Map<String, String> countriesWithCapitals) {
        if (countriesWithCapitals == null) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }

        return countriesWithCapitals.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterAndSortByLength(List<String> strings, char c) {
        if (strings == null) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }

        var charValue = String.valueOf(c);
        return strings.stream()
                .filter(s -> s != null && s.startsWith(charValue))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> mapToBinaryCode(List<Integer> integers) {
        if (integers == null) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }

        return integers.stream()
                .filter(Objects::nonNull)
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterByAlphabetAndSortByLength(List<String> strings, String alphabet) {
        if (strings == null || alphabet == null || alphabet.isBlank()) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        var pattern = "[" + alphabet + "]+";

        return strings.stream()
                .filter(s -> s != null && s.matches(pattern))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
