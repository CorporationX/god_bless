package streamapi2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class StreamOperations2Test {

    private Set<Integer> numberSet;
    private Map<String, String> countryCapitalMap;
    private List<String> stringList;
    private List<Integer> numberList;

    @BeforeEach
    void setUp() {
        numberSet = new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        countryCapitalMap = Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin"
        );
        stringList = Arrays.asList("apple", "banana", "avocado", "apricot");
        numberList = Arrays.asList(1, 2, 3, 4);
    }

    @Nested
    class FindUniquePairsTests {
        @Test
        void testFindUniquePairsPositive() {
            List<int[]> pairs = StreamOperations2.findUniquePairs(numberSet, 6);
            Set<List<Integer>> resultSet = pairs.stream()
                    .map(arr -> Arrays.stream(arr).boxed().toList())
                    .collect(Collectors.toSet());
            Set<List<Integer>> expected = Set.of(
                    List.of(1, 5),
                    List.of(2, 4)
            );
            assertEquals(expected, resultSet);
        }

        @Test
        void testFindUniquePairsNoPairs() {
            List<int[]> pairs = StreamOperations2.findUniquePairs(numberSet, 100);
            assertTrue(pairs.isEmpty());
        }

        @Test
        void testFindUniquePairsNullSet() {
            assertThrows(IllegalArgumentException.class, () ->
                    StreamOperations2.findUniquePairs(null, 10)
            );
        }
    }

    @Nested
    class SortCapitalsTests {
        @Test
        void testSortCapitalsPositive() {
            List<String> capitals = StreamOperations2.sortCapitals(countryCapitalMap);
            List<String> expected = Arrays.asList("Berlin", "Moscow", "Washington");
            assertEquals(expected, capitals);
        }

        @Test
        void testSortCapitalsNullMap() {
            assertThrows(IllegalArgumentException.class, () ->
                    StreamOperations2.sortCapitals(null)
            );
        }
    }

    @Nested
    class FilterAndSortStringsTests {
        @Test
        void testFilterAndSortStringsPositive() {
            List<String> filtered = StreamOperations2.filterAndSortStrings(stringList, 'a');
            assertEquals(3, filtered.size());
            assertEquals("apple", filtered.get(0));
            for (int i = 0; i < filtered.size() - 1; i++) {
                assertTrue(filtered.get(i).length() <= filtered.get(i + 1).length());
            }
        }

        @Test
        void testFilterAndSortStringsNullList() {
            assertThrows(IllegalArgumentException.class, () ->
                    StreamOperations2.filterAndSortStrings(null, 'a')
            );
        }
    }

    @Nested
    class ConvertToBinaryTests {
        @Test
        void testConvertToBinaryPositive() {
            List<String> binaryList = StreamOperations2.convertToBinary(numberList);
            List<String> expected = Arrays.asList("1", "10", "11", "100");
            assertEquals(expected, binaryList);
        }

        @Test
        void testConvertToBinaryNullList() {
            assertThrows(IllegalArgumentException.class, () ->
                    StreamOperations2.convertToBinary(null)
            );
        }
    }

    @Nested
    class FilterStringsByAlphabetTests {
        @Test
        void testFilterStringsByAlphabetPositive() {
            List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
            String allowedAlphabet = "abcdefghijklmnopqrstuvwxyz";
            List<String> filtered = StreamOperations2.filterStringsByAlphabet(words, allowedAlphabet);
            List<String> expected = Arrays.asList("fig", "date", "apple", "grape", "banana", "cherry");
            assertEquals(expected, filtered);
        }

        @Test
        void testFilterStringsByAlphabetWithNonMatching() {
            List<String> words = Arrays.asList("abc", "def", "a", "b", "cab", "dab");
            List<String> filtered = StreamOperations2.filterStringsByAlphabet(words, "abc");
            List<String> expected = Arrays.asList("a", "b", "abc", "cab");
            assertEquals(expected, filtered);
        }

        @Test
        void testFilterStringsByAlphabetNullList() {
            assertThrows(NullPointerException.class, () ->
                    StreamOperations2.filterStringsByAlphabet(null, "abcdefghijklmnopqrstuvwxyz")
            );
        }

        @Test
        void testFilterStringsByAlphabetNullAlphabet() {
            List<String> words = Arrays.asList("apple", "banana");
            assertThrows(NullPointerException.class, () ->
                    StreamOperations2.filterStringsByAlphabet(words, null)
            );
        }

        @Test
        void testFilterStringsByAlphabetEmptyAlphabet() {
            List<String> words = Arrays.asList("apple", "banana");
            List<String> filtered = StreamOperations2.filterStringsByAlphabet(words, "");
            assertTrue(filtered.isEmpty());
        }
    }
}
