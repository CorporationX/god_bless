package dima.evseenko.streamapi2;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class StreamOperationsTest {

    @Test
    void findUniquePairs() {
        assertEquals(Set.of(List.of(3, 4), List.of(2, 5), List.of(1, 6)), StreamOperations.findUniquePairs(List.of(1, 2, 3, 4, 5, 6), 7));
    }

    @Test
    void sortCapitals() {
        assertEquals(List.of("Berlin", "Moscow", "Washington"), StreamOperations.sortCapitals(Map.of("Russia", "Moscow", "USA", "Washington", "Germany", "Berlin")));
    }

    @Test
    void filterAndSorting() {
        assertEquals(List.of("apple", "avocado", "apricot"), StreamOperations.filterAndSorting(List.of("apple", "banana", "avocado", "apricot"), 'a'));
    }

    @Test
    void numbersToBinaries() {
        assertEquals(List.of("1", "10", "11", "100"), StreamOperations.numbersToBinaries(List.of(1, 2, 3, 4)));
    }

    @Test
    void filterByAlphabetAndSort() {
        assertEquals(List.of("fig", "date", "apple", "grape", "banana", "cherry"), StreamOperations.filterByAlphabetAndSort(List.of("apple", "banana", "cherry", "date", "fig", "grape"), "abcdefghijklmnopqrstuvwxyz"));
    }
}