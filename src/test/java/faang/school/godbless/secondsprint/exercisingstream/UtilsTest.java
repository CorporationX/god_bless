package faang.school.godbless.secondsprint.exercisingstream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UtilsTest {

    @Test
    @DisplayName("Should find unique pairs that sum to targetSum")
    public void testFindUniquePairs() {
        List<Integer> numbers = List.of(1, 9, 3, 6, 4, 5);
        Set<List<Integer>> expectedPairs = new HashSet<>(Arrays.asList(
                List.of(1, 9),
                List.of(4, 6)
        ));
        Set<List<Integer>> actualPairs = Utils.findUniquePairs(numbers, 10);
        assertEquals(expectedPairs, actualPairs, "The unique pairs with sum 10 should be [1, 9] and [4, 6]");
    }

    @Test
    @DisplayName("Should get capitals sorted by country")
    public void testGetCapitalsSortedByCountry() {
        Map<String, String> countriesAndCapitals = Map.of(
                "Germany", "Berlin",
                "Australia", "Canberra",
                "Canada", "Ottawa",
                "Brazil", "Brasilia",
                "Japan", "Tokyo"
        );

        List<String> expectedCapitals = List.of("Canberra", "Brasilia", "Ottawa", "Berlin", "Tokyo");
        List<String> actualCapitals = Utils.getCapitalsSortedByCountry(countriesAndCapitals);
        assertEquals(expectedCapitals, actualCapitals, "Capitals should be sorted by country name");
    }

    @Test
    @DisplayName("Should filter and sort strings by starting letter")
    public void testFilterAndSortStrings() {
        List<String> strings = List.of("apple", "apricot", "banana", "avocado", "blueberry", "blackberry",
                "cherry", "aperture");
        char startingLetter = 'b';
        List<String> expectedStrings = List.of("banana", "blueberry", "blackberry");
        List<String> actualStrings = Utils.filterAndSortStrings(strings, startingLetter);
        assertEquals(expectedStrings, actualStrings,
                "Strings should be filtered by starting letter and sorted by length");
    }

    @Test
    @DisplayName("Should find non-friends with common friends")
    public void testFindNonFriendsWithCommonFriends() {
        Map<String, List<String>> usersFriends = Map.of(
                "Alice", List.of("Bob", "Charlie"),
                "Bob", List.of("Alice", "David"),
                "Charlie", List.of("Alice", "Eve"),
                "David", List.of("Bob", "Frank")
        );

        Set<List<String>> expectedNonFriendsWithCommonFriends = new HashSet<>(Arrays.asList(
                List.of("Bob", "Charlie"),
                List.of("Alice", "David")
        ));
        Set<List<String>> actualNonFriendsWithCommonFriends = Utils.findNonFriendsWithCommonFriends(usersFriends);
        assertEquals(expectedNonFriendsWithCommonFriends, actualNonFriendsWithCommonFriends,
                "Should find non-friends with common friends");
    }

    @Test
    @DisplayName("Should calculate average salary by department")
    public void testAverageSalaryByDepartment() {
        List<Utils.Employee> employees = List.of(
                new Utils.Employee("Alice", "Engineering", 81234.4),
                new Utils.Employee("Bob", "Engineering", 98765.4),
                new Utils.Employee("Charlie", "Sales", 67865.4),
                new Utils.Employee("David", "Sales", 65343.4),
                new Utils.Employee("Eve", "HR", 59876.3),
                new Utils.Employee("Frank", "HR", 55453.2)
        );

        Map<String, Double> expectedAverages = Map.of(
                "Engineering", 89999.9,
                "Sales", 66604.4,
                "HR", 57664.75
        );

        Map<String, Double> actualAverages = Utils.averageSalaryByDepartment(employees);
        assertEquals(expectedAverages, actualAverages,
                "Average salaries by department should be correctly calculated");
    }

    @Test
    @DisplayName("Should filter and sort strings by allowed characters")
    public void testFilterAndSortByAlphabet() {
        List<String> strings = List.of("apple", "banana", "123", "dog", "cat", "собака");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        List<String> expectedFilteredAndSorted = List.of("cat", "dog", "apple", "banana");
        List<String> actualFilteredAndSorted = Utils.filterAndSortByAlphabet(strings, alphabet);
        assertEquals(expectedFilteredAndSorted, actualFilteredAndSorted,
                "Strings should be filtered by allowed characters and sorted by length");
    }

    @Test
    @DisplayName("Should convert integers to binary strings")
    public void testConvertToBinaryStrings() {
        List<Integer> numbers = List.of(2, 5, 8);
        List<String> expectedBinaryStrings = List.of("10", "101", "1000");
        List<String> actualBinaryStrings = Utils.convertToBinaryStrings(numbers);
        assertEquals(expectedBinaryStrings, actualBinaryStrings,
                "Integers should be correctly converted to binary strings");
    }

    @Test
    @DisplayName("Should find palindromes within a range")
    public void testFindPalindromes() {
        List<Integer> expectedPalindromes = List.of(101, 111, 121, 131, 141, 151, 161, 171, 181, 191);
        List<Integer> actualPalindromes = Utils.findPalindromes(100, 200);
        assertEquals(expectedPalindromes, actualPalindromes,
                "Palindromes between 100 and 200 should be correctly identified");
    }

    @Test
    @DisplayName("Should find palindromic substrings in a string")
    public void testFindPalindromicSubstrings() {
        String input = "Sometimes racecarracecar set in...";
        List<String> expectedPalindromicSubstrings = List.of("esracecarracecarse", "sracecarracecars", "racecar",
                "racecarracecar", "aceca", "acecarraceca", "cec", "cecarracec", "ecarrace", "carrac", "arra", "rr");
        List<String> actualPalindromicSubstrings = Utils.findPalindromicSubstrings(input);
        assertEquals(expectedPalindromicSubstrings, actualPalindromicSubstrings,
                "Palindromic substrings should be correctly identified");
    }

    @Test
    @DisplayName("Should find perfect numbers within a range")
    public void testFindPerfectNumbers() {
        List<Integer> expectedPerfectNumbers = List.of(6, 28, 496, 8128);
        List<Integer> actualPerfectNumbers = Utils.findPerfectNumbers(1, 10000);
        assertEquals(expectedPerfectNumbers, actualPerfectNumbers,
                "Perfect numbers between 1 and 10000 should be correctly identified");
    }
}
