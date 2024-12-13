package school.faang.task_47173;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class Main {
    public static void main(String[] args) {
        printUniquePairs();
        printSortedCapitals();
        printFilteredAndSortedFruits();
        printBinaryNumbers();
        printFilteredAndSortedByLengthFruits();
    }

    private static void printUniquePairs() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        log.info("Unique pairs: {}", StreamOperations.findUniquePairs(numbers, 7));
    }

    private static void printSortedCapitals() {
        Map<String, String> countries = new HashMap<>();
        countries.put("Russia", "Moscow");
        countries.put("USA", "Washington");
        countries.put("Germany", "Berlin");

        log.info("Sorted capitals: {}", StreamOperations.getSortedCapitals(countries));
    }

    private static void printFilteredAndSortedFruits() {
        List<String> fruits = List.of("apple", "banana", "avocado", "apricot");
        log.info("Filter and sort fruits: {}", StreamOperations.filterAndSort(fruits, 'a'));
    }

    private static void printBinaryNumbers() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        log.info("Bynary numbers: {}", StreamOperations.convertToBinary(numbers));
    }

    private static void printFilteredAndSortedByLengthFruits() {
        List<String> strings = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        log.info("Filtered and sorted by length fruits: {}", StreamOperations.filterAndSortByLength(strings, alphabet));
    }
}
