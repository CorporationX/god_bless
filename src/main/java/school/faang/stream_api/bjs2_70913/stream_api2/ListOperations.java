package school.faang.stream_api.bjs2_70913.stream_api2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ListOperations {
    public static List<List<Integer>> findUniquePairsWithTargetSum(Set<Integer> numbers, int target) {
        return numbers.stream()
                .filter(i -> numbers.contains(target - i) && i != target - i)
                .map(i -> Arrays.asList(i, target - i))
                .peek(Collections::sort)
                .distinct()
                .toList();
    }

    public static List<String> getCapitalsOfSortedCountries(Map<String, String> countryCapitalMap) {
        return countryCapitalMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> findStringsStartingWithSymbolAndSortByLength(List<String> strings, char symbol) {
        return strings.stream()
                .filter(str -> str.charAt(0) == symbol)
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> convertNumbersToBinaryStrings(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterStringsContainingAlphabetAndSortByLength(List<String> strings, String alphabet) {
        return strings.stream()
                .filter(str -> str.chars()
                        .allMatch(c -> alphabet.indexOf(c) != -1))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
