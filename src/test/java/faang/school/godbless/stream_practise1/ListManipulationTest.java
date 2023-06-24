package faang.school.godbless.stream_practise1;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListManipulationTest {

    @Test
    void testSumOfEvenNumbers() {
        int actualOutput = ListManipulation.sumOfEvenNumbers(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        int expectedOutput = 30;

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testGetMaxNumber() {
        int actualOutput = ListManipulation.getMaxNumber(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        int expectedOutput = 10;

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testGetAverageNumber() {
        double actualOutput = ListManipulation.getAverageNumber(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        double expectedOutput = 5.5;

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testGetQuantityOfStringsStartWith() {
        long actualOutput = ListManipulation.getQuantityOfStringsStartWith(List.of("Hello", "How are you", "Hell on earth", "Hobbit", "5", "6"), "H");
        long expectedOutput = 4;

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testFilterListBySubstring() {
        List<String> actualOutput = ListManipulation.filterListBySubstring(List.of("Hello", "How are you", "Hell on earth", "Hobbit", "5", "6"), "Hell");
        List<String> expectedOutput = List.of("Hello", "Hell on earth");

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testSortListByStringsLength() {
        List<String> actualOutput = ListManipulation.sortListByStringsLength(List.of("Hello", "How are you", "Hell on earth", "Hobbit", "5", "6"));
        List<String> expectedOutput = List.of("5", "6", "Hello", "Hobbit", "How are you", "Hell on earth");

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testIfAllElementsPassTheCondition() {
        Predicate<Integer> condition = n -> n > 0;
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        boolean actualOutput = ListManipulation.ifAllElementsPassTheCondition(numbers, condition);
        boolean expectedOutput = true;

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testFindSmallestNumberGreaterThan() {
        int actualOutput = ListManipulation.findSmallestNumberGreaterThan(5, List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        int expectedOutput = 6;

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testTransformStringsToItsLength() {
        List<Integer> actualOutput = ListManipulation.transformStringsToItsLength(List.of("Hello", "How are you", "Hell on earth", "Hobbit", "5", "6"));
        List<Integer> expectedOutput = List.of(5, 11, 13, 6, 1, 1);

        assertEquals(expectedOutput, actualOutput);
    }
}
