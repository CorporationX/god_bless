package school.faang.bjs2_72451;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamUtils {
    public static List<Map.Entry<String, String>> findPeopleWithCommonFriends(Map<String, List<String>> friendsMap) {
        return friendsMap.entrySet().stream()
                .flatMap(person1 -> friendsMap.entrySet().stream()
                        .filter(person -> !person1.getKey().equals(person.getKey()))
                        .filter(person -> !person1.getValue().contains(person.getKey()))
                        .filter(person -> !Collections.disjoint(person1.getValue(), person.getValue()))
                        .map(person2 -> Map.entry(person1.getKey(), person2.getKey()))
                        .distinct())
                        .collect(Collectors.toList());
    }

    public static Map<String, Double> averageSalaryByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.averagingDouble(Employee::salary)
                ));
    }

    public static List<Integer> findPalindromes(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .filter(number -> StreamUtils.isPalindrome(String.valueOf(number)))
                .boxed()
                .collect(Collectors.toList());
    }

    public static List<String> findAllPalindromicSubstrings(String string) {
        return IntStream.range(0, string.length())
                .boxed()
                .flatMap(left -> IntStream.rangeClosed(left + 1, string.length())
                        .mapToObj(right -> string.substring(left, right)))
                .filter(StreamUtils::isPalindrome)
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<Integer> findPerfectNumbers(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .filter(StreamUtils::isPerfectNumber)
                .boxed()
                .collect(Collectors.toList());
    }

    private static boolean isPalindrome(String string) {
        String reversed = new StringBuilder(string).reverse().toString();
        return string.equals(reversed);
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
