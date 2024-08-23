package faang.school.godbless.sprint2.streamAPI.BJS2_22432;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 9, 3, 6, 4, 5, 5, 5, 9, 1, 9, 1);
        int targetSum = 10;
        Tasks.printPairsWithSum(numbers, targetSum);

        Map<String, String> countriesAndCapitals = Map.of(
                "France", "Paris",
                "Germany", "Berlin",
                "Italy", "Rome",
                "Spain", "Madrid"
        );
        List<String> capitals = Tasks.getCapitalsSortedByCountry(countriesAndCapitals);
        System.out.println("Capitals sorted by country: " + capitals);

        List<String> strings = List.of("apple", "banana", "cherry", "date", "apricot", "blueberry");
        char startingLetter = 'a';
        List<String> filteredAndSorted = Tasks.filterAndSortStringsByLength(strings, startingLetter);
        System.out.println("Filtered and sorted strings: " + filteredAndSorted);

        Map<String, List<String>> friendships = Map.of(
                "Alice", List.of("Bob", "Charlie"),
                "Bob", List.of("Alice", "David"),
                "Charlie", List.of("Alice", "David"),
                "David", List.of("Bob", "Charlie")
        );
        List<List<String>> nonFriendPairs = Tasks.findNonFriendPairsWithCommonFriends(friendships);
        System.out.println("Non-friend pairs with common friends: " + nonFriendPairs);

        List<Employee> employees = List.of(
                new Employee("John", 60000, "Engineering"),
                new Employee("Jane", 65000, "Engineering"),
                new Employee("Mike", 70000, "Marketing"),
                new Employee("Sara", 72000, "Marketing")
        );
        Map<String, Double> averageSalaries = Tasks.getAverageSalaryByDepartment(employees);
        System.out.println("Average salary by department: " + averageSalaries);

        List<String> inputStrings = List.of("apple", "banana", "123", "dog", "cat");
        String alphabetString = "abcdefghijklmnopqrstuvwxyz";
        char[] alphabet = alphabetString.toCharArray();
        List<String> filteredSortedStrings = Tasks.filterAndSortByAlphabet(inputStrings, alphabet);
        System.out.println("Filtered and sorted strings by alphabet: " + filteredSortedStrings);

        List<Integer> intList = List.of(2, 5, 7, 10);
        List<String> binaryStrings = Tasks.convertNumbersToBinaryStrings(intList);
        System.out.println("Binary representations: " + binaryStrings);

        List<Integer> palindromes = Tasks.findPalindromesInRange(90, 200);
        System.out.println("Palindromic numbers in range: " + palindromes);

        String inputString = "madamracecar";
        List<String> palindromicSubstrings = Tasks.findAllPalindromicSubstrings(inputString);
        System.out.println("Palindromic substrings: " + palindromicSubstrings);
    }
}