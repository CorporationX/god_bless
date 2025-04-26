package school.faang.bjs2_72367;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int target = 6;
        StreamUtils.findUniquePairsFromTarget(numbers, target).forEach(
                entry -> log.info("({}, {})", entry.getKey(), entry.getValue())
        );

        Map<String, String> countryByCapital = Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin"
        );
        StreamUtils.getSortedCapitals(countryByCapital).forEach(log::info);

        List<String> words = Arrays.asList("apple", "banana", "avocado", "apricot");
        char prefix = 'a';
        StreamUtils.filterAndSortStringsByPrefix(words, prefix).forEach(log::info);

        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4);
        StreamUtils.convertNumbersToBinary(numbers2).forEach(log::info);

        List<String> fruits = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StreamUtils.filterAndSortStringsByAlphabet(fruits, alphabet).forEach(log::info);
    }
}
