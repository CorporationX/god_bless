package lets_practice_streamapi_3;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, List<String>> friends = Map.of(
                "Alice", List.of("Bob", "Charlie"),
                "Bob", List.of("Alice", "David"),
                "Charlie", List.of("Alice", "David"),
                "David", List.of("Bob", "Charlie")
        );
        System.out.println(SteamAPIManager.findNonFriendPairsWithCommonFriends(friends));

        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 3000, "IT"),
                new Employee("Bob", 3500, "HR"),
                new Employee("Charlie", 3200, "IT"),
                new Employee("Dave", 4000, "HR"),
                new Employee("Eve", 4500, "Finance"),
                new Employee("Frank", 5000, "Finance")
        );

        Map<String, Double> averageSalaries = SteamAPIManager.calculateAverageSalaryByDepartment(employees);
        System.out.println(averageSalaries);

        List<Integer> palindromesInteger = SteamAPIManager.findPalindromes(100, 200);
        System.out.println(palindromesInteger);

        List<String> palindromesString = SteamAPIManager.findPalindromeSubstrings("abcddcba");
        System.out.println(palindromesString);

        List<Integer> perfectNumbers = SteamAPIManager.findPerfectNumbers(1, 1000);
        System.out.println(perfectNumbers);
    }
}
