package school.faang.sprint_2.task_47028;

import java.util.*;
import java.util.stream.Collectors;

public class ListOperations {
    public static Set<List<Integer>> findUniquePairsWithSum(List<Integer> integers, int sum) {
        Set<Integer> set = new HashSet<>();
        return integers.stream()
                .filter(num -> set.add(num) || set.contains(sum - num))
                .filter(num -> set.contains(sum - num))
                .map(num -> Arrays.asList(Math.min(num, sum - num), Math.max(num, sum - num)))
                .collect(Collectors.toSet());
    }

    public static List<String> getCapitalsSortedByCountry(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public static List<String> filterAndSortByLength(List<String> strings, char symbol) {
        return strings.stream()
                .filter(string -> string.startsWith(String.valueOf(symbol)))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static List<String> convertIntegersToBinaryStrings(List<Integer> integers) {
        return integers.stream()
                .map(integer -> Integer.toBinaryString(integer))
                .collect(Collectors.toList());
    }

    public static List<String> filterAndSortByLengthAlphabet(List<String> strings, String alphabet) {
        return strings.stream()
                .filter(string -> string.chars().allMatch(c -> alphabet.indexOf(c) >= 0))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
}