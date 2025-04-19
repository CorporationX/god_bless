package school.faang.bjs2_70828;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Set<Integer> integers = Set.of(1, 2, 3, 4, 5, 6);
        Map<String, String> countries = Map.of("Russia", "Moscow", "USA", "Washington", "Germany", "Berlin");
        List<String> stringsToSort = List.of("apple", "banana", "avocado", "apricot");
        List<Integer> numbersToBinaryList = List.of(1, 2, 3, 4);
        List<String> alphabetList = List.of("apple", "banana", "cherry", "date", "fig", "grape");


        log.info("Unique pairs in integers with sum = 6: {}", CollectionOperations.findUniquePairs(integers, 6));
        log.info("Sorted list of capitals: {}", CollectionOperations.mapToSortedCapitals(countries));
        log.info("Sorted list with string started with 'a': {}",
                CollectionOperations.sortStringsStartsWithCharacter(stringsToSort, 'a'));
        log.info("Binary list of numbers: {}", CollectionOperations.mapNumbersToBinary(numbersToBinaryList));
        log.info("Sorted strings, that contains 'abcdefghijklmnopqrstuvwxyz': {}",
                CollectionOperations.filterByAlphabetAndSortByLength(alphabetList, "abcdefghijklmnopqrstuvwxyz"));
    }
}