package stream;

import java.util.*;
import java.util.stream.Collectors;

public class ListOperationNew {
    public static Set<List<Integer>> uniquePairsOfNumbers(List<Integer> numbers, int whole) {
        return numbers.stream()
                .flatMap(n -> numbers.stream()
                        .filter(m -> n + m == whole && n <= m)
                        .map(m -> Arrays.asList(n, m)))
                .distinct()
                .collect(Collectors.toSet());
    }

    public static List<String> getSortedCapitals(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public static List<String> getSortedFruit(List<String> fruit, char c) {
        return fruit.stream()
                .filter(s -> s.startsWith(String.valueOf(c)))
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
    }

    public static List<String> convertToBinary(List<Integer> newNumber) {
        return newNumber.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }

    public static List<String> getSortByFresh(List<String> fresh, String alphabet) {
        String regex = "[" + alphabet + "]+";

        return fresh.stream()
                .filter(s -> s.matches(regex))
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
    }

}
