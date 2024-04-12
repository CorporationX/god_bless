package faang.school.godbless.practice_stream_2;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void findUniquePairsEqualsK() {
        Set<List<Integer>> result = Main.findUniquePairsEqualsK(List.of(1, 9, 3, 6, 4, 5), 10);
        Set<List<Integer>> expectedResult = Set.of(List.of(9, 1), List.of(6, 4));
        assertEquals(result, expectedResult);
    }

    @Test
    void findCapitalsBySortedCountries() {
        List<String> result = Main.findCapitalsBySortedCountries(Map.of("Russia", "Moscow", "UK", "London"));
        List<String> expectedResult = List.of("Moscow", "London");
        assertEquals(result, expectedResult);
    }

    @Test
    void findStringsStartsWith() {
        List<String> result = Main.findStringsStartsWith(List.of("text", "monkey", "micro", "delete", "numbers", "mouse"), 'm');
        List<String> expectedResult = List.of("micro", "mouse", "monkey");
        assertEquals(result, expectedResult);
    }

    @Test
    void findPeopleByMutualFriends() {
        Set<List<String>> result = Main.findPeopleByMutualFriends(Map.of(
                "Dima", List.of("Masha", "Danya"),
                "Andrew", List.of("Masha"),
                "Danya", List.of("Masha"),
                "Masha", List.of("Dima")
        ));
        Set<List<String>> expectedResult = Set.of(List.of("Dima", "Andrew"), List.of("Danya", "Andrew"));
        assertEquals(result, expectedResult);
    }

    @Test
    void findAvgSalaryInDepartments() {
        Map<String, Double> result = Main.findAvgSalaryInDepartments(List.of(
                new Employee("Dima", 20.0, "IT"),
                new Employee("Lena", 20.0, "Managers"),
                new Employee("Andrew", 12.0, "IT")
        ));
        Map<String, Double> expectedResult = Map.of("Managers", 20.0, "IT", 16.0);
        assertEquals(result, expectedResult);
    }

    @Test
    void findStringsContainsOnlyThisAlphabet() {
        List<String> result = Main.findStringsContainsOnlyThisAlphabet(List.of("text", "monkey", "micro", "delete", "numbers", "mouse"), "txetmonkyicr");
        List<String> expectedResult = List.of("text", "micro", "monkey");
        assertEquals(result, expectedResult);
    }

    @Test
    void convertIntegerListToStringList() {
        List<String> result = Main.convertIntegerListToStringList(List.of(1, 2, 3, 4, 5, 6));
        List<String> expectedResult = List.of("1", "10", "11", "100", "101", "110");
        assertEquals(result, expectedResult);
    }

    @Test
    void findAllPalindromesInIntRange() {
        List<Integer> result = Main.findAllPalindromesInIntRange(1, 100);
        List<Integer> expectedResult = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 22, 33, 44, 55, 66, 77, 88, 99);
        assertEquals(result, expectedResult);
    }

    @Test
    void findAllPalindromesInString() {
        Set<String> result = Main.findAllPalindromesInString("toot");
        Set<String> expectedResult = Set.of("oo", "t", "toot", "o");
        assertEquals(result, expectedResult);
    }

    @Test
    void findPerfectNumbers() {
        List<Integer> result = Main.findPerfectNumbers(1, 100);
        List<Integer> expectedResult = List.of(6, 28);
        assertEquals(result, expectedResult);
    }
}