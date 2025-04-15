package school.faang.stream_api;

import java.util.*;
import java.util.stream.Collectors;

public class StreamHandler {
    public static Set<List<Integer>> findUniquePairs(Set<Integer> numbers, int sum) {
        return numbers.stream()
                .filter(number -> number != sum - number && numbers.contains(sum - number))
                .map(number -> new ArrayList<>(List.of(number, sum - number)))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> getCapitals(Map<String, String> countryToCopitalMap) {
        return countryToCopitalMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public static List<String> transferList(List<String> strings, char symbol) {
        return strings.stream()
                .filter(str -> str.startsWith(String.valueOf(symbol)))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static List<String> transferToBinaryFormat(List<Integer> numbers) {
        return numbers.stream().map(Integer::toBinaryString).collect(Collectors.toList());
    }

    public static List<String> filterAndSort(List<String> strings, String alphabet) {
        Set<Integer> alphabetChars = alphabet.chars().boxed().collect(Collectors.toSet());
        return strings.stream()
                .filter(str -> str.chars().allMatch(alphabetChars::contains))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
}
