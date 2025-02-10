package listoperations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ListOperationsTest {

    private List<Integer> numbers;
    private List<String> strings;

    @BeforeEach
    void setUp() {
        numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        strings = Arrays.asList("apple", "banana", "cherry", "date", "an", null, "");
    }

    @Nested
    class SumOfEvenNumbersTests {
        @Test
        void testSumOfEvenNumbersPositive() {
            int sum = ListOperations.sumOfEvenNumbers(numbers);
            assertEquals(12, sum);
        }

        @Test
        void testSumOfEvenNumbersEmpty() {
            int sum = ListOperations.sumOfEvenNumbers(Collections.emptyList());
            assertEquals(0, sum);
        }

        @Test
        void testSumOfEvenNumbersNull() {
            assertThrows(IllegalArgumentException.class, () ->
                    ListOperations.sumOfEvenNumbers(null)
            );
        }
    }

    @Nested
    class FindMaxTests {
        @Test
        void testFindMaxPositive() {
            int max = ListOperations.findMax(numbers);
            assertEquals(6, max);
        }

        @Test
        void testFindMaxSingleElement() {
            int max = ListOperations.findMax(Collections.singletonList(42));
            assertEquals(42, max);
        }

        @Test
        void testFindMaxEmpty() {
            List<Integer> emptyList = Collections.emptyList();
            assertThrows(IllegalArgumentException.class, () ->
                    ListOperations.findMax(emptyList)
            );
        }

        @Test
        void testFindMaxNull() {
            assertThrows(IllegalArgumentException.class, () ->
                    ListOperations.findMax(null)
            );
        }
    }

    @Nested
    class FindAverageTests {
        @Test
        void testFindAveragePositive() {
            double avg = ListOperations.findAverage(numbers);
            assertEquals(3.5, avg, 0.0001);
        }

        @Test
        void testFindAverageSingleElement() {
            double avg = ListOperations.findAverage(Collections.singletonList(10));
            assertEquals(10.0, avg, 0.0001);
        }

        @Test
        void testFindAverageEmpty() {
            List<Integer> emptyList = Collections.emptyList();
            assertThrows(IllegalArgumentException.class, () ->
                    ListOperations.findAverage(emptyList)
            );
        }

        @Test
        void testFindAverageNull() {
            assertThrows(IllegalArgumentException.class, () ->
                    ListOperations.findAverage(null)
            );
        }
    }

    @Nested
    class CountStringsStartingWithTests {
        @Test
        void testCountStringsStartingWithPositive() {
            long count = ListOperations.countStringsStartingWith(strings, 'a');
            assertEquals(2, count);
        }

        @Test
        void testCountStringsStartingWithNoMatch() {
            long count = ListOperations.countStringsStartingWith(strings, 'z');
            assertEquals(0, count);
        }

        @Test
        void testCountStringsStartingWithNullList() {
            assertThrows(IllegalArgumentException.class, () ->
                    ListOperations.countStringsStartingWith(null, 'a')
            );
        }
    }

    @Nested
    class FilterStringsContainingSubstringTests {
        @Test
        void testFilterStringsContainingSubstringPositive() {
            List<String> filtered = ListOperations.filterStringsContainingSubstring(strings, "an");
            assertEquals(2, filtered.size());
            assertTrue(filtered.contains("banana"));
            assertTrue(filtered.contains("an"));
        }

        @Test
        void testFilterStringsContainingSubstringNoMatch() {
            List<String> filtered = ListOperations.filterStringsContainingSubstring(strings, "xyz");
            assertTrue(filtered.isEmpty());
        }

        @Test
        void testFilterStringsContainingSubstringNullList() {
            assertThrows(IllegalArgumentException.class, () ->
                    ListOperations.filterStringsContainingSubstring(null, "an")
            );
        }

        @Test
        void testFilterStringsContainingSubstringNullSubstring() {
            assertThrows(IllegalArgumentException.class, () ->
                    ListOperations.filterStringsContainingSubstring(strings, null)
            );
        }
    }

    @Nested
    class SortByLengthTests {
        @Test
        void testSortByLengthPositive() {
            List<String> nonNullStrings = Arrays.asList("apple", "banana", "cherry", "date", "an");
            List<String> sorted = ListOperations.sortByLength(nonNullStrings);
            assertEquals("an", sorted.get(0));
            assertEquals("date", sorted.get(1));
            for (int i = 0; i < sorted.size() - 1; i++) {
                assertTrue(sorted.get(i).length() <= sorted.get(i + 1).length());
            }
        }

        @Test
        void testSortByLengthNullList() {
            assertThrows(IllegalArgumentException.class, () ->
                    ListOperations.sortByLength(null)
            );
        }
    }

    @Nested
    class AllMatchConditionTests {
        @Test
        void testAllMatchConditionPositive() {
            boolean result = ListOperations.allMatchCondition(numbers, n -> n > 0);
            assertTrue(result);
        }

        @Test
        void testAllMatchConditionNegative() {
            boolean result = ListOperations.allMatchCondition(numbers, n -> n % 2 == 0);
            assertFalse(result);
        }

        @Test
        void testAllMatchConditionNullList() {
            assertThrows(IllegalArgumentException.class, () ->
                    ListOperations.allMatchCondition(null, n -> n > 0)
            );
        }

        @Test
        void testAllMatchConditionNullPredicate() {
            assertThrows(IllegalArgumentException.class, () ->
                    ListOperations.allMatchCondition(numbers, null)
            );
        }
    }

    @Nested
    class FindMinGreaterThanTests {
        @Test
        void testFindMinGreaterThanPositive() {
            int result = ListOperations.findMinGreaterThan(numbers, 4);
            assertEquals(5, result);
        }

        @Test
        void testFindMinGreaterThanBoundary() {
            assertThrows(IllegalArgumentException.class, () ->
                    ListOperations.findMinGreaterThan(numbers, 6)
            );
        }

        @Test
        void testFindMinGreaterThanNoSuchElement() {
            assertThrows(IllegalArgumentException.class, () ->
                    ListOperations.findMinGreaterThan(numbers, 100)
            );
        }

        @Test
        void testFindMinGreaterThanNullList() {
            assertThrows(IllegalArgumentException.class, () ->
                    ListOperations.findMinGreaterThan(null, 4)
            );
        }
    }

    @Nested
    class ConvertToLengthsTests {
        @Test
        void testConvertToLengthsPositive() {
            List<Integer> lengths = ListOperations.convertToLengths(strings);
            List<Integer> expected = Arrays.asList(5, 6, 6, 4, 2, 0, 0);
            assertEquals(expected, lengths);
        }

        @Test
        void testConvertToLengthsNullList() {
            assertThrows(IllegalArgumentException.class, () ->
                    ListOperations.convertToLengths(null)
            );
        }
    }
}
