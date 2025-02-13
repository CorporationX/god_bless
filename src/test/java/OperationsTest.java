import org.junit.jupiter.api.Test;
import school.faang.Employee;
import school.faang.Operations;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OperationsTest {
    @Test
    void testGetMutualFriends_basicCase() {
        Map<String, List<String>> friendsMap = new HashMap<>();
        friendsMap.put("Alice", List.of("Bob", "Charlie"));
        friendsMap.put("Bob", List.of("Alice", "David"));
        friendsMap.put("Charlie", List.of("Alice", "David"));
        friendsMap.put("David", List.of("Bob", "Charlie"));
        assertEquals(List.of(List.of("Bob", "Charlie"), List.of("Alice", "David")),
                Operations.getMutualFriends(friendsMap));
    }

    @Test
    void testGetMutualFriends_inconsistentFriendsList() {
        Map<String, List<String>> friendships = new HashMap<>();
        friendships.put("Alice", List.of("Bob", "Charlie"));
        friendships.put("Bob", List.of("Alice", "David"));
        friendships.put("Charlie", List.of("Alice", "David", "Bob"));
        friendships.put("David", List.of("Bob", "Charlie"));
        assertEquals(List.of(List.of("Alice", "David")),
                Operations.getMutualFriends(friendships));
    }

    @Test
    void testGetMutualFriends_noMutualFriends() {
        Map<String, List<String>> friendships = new HashMap<>();
        friendships.put("Alice", List.of("Bob"));
        friendships.put("Bob", List.of("Alice"));
        friendships.put("Charlie", List.of("David"));
        friendships.put("David", List.of("Charlie"));
        assertEquals(Collections.emptyList(),
                Operations.getMutualFriends(friendships));
    }

    @Test
    void testGetMutualFriends_noFriendsForOnePerson() {
        Map<String, List<String>> friendships = new HashMap<>();
        friendships.put("Alice", List.of("Bob"));
        friendships.put("Bob", List.of("Alice"));
        friendships.put("Charlie", List.of("David"));
        friendships.put("David", Collections.emptyList());
        assertEquals(Collections.emptyList(),
                Operations.getMutualFriends(friendships));
    }

    @Test
    void testGetMutualFriends_emptyFriendships() {
        assertEquals(Collections.emptyList(),
                Operations.getMutualFriends(Collections.emptyMap()));
    }

    @Test
    void testGetMutualFriends_nullFriendships() {
        assertThrows(IllegalArgumentException.class, () -> Operations.getMutualFriends(null));
    }

    @Test
    void testGetMeanSalaryForDepartment_basicCase() {
        List<Employee> employees = Arrays.asList(
                new Employee("John", 60000, "IT"),
                new Employee("Alice", 70000, "IT"),
                new Employee("Bob", 50000, "HR"),
                new Employee("David", 55000, "HR")
        );
        Map<String, Double> meanSalary = Operations.getMeanSalaryForDepartment(employees);
        assertEquals(65000.0, meanSalary.get("IT"));
        assertEquals(52500.0, meanSalary.get("HR"));
    }

    @Test
    void testGetMeanSalaryForDepartment_emptyList() {
        assertTrue(Operations.getMeanSalaryForDepartment(Collections.emptyList()).isEmpty());
    }

    @Test
    void testGetMeanSalaryForDepartment_nullList() {
        assertThrows(IllegalArgumentException.class, () -> Operations.getMeanSalaryForDepartment(null));
    }

    @Test
    void testFindPalindromeNumbers_withSingleDigitRange() {
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertEquals(expected, Operations.findPalindromeNumbers(1, 9));
    }

    @Test
    void testFindPalindromeNumbers_withMultiDigitRange() {
        List<Integer> expected = List.of(11, 22, 33, 44, 55, 66, 77, 88, 99);
        assertEquals(expected, Operations.findPalindromeNumbers(10, 100));
    }

    @Test
    void testFindPalindromeNumbers_withNoPalindromes() {
        assertEquals(Collections.emptyList(), Operations.findPalindromeNumbers(123, 130));
    }

    @Test
    void testFindPalindromeNumbers_withNegativeNumbers() {
        assertEquals(Collections.emptyList(), Operations.findPalindromeNumbers(-50, -1));
    }

    @Test
    void testFindPalindromeNumbers_withZeroRange() {
        assertEquals(List.of(0), Operations.findPalindromeNumbers(0, 0));
    }

    @Test
    void testFindPalindromeSubstrings_emptyString() {
        assertTrue(Operations.findPalindromeSubstrings("").isEmpty());
    }

    @Test
    public void testFindPalindromeSubstrings_singleCharacterString() {
        assertEquals(List.of("a"), Operations.findPalindromeSubstrings("a"));
    }

    @Test
    public void testFindPalindromeSubstrings_withNoPalindrome() {
        assertEquals(List.of("a", "b", "c"), Operations.findPalindromeSubstrings("abc"));
    }

    @Test
    public void testFindPalindromeSubstrings_basicCase() {
        List<String> expected = List.of("a", "b", "c", "cc", "bccb", "abccba");
        assertEquals(expected.stream().sorted().toList(), Operations.findPalindromeSubstrings("abccba"));
    }

    @Test
    public void testGetPerfectNumbers_basicCase() {
        assertEquals(List.of(6, 28, 496, 8128), Operations.getPerfectNumbers(1, 10000));
    }

    @Test
    public void testGetPerfectNumbers_noPerfectNumbersInRange() {
        assertTrue(Operations.getPerfectNumbers(29, 495).isEmpty());
    }

    @Test
    public void testGetPerfectNumbers_onlyOnePerfectNumber() {
        assertEquals(1, Operations.getPerfectNumbers(6, 6).size());
    }

    @Test
    public void testGetPerfectNumbers_withNegativeValues() {
        assertEquals(List.of(6, 28, 496), Operations.getPerfectNumbers(-100, 500));
    }
}
