package faang.school.godbless.sprint.two.streamapi1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StreamApiServiceTest {
    private List<Integer> numbers = new ArrayList<>();
    private List<Integer> zeroNumbers = new ArrayList<>();
    private List<String> strings = new ArrayList<>();
    private final int SUM_EVEN_NUMBERS = 6;
    private final int SUM_ODD_NUMBERS = 0;
    private final int MAX_NUMBER = 23;
    private final int ZERO_INT_NUMBER = 0;
    private final double ZERO_DOUBLE_NUMBER = 0.0;
    private final double AVERAGE_NUMBER = 8.0;
    private final char SEARCHING_SYMBOL = 'i';
    private final String SEARCHING_SUBSTRING = "test substring";
    private final List<String> SEARCH_SUBSTRING_RESULT = new ArrayList<>(List.of(
            "poorly designed and test substring is search_val writing is a lot of error messages to standard",
            "it returns test substring a XML response"
    ));

    private final List<String> SORTED_LIST_BY_LENGTH = new ArrayList<>(List.of(
            "it returns test substring a XML response",
            "i need to write JUnit tests for an old application that's",
            "output. When the getResponse(String request) method behaves correctly",
            "poorly designed and test substring is search_val writing is a lot of error messages to standard"
    ));


    @BeforeEach
    void setUp() {
        numbers = List.of(this.MAX_NUMBER, 2, 3, 4);
        zeroNumbers = List.of(this.ZERO_INT_NUMBER, this.ZERO_INT_NUMBER, this.ZERO_INT_NUMBER);
        strings = List.of(
                "i need to write JUnit tests for an old application that's",
                "poorly designed and test substring is search_val writing is a lot of error messages to standard",
                "output. When the getResponse(String request) method behaves correctly",
                "it returns test substring a XML response"
        );
    }

    @Test
    void testGetSumOfEvenNumbersInList_processListOfOddAndEvenNumbers() {
        assertEquals(this.SUM_EVEN_NUMBERS, StreamApiService.getSumOfEvenNumbersInList(this.numbers));
    }

    @Test
    void testGetSumOfEvenNumbersInList_processListOfOddNumbers() {
        assertEquals(this.SUM_ODD_NUMBERS, StreamApiService.getSumOfEvenNumbersInList(List.of(1, 3, 5, 7, 9)));
    }

    @Test
    void testGetSumOfEvenNumbersInList_processEmptyList() {
        assertEquals(this.SUM_ODD_NUMBERS, StreamApiService.getSumOfEvenNumbersInList(List.of()));
    }

    @Test
    void testFindMaxElementInList_checkNormalListOfDifferentNumbers() {
        assertEquals(this.MAX_NUMBER, StreamApiService.findMaxElementInList(this.numbers));
    }

    @Test
    void testFindMaxElementInList_checkListOfZeros() {
        assertEquals(this.ZERO_INT_NUMBER, StreamApiService.findMaxElementInList(this.zeroNumbers));
    }

    @Test
    void testFindMaxElementInList_checkEmptyListException() {
        NoSuchElementException ex = assertThrows(NoSuchElementException.class, () -> {
            StreamApiService.findMaxElementInList(List.of());
        });
        assertEquals(Constants.EMPTY_LIST_EXCEPTION, ex.getMessage());
    }

    @Test
    void testFindAverageNumberInList_checkNormalListOfDifferentNumbers() {
        assertEquals(this.AVERAGE_NUMBER, StreamApiService.findAverageNumberInList(numbers));
    }

    @Test
    void testFindAverageNumberInList_checkListOfZeros() {
        assertEquals(this.ZERO_DOUBLE_NUMBER, StreamApiService.findAverageNumberInList(this.zeroNumbers));
    }

    @Test
    void testFindAverageNumberInList_checkEmptyList() {
        assertEquals(this.ZERO_DOUBLE_NUMBER, StreamApiService.findAverageNumberInList(List.of()));
    }

    @Test
    void testFindLinesAmountFromStringsStartsWith_checkNormalArrayOfStringsTwoElements() {
        assertEquals(2, StreamApiService.findLinesAmountFromStringsStartsWith(strings, this.SEARCHING_SYMBOL));
    }

    @Test
    void testFindLinesAmountFromStringsStartsWith_checkNormalArrayOfStringsZeroElements() {
        assertEquals(this.ZERO_INT_NUMBER, StreamApiService.findLinesAmountFromStringsStartsWith(strings, '*'));
    }

    @Test
    void testFindLinesAmountFromStringsStartsWith_emptyArray() {
        assertEquals(this.ZERO_INT_NUMBER, StreamApiService.findLinesAmountFromStringsStartsWith(new ArrayList<>(List.of()), '*'));
    }

    @Test
    void testFindSubstringsInList_normalListContainsTwoSubStrings() {
        assertEquals(this.SEARCH_SUBSTRING_RESULT, StreamApiService.findSubstringsInList(strings, this.SEARCHING_SUBSTRING));
    }

    @Test
    void testFindSubstringsInList_normalListNotContainsTwoSubStrings() {
        assertEquals(new ArrayList<>(List.of()), StreamApiService.findSubstringsInList(strings, "xxxxxxx"));
    }

    @Test
    void testSortListOfStringsByLength_normalList() {
        assertEquals(this.SORTED_LIST_BY_LENGTH, StreamApiService.sortListOfStringsByLength(strings));
    }

    @Test
    void testCheckIfElementsGreaterThan_allNumbersGreater() {
        assertTrue(StreamApiService.checkIfElementsGreaterThan(numbers, 1));
    }

    @Test
    void testCheckIfElementsGreaterThan_notAllNumbersGreater() {
        assertFalse(StreamApiService.checkIfElementsGreaterThan(numbers, 5));
    }

    @Test
    void testFindMinElementGreaterThan_correctList() {
        assertEquals(4, StreamApiService.findMinElementGreaterThan(numbers, 3));
    }

    @Test
    void testFindMinElementGreaterThan_numberThatHigherThanAllInList() {
        assertEquals(this.ZERO_INT_NUMBER, StreamApiService.findMinElementGreaterThan(numbers, 100));
    }

    @Test
    void testFindMinElementGreaterThan_emptyList() {
        assertEquals(this.ZERO_INT_NUMBER, StreamApiService.findMinElementGreaterThan(new ArrayList<>(List.of()), 100));
    }

    @Test
    void testConvertStringsToTheirLength() {
        assertEquals(new ArrayList<>(List.of(57, 95, 69, 40)), StreamApiService.convertStringsToTheirLength(strings));
    }
}
