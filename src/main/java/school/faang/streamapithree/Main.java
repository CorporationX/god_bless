package school.faang.streamapithree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, List<String>> friendsMap = new HashMap<>();
        friendsMap.put("Alice", Arrays.asList("Bob", "Charlie"));
        friendsMap.put("Bob", Arrays.asList("Alice", "David"));
        friendsMap.put("Charlie", Arrays.asList("Alice", "David"));
        friendsMap.put("David", Arrays.asList("Bob", "Charlie"));

        List<CommonFriendsFinder.Pair> commonFriendPairs = CommonFriendsFinder.findPairsWithCommonFriends(friendsMap);
        System.out.println("Pairs with common friends:");
        commonFriendPairs.forEach(pair -> System.out.println(pair.getPerson1() + " - " + pair.getPerson2()));

        List<Employee> employees = Arrays.asList(
                new Employee("John", 5000, "Engineering"),
                new Employee("Jane", 6000, "Engineering"),
                new Employee("Doe", 5500, "HR"),
                new Employee("Smith", 4000, "HR")
        );
        Map<String, Double> avgSalaryByDept = AverageSalaryCalculator.calculateAverageSalaryByDepartment(employees);
        System.out.println("\nAverage salary by department:");
        avgSalaryByDept.forEach((dept, avgSalary) -> System.out.println(dept + ": " + avgSalary));

        int startRange = 100, endRange = 200;
        List<Integer> palindromeNumbers = PalindromeNumbersFinder.findPalindromesInRange(startRange, endRange);
        System.out.println("\nPalindrome numbers between " + startRange + " and " + endRange + ": " + palindromeNumbers);

        String inputString = "abac";
        List<String> palindromicSubstrings = PalindromeSubstringFinder.findPalindromicSubstrings(inputString);
        System.out.println("\nPalindromic substrings in '" + inputString + "': " + palindromicSubstrings);

        int perfectStartRange = 1, perfectEndRange = 1000;
        List<Integer> perfectNumbers = PerfectNumberFinder.findPerfectNumbersInRange(perfectStartRange, perfectEndRange);
        System.out.println("\nPerfect numbers between " + perfectStartRange + " and " + perfectEndRange + ": " + perfectNumbers);
    }
}

