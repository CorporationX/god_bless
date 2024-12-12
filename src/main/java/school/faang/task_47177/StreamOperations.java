package school.faang.task_47177;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamOperations {

    public static Set<List<Integer>> collectPair(List<Integer> numbers, int sum) {
        Set<Integer> pairs = new HashSet<>(numbers);
        return numbers.stream()
                .filter(num -> pairs.contains(sum - num))
                .map(num -> {
                    List<Integer> pair = Arrays.asList(num, sum - num);
                    Collections.sort(pair);
                    return pair;
                }).collect(Collectors.toSet());
    }

    public static List<String> getSortedCapitals(Map<String, String> countryCapital) {
        return countryCapital.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public static List<String> filterAndSort(List<String> strings, char letter) {
        return strings.stream()
                .filter(str -> str.startsWith(String.valueOf(letter)))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static List<String> convertToBinary(List<Integer> integers) {
        return integers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public List<String> filterAndSortByLength(List<String> strings, String alphabet) {
        String regex = "[" + alphabet + "]+";
        return strings.stream()
                .filter(str -> str.matches(regex))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }
}
