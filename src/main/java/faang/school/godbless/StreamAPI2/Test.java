package faang.school.godbless.StreamAPI2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
//        testFindUniquePairs();
//        testSortCapitalsByAlphabet();
//        testFilter();
//        testFindPeopleThatNoFriendsButHaveMutualFriends();
//        testAverageSalary();
//        testFilterAndSortStrings();
//        testConvertToBinary();
        testFindAllPalindromes();
    }

    private static void testFindUniquePairs() {
        int[] nums = {1, 5, 3, 7, 9, 2, 4, 6, 8, 5};
        int target = 10;

        int[][] pairs = StreamAPI.findUniquePairs(nums, target);

        for (int[] pair : pairs) {
            System.out.println(Arrays.toString(pair));
        }
    }

    private static void testSortCapitalsByAlphabet() {
        Map<String, String> countries = new HashMap<>();
        countries.put("Russia", "Moscow");
        countries.put("France", "Paris");
        countries.put("Japan", "Tokyo");
        countries.put("Germany", "Berlin");
        countries.put("Australia", "Canberra");

        System.out.println(StreamAPI.sortCapitalsByAlphabet(countries));
    }

    private static void testFilter() {
        List<String> words = Arrays.asList("apple", "apricot", "banana", "avocado", "ace");
        char character = 'a';

        System.out.println(StreamAPI.filter(words, character));
    }

    private static void testFindPeopleThatNoFriendsButHaveMutualFriends() {
        Map<String, List<String>> people = new HashMap<>();
        people.put("Alice", Arrays.asList("Bob", "Charlie"));
        people.put("Bob", Arrays.asList("Alice", "David"));
        people.put("Charlie", Arrays.asList("Alice", "David"));
        people.put("David", Arrays.asList("Bob", "Charlie"));
        people.put("Eve", List.of("Frank"));
        people.put("Frank", List.of("Eve"));

        System.out.println(StreamAPI.findPeopleThatNoFriendsButHaveMutualFriends(people));
    }

    private static void testAverageSalary() {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 50000, "HR"),
                new Employee("Bob", 60000, "HR"),
                new Employee("Charlie", 70000, "IT"),
                new Employee("David", 80000, "IT"),
                new Employee("Eve", 75000, "Sales"),
                new Employee("Frank", 65000, "Sales")
        );

        Map<String, Double> averageSalaries = StreamAPI.averageSalary(employees);
        averageSalaries.forEach((department, avgSalary) ->
                System.out.println(department + ": " + avgSalary));
    }

    private static void testFilterAndSortStrings() {
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape", "kiwi", "арбуз");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        StreamAPI.filterAndSortStrings(strings, alphabet).forEach(System.out::println);
    }

    private static void testConvertToBinary() {
        List<Integer> numbers = List.of(5, 8, 15, 23, 42);

        StreamAPI.convertToBinary(numbers).forEach(System.out::println);
    }

    private static void testFindAllPalindromes() {
        int start = 100;
        int end = 200;

        List<Integer> palindromes = StreamAPI.findAllPalindromes(start, end);

        System.out.println("Palindromes between " + start + " and " + end + ": " + palindromes);
    }
}
