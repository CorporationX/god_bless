package school.faang.bjs22_59996;

import school.faang.bjs2_58308.ListOperations;

import java.util.*;
import java.util.stream.Collectors;

public class ListOperation {
    public static Set<List<Integer>> findUniquePairsOfNumbers(Set<Integer> manyIntegers, int sum) {
        return manyIntegers
                .stream()
                .filter(i -> sum - i != i && manyIntegers.contains(sum - i))
                .map(i -> Arrays.asList(i, sum - i))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> sortedCapital(Map<String, String> countryAndCapital) {
        validateMap(countryAndCapital);
        return countryAndCapital
                .entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .sorted()
                .toList();
    }

    public static List<String> sortingLines(List<String> list, char symbol) {
        return list
                .stream()
                .filter(line -> line.startsWith(String.valueOf(symbol)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> convertDoubleFormat(List<Integer> listNumbers) {
        return listNumbers
                .stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterLines(List<String> list, String alphabet) {
        String regex = "[" + alphabet + "]+";
        return list
                .stream()
                .filter(i -> i.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    private static <U, V> void validateMap(Map<U, V> map) {
        if (map == null) {
            throw new IllegalArgumentException("The map can't be null");
        }
        for (var entry : map.entrySet()) {
            if (entry.getKey() == null) {
                throw new IllegalArgumentException("The key in map can't be null");
            } else if (entry.getValue() == null) {
                throw new IllegalArgumentException("The value in map can't be null");
            }
        }
    }
}
