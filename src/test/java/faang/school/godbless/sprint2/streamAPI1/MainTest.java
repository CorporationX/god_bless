package faang.school.godbless.sprint2.streamAPI1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void sumOfEvenNumbers() {
        int expected = 20;
        List<Integer> numbers = List.of(1, 2, 3, 4, 6, 8);
        int result = Main.sumOfEvenNumbers(numbers);
        assertEquals(expected, result);
    }

    @Test
    void maxNumber() {
        int expected = 31;
        List<Integer> numbers = List.of(1, 2, 3, 31, 20, 18, 4, 6, 8);
        int result = Main.maxNumber(numbers);
        assertEquals(expected, result);
    }

    @Test
    void maxNumberWhenEmptyList() {
        List<Integer> numbers = new ArrayList<>();
        assertThrows(IllegalArgumentException.class, () -> Main.maxNumber(numbers));
    }

    @Test
    void average() {
        double expected = 4.0;
        List<Integer> numbers = List.of(1, 2, 3, 4, 6, 8);
        double result = Main.average(numbers);
        assertEquals(expected, result);
    }

    @Test
    void stringsStartWithA() {
        List<String> strings = List.of("abc", "apple", "body", "circle", "star");
        long result = Main.stringsStartWith(strings, 'a');
        long expected = 2L;
        assertEquals(expected, result);
    }

    @Test
    void stringsStartWithV() {
        List<String> strings = List.of("abc", "apple", "body", "circle", "star");
        long result = Main.stringsStartWith(strings, 'v');
        long expected = 0;
        assertEquals(expected, result);
    }

    @Test
    void containsSubstring() {
        List<String> strings = List.of("apple", "banana", "apricot", "grape");
        List<String> expected = List.of("apple", "apricot", "grape");
        List<String> result = Main.containsSubstring(strings, "ap");
        assertEquals(expected, result);
    }

    @Test
    void sortedByLength() {
        List<String> strings = List.of("abc", "apple", "body", "circle", "star");
        List<String> expected = List.of("abc", "body", "star", "apple", "circle");
        List<String> result = Main.sortedByLength(strings);
        assertEquals(expected, result);
    }

    @Test
    void allMatchByPredicateNotEvenNumbers() {
        List<Integer> numbers = List.of(1, 3, 5, 7, 9, 11, 25, 17);
        boolean result = Main.allMatchByPredicate(numbers, numb -> numb % 2 != 0);
        assertTrue(result);
    }

    @Test
    void allMatchByPredicateLengthMoreThan2() {
        List<String> strings = List.of("abc", "apple", "body", "circle", "star");
        assertTrue(Main.allMatchByPredicate(strings, string -> string.length() > 2));
    }

    @Test
    void allMatchByPredicateLengthMoreThan3() {
        List<String> strings = List.of("abc", "apple", "body", "circle", "star");
        assertFalse(Main.allMatchByPredicate(strings, string -> string.length() > 3));
    }

    @Test
    void minNumberThatLargerThanNumber() {
        List<Integer> numbers = List.of(1, 2, 3, 31, 20, 18, 4, 6, 8);
        int number = 18;
        int result = Main.minNumberThatLargerThanNumber(numbers, number);
        int expected = 20;
        assertEquals(expected, result);
    }

    @Test
    void minNumberThatLargerThanNumberWhenNumberIsBiggest() {
        List<Integer> numbers = List.of(1, 2, 3, 31, 20, 18, 4, 6, 8);
        int number = 32;
        int result = Main.minNumberThatLargerThanNumber(numbers, number);
        int expected = Integer.MAX_VALUE;
        assertEquals(expected, result);
    }

    @Test
    void stringLengths() {
        List<String> strings = List.of("abc", "apple", "body", "circle", "star");
        List<Integer> expected = List.of(3, 5, 4, 6, 4);
        List<Integer> result = Main.stringLengths(strings);
        assertEquals(expected, result);
    }
}