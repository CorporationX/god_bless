package bjs257886;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TaskStreamApi {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static Set<List<Integer>> findUniquePairsNumbers(Set<Integer> numbers, int targetNumber) {
        return numbers.stream()
                .filter(number -> targetNumber - number != number && numbers.contains(targetNumber - number))
                .map(number -> Arrays.asList(number, targetNumber - number))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> sortCountriesAndGetCapitals(Map<String, String> countryToCapital) {
        return countryToCapital.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.naturalOrder()))
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> findAndSortStrings(List<String> strings, char startSymbol) {
        return strings.stream()
                .filter(string -> string.startsWith(String.valueOf(startSymbol)))
                .sorted(Comparator.comparing(String::length))
                .sorted(Comparator.naturalOrder())
                .toList();
    }

    public static List<String> convertNumbersToBinaryFormat(List<Integer> numbers) {
        return numbers.stream().map(Integer::toBinaryString).toList();
    }

    public static List<String> filterStringsAndSortByLength(List<String> strings) {
        return strings.stream()
                .filter(string -> string.matches("[" + ALPHABET + "]+"))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }
}
