package lets_practice_streamapi_2;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StreamApiProcessorTest {

    @Test
    void findUniquePairs() {
        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Set<Set<Integer>> resultFindUniquePairs = StreamApiProcessor.findUniquePairs(numbers, 7);
        assertEquals(Set.of(Set.of(1, 6), Set.of(2, 5), Set.of(3, 4)), resultFindUniquePairs);
    }

    @Test
    void sortByCapital() {
        Map<String, String> words = Map.of("Russia", "Moscow", "USA", "Washington", "Germany", "Berlin");

        List<String> resultSortByCapital = StreamApiProcessor.sortByCapital(words);
        assertEquals(List.of("Berlin", "Moscow", "Washington"), resultSortByCapital);
    }

    @Test
    void sortWordsByLengthAndStartWithLetter() {
        List<String> fruits = List.of("apple", "banana", "avocado", "apricot");

        List<String> resultSortWordsByLengthAndStartWithLetter = StreamApiProcessor
                .sortWordsByLengthAndStartWithLetter(fruits, 'a');
        assertEquals(List.of("apple", "avocado", "apricot"), resultSortWordsByLengthAndStartWithLetter);
    }

    @Test
    void convertNumbersToBinary() {
        List<Integer> numbers = List.of(1, 2, 3, 4);

        List<String> result = StreamApiProcessor.convertNumbersToBinary(numbers);
        assertEquals(List.of("1", "10", "11", "100"), result);
    }

    @Test
    void filterWordsByAlphabetAndSort() {
        List<String> words = List.of("apple", "banana", "cherry", "date", "fig", "grape");

        List<String> result = StreamApiProcessor
                .filterWordsByAlphabetAndSort(words, "abcdefghijklmnopqrstuvwxyz");
        assertEquals(List.of("fig", "date", "apple", "grape", "banana", "cherry"), result);
    }
}