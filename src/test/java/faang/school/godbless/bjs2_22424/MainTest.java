package faang.school.godbless.bjs2_22424;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {
    // 1
    @Test
    void testGetPairs() {
        var result = Main.getPairs(List.of(1, 9, 9, 3, 6, 4, 5, 1), 10);
        assertEquals(1, result.get(0).getLeft());
        assertEquals(9, result.get(0).getRight());

        assertEquals(6, result.get(1).getLeft());
        assertEquals(4, result.get(1).getRight());
    }

    // 2
    @Test
    void testGetCapitals() {
        var result = Main.getCapitals(Map.of(
                "England", "London",
                "Belarus", "Minsk",
                "Russia", "Moscow"));
        assertEquals("Minsk", result.get(0));
        assertEquals("London", result.get(1));
        assertEquals("Moscow", result.get(2));
    }

    // 3
    @Test
    void testGetStrings() {
        var result = Main.getStrings(List.of("abc", "a", " a", "ba", "aaaa"), 'a');
        assertEquals("a", result.get(0));
        assertEquals("abc", result.get(1));
        assertEquals("aaaa", result.get(2));
    }

    // 4
    @Test
    void testGetFriends() {
        Map<String, List<String>> friends1 = new HashMap<>();
        friends1.put("John", List.of("Alex"));
        friends1.put("Ivan", List.of("Alex"));
        friends1.put("Alex", List.of("John", "Ivan"));

        var result1 = Main.getFriends(friends1);
        assertEquals(1, result1.size());
        assertEquals("Ivan", result1.get(0).getLeft());
        assertEquals("John", result1.get(0).getRight());

        Map<String, List<String>> friends2 = new HashMap<>();
        friends1.put("John", List.of("Alex"));
        friends1.put("Ivan", List.of("Incognito"));
        friends1.put("Alex", List.of("John"));
        friends1.put("Incognito", List.of("Ivan"));

        var result2 = Main.getFriends(friends2);
        assertEquals(0, result2.size());
    }

    // 5
    @Test
    void testGetAverageSalary() {
        var employees = List.of(
                new Employee("1", 10, "java"),
                new Employee("2", 20, "java"),
                new Employee("2", 10, "python"),
                new Employee("2", 0, "python"),
                new Employee("2", 25, "go")
        );
        var result = Main.getAverageSalary(employees);
        assertEquals(15D, result.get("java"));
        assertEquals(5D, result.get("python"));
        assertEquals(25D, result.get("go"));
    }

    @Test
    void testGetAverageSalarySecondApproach() {
        var employees = List.of(
                new Employee("1", 10, "java"),
                new Employee("2", 20, "java"),
                new Employee("2", 10, "python"),
                new Employee("2", 0, "python"),
                new Employee("2", 25, "go")
        );
        var result = Main.getAverageSalarySecondApproach(employees);
        assertEquals(15D, result.get("java"));
        assertEquals(5D, result.get("python"));
        assertEquals(25D, result.get("go"));
    }

    // 6
    @Test
    void testGetStringsAlphabet() {
        var alphabet = new char[]{'a', 'b', 'c'};
        var strings = List.of("abc", "", " ", "a", " a", "ä", "aaaa", "a1", "ad");
        var result = Main.getStringsAlphabet(strings, alphabet);
        assertEquals(3, result.size());
        assertEquals("a", result.get(0));
        assertEquals("abc", result.get(1));
        assertEquals("aaaa", result.get(2));
    }

    // 7
    @Test
    void testIntToString() {
        var numbers = List.of(1, 2, 5);
        var result = Main.intToString(numbers);
        assertEquals("1", result.get(0));
        assertEquals("10", result.get(1));
        assertEquals("101", result.get(2));
    }

    // 8
    @Test
    void testGetPalindromes() {
        var result = Main.getPalindromes(99, 121);
        assertEquals(4, result.size());
        assertEquals(99, result.get(0));
        assertEquals(101, result.get(1));
        assertEquals(111, result.get(2));
        assertEquals(121, result.get(3));
    }

    // 9
    @Test
    void testGetPalindromesFromString() {
        var result = Main.getPalindromesFromString("ehellol");
        assertEquals("ehe", result.get(0));
        assertEquals("ll", result.get(1));
        assertEquals("lol", result.get(2));
    }

    // 10
    @Test
    void testGetPerfectNumbers() {
        var result = Main.getPerfectNumbers(6, 496);
        assertEquals(6, result.get(0));
        assertEquals(28, result.get(1));
        assertEquals(496, result.get(2));
    }
}