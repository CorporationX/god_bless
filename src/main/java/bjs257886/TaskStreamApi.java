package bjs257886;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class TaskStreamApi {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static Set<List<Integer>> findUniquePairsNumbers(Set<Integer> numbersParameter, int targetNumber) {
        Map<Integer, Integer> map = new TreeMap<>();
        List<Integer> numbers = new ArrayList<>(numbersParameter);
        Set<List<Integer>> result = new HashSet<>();
        IntStream.range(0, numbers.size())
                .forEach(i -> {
                    int complement = targetNumber - numbers.get(i);
                    if (map.containsKey(complement)) {
                        result.add(Arrays.asList(numbers.get(i), complement));
                    }
                    map.put(numbers.get(i), i);
                });
        return result;
    }

    public static List<String> sortCountriesAndGetCapitals(Map<String, String> countryToCapital) {
        return countryToCapital.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.naturalOrder()))
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> findAndSortStrings(List<String> strings, char startSymbol) {
        return strings.stream()
                .filter(string -> string.charAt(0) == startSymbol)
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static List<String> convertNumbersToBinaryFormat(List<Integer> numbers) {
        return numbers.stream().map(Integer::toBinaryString).toList();
    }

    public static List<String> filterStringsAndSortByLength(List<String> strings) {
        return strings.stream()
                .filter(string -> !string.isBlank() && string.matches("[" + ALPHABET + "]*"))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }
}
