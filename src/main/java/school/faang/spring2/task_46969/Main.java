package school.faang.spring2.task_46969;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Map<String, List<String>> map = new HashMap<>();
        map.put("Alice", List.of("Bob", "Charlie"));
        map.put("Bob", List.of("Alice", "David"));
        map.put("Charlie", List.of("Alice", "David"));
        map.put("David", List.of("Bob", "Charlie"));

        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR", 50000),
                new Employee("Bob", "IT", 70000),
                new Employee("Charlie", "IT", 75000),
                new Employee("Diana", "Finance", 60000),
                new Employee("Eve", "Finance", 65000),
                new Employee("Frank", "HR", 55000)
        );
        System.out.println(findAverageSalary(employees));

        System.out.println(findPalindromeNumbersByRange(100, 200));

        System.out.println(findSubstringPalindrome("abac"));


    }

    public static List<Integer> findPerfectNumbers(int end) {
        List<Integer> numbers = new ArrayList<>();
        numbers.addAll(IntStream.range(0, end)
                .boxed()
                .toList());

        return numbers.stream()
                .filter(n -> isPerfectNumber(n))
                .toList();
    }

    private static boolean isPerfectNumber(int number) {
        if (number <= 1) {
            return false;
        }
        int sum = IntStream.rangeClosed(1, number / 2)
                .filter(i -> number % i == 0)
                .sum();
        return sum == number;
    }

    public static List<String> findSubstringPalindrome(String str) {
        return IntStream.range(0, str.length())
                .boxed()
                .flatMap(start -> IntStream.rangeClosed(start + 1, str.length())
                        .mapToObj(end -> str.substring(start, end)))
                .filter(Main::isPalindrome)
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<Integer> findPalindromeNumbersByRange(int down, int upper) {
        return IntStream.range(down, upper)
                .mapToObj(String::valueOf)
                .filter(Main::isPalindrome).map(Integer::parseInt).toList();
    }

    private static boolean isPalindrome(String string) {
        return new StringBuilder(string).reverse().toString().equals(string);
    }

    public static Map<String, Double> findAverageSalary(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::department, Collectors.averagingDouble(Employee::salary)));
    }

    public static Set<List<String>> findCommonFriends(Map<String, List<String>> usersFriends) {
        if (usersFriends == null) {
            throw new IllegalArgumentException("List of Users Friends can't be null");
        }
        List<String> users = new ArrayList<>(usersFriends.keySet());

        return users.stream()
                .flatMap(user -> users.stream()
                        .filter(friend -> !user.equals(friend) && !usersFriends.get(user).contains(friend))
                        .filter(friend -> usersFriends.get(user).stream().anyMatch(usersFriends.get(friend)::contains))
                        .map(friend -> Arrays.asList(user, friend))
                        .peek(list -> Collections.sort(list)))
                .collect(Collectors.toSet());
    }


}
