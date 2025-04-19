package school.faang.bjs2_70820;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
class StreamApi {
    public static void main(String[] args) {
        log.info(findUniquePairsWithSumOfTargetNumber(Set.of(1, 2, 3, 4, 5, 6), 6).toString());
        log.info(sortCountriesAlphabetically(Map.of("Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin")).toString());
        log.info(sortByLengthFilteredByFirstChar(List.of("apple", "banana", "avocado", "apricot"), 'a')
                .toString());
        log.info(digitsToBinaryView(List.of(1, 2, 3, 4)).toString());
        log.info(filterByGivenAlphabetAndSortByLength(List.of("apple", "banana", "cherry", "date", "fig", "grape"),
                "abcdefghijklmnopqrstuvwxyz").toString());
    }

    public static Set<Pair<Integer, Integer>> findUniquePairsWithSumOfTargetNumber(
            Set<Integer> numbers, Integer targetNumber) {
        return numbers.stream()
                .flatMap(i -> numbers.stream()
                        .filter(j -> !Objects.equals(i, j) && i + j == targetNumber)
                        .map(j -> new Pair<>(i, j)))
                .collect(Collectors.toSet());

    }

    public static List<String> sortCountriesAlphabetically(Map<String, String> countriesCapitals) {
        return countriesCapitals.keySet().stream()
                .sorted()
                .map(countriesCapitals::get)
                .toList();
    }

    public static List<String> sortByLengthFilteredByFirstChar(List<String> strings, char letter) {
        return strings.stream()
                .filter(string ->
                        string.startsWith(String.valueOf(letter)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> digitsToBinaryView(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterByGivenAlphabetAndSortByLength(List<String> strings, String alphabet) {
        return strings.stream()
                .filter(string -> string.matches(String.format("[%s]+", alphabet)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
