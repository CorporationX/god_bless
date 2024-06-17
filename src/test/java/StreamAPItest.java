import faang.school.godbless.BJS2_10459.StreamAPI;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class StreamAPItest {
    private final List<Integer> testNumberList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
    private final List<String> testStringList = List.of("Antony", "Andrew", "Oleg", "Margogot", "Sean", "Keith");

    @Test
    void evenSumTest() {
        int res = StreamAPI.evenSum(testNumberList);

        assertEquals(20, res);
    }

    @Test
    void maxTest() {
        int res = StreamAPI.max(testNumberList);

        assertEquals(9, res);
    }

    @Test
    void averageTest() {
        double res = StreamAPI.average(testNumberList);

        assertEquals(5d, res);
    }

    @Test
    void findStringCountTest() {
        long res = StreamAPI.findStringCount(testStringList, "a");

        assertEquals(2, res);
    }

    @Test
    void stringsWithSubstringTest() {
        List<String> strings = StreamAPI.stringsWithSubstring(testStringList, "e");

        assertEquals("Andrew", strings.get(0));
        assertEquals("Oleg", strings.get(1));
        assertEquals("Sean", strings.get(2));
        assertEquals("Keith", strings.get(3));
    }

    @Test
    void sortedByLengthTest() {
        List<String> strings = StreamAPI.sortedByLength(testStringList);

        assertEquals("Margogot", strings.get(strings.size() - 1));
    }

    @Test
    void isListRightTest() {
        boolean res = StreamAPI.isListRight(testNumberList, (num) -> num > 20);

        assertFalse(res);
    }

    @Test
    void findMinBiggerThanNumTest() {
        int res = StreamAPI.findMinBiggerThanNum(testNumberList,5);

        assertEquals(6, res);
    }

    @Test
    void stringsToLengthsTest() {
        List<Integer> nums = StreamAPI.stringsToLengths(testStringList);

        assertEquals(6, nums.get(0));
        assertEquals(6, nums.get(1));
        assertEquals(4, nums.get(2));
        assertEquals(8, nums.get(3));
        assertEquals(4, nums.get(4));
        assertEquals(5, nums.get(5));
    }
}
