package school.faang.sprint_2.task_47049;

import lombok.NonNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        filterAndSortString(List.of("apple", "banana", "avocado", "apricot"), 'a')
                .forEach(System.out::println);
    }

    public static Set<List<Integer>> findUniquePairs(@NonNull List<Integer> numbers, int targetNumber) {
        Set<Integer> numbersSet = new HashSet<>(numbers);
        return numbers.stream()
                .filter(number -> numbersSet.contains(targetNumber - number))
                .map(number -> Arrays.asList(number, targetNumber - number))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> getSortedCapitals(@NonNull Map<String, String> countriesCapitals) {
        return countriesCapitals.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterAndSortString(@NonNull List<String> strings, char beginningChar) {
        return strings.stream()
                .filter(string -> string.charAt(0) == beginningChar)
                .sorted()
                .toList();
    }

    public static List<String> mapToBinary(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterByAlphabetAndSort(List<String> strings, String alphabet) {
        String regEx = "[" + alphabet + "]+";
        return strings.stream()
                .filter(string -> string.matches(regEx))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
