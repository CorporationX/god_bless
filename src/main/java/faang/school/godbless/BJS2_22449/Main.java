package faang.school.godbless.BJS2_22449;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = List.of(5, 5, 7, 8, 3, 4);
        int sum = 12;
        System.out.println("Unique pairs of numbers from list with the sum " + sum + ":");
        StreamProcess.findUniquePairsWithSum(sum, nums).forEach(System.out::println);

        Map<String, String> capitalsByCountries = new HashMap<>();
        capitalsByCountries.put("Belarus", "Minsk");
        capitalsByCountries.put("Russia", "Moscow");
        capitalsByCountries.put("England", "London");
        System.out.println("Sorted cities by countries:");
        StreamProcess.printSortedCapitalsByCountry(capitalsByCountries);

        List<String> strings = List.of("avocado", "orange", "apple");
        System.out.println("Filtered strings that start with 'a' and sorted by length:");
        StreamProcess.filterStringsStartWithCharAndSortByLength('a', strings).forEach(System.out::println);

        Map<String, List<String>> friendsByNames = new HashMap<>();
        friendsByNames.put("Alice", List.of("Bob", "Charlie", "David"));
        friendsByNames.put("Bob", List.of("Alice", "David"));
        friendsByNames.put("Charlie", List.of("Alice"));
        friendsByNames.put("David", List.of("Alice", "Bob"));
        friendsByNames.put("Eve", List.of("Frank"));
        System.out.println("Found pairs of non friends but with common friends:");
        StreamProcess.findPairsOfNonFriendsWithCommonFriends(friendsByNames)
                .forEach((person, friend) -> System.out.println(person + " - " + friend));

        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 50000, "HR"),
                new Employee("Bob", 60000, "HR"),
                new Employee("Charlie", 70000, "IT"),
                new Employee("David", 80000, "IT"),
                new Employee("Eve", 75000, "Finance")
        );
        System.out.println("Average salaries in departments:");
        StreamProcess.countAvgSalaryForEachDepartment(employees)
                .forEach((department, avgSalary) ->
                        System.out.println("Department: " + department + ", average salary: " + avgSalary));

        List<String> words = List.of("apple", "banana", "123", "dog", "cat");
        Set<Character> letters = "abcdefghijklmnopqrstuvwxyz".chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());
        System.out.println("Filtered by alphabet and sorted by length strings:");
        StreamProcess.filterByAlphabetAndSortByLength(words, letters).forEach(System.out::println);

        System.out.println("Result of converting integers to binary view strings list:");
        StreamProcess.convertIntegersToBinaryStrings(nums).forEach(System.out::println);

        int leftBounder = 10;
        int rightBounder = 150;
        System.out.println("Palindromic nums in the range from " + leftBounder + " to " + rightBounder);
        StreamProcess.findPalindromicNumsInBoundaries(leftBounder, rightBounder).forEach(System.out::println);
    }
}
