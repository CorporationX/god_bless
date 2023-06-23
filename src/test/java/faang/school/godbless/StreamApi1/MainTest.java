package faang.school.godbless.StreamApi1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    int[] array = {1, 2, 3, 4, 5, 6};
    List<String> strings = List.of("Word", "Random", "Building", "Spirit", "Wolf");
    List<Integer> integers = List.of(4, 6, 8, 6, 4);

    @Test
    void testGetSumOfHonestNumber() {
        assertEquals(12, Main.getSumOfHonestNumber(array));
    }

    @Test
    void getMaxNumber() {
        assertEquals(6, Main.getMaxNumber(array));
    }

    @Test
    void getMiddleNumber() {
        assertEquals(3.5, Main.getMiddleNumber(array));
    }

    @Test
    void getCountOfOneLetterStrings() {
        assertEquals(2, Main.getCountOfOneLetterStrings(strings, 'W'));
    }

    @Test
    void getStringsContainsSubstring() {
        assertEquals(List.of("Word", "Wolf"), Main.getStringsContainsSubstring(strings, "Wo"));
    }

    @Test
    void getSortedStringsByLength() {
        List<String> sortedStrings = List.of("Word", "Wolf", "Random", "Spirit", "Building");
        assertEquals(sortedStrings, Main.getSortedStringsByLength(strings));
    }

    @Test
    void isAllStringsSatisfyCondition() {
        assertTrue(Main.isAllStringsSatisfyCondition(strings, strings -> strings.length() > 2));
        assertFalse(Main.isAllStringsSatisfyCondition(strings, strings -> strings.length() > 5));
    }

    @Test
    void getSmallestElement() {
        assertEquals(4, Main.getSmallestElement(integers, 0));
        assertEquals(6, Main.getSmallestElement(integers, 5));
        assertEquals(4, Main.getSmallestElement(integers, -2342));
    }

    @Test
    void convertListStringsIntoListLength() {
        assertEquals(integers, Main.convertListStringsIntoListLength(strings));
    }
}