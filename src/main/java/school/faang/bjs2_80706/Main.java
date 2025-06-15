package school.faang.bjs2_80706;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
public class Main {
    public static void main(String[] args) {
        log.info(getPairNumberBySum(Set.of(1, 2, 3, 4, 5, 6, 7, 8), 5).toString());
        log.info(getSortedCapitals(Map.of("Russia", "Moscow", "USA", "Washington", "Germany", "Berlin")).toString());

        log.info(sortStringStartingWith(List.of("Hello", "apple", "dog", "cat", "april"), 'a').toString());
        log.info(filterByAlphabetAndSortByLength(
                List.of("1apple", "banana", "cherry", "date", "fig", "grape"),
                "abcdefghijklmnopqrstuvwxyz").toString()
        );
        log.info(convertToBinaryNum(List.of(1, 2, 3, 4)).toString());
    }


    private static Set<List<Integer>> getPairNumberBySum(Set<Integer> nums, int target) {
        return nums.stream()
                .filter(num -> nums.contains(target - num) && num < (target - num))
                .map(num -> Arrays.asList(num, target - num))
                .collect(Collectors.toSet());
    }

    private static List<String> getSortedCapitals(Map<String, String> country) {
        return country.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    private static List<String> sortStringStartingWith(List<String> strings, char letter) {
        return strings.stream()
                .filter(str -> str.startsWith(String.valueOf(letter)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    private static List<String> convertToBinaryNum(List<Integer> nums) {
        return nums.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    private static List<String> filterByAlphabetAndSortByLength(List<String> strings, String alphabet) {
        return strings.stream()
                .filter(s -> s.matches("[" + alphabet + "]+"))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

}
