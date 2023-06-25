package faang.school.godbless.sprint3.streamAPI.task2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StreamAPITest {

    @Test
    void testSumEvenNumber() {
        int expected = 20;
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8);

        int actual = StreamAPI.sumEvenNumber(numbers);

        assertEquals(expected, actual);
    }

    @Test
    void testMaxNumber() {
        int expected = 8;
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8);

        int actual = StreamAPI.maxNumber(numbers).get();

        assertEquals(expected, actual);
    }

    @Test
    void testFindAverageValueNumbers() {
        double expected = 4.5;
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8);

        double actual = StreamAPI.findAverageValueNumbers(numbers);

        assertEquals(expected, actual);
    }

    @Test
    void testFindStringsStartWith() {
        List<String> expected = List.of("Work", "Win");
        List<String> strings = List.of("Work", "Win", "Perk", "winline");

        List<String> actual = StreamAPI.findStringsStartWith(strings);

        assertEquals(expected, actual);
    }

    @Test
    void testFindStringsContainsSubstring() {
        List<String> expected = List.of("Win", "winline", "df s in fsdl");
        List<String> strings = List.of("Work", "Win", "Perk", "winline", "df s in fsdl");

        List<String> actual = StreamAPI.findStringsContainsSubstring(strings);

        assertEquals(expected, actual);
    }

    @Test
    void testSortLength() {
        List<String> expected = List.of("df s in fsdl", "winline", "Work", "Perk", "Win");
        List<String> strings = List.of("Work", "Win", "Perk", "winline", "df s in fsdl");

        List<String> actual = StreamAPI.sortLength(strings);

        assertEquals(expected, actual);
    }

    @Test
    void testCheckCondition() {
        List<String> expected = List.of("winline", "df s in fsdl");
        List<String> strings = List.of("Work", "Win", "Perk", "winline", "df s in fsdl");

        List<String> actual = StreamAPI.checkCondition(strings);

        assertEquals(expected, actual);
    }

    @Test
    void testFindSmallestNumberThanSpecifiedNumber() {
        int expected = 8;
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8);

        int actual = StreamAPI.findSmallestNumberThanSpecifiedNumber(numbers, 7);

        assertEquals(expected, actual);
    }

    @Test
    void testConvertStringsToStringLength() {
        List<Integer> expected = List.of(4, 3, 4, 7, 12);
        List<String> strings = List.of("Work", "Win", "Perk", "winline", "df s in fsdl");

        List<Integer> actual = StreamAPI.convertStringsToStringLength(strings);

        assertEquals(expected, actual);
    }

    @Test
    void testValidation(){
        assertThrows(IllegalArgumentException.class, () -> StreamAPI.checkCondition(null));
        assertThrows(IllegalArgumentException.class, () -> StreamAPI.checkCondition(List.of()));
    }
}