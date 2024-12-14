package school.faang.task_46968;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ListOperationsTest {
    private List<Integer> integerListWithNull;
    private List<String> stringListWithNull;
    private List<String> stringEmptyList;
    private List<Integer> integerEmptyList;

    @BeforeEach
    void setUp() {
        integerListWithNull = new ArrayList<>();
        integerListWithNull.add(null);

        stringListWithNull = new ArrayList<>();
        stringListWithNull.add(null);

        stringEmptyList = List.of();
        integerEmptyList = List.of();
    }

    @Test
    void testSumOfEvenNumbers() {
        assertEquals(32, ListOperations.sumOfEvenNumbers(List.of(1, 2, 3, 4, 5, 6, 13, 17, 20)));
        assertEquals(0, ListOperations.sumOfEvenNumbers(integerEmptyList));
        assertEquals(0, ListOperations.sumOfEvenNumbers(List.of(0, 0, 0)));
        assertEquals(0, ListOperations.sumOfEvenNumbers(List.of(1)));
        assertEquals(2, ListOperations.sumOfEvenNumbers(List.of(2)));
        assertEquals(0, ListOperations.sumOfEvenNumbers(List.of(3, 13, 21, 27)));
        assertEquals(60, ListOperations.sumOfEvenNumbers(List.of(2, -2, 0, 60)));
        assertEquals(-4, ListOperations.sumOfEvenNumbers(List.of(-4, -2, 0, 2)));
        assertEquals(0, ListOperations.sumOfEvenNumbers(integerListWithNull));

        assertThrows(IllegalArgumentException.class, () -> ListOperations.sumOfEvenNumbers(null));
    }

    @Test
    void testFindMax() {
        assertEquals(20, ListOperations.findMax(List.of(1, 2, 3, 4, 5, 6, 13, 17, 20)));
        assertEquals(0, ListOperations.findMax(List.of(0, 0, 0)));
        assertEquals(-1, ListOperations.findMax(List.of(-1)));
        assertEquals(1, ListOperations.findMax(List.of(1)));
        assertEquals(1, ListOperations.findMax(List.of(1, 1, 1, 1)));
        assertEquals(100, ListOperations.findMax(List.of(2, 100, 0, 60)));
        assertEquals(-1, ListOperations.findMax(List.of(-4, -2, -1, -100)));

        assertThrows(NoSuchElementException.class, () -> ListOperations.findMax(integerEmptyList));
        assertThrows(NoSuchElementException.class, () -> ListOperations.findMax(integerListWithNull));
        assertThrows(IllegalArgumentException.class, () -> ListOperations.findMax(null));
    }

    @Test
    void testFindAverage() {
        assertEquals(20, ListOperations.findAverage(List.of(20, 20, 20, 20)));
        assertEquals(0, ListOperations.findAverage(List.of(0, 0, 0)));
        assertEquals(-1, ListOperations.findAverage(List.of(-1)));
        assertEquals(1, ListOperations.findAverage(List.of(1)));
        assertEquals(3, ListOperations.findAverage(List.of(1, 2, 3, 4, 5)));
        assertEquals(-26.75, ListOperations.findAverage(List.of(-4, -2, -1, -100)));
        assertEquals(0, ListOperations.findAverage(integerEmptyList));
        assertEquals(0, ListOperations.findAverage(integerListWithNull));

        assertThrows(IllegalArgumentException.class, () -> ListOperations.findAverage(null));
    }

    @Test
    void testCountStringsStartingWith() {
        assertEquals(3, ListOperations.countStringsStartingWith(List.of("str1", "str2", "str3"), 's'));
        assertEquals(0, ListOperations.countStringsStartingWith(List.of("str1", "str2", "str3"), 't'));
        assertEquals(0, ListOperations.countStringsStartingWith(List.of("str1"), 't'));
        assertEquals(0, ListOperations.countStringsStartingWith(List.of("", "", ""), 't'));
        assertEquals(0, ListOperations.countStringsStartingWith(List.of(""), 't'));
        assertEquals(0, ListOperations.countStringsStartingWith(stringEmptyList, 's'));
        assertEquals(0, ListOperations.countStringsStartingWith(stringListWithNull, 's'));

        assertThrows(IllegalArgumentException.class, () -> ListOperations.countStringsStartingWith(null, 'a'));
    }

    @Test
    void testFilterStringsContainingSubstring() {
        assertEquals(List.of("str1", "str2", "str3"),
                ListOperations.filterStringsContainingSubstring(List.of("str1", "str2", "str3"), "s"));
        assertEquals(List.of("str1", "str2", "str3"),
                ListOperations.filterStringsContainingSubstring(List.of("str1", "str2", "str3"), ""));
        assertEquals(List.of("str1"),
                ListOperations.filterStringsContainingSubstring(List.of("str1", "str2", "str3"), "r1"));
        assertEquals(List.of("str1"),
                ListOperations.filterStringsContainingSubstring(List.of("str1"), "tr"));
        assertEquals(List.of("", "", ""),
                ListOperations.filterStringsContainingSubstring(List.of("", "", ""), ""));
        assertEquals(stringEmptyList,
                ListOperations.filterStringsContainingSubstring(List.of(""), "tr"));
        assertEquals(stringEmptyList,
                ListOperations.filterStringsContainingSubstring(stringListWithNull, "tr"));

        assertThrows(IllegalArgumentException.class,
                () -> ListOperations.filterStringsContainingSubstring(null, "tr"));
    }

    @Test
    void testSortByLength() {
        assertEquals(List.of("str123", "str1234", "str12345"),
                ListOperations.sortByLength(List.of("str123", "str1234", "str12345")));
        assertEquals(List.of("str123", "str12345", "str123456789"),
                ListOperations.sortByLength(List.of("str12345", "str123456789", "str123")));
        assertEquals(List.of("str1", "str2", "str3"),
                ListOperations.sortByLength(List.of("str1", "str2", "str3")));
        assertEquals(List.of("str1"),
                ListOperations.sortByLength(List.of("str1")));
        assertEquals(List.of("", "", "str123"),
                ListOperations.sortByLength(List.of("", "str123", "")));
        assertEquals(List.of(""),
                ListOperations.sortByLength(List.of("")));
        assertEquals(stringEmptyList,
                ListOperations.sortByLength(stringListWithNull));

        assertThrows(IllegalArgumentException.class, () -> ListOperations.sortByLength(null));
    }

    @Test
    void testAllMatchCondition() {
        assertTrue(ListOperations.allMatchCondition(List.of(20, 20, 20, 20), n -> n % 2 == 0));
        assertTrue(ListOperations.allMatchCondition(List.of(0, 0, 0), n -> n % 2 == 0));
        assertFalse(ListOperations.allMatchCondition(List.of(-1), n -> n % 2 == 0));
        assertFalse(ListOperations.allMatchCondition(List.of(1), n -> n % 2 == 0));
        assertFalse(ListOperations.allMatchCondition(List.of(1, 2, 3, 4, 5), n -> n % 2 == 0));
        assertTrue(ListOperations.allMatchCondition(List.of(-4, -2, -100), n -> n % 2 == 0));
        assertTrue(ListOperations.allMatchCondition(integerEmptyList, n -> n % 2 == 0));
        assertTrue(ListOperations.allMatchCondition(integerListWithNull, n -> n % 2 == 0));

        assertThrows(IllegalArgumentException.class,
                () -> ListOperations.allMatchCondition(null, n -> n % 2 == 0));
    }

    @Test
    void findMinGreaterThan() {
        assertEquals(-2, ListOperations.findMinGreaterThan(List.of(-1, -2, -3, 4, 5), -3));
        assertEquals(3, ListOperations.findMinGreaterThan(List.of(1, 2, 3, 4, 5), 2));
        assertEquals(3, ListOperations.findMinGreaterThan(List.of(3, 2), 2));

        assertThrows(NoSuchElementException.class,
                () -> ListOperations.findMinGreaterThan(List.of(-1), 0));
        assertThrows(NoSuchElementException.class,
                () -> ListOperations.findMinGreaterThan(List.of(-1), -1));
        assertThrows(NoSuchElementException.class,
                () -> ListOperations.findMinGreaterThan(List.of(20, 20, 20, 20), 20));
        assertThrows(NoSuchElementException.class,
                () -> ListOperations.findMinGreaterThan(List.of(-4, -2, -1, -100), -1));
        assertThrows(IllegalArgumentException.class,
                () -> ListOperations.findMinGreaterThan(integerEmptyList, 5));
        assertThrows(NoSuchElementException.class,
                () -> ListOperations.findMinGreaterThan(integerListWithNull, 5));
        assertThrows(IllegalArgumentException.class,
                () -> ListOperations.findMinGreaterThan(null, 5));
    }

    @Test
    void testConvertToLengths() {
        assertEquals(List.of(8, 12, 6),
                ListOperations.convertToLengths(List.of("str12345", "str123456789", "str123")));
        assertEquals(List.of(4, 4, 4),
                ListOperations.convertToLengths(List.of("str1", "str2", "str3")));
        assertEquals(List.of(4),
                ListOperations.convertToLengths(List.of("str1")));
        assertEquals(List.of(0, 6, 0),
                ListOperations.convertToLengths(List.of("", "str123", "")));
        assertEquals(List.of(0),
                ListOperations.convertToLengths(List.of("")));
        assertEquals(integerEmptyList,
                ListOperations.convertToLengths(stringListWithNull));

        assertThrows(IllegalArgumentException.class, () -> ListOperations.convertToLengths(null));
    }
}