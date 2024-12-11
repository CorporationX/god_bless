package school.faang.sprint_2.task_47161;

import java.util.*;
import java.util.stream.Collectors;

public class ListOperations {

    public static Set<List<Integer>> findPairOfNumbers(List<Integer> numbers, int sumTarget) {
        Set<Integer> set = new HashSet<>(numbers);

        return numbers.stream()
                .filter(num -> set.contains(sumTarget - num))
                .map(num -> {
                    List<Integer> pair = Arrays.asList(num, sumTarget - num);
                    Collections.sort(pair);
                    return pair;
                })
                .collect(Collectors.toSet());
    }

    public static List<String> sortCapitals(Map<String, String> countriesCity) {
        return countriesCity.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());

    }

    public static List<String> filterAndSortStrings(List<String> strings, char ch) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(ch)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();

    }

    public static List<String> convertToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterAndSortByLength(List<String> strings, String alphabet) {
        String regex = String.format("[%s]+", alphabet);
        return strings.stream()
                .filter(s -> s.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
