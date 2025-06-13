package school.faang.module1.bjs2_80690;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class Main {

    public static void main(String[] args) {
        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5, 6);
        int target = 6;
        Set<List<Integer>> pairs = Operations.findPairs(numbers, target);
        log.info("Уникальные пары с суммой {}: {}", target, pairs);

        Map<String, String> countriesAndCapitals = Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin"
        );
        List<String> sortedCapitals = Operations.getSortedCapitals(countriesAndCapitals);
        log.info("Столицы по алфавиту стран: {}", sortedCapitals);

        List<String> words = List.of("apple", "banana", "avocado", "apricot");
        char startsWith = 'a';
        List<String> filteredAndSorted = Operations.filterAndSortByLength(words, startsWith);
        log.info("Строки, начинающиеся на '{}', отсортированы по длине: {}", startsWith, filteredAndSorted);

        List<Integer> nums = List.of(1, 2, 3, 4);
        List<String> binaryStrings = Operations.convertToBinary(nums);
        log.info("Двоичное представление чисел: {}", binaryStrings);

        List<String> fruits = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        List<String> filteredByAlphabet = Operations.filterByAlphabetAndSort(fruits, alphabet);
        log.info("Строки, содержащие только буквы из алфавита, отсортированы по длине: {}", filteredByAlphabet);
    }
}