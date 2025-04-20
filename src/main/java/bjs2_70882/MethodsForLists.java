package bjs2_70882;

import java.util.*;
import java.util.stream.Collectors;

public class MethodsForLists {
    public static Set<List<Integer>> findUniquePairsOfNumbers(Set<Integer> numbers, int targetNumber) {
        return numbers.stream()
                .filter(num -> numbers.contains(targetNumber-num) && num != targetNumber - num)
                .map(num -> Arrays.asList(num, targetNumber - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> sortingCountriesAndDisplayingCapitals(Map<String, String> mapOfCountriesAndCapitals) {
        return mapOfCountriesAndCapitals.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterAndSortTheRows(List<String> lines, char symbol) {
        return lines.stream()
                .filter(line -> line.charAt(0) == symbol)
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> convertToBinaryFormat(List<Integer> numbers) {
        return numbers.stream()
                .map(num -> Integer.toBinaryString(num))
                .toList();
    }

    public static List<String> filterAlphabeticallyAndSortByLength(List<String> lines, String alphabet) {
        String regex = "[" + alphabet + "]+";
        return lines.stream()
                .filter(line -> line.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
