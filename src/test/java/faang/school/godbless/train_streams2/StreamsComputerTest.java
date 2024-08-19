package faang.school.godbless.train_streams2;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import static faang.school.godbless.train_streams2.StreamsComputer.*;
import static org.junit.jupiter.api.Assertions.*;

public class StreamsComputerTest {

    @Test
    public void testAddToTarget() {
        assertEquals(List.of(List.of(1, 9), List.of(6, 4)),
                pairsAddingToTarget(List.of(1, 9, 3, 6, 4), 10));
    }

    @Test
    public void testSortCountiesGetCapitals() {
        assertEquals(List.of("Prague", "Moscow", "London"),
                sortedCountriesCapitals(Map.of(
                "Russia", "Moscow",
                "Czech Republic", "Prague",
                "United Kingdom", "London"))
        );
    }

    @Test
    public void testStartWithCharLengthSorted() {
        assertEquals(List.of("London", "Lost Angeles"),
                startWithCharLengthSorted(List.of("London", "Los Angeles", "Kaliningrad", "Amsterdam"), 'L'));
    }

    @Test
    public void testNotFriendsWithCommonFriends() {
        assertEquals(List.of(List.of("Arman", "Nikita")),
                notFriendsWithCommonFriends(Map.of(
                        "Nikita", List.of("Denis", "Matvey"),
                        "Denis", List.of("Mike", "Emma"),
                        "Arman", List.of("Denis", "Peter")
                ))
        );
    }

    @Test
    public void testDepartmentAvgSalaries() {
        Map<String, Double> avgSalaryByDepartment = departmentAverageSalaries(List.of(
                new Employee("Nikita", "IT", 120000),
                new Employee("Matvey", "IT", 80000),
                new Employee("Arman", "Sales", 70000),
                new Employee("Denis", "Sales", 50000),
                new Employee("Ivan", "Marketing", 60000),
                new Employee("Alex", "Marketing", 40000)
        ));
        assertEquals(3, avgSalaryByDepartment.size());
        assertEquals(100000.0, avgSalaryByDepartment.get("IT"));
    }

    @Test
    public void testAlphabetPresentLengthSorted() {
        List<String> strings = List.of("apple", "banana", "123", "dog", "cat");
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        assertEquals(List.of("dog", "cat", "apple", "banana"),
                fromAlphabetLengthSorted(strings, alphabet)
        );
    }

    @Test
    public void testIntsToBinaryStrings() {
        assertEquals(List.of("1", "10", "11", "100", "101"),
                intToBinaryString(List.of(1, 2, 3, 4, 5))
        );
    }

    @Test
    public void testAllPalindromesInRange() {
        assertEquals(List.of(101, 111, 121, 131, 141, 151, 161, 171, 181, 191, 202),
                allPalindromesInRange(100, 203)
        );
    }
}
