package BJS2_57869;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
public class Main {
    public static void main(String[] args) {
        var pairs = ListOperations.findPairs(Set.of(1, 2, 3, 4, 5, 6), 6);
        var cities = ListOperations.sortCitiesByCountries(
                Map.of("Paris", "France", "Berlin", "Germany", "Madrid", "Spain", "Rome", "Italy"));
        var strings = List.of("apple", "banana", "avocado", "apricot", "blueberry", "blackberry", "cherry", "coconut");
        var binaryNumbers = ListOperations.transformToBinary(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        var filteredStrings = ListOperations.filterStringsByAlphabetAndSort(
                List.of("apple", "banana", "cherry", "date", "fig", "grape"), "abcdefghijklmnopqrstuvwxyz"
        );

        log.info("Pairs: {}", pairs);
        log.info("Cities: {}", cities);
        log.info("Filtered and sorted strings: {}", ListOperations.filterAndSortStrings(strings, 'a'));
        log.info("Binary numbers: {}", binaryNumbers);
        log.info("Filtered strings: {}", filteredStrings);
    }
}
