package school.faang.task_46892;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ListOperationsTest {

    @Test
    void testCreateEmployee() {
        assertThrows(IllegalArgumentException.class, () -> new Employee("", 100_000.0, "dep1"));
        assertThrows(IllegalArgumentException.class, () -> new Employee("name1", 100_000.0, ""));
        assertThrows(IllegalArgumentException.class, () -> new Employee(null, 100_000.0, ""));
        assertThrows(IllegalArgumentException.class, () -> new Employee("", 100_000.0, null));
    }

    @Test
    void testFindMutualFriends() {
        Map<String, List<String>> friends = Map.of(
                "Alice", List.of("Bob", "Charlie"),
                "Bob", List.of("Alice", "David"),
                "Charlie", List.of("Alice", "David"),
                "David", List.of("Bob", "Charlie")
        );

        assertEquals(List.of(List.of("Bob", "Charlie"), List.of("Alice", "David")),
                ListOperations.findMutualFriends(friends));
        assertThrows(IllegalArgumentException.class, () -> ListOperations.findMutualFriends(null));
        assertThrows(IllegalArgumentException.class, () -> ListOperations.findMutualFriends(Map.of()));
    }

    @Test
    void testFindAverageSalary() {
        List<Employee> employees = List.of(
                new Employee("Иванов Иван", 200_000.0, "IT"),
                new Employee("Петров Петр", 160_000.0, "IT"),
                new Employee("Сидоров Алексей", 185_000.0, "IT"),

                new Employee("Васильева Мария", 155_000.0, "HR"),
                new Employee("Кузнецова Анна", 165_000.0, "HR"),
                new Employee("Федорова Ольга", 140_000.0, "HR"),

                new Employee("Николаев Сергей", 170_000.0, "Finance"),
                new Employee("Орлова Татьяна", 175_000.0, "Finance"),
                new Employee("Павлов Дмитрий", 180_000.0, "Finance")
        );

        assertEquals(Map.of(
                        "Finance", 175000.0,
                        "HR", 153333.33333333334,
                        "IT", 181666.66666666666),
                ListOperations.findAverageSalary(employees));
        assertThrows(IllegalArgumentException.class, () -> ListOperations.findAverageSalary(null));
        assertThrows(IllegalArgumentException.class, () -> ListOperations.findAverageSalary(List.of()));
    }

    @Test
    void testFindPalindrome() {
        assertEquals(List.of(101, 111, 121, 131, 141, 151, 161, 171, 181, 191),
                ListOperations.findPalindromes(List.of(100, 200)));
        assertEquals(List.of(),
                ListOperations.findPalindromes(List.of(12, 19)));
        assertEquals(List.of(),
                ListOperations.findPalindromes(List.of(200, 100)));

        assertThrows(IllegalArgumentException.class, () -> ListOperations.findPalindromes(List.of(10)));
        assertThrows(IllegalArgumentException.class, () -> ListOperations.findPalindromes(List.of(10, 22, 30)));
        assertThrows(IllegalArgumentException.class, () -> ListOperations.findPalindromes(null));
        assertThrows(IllegalArgumentException.class, () -> ListOperations.findPalindromes(List.of()));
    }

    @Test
    void testFindSubstringPalindromes() {
        assertEquals(List.of("c", "aba", "a", "b"), ListOperations.findSubstringPalindromes("abac"));
        assertEquals(List.of("aaa", "aa", "a"), ListOperations.findSubstringPalindromes("aaa"));
        assertEquals(List.of("e", "d", "c", "b", "a"), ListOperations.findSubstringPalindromes("abcde"));
        assertEquals(List.of("a", "c", "!!", "!"), ListOperations.findSubstringPalindromes("a!!ca"));

        assertThrows(IllegalArgumentException.class, () -> ListOperations.findSubstringPalindromes(""));
        assertThrows(IllegalArgumentException.class, () -> ListOperations.findSubstringPalindromes(null));
    }

    @Test
    void testFindPerfectNumbers() {
        assertEquals(List.of(6, 28, 496), ListOperations.findPerfectNumbers((List.of(1, 1000))));
        assertEquals(List.of(6), ListOperations.findPerfectNumbers((List.of(1, 6))));
        assertEquals(List.of(), ListOperations.findPerfectNumbers((List.of(-1, -6))));
        assertEquals(List.of(), ListOperations.findPerfectNumbers((List.of(6, -1))));
        assertEquals(List.of(6, 28, 496), ListOperations.findPerfectNumbers((List.of(0, 1000))));
        assertEquals(List.of(6), ListOperations.findPerfectNumbers((List.of(-1, 6))));


        assertThrows(IllegalArgumentException.class, () -> ListOperations.findPerfectNumbers((List.of(10))));
        assertThrows(IllegalArgumentException.class, () -> ListOperations.findPerfectNumbers(null));
    }
}