package school.faang.sprint_2.task_47420;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamOperations {

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
                        .peek(Collections::sort))
                .collect(Collectors.toSet());
    }

    public static Map<String, Double> calculateAverageSalary(List<Employee> employees) {
        if (employees == null) {
            throw new IllegalArgumentException("List of Employees can't be null");
        }
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::department,
                        Collectors.averagingDouble(Employee::salary)));

    }

    public static List<String> findPalindromeNumbers(int start, int end) {
        if (start < 0) {
            throw new IllegalArgumentException("Input number should be positive");
        }
        if (end < start) {
            throw new IllegalArgumentException("End number should be more than start number");
        }

        List<Integer> numbers = new ArrayList<>();
        numbers.addAll(IntStream.range(start, end)
                .boxed()
                .toList());

        return numbers.stream()
                .map(String::valueOf)
                .filter(s -> isPalindrome(s))
                .toList();
    }

    public static List<String> findPalindromeSubstrings(String string) {
        Set<String> substrings = IntStream.range(0, string.length())
                .mapToObj(i -> IntStream.range(i + 1, string.length() + 1)
                        .mapToObj(j -> string.substring(i, j))
                )
                .flatMap(x -> x)
                .collect(Collectors.toSet());

        return substrings.stream()
                .filter(s -> isPalindrome(s))
                .toList();
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

    private static boolean isPalindrome(String string) {
        return new StringBuilder(string).reverse().toString().equals(string);
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
}
