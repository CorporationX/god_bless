package school.faang.bjs2_80727;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static school.faang.bjs2_80727.Service.*;

class ServiceTest {
    private static final String SUBSTRING = "Клуб";
    private static final char FIRST_SYMBOL = 'K';
    private static final char THRESHOLD = 5;
    private final List<Integer> numbers = List.of(5, 55, 40, 30, 25);
    private final List<String> strings = List.of("Яблоко", "Клубника", "Котлета");

    @Test
    void shouldSumEvenNumbers() {
        int expected = numbers.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();

        int actual = sumEvenNumbers(numbers);

        assertEquals(expected, actual);
    }

    @Test
    void shouldFindMaxNumber() {
        int expected = numbers.get(0);
        for (Integer num : numbers) {
            if (num > expected) {
                expected = num;
            }
        }

        int actual = findMaxNumber(numbers);

        assertEquals(expected, actual);
    }

    @Test
    void shouldFindAvgNumber() {
        double sum = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
        double expected = sum / numbers.size();

        double actual = findAvgNumber(numbers);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCountStringStartWith() {
        long expected = strings.stream()
                .filter(string -> string.startsWith(Character.toString(FIRST_SYMBOL)))
                .count();

        long actual = countStringStartWith(strings, FIRST_SYMBOL);

        assertEquals(expected, actual);
    }

    @Test
    void shouldFilterBySubstring() {
        List<String> expected = strings.stream()
                .filter(string -> string.contains(SUBSTRING))
                .toList();

        List<String> actual = filterBySubstring(strings, SUBSTRING);

        assertEquals(expected, actual);
    }

    @Test
    void shouldSortByLength() {
        List<String> expectSortedString = strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();

        List<String> actualSortedString = sortByLength(strings);

        for (int i = 0; i < expectSortedString.size(); i++) {
            String expected = expectSortedString.get(i);
            String actual = actualSortedString.get(i);

            assertEquals(expected, actual);
        }
    }

    @Test
    void shouldCheckAllMatch() {
        int divider = 5;
        boolean actual = allMatch(numbers, (num) -> num % divider == 0);

        assertTrue(actual);
    }

    @Test
    void shouldCheckNotAllMatch() {
        int divider = 3;
        boolean actual = allMatch(numbers, (num) -> num % divider == 0);

        assertFalse(actual);
    }

    @Test
    void shouldFindMinAndGreaterThan() {
        List<Integer> filteredNumbers = numbers.stream().filter(num -> num > THRESHOLD).toList();
        int expected = filteredNumbers.get(0);
        for (Integer num : filteredNumbers) {
            if (num < expected) {
                expected = num;
            }
        }

        int actual = findMinAndGreaterThan(numbers, THRESHOLD);

        assertEquals(expected, actual);
    }

    @Test
    void shouldConvertStringToLength() {
        List<Integer> expected = strings.stream()
                .map(String::length)
                .toList();

        List<Integer> actual = stringToLength(strings);

        assertEquals(expected, actual);
    }
}