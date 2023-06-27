package faang.school.godbless.sprint3.stream_api2;

import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UtilsTest {

    @Test
    void getUniquePairs() {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Set<List<Integer>> expected = Set.of(
                List.of(1, 9),
                List.of(2, 8),
                List.of(3, 7),
                List.of(4, 6),
                List.of(5, 5)
        );

        assertEquals(expected, Utils.getUniquePairs(nums, 10));
    }

    @Test
    void getAlphabeticCapitalsList() {
        Map<String, String> capitalsMap = Map.of(
                "Nederland", "Amsterdam",
                "England", "London",
                "Russia", "Moscow",
                "Italy", "Rome"
        );
        List<String> expected = List.of("London", "Rome", "Amsterdam", "Moscow");

        assertEquals(expected, Utils.getAlphabeticCapitalsList(capitalsMap));
    }

    @Test
    void getStringsStartingWithSpecificCharSortedByLength() {
        List<String> stringList = List.of("java", "junior", "spring", "jar");
        List<String> expected = List.of("jar", "java", "junior");

        assertEquals(expected, Utils.getStringsStartingWithSpecificCharSortedByLength(stringList, 'j'));
    }

    @Test
    void getPeopleWithMutualFriends() {
        Map<String, List<String>> map = Map.of(
                "Ronaldo", List.of("Ramos", "Marcelo", "Benzema"),
                "Benzema", List.of("Ramos", "Vini", "Ronaldo"),
                "Messi", List.of("Ramos", "Neymar", "Suarez")
        );

        Set<List<String>> expected = Set.of(
                List.of("Benzema", "Messi"),
                List.of("Messi", "Ronaldo")
        );

        assertEquals(expected, Utils.getPeopleWithMutualFriends(map));
    }

    @Test
    void getAverageSalaryForDepartment() {
        List<Employee> employees = List.of(
                new Employee("Tom", 100, "Development"),
                new Employee("Mark", 50, "Development"),
                new Employee("Sam", 80, "Testing"),
                new Employee("Jim", 50, "Testing"),
                new Employee("Hank", 70, "Sales"),
                new Employee("Ben", 60, "Sales")
        );
        Map<String, Double> expected = Map.of(
                "Development", 75.0,
                "Testing", 65.0,
                "Sales", 65.0
        );

        assertEquals(expected, Utils.getAverageSalaryForDepartment(employees));
    }

    @Test
    void getBySpecificAlphabetSortedByLength() {
        List<String> stringList = List.of("java", "jar", "junior", "job");
        Set<Character> alphabet = Set.of('j', 'v', 'e', 'r', 'a', 'o');

        List<String> expected = List.of("jar", "java");
        assertEquals(expected, Utils.getBySpecificAlphabetSortedByLength(stringList, alphabet));
    }

    @Test
    void getListOfBinaryRepresentation() {
        List<Integer> nums = List.of(11, 12, 13);
        List<String> expected = List.of("1011", "1100", "1101");

        assertEquals(expected, Utils.getListOfBinaryRepresentation(nums));
    }

    @Test
    void getPalindromes() {
        List<Integer> expected = List.of(7, 8, 9, 11, 22, 33);

        assertEquals(expected, Utils.getPalindromes(7, 33));
    }
}