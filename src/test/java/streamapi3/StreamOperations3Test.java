package streamapi3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


class StreamOperations3Test {

    private Map<String, List<String>> friendsMap;
    private List<Employee> employees;

    @BeforeEach
    void setUp() {
        friendsMap = Map.of(
                "Alice", List.of("Bob", "Charlie"),
                "Bob", List.of("Alice", "David"),
                "Charlie", List.of("Alice", "David"),
                "David", List.of("Bob", "Charlie")
        );
        employees = List.of(
                new Employee("John", 5000, "IT"),
                new Employee("Alice", 6000, "IT"),
                new Employee("Bob", 7000, "HR"),
                new Employee("Carol", 8000, "HR"),
                new Employee("Dave", 9000, "Sales")
        );
    }

    @Nested
    class FindPeopleWithCommonFriendsTests {
        @Test
        void testFindPeopleWithCommonFriendsPositive() {
            List<StreamOperations3.PeoplePair> pairs = StreamOperations3.findPeopleWithCommonFriends(friendsMap);
            Set<StreamOperations3.PeoplePair> expected = Set.of(
                    new StreamOperations3.PeoplePair("Alice", "David"),
                    new StreamOperations3.PeoplePair("Bob", "Charlie")
            );
            assertEquals(expected, new HashSet<>(pairs));
        }

        @Test
        void testFindPeopleWithCommonFriendsNoResult() {
            Map<String, List<String>> map = Map.of(
                    "Alice", List.of("Bob"),
                    "Bob", List.of("Alice")
            );
            List<StreamOperations3.PeoplePair> pairs = StreamOperations3.findPeopleWithCommonFriends(map);
            assertTrue(pairs.isEmpty());
        }

        @Test
        void testFindPeopleWithCommonFriendsNullMap() {
            assertThrows(IllegalArgumentException.class, () ->
                    StreamOperations3.findPeopleWithCommonFriends(null)
            );
        }
    }

    @Nested
    class AverageSalaryByDepartmentTests {
        @Test
        void testAverageSalaryByDepartmentPositive() {
            Map<String, Double> avgSalaries = StreamOperations3.averageSalaryByDepartment(employees);
            assertEquals(5500.0, avgSalaries.get("IT"), 0.001);
            assertEquals(7500.0, avgSalaries.get("HR"), 0.001);
            assertEquals(9000.0, avgSalaries.get("Sales"), 0.001);
        }

        @Test
        void testAverageSalaryByDepartmentNullList() {
            assertThrows(IllegalArgumentException.class, () ->
                    StreamOperations3.averageSalaryByDepartment(null)
            );
        }
    }

    @Nested
    class FindPalindromicNumbersTests {
        @Test
        void testFindPalindromicNumbersPositive() {
            List<Integer> palindromes = StreamOperations3.findPalindromicNumbers(100, 200);
            List<Integer> expected = List.of(101, 111, 121, 131, 141, 151, 161, 171, 181, 191);
            assertEquals(expected, palindromes);
        }
    }

    @Nested
    class FindPalindromicSubstringsTests {
        @Test
        void testFindPalindromicSubstringsPositive() {
            List<String> palSubstrings = StreamOperations3.findPalindromicSubstrings("abac");
            Set<String> expected = Set.of("a", "aba", "b", "c");
            assertEquals(expected, Set.copyOf(palSubstrings));
        }

        @Test
        void testFindPalindromicSubstringsEmptyInput() {
            List<String> result = StreamOperations3.findPalindromicSubstrings("");
            assertTrue(result.isEmpty());
        }

        @Test
        void testFindPalindromicSubstringsNullInput() {
            assertThrows(IllegalArgumentException.class, () ->
                    StreamOperations3.findPalindromicSubstrings(null)
            );
        }
    }

    @Nested
    class FindPerfectNumbersTests {
        @Test
        void testFindPerfectNumbersPositive() {
            List<Integer> perfectNumbers = StreamOperations3.findPerfectNumbers(1, 1000);
            List<Integer> expected = List.of(6, 28, 496);
            assertEquals(expected, perfectNumbers);
        }
    }
}
