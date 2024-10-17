package school.faangSprint2.t23;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static List<List<String>> findPeopleWithCommonFriends(Map<String, List<String>> friendships) {
        return friendships.keySet().stream()
                .flatMap(person1 -> friendships.keySet().stream()
                        .filter(person2 -> person1.compareTo(person2) < 0)
                        .filter(person2 -> !friendships.get(person1).contains(person2))
                        .filter(person2 -> {
                            Set<String> friends1 = new HashSet<>(friendships.get(person1));
                            Set<String> friends2 = new HashSet<>(friendships.get(person2));
                            friends1.retainAll(friends2);
                            return !friends1.isEmpty();
                        })
                        .map(person2 -> Arrays.asList(person1, person2)))
                .collect(Collectors.toList());
    }

    public static Map<String, Double> findAverageSalaryByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        emp -> emp.department,
                        Collectors.averagingDouble(emp -> emp.salary)
                ));
    }

    public static List<Integer> findPalindromeNumbers(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .filter(num -> isPalindrome(String.valueOf(num)))
                .boxed()
                .collect(Collectors.toList());
    }

    public static List<String> findPalindromeSubstrings(String input) {
        return IntStream.range(0, input.length())
                .boxed()
                .flatMap(i -> IntStream.rangeClosed(i + 1, input.length())
                        .mapToObj(j -> input.substring(i, j)))
                .filter(Main::isPalindrome)
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<Integer> findPerfectNumbers(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .filter(Main::isPerfectNumber)
                .boxed()
                .collect(Collectors.toList());
    }

    private static boolean isPalindrome(String str) {
        return IntStream.range(0, str.length() / 2)
                .allMatch(i -> str.charAt(i) == str.charAt(str.length() - 1 - i));
    }

    private static boolean isPerfectNumber(int num) {
        if (num <= 1) return false;

        int sum = IntStream.rangeClosed(1, (int) Math.sqrt(num))
                .filter(i -> num % i == 0)
                .flatMap(i -> {
                    if (i == num / i || i == 1) {
                        return IntStream.of(i);
                    }
                    return IntStream.of(i, num / i);
                })
                .sum();

        return sum == num;
    }

    public static void main(String[] args) {

        Map<String, List<String>> friendships = Map.of(
                "Alice", Arrays.asList("Bob", "Charlie"),
                "Bob", Arrays.asList("Alice", "David"),
                "Charlie", Arrays.asList("Alice", "David"),
                "David", Arrays.asList("Bob", "Charlie")
        );

        System.out.println("People with common friends: " +
                findPeopleWithCommonFriends(friendships));

        List<Employee> employees = Arrays.asList(
                new Employee("Tom", 50000, "IT"),
                new Employee("John", 60000, "IT"),
                new Employee("Bob", 55000, "HR"),
                new Employee("Anna", 65000, "HR")
        );
        System.out.println("Average salary by department: " +
                findAverageSalaryByDepartment(employees));

        System.out.println("Palindrome numbers: " +
                findPalindromeNumbers(100, 200));

        System.out.println("Palindrome substrings: " +
                findPalindromeSubstrings("abac"));

        System.out.println("Perfect numbers: " +
                findPerfectNumbers(1, 1000));
    }
}