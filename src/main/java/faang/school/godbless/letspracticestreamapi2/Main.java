package faang.school.godbless.letspracticestreamapi2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 9, 3, 6, 4, 5);
        Set<List<Integer>> pairs = ListUtils.findPairsWithSum(numbers, 10);
        System.out.println("Pairs with sum 10: " + pairs);

        Map<String, String> countryCapitalMap = new HashMap<>();
        countryCapitalMap.put("France", "Paris");
        countryCapitalMap.put("Germany", "Berlin");
        countryCapitalMap.put("Italy", "Rome");
        List<String> capitals = ListUtils.getSortedCapitals(countryCapitalMap);
        System.out.println("Sorted capitals: " + capitals);

        List<String> strings = Arrays.asList("apple", "apricot", "banana", "avocado");
        List<String> filteredStrings = ListUtils.filterAndSortStrings(strings, 'a');
        System.out.println("Filtered and sorted strings: " + filteredStrings);

        Map<String, List<String>> friendsMap = new HashMap<>();
        friendsMap.put("Alice", Arrays.asList("Bob", "Charlie"));
        friendsMap.put("Bob", Arrays.asList("Alice", "David"));
        friendsMap.put("Charlie", Arrays.asList("Alice", "David"));
        friendsMap.put("David", Arrays.asList("Bob", "Charlie"));
        Set<List<String>> nonFriends = ListUtils.findNonFriendsWithCommonFriends(friendsMap);
        System.out.println("Non-friends with common friends: " + nonFriends);

        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 50000, "HR"),
                new Employee("Bob", 60000, "IT"),
                new Employee("Charlie", 55000, "HR"),
                new Employee("David", 75000, "IT")
        );
        Map<String, Double> avgSalaryByDept = ListUtils.calculateAverageSalaryByDepartment(employees);
        System.out.println("Average salary by department: " + avgSalaryByDept);

        List<String> inputStrings = Arrays.asList("apple", "banana", "123", "dog", "cat");
        Set<Character> alphabet = "abcdefghijklmnopqrstuvwxyz".chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
        List<String> filteredSortedStrings = ListUtils.filterAndSortByAlphabet(inputStrings, alphabet);
        System.out.println("Filtered and sorted strings by alphabet: " + filteredSortedStrings);

        List<String> binaryStrings = ListUtils.convertToBinary(Arrays.asList(3, 5, 7, 10));
        System.out.println("Binary strings: " + binaryStrings);

        List<Integer> palindromes = ListUtils.findPalindromesInRange(1, 200);
        System.out.println("Palindromes in range: " + palindromes);

        List<String> palindromeSubstrings = ListUtils.findPalindromeSubstrings("abac");
        System.out.println("Palindrome substrings: " + palindromeSubstrings);

        List<Integer> perfectNumbers = ListUtils.findPerfectNumbersInRange(1, 10000);
        System.out.println("Perfect numbers in range: " + perfectNumbers);
    }
}