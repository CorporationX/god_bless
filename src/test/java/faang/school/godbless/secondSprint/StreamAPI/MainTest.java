package faang.school.godbless.secondSprint.StreamAPI;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    List<Integer> nums;
    List<String> strings;

    @BeforeEach
    void setUp() {
        nums = List.of(2, 6, 3, 5);
        strings = List.of("shish", "por favor", "kek");
    }

    @Test
    public void testFindSumEvenNumbers() {
        int result = Main.findSumEvenNumbers(nums);

        assertEquals(8, result);
    }

    @Test
    public void testFindMaxNum() {
        int result = Main.findMaxNum(nums);

        assertEquals(6, result);
    }

    @Test
    public void testFindAverage() {
        double result = Main.findAverage(nums);

        assertEquals(4, result);
    }

    @Test
    public void testFindStringsCount() {
        char symbol = 107;
        int result = Main.findStringsCount(strings, symbol);

        assertEquals(1, result);
    }

    @Test
    public void testFindCorrectStrings() {
        List<String> result = Main.findCorrectStrings(strings, "favor");

        assertEquals(List.of("por favor"), result);
    }

    @Test
    public void testSortListByStringLength() {
        List<String> result = Main.sortListByStringLength(strings);
        List<String> expected = List.of("por favor", "shish", "kek");

        assertEquals(expected, result);
    }

    @Test
    public void testCheckAllMatchWithStrings() {
        boolean result = Main.checkAllMatch(strings, string -> string.length() > 2);

        assertTrue(result);
    }

    @Test
    public void testCheckAllMatchWithInt() {
        boolean result = Main.checkAllMatch(nums, num -> num > 2);

        assertFalse(result);
    }

    @Test
    public void testFindCorrectNum() {
        int result = Main.findCorrectNum(nums, 4);

        assertEquals(5, result);
    }

    @Test
    public void testConvertStringToItsLength() {
        List<Integer> result = Main.convertStringToItsLength(strings);
        List<Integer> expected = List.of(5, 9, 3);

        assertEquals(expected, result);
    }
}