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
        System.out.println(StreamHandler.getWithMutualFriends(people));

        System.out.println(StreamHandler.getDeptAverageSalary(List.of(
                new Employee("Kirill", 1000, "IT"),
                new Employee("Ilya", 500, "IT"),
                new Employee("Vasya", 300, "HR"),
                new Employee("Kate", 10000, "HR"))));

        System.out.println(StreamHandler.getPalindromInRage(100, 200));
        System.out.println(StreamHandler.getPalindromsForString("adata"));
        System.out.println(StreamHandler.getPerfectNumbers(1, 1000));
    }
}
