package faang.school.godbless.streams;

import org.junit.jupiter.api.Test;

import java.util.List;

import static faang.school.godbless.streams.StreamUtil.*;
import static org.junit.jupiter.api.Assertions.*;

class StreamUtilTest {

    final List<Integer> NUMBERS = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    final List<Integer> NUMBERS_EMPTY = List.of();

    final List<String> SENTENCES = List.of("Sentence a", "Sentence b", "Test");
    final List<String> SENTENCES_EMPTY = List.of();

    final Character LETTER = 'S';

    final String LETTER_ONE = "1";
    final String LETTER_T = "t";
    final String TEST = "Test";
    final String SENT = "Sent";

    final int ZERO = 0;
    final int TWO = 2;
    final int FOUR = 4;
    final int FIVE = 5;
    final int TEN = 10;
    final int THIRTY = 30;

    final double FIVE_POINT_FIVE = 5.5;

    @Test
    void testGetSumOddNumbersCorrect() {
        assertEquals(THIRTY, getSumOddNumbers(NUMBERS));
    }

    @Test
    void testGetSumOddNumbersError() {
        assertThrows(IllegalArgumentException.class, () -> getSumOddNumbers(NUMBERS_EMPTY));
    }

    @Test
    void testGetMaxInListNumbers() {
        assertEquals(TEN, getMaxInListNumbers(NUMBERS));
    }

    @Test
    void testGetAverageSumInListNumbers() {
        assertEquals(FIVE_POINT_FIVE, getAverageSumInListNumbers(NUMBERS));
    }

    @Test
    void testFindHowManySentencesStartsWithLetterNotEmptyList() {
        assertEquals(TWO, findHowManySentencesStartsWithLetter(SENTENCES, LETTER));
    }

    @Test
    void testFindHowManySentencesStartsWithLetterEmptyList() {
        assertEquals(TWO, findHowManySentencesStartsWithLetter(SENTENCES_EMPTY, LETTER));
    }

    @Test
    void testFilterListSentencesContainsSubstring() {
        assertEquals(TWO, filterListSentencesContainsSubstring(SENTENCES, SENT).size());
    }

    @Test
    void testSortListSentencesByLength() {
        assertEquals(TEST, sortListSentencesByLength(SENTENCES).get(ZERO));
    }

    @Test
    void testCheckIfAllElementsSatisfyConditionTrue() {
        assertTrue(checkIfAllElementsSatisfyCondition(SENTENCES, (s) -> s.contains(LETTER_T)));
    }

    @Test
    void testCheckIfAllElementsSatisfyConditionFalse() {
        assertFalse(checkIfAllElementsSatisfyCondition(SENTENCES, s -> s.contains(LETTER_ONE)));
    }

    @Test
    void testFindMinNumberInListByFilterWithoutError() {
        assertEquals(FIVE, findMinNumberInListByFilter(NUMBERS, n -> n >= FIVE));
    }

    @Test
    void testFindMinNumberInListByFilterWithError() {
        assertThrows(RuntimeException.class, () -> findMinNumberInListByFilter(NUMBERS, n -> n > THIRTY));
    }

    @Test
    void testCastListStringToListIntegersByTheirLength() {
        assertEquals(List.of(TEN, TEN, FOUR), castListStringToListIntegersByTheirLength(SENTENCES));
    }
}