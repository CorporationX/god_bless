package faang.school.godbless.BJS210900;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StreamMethodsTest {
    @Test
    void testGetPairsWithSumOf() {
        List<Integer> nums = Arrays.asList(5, 5, 5, 6, 6, 6, 4, 4, 4, 1, 9, 8, 2, 3, 8, 2, 20, -10, null);
        Set<List<Integer>> expected = Set.of(
                List.of(5, 5), List.of(4, 6), List.of(1, 9), List.of(2, 8), List.of(-10, 20)
        );

        assertEquals(expected, StreamMethods.getPairsWithSumOf(nums, 10));

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> StreamMethods.getPairsWithSumOf(null, 5));
        assertEquals("List nums can't be null!", ex.getMessage());
    }

    @Test
    void testSortCapitals() {
        Map<String, String> input = new HashMap<>();
        input.put("Russia", "Moscow");
        input.put("Argentina", "Buenos-Aires");
        input.put("Belarus", "Minsk");
        List<String> expected = List.of("Buenos-Aires", "Minsk", "Moscow");

        assertEquals(expected, StreamMethods.sortCapitals(input));
    }

    @Test
    void testSortFilteredStrings() {
        List<String> input = List.of("Russia", "Moscow", "Argentina", "Buenos-Aires", "Belarus", "Minsk");
        List<String> expected = List.of("Minsk", "Moscow");

        assertEquals(expected, StreamMethods.sortFilteredStrings(input, 'M'));
    }

    @Test
    void testFindStrangersWithCommonFriends() {
        Map<String, List<String>> friends = new HashMap<>();
        friends.put("Vasya", List.of("Petya", "Grisha"));
        friends.put("Tanya", List.of("Petya", "Grisha"));
        Set<Set<String>> actual = StreamMethods.findStrangersWithCommonFriends(friends);

        Set<Set<String>> expected = Set.of(Set.of("Petya", "Grisha"), Set.of("Tanya", "Vasya"));


        assertEquals(expected, actual);
    }

    @Test
    void testGetDepartmentAverageSalary() {
        List<Employee> employees = List.of(
                new Employee("Maksim", 5000, "Developer"),
                new Employee("Gena", 4000, "Developer"),
                new Employee("Neo", 1500, "Marketing"),
                new Employee("Morpheus", 1600, "Marketing"),
                new Employee("Walter", 100_000, "Chemistry"),
                new Employee("Jessy", 10_000, "Chemistry")
        );
        Map<String, Double> actual = StreamMethods.getDepartmentAverageSalary(employees);

        Map<String, Double> expected = new HashMap<>();
        expected.put("Developer", 4500.);
        expected.put("Marketing", 1550.);
        expected.put("Chemistry", 55_000.);

        assertEquals(expected, actual);
    }

    @Test
    void testFilterAndSortStringsContainsAlphabet() {
        char[] alphabet = {'a', 'b', 'c', 'd', 'r'};
        List<String> strings = List.of(
                "cadabra", "abra", "bar", "public"
        );

        List<String> actual = StreamMethods.filterAndSortStringsContainsAlphabet(strings, alphabet);
        List<String> expected = List.of(
                "bar", "abra", "cadabra"
        );

        assertEquals(expected, actual);
    }

    @Test
    void testToBinaryString() {
        List<Integer> nums = List.of(1, 2, 3, 4);
        List<String> actual = StreamMethods.toBinaryString(nums);
        List<String> expected = List.of("1", "10", "11", "100");

        assertEquals(expected, actual);
    }

    @Test
    void testFindPalindromes() {
        int from = 10;
        int to = 50;
        List<Integer> actual = StreamMethods.findPalindromes(from, to);
        List<Integer> expected = List.of(11, 22, 33, 44);

        assertEquals(expected, actual);

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> StreamMethods.findPalindromes(-5, 5));
        assertEquals("Please write correct numbers (>= 10 and from < to)", ex.getMessage());
    }

}
