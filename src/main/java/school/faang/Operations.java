package school.faang;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Operations {
    public static List<List<String>> getMutualFriends(Map<String, List<String>> friendships) {
        validateFriendships(friendships);
        return friendships.keySet().stream()
                .flatMap(person1 -> friendships.keySet().stream()
                        .filter(person2 -> !friendships.get(person1).contains(person2)
                                && !friendships.get(person2).contains(person1)
                                && !Collections.disjoint(friendships.get(person1), friendships.get(person2)))
                        .map(person2 -> Arrays.asList(person1, person2))
                        .filter(pair -> pair.get(0).compareTo(pair.get(1)) < 0))
                .toList();
    }

    public static Map<String, Double> getMeanSalaryForDepartment(List<Employee> employees) {
        validateEmployees(employees);
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));
    }

    public static List<Integer> findPalindromeNumbers(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .filter(Operations::isPalindrome)
                .boxed()
                .toList();
    }

    public static List<String> findPalindromeSubstrings(String str) {
        return IntStream.range(0, str.length())
                .boxed()
                .flatMap(i -> IntStream.range(i, str.length())
                        .filter(j -> isPalindrome(str.substring(i, j + 1)))
                        .mapToObj(j -> str.substring(i, j + 1)))
                .collect(Collectors.toSet())
                .stream()
                .sorted()
                .toList();
    }

    public static List<Integer> getPerfectNumbers(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .boxed()
                .filter(i -> i > 0 && isPerfectNumber(i))
                .toList();
    }

    private static boolean isPerfectNumber(int number) {
        return IntStream.range(1, number)
                .filter(i -> number % i == 0)
                .sum() == number;
    }

    public static boolean isPalindrome(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }

    private static boolean isPalindrome(int num) {
        String str = String.valueOf(num);
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }

    private static void validateEmployees(List<Employee> employees) {
        if (employees == null) {
            throw new IllegalArgumentException("Employee list can't be null.");
        }
        if (employees.stream().anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException("Employee in list can't be null.");
        }
    }

    private static void validateFriendships(Map<String, List<String>> friendships) {
        if (friendships == null) {
            throw new IllegalArgumentException("Friendships can't be null.");
        }
        for (var entry : friendships.entrySet()) {
            if (entry.getKey() == null) {
                throw new IllegalArgumentException("Key in friendships can't be null.");
            } else if (entry.getValue() == null) {
                throw new IllegalArgumentException("Value in friendships can't be null.");
            }
            if (entry.getValue().stream().anyMatch(Objects::isNull)) {
                throw new IllegalArgumentException("String in friend list can't be null.");
            }
        }
    }
}
