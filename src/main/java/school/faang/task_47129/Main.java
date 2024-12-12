package school.faang.task_47129;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
public class Main {
    public static void main(String[] args) {
        log.info("{}", findPairs(List.of(1, 2, 3, 4, 5, 6), 7));
        log.info("{}", getSortedCapitals(
                Map.of("Russia", "Moscow", "USA", "Washington", "Germany", "Berlin")));
        log.info("{}", filterAndSort(List.of("apple", "banana", "avocado", "apricot"), 'a'));
        log.info("{}", convertToBinary(List.of(1, 2, 3, 4)));
        log.info("{}", filterAndSortByLength(List.of("apple", "banana", "cherry", "date", "fig", "grape"),
                "a-z"));
    }


    public static Set<List<Integer>> findPairs(@NonNull List<Integer> numbers, int sum) {
        Set<List<Integer>> pairs;
        Set<Integer> set = new HashSet<>(numbers);

        pairs = numbers.stream()
                .filter(num -> num != null && set.contains(sum - num))
                .map(num -> Arrays.asList(num, sum - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());

        return pairs;
    }

    public static List<String> getSortedCapitals(@NonNull Map<String, String> capitalByCountry) {
        return capitalByCountry.entrySet().stream()
                .filter(Objects::nonNull)
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public static List<String> filterAndSort(@NonNull List<String> strings, char letter) {
        return strings.stream()
                .filter(s -> s != null && s.startsWith(String.valueOf(letter)))
                .sorted(String::compareTo)
                .collect(Collectors.toList());
    }

    public static List<String> convertToBinary(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .filter(Objects::nonNull)
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }

    public static List<String> filterAndSortByLength(@NonNull List<String> strings, @NonNull String alphabet) {
        String regex = String.format("[%s]+", alphabet);
        return strings.stream()
                .filter(s -> s != null && s.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

}
