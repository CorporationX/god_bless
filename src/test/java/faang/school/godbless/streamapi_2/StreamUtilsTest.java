package faang.school.godbless.streamapi_2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StreamUtilsTest {
    @Test
    public void testUniqueSum() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        List<List<Integer>> expected = Arrays.asList(List.of(1,4), List.of(2,3));
        assertEquals(expected, StreamUtils.uniqueSum(list, 5));
    }

    @Test
    public void testSortCapitals() {
        Map<String, String> map = new HashMap<>();
        map.put("Italy", "Rome");
        map.put("France", "Paris");
        map.put("Germany", "Berlin");
        List<String> expected = Arrays.asList("Paris", "Berlin", "Rome");
        assertEquals(expected, StreamUtils.sortCapitals(map));
    }

    @Test
    public void testSortWords() {
        List<String> list = Arrays.asList("apple", "banana", "avocado", "blueberry", "apricot");
        List<String> expected = Arrays.asList("apple", "apricot", "avocado");
        assertEquals(expected, StreamUtils.sortWords(list, 'a'));
    }

    @Test
    public void testFriends() {
        Map<String, List<String>> map = new HashMap<>();
        map.put("Alice", Arrays.asList("Bob", "Charlie"));
        map.put("Bob", Arrays.asList("Alice", "David"));
        map.put("Charlie", List.of("Alice"));
        map.put("David", List.of("Bob"));
        Map<String, List<String>> expected = Map.of("Alice", List.of("David"), "Bob", List.of("Charlie"), "Charlie", List.of("Bob"), "David", List.of("Alice"));
        assertEquals(expected, StreamUtils.friends(map));
    }

    @Test
    public void testBranchSalary() {
        List<Employee> list = Arrays.asList(
                new Employee("Alice", 50000, "HR"),
                new Employee("Bob", 60000, "IT"),
                new Employee("Charlie", 70000, "HR"),
                new Employee("David", 80000, "IT")
        );
        Map<String, Double> expected = new HashMap<>();
        expected.put("HR", 60000.0);
        expected.put("IT", 70000.0);
        assertEquals(expected, StreamUtils.branchSalary(list));
    }

    @Test
    public void testFilterLanguage() {
        List<String> list = Arrays.asList("apple", "banana", "cherry", "date");
        String language = "abnple";
        List<String> expected = Arrays.asList("apple", "banana");
        assertEquals(expected, StreamUtils.filterLanguage(list, language));
    }

    @Test
    public void testToBinaryString() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        List<String> expected = Arrays.asList("1", "10", "11", "100");
        assertEquals(expected, StreamUtils.toBinaryString(list));
    }

    @Test
    public void testPalNumber() {
        int start = 10;
        int end = 50;
        List<Integer> expected = Arrays.asList(11, 22, 33, 44);
        assertEquals(expected, StreamUtils.palNumber(start, end));
    }

    @Test
    public void testSubstringPalindrome() {
        String str = "ababa";
        List<String> expected = Arrays.asList("aba", "ababa", "bab");
        assertEquals(expected, StreamUtils.substringPalindrome(str));
    }

    @Test
    public void testCompleteNumber() {
        int start = 1;
        int end = 30;
        List<Integer> expected = Arrays.asList(6, 28);
        assertEquals(expected, StreamUtils.completeNumber(start, end));
    }
}