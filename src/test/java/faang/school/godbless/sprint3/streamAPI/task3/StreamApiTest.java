package faang.school.godbless.sprint3.streamAPI.task3;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StreamApiTest {

    @Test
    void testFindUniquePairsNumbers() {
        List<Pair> expected = List.of(
                new Pair(-1, 8),
                new Pair(1, 6),
                new Pair(2, 5),
                new Pair(3, 4)
        );
        List<Integer> numbers = List.of(-1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Pair> actual = StreamApi.findUniquePairsNumbers(numbers, 7);

        assertEquals(expected, actual);
    }


    @Test
    void testGetCapitals() {
        Map<String, String> countries = Map.of(
                "Russia", "Moscow",
                "New Zealand", "Wellington",
                "Australia", "Canberra",
                "Japan", "Tokio"
        );
        List<String> expected = List.of("Canberra", "Tokio", "Wellington", "Moscow");

        List<String> actual = StreamApi.getCapitals(countries);

        assertEquals(expected, actual);
    }

    @Test
    void testFilterStrings() {
        List<String> strings = List.of("Canberra", "Manchester", "Tokio", "Wellington", "Moscow", "Milan", "Madrid");
        List<String> expected = List.of("Milan", "Moscow", "Madrid", "Manchester");

        List<String> actual = StreamApi.filterStrings(strings, 'M');

        assertEquals(expected, actual);
    }

    @Test
    void testGetPeopleHavingMutualFriends() {
        Map<String, List<String>> friends = Map.of(
                "Иван", List.of("Александр", "Артем", "Михаил"),
                "Максим", List.of("Мария", "Артем", "Лев"),
                "Мария", List.of("Лев", "Максим", "София"),
                "Петя", List.of("София", "Анна", "Мария")
        );
        Map<String, String> expected = Map.of(
                "Мария", "Петя",
                "Максим", "Иван",
                "Петя", "Максим"
        );

        Map<String, String> actual = StreamApi.getPeopleHavingMutualFriends(friends);

        assertEquals(expected, actual);
    }

    @Test
    void testGetAvgSalaryDepartment() {
        List<Employee> employees = List.of(
                new Employee("Александр", 5000, "IT"),
                new Employee("Михаил", 4000, "IT"),
                new Employee("Лев", 3000, "IT"),
                new Employee("Марк", 500, "IT"),
                new Employee("Артем", 2000, "HR"),
                new Employee("София", 2500, "HR"),
                new Employee("Мария", 1200, "HR")
        );
        Map<String, Double> expected = Map.of(
                "IT", 3125.0,
                "HR", 1900.0
        );

        Map<String, Double> actual = StreamApi.getAvgSalaryDepartment(employees);

        assertEquals(expected, actual);
    }

    @Test
    void testGetFilteredStringsContainsCharacterAlphabet() {
        List<String> strings = List.of("Canberra", "Manchester", "Tokio", "Wellington", "Moscow", "Milan", "Madrid", "Казань", "Lonдон");
        List<String> expected = List.of("Tokio", "Milan", "Moscow", "Madrid", "Canberra", "Manchester", "Wellington");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        List<String> actual = StreamApi.getFilteredStringsContainsCharacterAlphabet(strings, alphabet);

        assertEquals(expected, actual);
    }

    @Test
    void testChangeNumberToBinaryString() {
        List<Integer> strings = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> expected = List.of("1", "10", "11", "100", "101", "110", "111", "1000", "1001", "1010");

        List<String> actual = StreamApi.changeNumberToBinaryString(strings);

        assertEquals(expected, actual);
    }

    @Test
    void testFindNumbersPalindromeToDiapason() {
        List<Integer> expected = List.of(11, 22, 33, 44, 55);

        List<Integer> actual = StreamApi.findNumbersPalindromeToDiapason(10, 60);

        assertEquals(expected, actual);
    }

    @Test
    void testFindStringsPalindromeToDiapason() {
        String string = "tenet замок каша шалаш канак";
        List<String> expected = List.of("tenet", "шалаш", "канак");

        List<String> actual = StreamApi.findStringsPalindromeToDiapason(string);

        assertEquals(expected, actual);
    }

    @Test
    void testFindPerfectNumbers() {
        List<Integer> expected = List.of(6, 28, 496, 8128);

        List<Integer> actual = StreamApi.findPerfectNumbers(1, 10_000);

        assertEquals(expected, actual);
    }
}