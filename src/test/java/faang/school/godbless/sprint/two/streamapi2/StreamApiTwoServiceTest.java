package faang.school.godbless.sprint.two.streamapi2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StreamApiTwoServiceTest {
    private List<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7));
    }

    @Test
    void testFindPairsInListEqualInputNumber_hasPairs() {
        int target = 7;
        List<List<Integer>> expected = List.of(List.of(1, 6), List.of(2, 5), List.of(3, 4));
        assertEquals(expected, StreamApiTwoService.findPairsInListEqualInputNumber(this.numbers, target));
    }

    @Test
    void testFindPairsInListEqualInputNumber_noPairs() {
        int target = 100;
        assertTrue(StreamApiTwoService.findPairsInListEqualInputNumber(this.numbers, target).isEmpty());
    }

    @Test
    void testFindCapitalsSortedByCountries() {
        Map<String, String> countryCapitals = new HashMap<>();
        countryCapitals.put("United States", "Washington, D.C.");
        countryCapitals.put("Canada", "Ottawa");
        countryCapitals.put("Australia", "Canberra");
        List<String> expected = List.of("Canberra", "Ottawa", "Washington, D.C.");
        assertEquals(expected, StreamApiTwoService.findCapitalsSortedByCountries(countryCapitals));
    }

    @Test
    void testGetFilteredByLetterAndSortedByLengthStrings() {
        List<String> strings = new ArrayList<>(List.of("Lorem ipsum dolor sit amet", "consectetur adipiscing elit vestibulum", "cVivamus lacinia odio vitae"));
        List<String> expected = List.of("cVivamus lacinia odio vitae", "consectetur adipiscing elit vestibulum");
        assertEquals(expected, StreamApiTwoService.getFilteredByLetterAndSortedByLengthStrings(strings, 'c'));
    }

    @Test
    void testFindPeopleWhoHasCommonFriends() {
        Map<String, List<String>> friends = new HashMap<>();
        friends.put("John", List.of("Michael", "Jessica", "David"));
        friends.put("Michael", List.of("John", "Jessica"));
        friends.put("Sarah", List.of("Jessica", "David"));
        friends.put("Jessica", List.of("John", "Michael", "Sarah"));
        friends.put("David", List.of("Sarah", "John"));

        List<List<String>> expected = List.of(
                List.of("Michael", "Sarah"),
                List.of("John", "Sarah"),
                List.of("David", "Michael"),
                List.of("David", "Jessica")
        );

        assertEquals(expected, StreamApiTwoService.findPeopleWhoHasCommonFriends(friends));
    }

    @Test
    void testGetAverageSalaryForDepartments() {
        List<Employee> employees = List.of(
                new Employee("Alice", 75000, "HR"),
                new Employee("Bob", 50000, "IT"),
                new Employee("Charlie", 80000, "IT"),
                new Employee("David", 60000, "Finance"),
                new Employee("Eva", 65000, "HR")
        );

        Map<String, Double> expected = new HashMap<>();
        expected.put("HR", 70000.0);
        expected.put("IT", 65000.0);
        expected.put("Finance", 60000.0);

        assertEquals(expected, StreamApiTwoService.getAverageSalaryForDepartments(employees));
    }

    @Test
    void testFilterByInputStringOfLettersAndSortWords() {
        List<String> strings = new ArrayList<>(List.of("apple", "banana", "123", "dog", "cat"));
        String letters = "abcdefghijklmnopqrstuvwxyz";

        List<String> expected = new ArrayList<>(List.of("dog", "cat", "apple", "banana"));
        assertEquals(expected, StreamApiTwoService.filterByInputStringOfLettersAndSortWords(strings, letters));
    }
    @Test
    void testConvertNumbersToBinary() {
        List<Integer> numbers = new ArrayList<>(List.of(2, 10, 5, 4, 6));
        List<String> expected = List.of("10", "1010", "101", "100", "110");
        assertEquals(expected, StreamApiTwoService.convertNumbersToBinary(numbers));
    }

    @Test
    void testFindPalindromeInRange() {
        List<Integer> expected = List.of(101, 111, 121);
        assertEquals(expected, StreamApiTwoService.findPalindromeInRange(100,130));
    }
}
