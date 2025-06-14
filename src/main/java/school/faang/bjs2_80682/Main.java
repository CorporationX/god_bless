package school.faang.bjs2_80682;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
public class Main {
    public static void main(String[] args) {
        log.info("Subsets: {}", Util.findAllSubsets(Set.of(1, 2, 3, 4, 5, 6), 6));

        log.info("Capitals: {}", Util.getCapitals(Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin")));

        log.info("Filtered strings: {}",
                Util.filterAndSortStringsStartingWith(List.of("apple", "banana", "avocado", "apricot"), 'a'));

        log.info("Binary numbers: {}", Util.convertToBinary(List.of(1, 2, 3, 4, 5)));

        log.info("Sorted strings: {}",
                Util.sortByAlphabetAndLength(
                        List.of("apple", "banana", "cherry", "date", "fig", "grape"),
                        "abcdefghijklmnopqrstuvwxyz"));
    }
}
