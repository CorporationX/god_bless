package faang.school.godbless.StreamApi2;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StreamApiTest {


    @Test
    void testGetCapitals() {
        Map<String, String> countries = new HashMap<>();
        countries.put("Russia", "Moscow");
        countries.put("USA", "Washington");
        countries.put("Great Britain", "London");
        List<String> capitals = List.of("London", "Moscow", "Washington");

        assertEquals(capitals, StreamApi.getCapitals(countries));
    }

    @Test
    void testGetStringsFilteredByCharAndSorted() {
        List<String> capitals = List.of("London", "Moscow", "Washington", "Londonlondon");
        assertEquals(List.of("London", "Londonlondon"), StreamApi.getStringsFilteredByCharAndSorted(capitals, 'L'));
    }

    @Test
    void testGetFriendsOfFriends() {
        Map<String, List<String>> friends = new HashMap<>();
        friends.put("Vlad", List.of("Oleg", "Andrey", "Alex"));
        friends.put("Oleg", List.of("Vlad", "Igor", "Alex"));
        friends.put("Igor", List.of("Oleg", "Andrey", "Alex"));

        assertEquals(Map.of("Vlad", "Igor"), StreamApi.getFriendsOfFriends(friends));

    }


    @Test
    void testGetPairsOfSum() {
        int[] integers = {1, 2, 3, 4, 5};
        assertEquals(Map.of(4, 5, 5, 4), StreamApi.getPairsOfSum(integers, 9));
    }

    @Test
    void testGetAverageSalary() {
        List<Employee> employees = List.of(new Employee("Ann", 300, "IT"),
                new Employee("Ann", 600, "IT"),
                new Employee("Ann", 300, "Manager"));

        assertEquals(Map.of("IT", 450.0, "Manager", 300.0), StreamApi.getAverageSalary(employees));
    }

    @Test
    void testAlphabetContains() {
        List<String> list = List.of("abc", "aak", "adASDSAFDGSDGFDG", "sfdf", "bca");

        assertEquals(List.of("abc", "bca"), StreamApi.alphabetContains(list, "abc"));
    }

    @Test
    void testConvertToBinary() {
        List<Integer> list = List.of(2, 5, 7);

        assertEquals(List.of("10", "101", "111"), StreamApi.convertToBinary(list));
    }

    @Test
    void testGetPalindromicNumbers() {

        assertEquals(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 22, 33, 44, 55, 66, 77, 88, 99),
                StreamApi.getPalindromicNumbers(0, 100));
    }
}