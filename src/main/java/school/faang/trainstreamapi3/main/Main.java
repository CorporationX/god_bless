package school.faang.trainstreamapi3.main;

import school.faang.trainstreamapi3.maincode.Employee;
import school.faang.trainstreamapi3.maincode.StreamApi3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, List<String>> friendsMap = new HashMap<>();
        friendsMap.put("Alice", Arrays.asList("Bob", "Charlie"));
        friendsMap.put("Bob", Arrays.asList("Alice", "David"));
        friendsMap.put("Charlie", Arrays.asList("Alice", "Eve"));
        friendsMap.put("David", Arrays.asList("Bob", "Eve"));
        friendsMap.put("Eve", Arrays.asList("Charlie", "David"));

        Set<Set<String>> mutualFriends = StreamApi3.findMutualFriends(friendsMap);
        System.out.println("Mutual Friends: " + mutualFriends);

        List<Employee> employees = Arrays.asList(
                new Employee("John", "IT", 60000),
                new Employee("Jane", "IT", 75000),
                new Employee("Jim", "HR", 50000),
                new Employee("Jake", "HR", 55000),
                new Employee("Jill", "Finance", 70000)
        );

        Map<String, Double> averageSalaries = StreamApi3.findAverageSalaryForDepartment(employees);
        System.out.println("Average Salaries: " + averageSalaries);

        int leftBorder = 10;
        int rightBorder = 200;
        List<Integer> palindromes = StreamApi3.findPalindrome(leftBorder, rightBorder);
        System.out.println("Palindromes between " + leftBorder + " and " + rightBorder + ": " + palindromes);

        String word = "racecar";
        Set<String> palindromicSubstrings = StreamApi3.substringPalindromes(word);
        System.out.println("Palindromic Substrings of '" + word + "': " + palindromicSubstrings);

        int perfectLeftBorder = 1;
        int perfectRightBorder = 10000;
        List<Integer> perfectNumbers = StreamApi3.findPerfectNumbers(perfectLeftBorder, perfectRightBorder);
        System.out.println("Perfect Numbers between " + perfectLeftBorder +
                " and " + perfectRightBorder + ": " + perfectNumbers);
    }
}
