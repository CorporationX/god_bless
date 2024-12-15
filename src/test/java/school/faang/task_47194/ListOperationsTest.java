package school.faang.task_47194;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ListOperationsTest {
    private List<Integer> integerListWithNull;
    private List<String> stringListWithNull;
    private Set<Integer> emptySet;
    private List<String> stringEmptyList;
    private List<Integer> integerEmptyList;

    @BeforeEach
    void setUp() {
        integerListWithNull = new ArrayList<>();
        integerListWithNull.add(null);
        stringListWithNull = new ArrayList<>();
        stringListWithNull.add(null);

        emptySet = Set.of();
        stringEmptyList = List.of();
        integerEmptyList = List.of();
    }

    @Test
    void testFindUniquePairsOfNumbers() {
        assertEquals(Set.of(Set.of(1, 6), Set.of(2, 5), Set.of(3, 4)),
                ListOperations.findUniquePairsOfNumbers(List.of(1, 2, 3, 4, 5, 6), 7)
        );
        assertEquals(Set.of(Set.of(5, 2)),
                ListOperations.findUniquePairsOfNumbers(List.of(2, 4, 6, 5, 0, 36), 7)
        );
        assertEquals(emptySet,
                ListOperations.findUniquePairsOfNumbers(List.of(2, 4, 1, 2, 0, 36), 7));
        assertEquals(emptySet,
                ListOperations.findUniquePairsOfNumbers(List.of(2), 7));
        assertEquals(emptySet,
                ListOperations.findUniquePairsOfNumbers(List.of(), 7));
        assertEquals(emptySet,
                ListOperations.findUniquePairsOfNumbers(integerListWithNull, 7));

        assertThrows(IllegalArgumentException.class,
                () -> ListOperations.findUniquePairsOfNumbers(null, 7));
    }

    @Test
    void testGetCapitals() {
        assertEquals(
                List.of("Москва", "Вашингтон", "Токио"),
                ListOperations.getCapitals(
                        Map.of("Россия", "Москва",
                                "США", "Вашингтон",
                                "Япония", "Токио"))
        );
        assertEquals(
                List.of("Москва"),
                ListOperations.getCapitals(Map.of("Россия", "Москва"))
        );
        assertEquals(
                stringEmptyList,
                ListOperations.getCapitals(Map.of())
        );

        assertThrows(IllegalArgumentException.class,
                () -> ListOperations.getCapitals(null));
    }

    @Test
    void testFilterAndSortByLength() {
        assertEquals(List.of("str1", "str2", "str3"),
                ListOperations.filterAndSortByLength(List.of("str1", "str2", "str3"), 's'));
        assertEquals(stringEmptyList,
                ListOperations.filterAndSortByLength(List.of("str1"), 'f'));
        assertEquals(List.of("str1234", "str1234567", "str12345678"),
                ListOperations.filterAndSortByLength(List.of("str1234567", "str1234", "str12345678"), 's'));
        assertEquals(stringEmptyList,
                ListOperations.filterAndSortByLength(stringListWithNull, 'c'));
        assertEquals(stringEmptyList,
                ListOperations.filterAndSortByLength(stringEmptyList, 'c'));

        assertThrows(IllegalArgumentException.class,
                () -> ListOperations.filterAndSortByLength(null, 'c'));
    }

    @Test
    void testMapToBinaryCode() {
        assertEquals(List.of("10"),
                ListOperations.mapToBinaryCode(List.of(2)));
        assertEquals(List.of("1", "10", "11", "100"),
                ListOperations.mapToBinaryCode(List.of(1, 2, 3, 4)));
        assertEquals(stringEmptyList,
                ListOperations.mapToBinaryCode(integerEmptyList));
        assertEquals(stringEmptyList,
                ListOperations.mapToBinaryCode(integerListWithNull));

        assertThrows(IllegalArgumentException.class,
                () -> ListOperations.mapToBinaryCode(null));
    }

    @Test
    void testFilterByAlphabetAndSortByLength() {
        assertEquals(List.of("fig", "date", "apple", "grape", "banana", "cherry"),
                ListOperations.filterByAlphabetAndSortByLength(
                        List.of("apple", "banana", "cherry", "date", "fig", "grape"),
                        "abcdefghijklmnopqrstuvwxyz"
                )
        );
        assertEquals(List.of("fig", "date", "apple", "cherry"),
                ListOperations.filterByAlphabetAndSortByLength(
                        List.of("apple", "banana1", "cherry", "date", "fig", "grape1"),
                        "abcdefghijklmnopqrstuvwxyz"
                )
        );
        assertEquals(stringEmptyList,
                ListOperations.filterByAlphabetAndSortByLength(stringEmptyList, "abc"));
        assertEquals(stringEmptyList,
                ListOperations.filterByAlphabetAndSortByLength(stringListWithNull, "abc"));

        assertThrows(IllegalArgumentException.class,
                () -> ListOperations.filterByAlphabetAndSortByLength(null, "abc"));
        assertThrows(IllegalArgumentException.class,
                () -> ListOperations.filterByAlphabetAndSortByLength(List.of("apple", "banana"), ""));
    }
}