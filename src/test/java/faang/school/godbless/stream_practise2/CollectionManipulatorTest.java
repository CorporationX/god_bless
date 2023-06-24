package faang.school.godbless.stream_practise2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CollectionManipulatorTest {


    @Test
    void testFindUniqueNumberPairsWithSum() {
        List<String> actualOutput = CollectionManipulator.findUniqueNumberPairsWithSum(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 10);
        List<String> expectedOutput = List.of("1 + 9", "2 + 8", "3 + 7", "4 + 6", "6 + 4", "7 + 3", "8 + 2", "9 + 1");

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testSortAlphabeticallyCountriesNames() {
        Map<String, String> countries = new HashMap<>();
        countries.put("America", "Washington");
        countries.put("Britain", "London");
        countries.put("Italy", "Rome");
        countries.put("Canada", "Ottawa");

        List<String> actualOutput = CollectionManipulator.sortAlphabeticallyCountriesNames(countries);
        List<String> expectedOutput = List.of("Washington", "London", "Ottawa", "Rome");

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testFilterAndSortStringsByStartingLetter() {
    }

    @Test
    void testFindNonFriendPairsWithCommonFriends() {
    }

    @Test
    void testGetAverageSalaryForDepartment() {
    }

    @Test
    void testFilterAndSortStrings() {
    }

    @Test
    void testConvertToBinaryList() {
    }

    @Test
    void testFindPalindromeNumbers() {
    }
}
