package faang.school.godbless.sprint2.streamAPI.BJS2_22432;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Task 1: Find all unique pairs of numbers that sum to a given number
        List<Integer> numbers = List.of(1, 9, 3, 6, 4, 5);
        int targetSum = 10;
        Tasks.printPairsWithSum(numbers, targetSum);

        // Task 2: Sort countries alphabetically and list their capitals
        Map<String, String> countriesAndCapitals = Map.of(
                "France", "Paris",
                "Germany", "Berlin",
                "Italy", "Rome",
                "Spain", "Madrid"
        );
        List<String> capitals = Tasks.getCapitalsSortedByCountry(countriesAndCapitals);
        System.out.println("Capitals sorted by country: " + capitals);

        // Task 3: Filter strings starting with a specific letter and sort by length
        List<String> strings = List.of("apple", "banana", "cherry", "date", "apricot", "blueberry");
        char startingLetter = 'a';
        List<String> filteredAndSorted = Tasks.filterAndSortStringsByLength(strings, startingLetter);
        System.out.println("Filtered and sorted strings: " + filteredAndSorted);

        // Task 4: Find pairs of people who are not friends but have common friends
        Map<String, List<String>> friendships = Map.of(
                "Alice", List.of("Bob", "Charlie"),
                "Bob", List.of("Alice", "David"),
                "Charlie", List.of("Alice", "David"),
                "David", List.of("Bob", "Charlie")
        );
        List<List<String>> nonFriendPairs = Tasks.findNonFriendPairsWithCommonFriends(friendships);
        System.out.println("Non-friend pairs with common friends: " + nonFriendPairs);

        // Task 5: Find average salary by department
        List<Employee> employees = List.of(
                new Employee("John", 60000, "Engineering"),
                new Employee("Jane", 65000, "Engineering"),
                new Employee("Mike", 70000, "Marketing"),
                new Employee("Sara", 72000, "Marketing")
        );
        Map<String, Double> averageSalaries = Tasks.getAverageSalaryByDepartment(employees);
        System.out.println("Average salary by department: " + averageSalaries);

        // Task 6: Filter strings that contain only allowed alphabet letters and sort by length
        List<String> inputStrings = List.of("apple", "banana", "123", "dog", "cat");
        String alphabetString = "abcdefghijklmnopqrstuvwxyz";
        char[] alphabet = alphabetString.toCharArray();
        List<String> filteredSortedStrings = Tasks.filterAndSortByAlphabet(inputStrings, alphabet);
        System.out.println("Filtered and sorted strings by alphabet: " + filteredSortedStrings);

        // Task 7: Convert list of integers to binary strings
        List<Integer> intList = List.of(2, 5, 7, 10);
        List<String> binaryStrings = Tasks.convertNumbersToBinaryStrings(intList);
        System.out.println("Binary representations: " + binaryStrings);

        // Task 8: Find all palindromic numbers in a range
        int start = 10;
        int end = 100;
        List<Integer> palindromes = Tasks.findPalindromesInRange(90, 200);
        System.out.println("Palindromic numbers in range: " + palindromes);

        // Task 9: Find all palindromic substrings in a string
        String inputString = "madamracecar";
        List<String> palindromicSubstrings = Tasks.findAllPalindromicSubstrings(inputString);
        System.out.println("Palindromic substrings: " + palindromicSubstrings);

    }
}
