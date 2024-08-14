package faang.school.godbless.secondsprint.exercisingstream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @Test
    @DisplayName("Should find unique pairs that sum to targetSum")
    void testFindUniquePairs() {
        List<Integer> numbers = Arrays.asList(1, 9, 3, 6, 4, 5);
        Set<List<Integer>> expectedPairs = new HashSet<>(Arrays.asList(
                Arrays.asList(1, 9),
                Arrays.asList(4, 6)
        ));
        Set<List<Integer>> actualPairs = Utils.findUniquePairs(numbers, 10);
        assertEquals(expectedPairs, actualPairs, "The unique pairs with sum 10 should be [1, 9] and [4, 6]");
    }

    @Test
    @DisplayName("Should get capitals sorted by country")
    void testGetCapitalsSortedByCountry() {
        Map<String, String> countryCapitalMap = new HashMap<>();
        countryCapitalMap.put("Germany", "Berlin");
        countryCapitalMap.put("Australia", "Canberra");
        countryCapitalMap.put("Canada", "Ottawa");
        countryCapitalMap.put("Brazil", "Brasilia");
        countryCapitalMap.put("Japan", "Tokyo");

        List<String> expectedCapitals = Arrays.asList("Canberra", "Brasilia", "Ottawa", "Berlin", "Tokyo");
        List<String> actualCapitals = Utils.getCapitalsSortedByCountry(countryCapitalMap);
        assertEquals(expectedCapitals, actualCapitals, "Capitals should be sorted by country name");
    }

    @Test
    @DisplayName("Should filter and sort strings by starting letter")
    void testFilterAndSortStrings() {
        List<String> strings = Arrays.asList("apple", "apricot", "banana", "avocado", "blueberry", "blackberry", "cherry", "aperture");
        char startingLetter = 'b';
        List<String> expectedStrings = Arrays.asList("banana", "blueberry", "blackberry");
        List<String> actualStrings = Utils.filterAndSortStrings(strings, startingLetter);
        assertEquals(expectedStrings, actualStrings, "Strings should be filtered by starting letter and sorted by length");
    }

    @Test
    @DisplayName("Should find non-friends with common friends")
    void testFindNonFriendsWithCommonFriends() {
        Map<String, List<String>> friendsMap = new HashMap<>();
        friendsMap.put("Alice", Arrays.asList("Bob", "Charlie"));
        friendsMap.put("Bob", Arrays.asList("Alice", "David"));
        friendsMap.put("Charlie", Arrays.asList("Alice"));
        friendsMap.put("David", Arrays.asList("Bob"));

        Set<List<String>> expectedNonFriendsWithCommonFriends = new HashSet<>(Arrays.asList(
                Arrays.asList("Bob", "Charlie"),
                Arrays.asList("Alice", "David")
        ));
        Set<List<String>> actualNonFriendsWithCommonFriends = Utils.findNonFriendsWithCommonFriends(friendsMap);
        assertEquals(expectedNonFriendsWithCommonFriends, actualNonFriendsWithCommonFriends, "Should find non-friends with common friends");
    }

    @Test
    @DisplayName("Should calculate average salary by department")
    void testAverageSalaryByDepartment() {
        List<Utils.Employee> employees = Arrays.asList(
                new Utils.Employee("Alice", "Engineering", 81234.4),
                new Utils.Employee("Bob", "Engineering", 98765.4),
                new Utils.Employee("Charlie", "Sales", 67865.4),
                new Utils.Employee("David", "Sales", 65343.4),
                new Utils.Employee("Eve", "HR", 59876.3),
                new Utils.Employee("Frank", "HR", 55453.2)
        );

        Map<String, Double> expectedAverages = new HashMap<>();
        expectedAverages.put("Engineering", 89999.9);
        expectedAverages.put("Sales", 66604.4);
        expectedAverages.put("HR", 57664.75);

        Map<String, Double> actualAverages = Utils.averageSalaryByDepartment(employees);
        assertEquals(expectedAverages, actualAverages, "Average salaries by department should be correctly calculated");
    }

    @Test
    @DisplayName("Should filter and sort strings by allowed characters")
    void testFilterAndSortByAlphabet() {
        List<String> strings = Arrays.asList("apple", "banana", "123", "dog", "cat", "собака");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        List<String> expectedFilteredAndSorted = Arrays.asList("cat", "dog", "apple", "banana");
        List<String> actualFilteredAndSorted = Utils.filterAndSortByAlphabet(strings, alphabet);
        assertEquals(expectedFilteredAndSorted, actualFilteredAndSorted, "Strings should be filtered by allowed characters and sorted by length");
    }

    @Test
    @DisplayName("Should convert integers to binary strings")
    void testConvertToBinaryStrings() {
        List<Integer> numbers = Arrays.asList(2, 5, 8);
        List<String> expectedBinaryStrings = Arrays.asList("10", "101", "1000");
        List<String> actualBinaryStrings = Utils.convertToBinaryStrings(numbers);
        assertEquals(expectedBinaryStrings, actualBinaryStrings, "Integers should be correctly converted to binary strings");
    }

    @Test
    @DisplayName("Should find palindromes within a range")
    void testFindPalindromes() {
        List<Integer> expectedPalindromes = Arrays.asList(101, 111, 121, 131, 141, 151, 161, 171, 181, 191);
        List<Integer> actualPalindromes = Utils.findPalindromes(100, 200);
        assertEquals(expectedPalindromes, actualPalindromes, "Palindromes between 100 and 200 should be correctly identified");
    }

    @Test
    @DisplayName("Should find palindromic substrings in a string")
    void testFindPalindromicSubstrings() {
        String input = "Sometimes racecarracecar set in...";
        List<String> expectedPalindromicSubstrings = Arrays.asList("esracecarracecarse", "sracecarracecars", "racecar",
                "racecarracecar", "aceca", "acecarraceca", "cec", "cecarracec", "ecarrace", "carrac", "arra", "rr");
        List<String> actualPalindromicSubstrings = Utils.findPalindromicSubstrings(input);
        assertEquals(expectedPalindromicSubstrings, actualPalindromicSubstrings, "Palindromic substrings should be correctly identified");
    }

    @Test
    @DisplayName("Should find perfect numbers within a range")
    void testFindPerfectNumbers() {
        List<Integer> expectedPerfectNumbers = Arrays.asList(6, 28, 496, 8128);
        List<Integer> actualPerfectNumbers = Utils.findPerfectNumbers(1, 10000);
        assertEquals(expectedPerfectNumbers, actualPerfectNumbers, "Perfect numbers between 1 and 10000 should be correctly identified");
    }
}
