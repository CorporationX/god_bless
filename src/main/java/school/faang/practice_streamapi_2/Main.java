package school.faang.practice_streamapi_2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Set<Integer> numbersSet = Set.of(1, 2, 3, 4, 5, 6);
        logger.info("There is set of numbers: {}", numbersSet);
        logger.info("Set of pairs: {}", findPairs(numbersSet, 6));
        logger.info(capitalSortedCountry(Map.of("Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin")).toString());
        logger.info(stringFilterAndSorted(List.of("apple", "banana", "avocado", "apricot"), 'a').toString());
        logger.info(converterIntDecToBiString(List.of(1, 2, 3, 4)).toString());
        logger.info(stringFilterAlphabetAndSorted(
                List.of("apple", "banana", "cherry", "date", "fig", "grape"),
                "abcdefghijklmnopqrstuvwxyz").toString());
    }

    public static Set<List<Integer>> findPairs(Set<Integer> set, int key) {
        Set<Integer> pairNumbers = new HashSet<>();
        return set.stream().filter(num -> num != key - num)
                .filter(num -> set.contains(key - num))
                .map(num -> Arrays.asList(num, key - num)).peek(Collections::sort).collect(Collectors.toSet());
    }

    public static List<String> capitalSortedCountry(Map<String, String> map) {
        return map.entrySet().stream()
                .sorted((s1, s2) -> s1.getKey().compareTo(s2.getKey()))
                .map(Map.Entry::getValue).toList();
    }

    public static List<String> stringFilterAndSorted(List<String> list, char symbol) {
        return list.stream()
                .filter(s -> s.indexOf(symbol) == 0)
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> converterIntDecToBiString(List<Integer> list) {
        return list.stream()
                .map(Integer::toBinaryString).toList();
    }

    public static List<String> stringFilterAlphabetAndSorted(List<String> list, String alphabet) {
        return list.stream()
                .filter(s -> s.chars().allMatch(c -> alphabet.indexOf(c) >= 0))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
