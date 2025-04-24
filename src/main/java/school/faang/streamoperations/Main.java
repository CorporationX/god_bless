package school.faang.streamoperations;

import school.faang.streamoperations.entity.Employee;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<String, List<String>> friends = new HashMap<>();
        friends.put("Alice", Arrays.asList("Bob", "Charlie"));
        friends.put("Bob", Arrays.asList("Alice", "David"));
        friends.put("Charlie", Arrays.asList("Alice", "David"));
        friends.put("David", Arrays.asList("Bob", "Charlie"));

        List<Employee> employees = List.of(
                new Employee("Alice", "IT", 1000000),
                new Employee("Bob", "IT", 900000),
                new Employee("Charlie", "IT", 1200000),
                new Employee("David", "HR", 850000),
                new Employee("Mike", "HR", 900000),
                new Employee("Alex", "HR", 110000)
        );

        List<Integer> numbers = List.of(100, 6, 121, 15, 11, 28, 33, 303, 12, 496);

        List<String> words = List.of("madam", "level", "afternoon", "banana");

        System.out.println("Пары людей, не являющиеся друзьями, но имеющие общих друзей: "
                + Operations.findPairNotFriends(friends));
        System.out.println("Средняя зарплата каждого отдела: " + Operations.getAverageSalary(employees));
        System.out.println("Числа-палиндромы: " + Operations.findPalindromicNumbers(numbers));
        System.out.println("Подстроки-палиндромы: " + Operations.findPalindromicSubstrings(words));
        System.out.println("Совершенные числа: " + Operations.findPerfectNumbers(numbers));

    }
}