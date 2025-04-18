package school.faang.streamapi3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, List<String>> people = new HashMap<>();
        people.put("Alice", Arrays.asList("Bob", "Charlie"));
        people.put("Bob", Arrays.asList("Alice", "David"));
        people.put("Charlie", Arrays.asList("Alice", "David"));
        people.put("David", Arrays.asList("Bob", "Charlie"));
        System.out.println(String.format("getWithMutualFriends result = %s",
                StreamHandler.getWithMutualFriends(people)));

        System.out.println(String.format("getDeptAverageSalary result = %s",
                StreamHandler.getDeptAverageSalary(List.of(
                        new Employee("Kirill", 1000, "IT"),
                        new Employee("Ilya", 500, "IT"),
                        new Employee("Vasya", 300, "HR"),
                        new Employee("Kate", 10000, "HR")))));

        System.out.println(String.format("getPalindromInRage for %d, %d: %s", 100, 200,
                StreamHandler.getPalindromInRage(100, 200)));
        System.out.println(String.format("getPalindromsForString - %s: %s", "abac",
                StreamHandler.getPalindromsForString("abac")));
        System.out.println(String.format("getPalindromsForString - %s: %s", "aabacgt",
                StreamHandler.getPalindromsForString("aabacgt")));
        System.out.println(String.format("getPalindromsForString - %s: %s", "aaaaaa",
                StreamHandler.getPalindromsForString("aaaaaa")));
        System.out.println(String.format("getPalindromsForString - %s: %s", "",
                StreamHandler.getPalindromsForString("")));
        System.out.println(String.format("getPerfectNumbers result = %s",
                StreamHandler.getPerfectNumbers(1, 1000)));
    }
}
