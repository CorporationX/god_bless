package bjs2_34888;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Map<String, List<String>> people = Map.of(
                "Alice", List.of("Bob", "Charlie"),
                "Bob", List.of("Alice", "David"),
                "Charlie", List.of("Alice", "David"),
                "David", List.of("Bob", "Charlie"));
        Set<List<String>> pairs = Solution.getPairsWithCommonFriends(people);

        List<Employee> employees = List.of(
                new Employee("name", 15, "dep1"),
                new Employee("name", 21, "dep1"),
                new Employee("name", 22, "dep2"),
                new Employee("name", 30, "dep1"),
                new Employee("name", 41, "dep2")
        );
        Map<String, Double> averageSalary = Solution.getAverageSalary(employees);
        List<Integer> palindromesInRange = Solution.findPalindromesInRange(300, 400);
        List<String> palindromes = Solution.findPalindromesOfSubstring("aabcbaa");
        List<Integer> perfect = Solution.findPerfectInRange(1, 1000);


        System.out.println(pairs);
        System.out.println(averageSalary);
        System.out.println(palindromesInRange);
        System.out.println(palindromes);
        System.out.println(perfect);
    }

}
