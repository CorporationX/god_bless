package faang.school.godbless.secondSprint.StreamAPI2;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    public void testFindPairs() {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        Set<List<Integer>> result = Main.findPairs(nums, 6);
        List<Integer> expectedList1 = List.of(2, 4);
        List<Integer> expectedList2 = List.of(1, 5);

        assertTrue(result.contains(expectedList1));
        assertTrue(result.contains(expectedList2));
        assertEquals(2, result.size());
    }

    @Test
    public void testFindCapitals() {
        Map<String, String> capitals = Map.of("B", "1", "A", "2");

        List<String> result = Main.findCapitals(capitals);
        List<String> expected = List.of("2", "1");

        assertEquals(expected, result);
    }

    @Test
    public void testFilterStringByChar() {
        List<String> result = Main.filterStringByChar(List.of("kdsad", "shish", "kek"), (char) 107);
        List<String> expected = List.of("kek", "kdsad");

        assertEquals(expected, result);
    }

    @Test
    public void testFindFamiliarPeople() {
        Map<String, List<String>> friends = Map.of(
                "1", List.of("2", "3", "4", "5"),
                "2", List.of("1", "5"),
                "3", List.of("1"),
                "4", List.of("1"),
                "5", List.of("1", "2")
        );
        List<List<String>> result = Main.findFamiliarPeople(friends);

        assertEquals(5, result.size());
        assertTrue(result.contains(List.of("2", "3")) || result.contains(List.of("3", "2")));
        assertTrue(result.contains(List.of("2", "4")) || result.contains(List.of("4", "2")));
        assertTrue(result.contains(List.of("3", "4")) || result.contains(List.of("4", "3")));
        assertTrue(result.contains(List.of("3", "5")) || result.contains(List.of("5", "3")));
        assertTrue(result.contains(List.of("4", "5")) || result.contains(List.of("5", "4")));
    }

    @Test
    public void testFindAvgSalary() {
        List<Employee> employees = List.of(
                new Employee("1", 30, "Marketing"),
                new Employee("2", 10, "Marketing"),
                new Employee("3", 8, "Development"),
                new Employee("4", 12, "Development")
        );
        Map<String, Double> result = Main.findAvgSalary(employees);

        assertEquals(2, result.size());
        assertEquals(20, result.get("Marketing"));
        assertEquals(10, result.get("Development"));
    }

    @Test
    public void testFilterStringByAlphabet() {
        List<String> result = Main.filterStringByAlphabet(List.of("abbaab", "avb", "ab", "kek"),
                List.of('a', 'b'));
        List<String> expected = List.of("ab", "abbaab");

        assertEquals(expected, result);
    }

    @Test
    public void testConvertNumsToStrings() {
        List<String> result = Main.convertNumsToStrings(List.of(1, 6, 2));
        List<String> expected = List.of("1", "110", "10");

        assertEquals(expected, result);
    }

    @Test
    public void testFindPalindromeNums() {
        List<Integer> result = Main.findPalindromeNums(44, 56);
        List<Integer> expected = List.of(44, 55);

        assertEquals(expected, result);
    }
}