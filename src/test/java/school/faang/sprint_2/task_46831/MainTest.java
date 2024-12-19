package school.faang.sprint_2.task_46831;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    Main main = new Main();

    @Test
    void testFindPairsWithMutualFriendsBaseCase() {
        var friends = Map.of(
                "Alice", List.of("Bob", "Charlie"),
                "Bob", List.of("Alice", "David"),
                "Charlie", List.of("Alice", "David"),
                "David", List.of("Bob", "Charlie")
        );
        var expect = Set.of(
                List.of("Bob", "Charlie"),
                List.of("Alice", "David")
        );

        var actual = main.findPairsWithMutualFriends(friends);

        assertEquals(expect, actual);
    }

    @Test
    void testFindAverageSalaryForEachEmployee() {
        var employeeList = List.of(
                new Employee("Alice", 13, "develop"),
                new Employee("Robert", 3, "develop"),
                new Employee("Bob", 2, "management"),
                new Employee("David", 33, "management")
        );
        var expect = Map.of(
                "develop", 8d,
                "management", 17.5d
        );

        var actual = main.findAverageSalaryForEachEmployee(employeeList);

        assertEquals(expect, actual);
    }

    @Test
    void testFindAllNumberPalindromes() {
        int leftBorder = 100;
        int rightBorder = 200;
        var expect = List.of(101, 111, 121, 131, 141, 151, 161, 171, 181, 191);

        var actual = main.findAllNumbersPalindromes(leftBorder, rightBorder);

        assertEquals(expect, actual);
    }

    @Test
    void testFindAllSubstringsPalindromes() {
        String string = "abac";
        var expect = List.of("a", "aba", "b", "c");

        var actual = main.findAllSubstringsPalindromes(string);

        assertEquals(expect, actual);
    }

    @Test
    void testFindExcellentNumbers() {
        int leftBorder = 1;
        int rightBorder = 1000;
        var expect = List.of(6, 28, 496);

        var actual = main.findExcellentNumbers(leftBorder, rightBorder);

        assertEquals(expect, actual);
    }
}
