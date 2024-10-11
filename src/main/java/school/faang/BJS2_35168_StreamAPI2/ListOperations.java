package school.faang.BJS2_35168_StreamAPI2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListOperations {
    public static Set<List<Integer>> findPairsWithSum(List<Integer> numbers, int requiredSum) {
        Set<Integer> checkedNumbers = new HashSet<>();

        return numbers.stream()
                .flatMap(number -> {
                    int difference = requiredSum - number;
                    if (checkedNumbers.contains(difference)) {
                        return Stream.of(Arrays.asList(Math.min(number, difference), Math.max(number, difference)));
                    } else {
                        checkedNumbers.add(number);
                        return Stream.empty();
                    }
                })
                .collect(Collectors.toSet());
    }

    public static List<String> sortAndGetCapitals(Map<String, String> capitalsByCountries) {
        return capitalsByCountries.entrySet().stream()
                .sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey()))
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterAndSort(List<String> list, char startChar) {
        return list.stream()
                .filter(string -> string.startsWith(Character.toString(startChar)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> convertToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterAndSort(List<String> list, String alphabet) {
        return list.stream().
                filter(string -> string.chars().
                        allMatch(ch -> alphabet.indexOf(ch) != -1)
                )
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
