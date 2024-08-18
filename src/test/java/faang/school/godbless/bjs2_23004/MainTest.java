package faang.school.godbless.bjs2_23004;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {
    // 1
    @Test
    void testSumEvenNumbers() {
        var result1 = Main.sumEvenNumbers1(1, 3, 5);
        assertEquals(0, result1);
        var result2 = Main.sumEvenNumbers1(1, 3, 2, 5, 4);
        assertEquals(6, result2);

        var result3 = Main.sumEvenNumbers2(new int[]{1, 3, 5});
        assertEquals(0, result3);
        var result4 = Main.sumEvenNumbers2(new int[]{1, 3, 2, 5, 4});
        assertEquals(6, result4);

        var result5 = Main.sumEvenNumbers3(List.of(1, 3, 5));
        assertEquals(0, result5);
        var result6 = Main.sumEvenNumbers3(List.of(1, 3, 2, 5, 4));
        assertEquals(6, result6);
    }

    // 2
    @Test
    void testMaxElement() {
        var result1 = Main.maxElement(new int[]{});
        assertEquals(0, result1);
        var result2 = Main.maxElement(new int[]{0, 1, 3, 2});
        assertEquals(3, result2);

        var result3 = Main.maxElement(List.of());
        assertEquals(0, result3);
        var result4 = Main.maxElement(List.of(1, 3, 5, 2, 4));
        assertEquals(5, result4);
    }

    // 3
    @Test
    void testAverage() {
        var result1 = Main.average(new int[]{});
        assertEquals(0, result1);
        var result2 = Main.average(new int[]{1, 2, 3});
        assertEquals(2, result2);

        var result3 = Main.average(List.of());
        assertEquals(0, result3);
        var result4 = Main.average(List.of(1, 2, 3));
        assertEquals(2, result4);
    }

    // 4
    @Test
    void testCountStrings() {
        var result1 = Main.countStrings(new String[]{}, "a");
        assertEquals(0, result1);
        var result2 = Main.countStrings(new String[]{"abc", "bac", " a", "a", ""}, "a");
        assertEquals(2, result2);

        var result3 = Main.countStrings(List.of(), "a");
        assertEquals(0, result3);
        var result4 = Main.countStrings(List.of("abc", "bac", " a", "a", ""), "a");
        assertEquals(2, result4);
    }

    // 5
    @Test
    void testContainsSubstring() {
        var result1 = Main.containsSubstring(new String[]{}, "a");
        assertEquals(0, result1);
        var result2 = Main.containsSubstring(new String[]{"abc", "bac", " a", "a", ""}, "a");
        assertEquals(4, result2);

        var result3 = Main.containsSubstring(List.of(), "a");
        assertEquals(0, result3);
        var result4 = Main.containsSubstring(List.of("abc", "bac", " a", "a", ""), "a");
        assertEquals(4, result4);
    }

    // 6
    @Test
    void testSortByLength() {
        var result1 = Main.sortByLength(new String[]{"a", "bac", "bc"});
        assertEquals("a", result1.get(0));
        assertEquals("bc", result1.get(1));
        assertEquals("bac", result1.get(2));

        var result2 = Main.sortByLength(List.of("a", "bac", "bc"));
        assertEquals("a", result2.get(0));
        assertEquals("bc", result2.get(1));
        assertEquals("bac", result2.get(2));
    }

    // 7
    @Test
    void testMatchAll() {
        var result1 = Main.matchAll(List.of("a", "bac", "bc"), "a");
        assertFalse(result1);

        var result2 = Main.matchAll(List.of("a", "bac", "bca"), "a");
        assertTrue(result2);
    }

    // 7
    @Test
    void testFindMin() {
        var result1 = Main.findMin(List.of(1, 5, 3), 5);
        assertEquals(0, result1);

        var result2 = Main.findMin(List.of(1, 5, 3), 2);
        assertEquals(3, result2);
    }

    // 7
    @Test
    void testConvert() {
        var result = Main.convert(List.of("a", "bac", "bc"));
        assertEquals(1, result.get(0));
        assertEquals(3, result.get(1));
        assertEquals(2, result.get(2));
    }
}