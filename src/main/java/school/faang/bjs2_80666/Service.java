package school.faang.bjs2_80666;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Service {
    public static Set<Set<Integer>> findUniquePairBySum(Set<Integer> numbers, int sum) {
        return numbers.stream()
                .filter(num -> num != sum - num && numbers.contains(sum - num))
                .map(num -> Set.of(num, sum - num))
                .collect(Collectors.toSet());
    }

    public static List<String> getSortedCapital(Map<String, String> countryCapital) {
        return countryCapital.values().stream()
                .sorted()
                .toList();
    }

    public static List<String> filterAndSortStartingWith(List<String> strings, char symbol) {
        return strings.stream()
                .filter(string -> string.startsWith(Character.toString(symbol)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> toBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterAndSort(List<String> strings, String alphabet) {
        String regex = "[" + alphabet + "]+";
        return strings.stream()
                .filter(string -> string.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .toList();

    }
}
