package trainingstream2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Service {
    public static Set<List<Integer>> findUniquePairs(List<Integer> numbers, int transmittedNumber) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        Set<List<Integer>> pairs = uniqueNumbers.stream()
                .filter(number -> uniqueNumbers.contains(transmittedNumber - number))
                .map(number -> Arrays.asList(number, transmittedNumber - number))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
        return pairs;
    }

    public static List<String> getSortedCapitals(Map<String, String> capitalCityByCountry) {
        return capitalCityByCountry.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterAndSortByCharacter(List<String> strings, char character) {
        return strings.stream()
                .filter(string -> string.startsWith(String.valueOf(character)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> convertToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterAndSortByLength(List<String> strings, String alphabet) {
        String regex = "[" + alphabet + "]+";
        return strings.stream()
                .filter(string -> string.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
