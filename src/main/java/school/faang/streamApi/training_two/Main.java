package school.faang.streamApi.training_two;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
public class Main {
    public static void main(String[] args) {
        log.info("Pairs: {}", StreamOperations.findUniquePairs(Set.of(1, 2, 3, 4, 5, 6), 6));
        log.info("Sorted capitals: {}", StreamOperations.sortCapitals(
                Map.of("Russia", "Moscow", "USA", "Washington", "Germany", "Berlin")));
        log.info("Filtered by symbol and sorted by length: {}", StreamOperations.filterAndSortByChar(
                List.of("apple", "banana", "avocado", "apricot"), 'a'));
        log.info("Binary transformation: {}", StreamOperations.fromDecimalToBinary(List.of(1, 2, 3, 4, 5, 6)));
        log.info("Filtered by alphabet and sorted by length: {}", StreamOperations.filterWithAlphabetAndSortByLength(
                List.of("apple", "banana", "cherry", "date", "fig", "grape"), "abcdefghijklmnopqrstuvwxyz"));
    }
}
