package school.faang.BJS2_34807_StreamAPI3;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Map<String, List<String>> peopleFriends = new HashMap<>();
        peopleFriends.put("Alice", Arrays.asList("Bob", "Charlie"));
        peopleFriends.put("Bob", Arrays.asList("Alice", "David"));
        peopleFriends.put("Charlie", Arrays.asList("Alice", "David"));
        peopleFriends.put("David", Arrays.asList("Bob", "Charlie"));

        Set<List<String>> mutualFriends = DataUtils.findMutualFriends(peopleFriends);
        System.out.println("Mutual Friends: " + mutualFriends);

        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 70000, "Sales"),
                new Employee("Bob", 80000, "Sales"),
                new Employee("Charlie", 50000, "IT"),
                new Employee("David", 60000, "IT"),
                new Employee("Eve", 90000, "HR")
        );

        Map<String, Double> averageSalaries = DataUtils.departuresAverageSalaries(employees);
        System.out.println("Average Salaries by Department: " + averageSalaries);

        List<Integer> palindromes = DataUtils.getPalindromes(100, 200);
        System.out.println("Palindromes between 100 and 200: " + palindromes);

        String inputString = "ababa";
        Set<String> substringPalindromes = DataUtils.getSubstringsPalindromes(inputString);
        System.out.println("Palindromic Substrings of '" + inputString + "': " + substringPalindromes);

        List<Integer> perfectNumbers = DataUtils.getPerfectNumbers(1, 10000);
        System.out.println("Perfect Numbers between 1 and 10000: " + perfectNumbers);
    }
}
