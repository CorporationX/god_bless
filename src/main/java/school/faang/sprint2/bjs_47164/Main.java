package school.faang.sprint2.bjs_47164;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, -1, 10, 7, 4, 0, 11);
        log.info("result {}", findPairs(numbers, 10));

        Map<String, String> geo = Map.of(
                "Canada", "Ottawa",
                "Germany", "Berlin",
                "USA", "Washington",
                "France", "Paris");
        log.info("Capitals: {}", sortCountries(geo));

        List<String> colors = Arrays.asList("red", "blue", "rose", "orange", "raspberry", "ruby", "Black");
        log.info("Sorted list: {}", filterAndSortByLength(colors, 'r'));

        log.info("Binaries {}", convertDecToBin(numbers));
        log.info("Filtered and sorted: {}", filterAndSortStrings(colors, "abcdefghijklmnopqrstuvwxyzABCD"));
    }

    public static Set<List<Integer>> findPairs(List<Integer> numbers, int sumOfPair) {
        return numbers.stream()
                .filter(number -> numbers.contains(sumOfPair - number))
                .map(number -> Arrays.asList(number, sumOfPair - number))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> sortCountries(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterAndSortByLength(List<String> strings, Character symbol) {
        return strings.stream()
                .filter(string -> string.startsWith(symbol.toString()))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> convertDecToBin(List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num >= 0)
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterAndSortStrings(List<String> strings, String alphabet) {
        return strings.stream()
                .filter(string -> string.matches("[" + alphabet + "]+"))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
