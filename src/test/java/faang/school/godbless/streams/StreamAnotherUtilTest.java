package faang.school.godbless.streams;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static faang.school.godbless.streams.StreamAnotherUtil.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StreamAnotherUtilTest {

    final Map<String, String> COUNTRIES_WITH_CAPITALS_EMPTY = new HashMap<>();
    final Map<String, String> COUNTRIES_WITH_CAPITALS = new HashMap<>(Map.of("Russia", "Moscow",
            "Germany", "Berlin",
            "Italy", "Rome"));
    final Map<String, List<String>> CONTACTS_OF_FRIENDS = new HashMap<>(Map.of(
            "a", List.of("b", "c"),
            "b", List.of("a", "d"),
            "c", List.of("a"),
            "d", List.of("b")
    ));

    final List<Integer> NUMBERS_EMPTY = List.of();
    final List<Integer> NUMBERS_TO_BINARY = List.of(1, 2, 5);
    final List<Integer> NUMBERS_TO_PALINDROME = List.of(11012, 123456, 15055);
    final List<Integer> NUMBERS = List.of(1, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9);

    final List<String> SENTENCES_EMPTY = List.of();
    final List<String> SENTENCES = List.of("Sentence test", "Sentence", "Test");
    final List<String> WORDS_FOR_ALPHABET_LIST = List.of("apple", "banana", "123", "dog", "cat");

    final List<Employee> EMPLOYEES = List.of(
            new Employee("a", 1000, "a"),
            new Employee("b", 2000, "a"),
            new Employee("c", 500, "c")
    );

    final ArrayList<Character> ALPHABET = new ArrayList<>(List.of(
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));

    final String LETTER_C = "c";
    final String SENTENCE = "Sentence";

    final Character CHARACTER_S = 'S';

    final int ZERO = 0;
    final int ONE = 1;
    final int TWO = 2;
    final int FOUR = 4;
    final int NINE = 9;
    final int TEN = 10;
    final int HUNDRED_ONE = 101;
    final int FIVE_HUNDRED_FIVE = 505;

    final double FIVE_HUNDRED = 500.0;

    @Test
    void findTargetNumberInListNumbersBySumElementsTest() {
        assertEquals(NINE, findTargetNumberInListNumbersBySumElements(NUMBERS, TEN).size());
    }

    @Test
    void findTargetNumberInListNumbersBySumElementsTestEmptyList() {
        assertThrows(IllegalArgumentException.class, () -> findTargetNumberInListNumbersBySumElements(NUMBERS_EMPTY, TEN));
    }

    @Test
    void getCapitalsAfterOrderTheirCountriesTest() {
        assertEquals(List.of("Berlin", "Rome", "Moscow"), getCapitalsAfterOrderTheirCountries(COUNTRIES_WITH_CAPITALS));
    }

    @Test
    void getCapitalsAfterOrderTheirCountriesTestEmpty() {
        assertEquals(List.of(), getCapitalsAfterOrderTheirCountries(COUNTRIES_WITH_CAPITALS_EMPTY));
    }

    @Test
    void orderSentencesByLengthWithFilterStartWithTest() {
        assertEquals(TWO, orderSentencesByLengthWithFilterStartWith(SENTENCES, CHARACTER_S).size());
        assertEquals(SENTENCE, orderSentencesByLengthWithFilterStartWith(SENTENCES, CHARACTER_S).get(ZERO));
    }

    @Test
    void orderSentencesByLengthWithFilterStartWithTestEmpty() {
        assertEquals(ZERO, orderSentencesByLengthWithFilterStartWith(SENTENCES_EMPTY, CHARACTER_S).size());
    }

    @Test
    void getAverageSalaryByDepartmentTest() {
        assertEquals(TWO, getAverageSalaryByDepartment(EMPLOYEES).size());
        assertEquals(FIVE_HUNDRED, getAverageSalaryByDepartment(EMPLOYEES).get(LETTER_C));
    }

    @Test
    void getWordsContainsOnlyAlphabetSymbolsTest() {
        assertEquals(FOUR, getWordsContainsOnlyAlphabetSymbols(WORDS_FOR_ALPHABET_LIST, ALPHABET).size());
    }

    @Test
    void convertIntegersToBinaryStringsTest() {
        assertEquals(List.of("1", "10", "101"), convertIntegersToBinaryStrings(NUMBERS_TO_BINARY));
    }

    @Test
    void getPalindromeNumbersByRangeTest() {
        assertEquals(TWO, getPalindromeNumbersByRange(NUMBERS_TO_PALINDROME, ONE, FOUR).size());
        assertEquals(HUNDRED_ONE, getPalindromeNumbersByRange(NUMBERS_TO_PALINDROME, ONE, FOUR).get(ZERO));
        assertEquals(FIVE_HUNDRED_FIVE, getPalindromeNumbersByRange(NUMBERS_TO_PALINDROME, ONE, FOUR).get(ONE));
    }

    @Test
    void getPeopleWhoIsNotFriendButIsFriendOfFriendTest() {
        assertEquals(FOUR, getPeopleWhoIsNotFriendButIsFriendOfFriend(CONTACTS_OF_FRIENDS).size());
    }
}