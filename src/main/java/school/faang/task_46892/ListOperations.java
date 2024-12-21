package school.faang.task_46892;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ListOperations {
    private static final String ERROR_MESSAGE = "Input parameters can't be null or empty!";

    public static Set<List<String>> findMutualFriends(Map<String, List<String>> friends) {
        if (friends == null || friends.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }

        return friends.entrySet().stream()
                .flatMap(entry -> friends.entrySet().stream()
                        .filter(innerEntry -> !innerEntry.getKey().equals(entry.getKey())
                                && !innerEntry.getValue().contains(entry.getKey())
                                && innerEntry.getValue().stream().anyMatch(entry.getValue()::contains))
                        .map(innerEntry ->
                                Stream.of(entry.getKey(), innerEntry.getKey()).sorted(String::compareTo).toList())
                )
                .collect(Collectors.toSet());
    }

    public static Map<String, Double> findAverageSalary(List<Employee> employees) {
        if (employees == null || employees.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }

        return employees.stream()
                .collect(Collectors.groupingBy(Employee::department, Collectors.averagingDouble(Employee::salary)));
    }

    public static List<Integer> findPalindromes(List<Integer> range) {
        if (range == null || range.size() != 2) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }

        return IntStream.rangeClosed(range.get(0), range.get(1))
                .boxed()
                .filter(num -> isPalindrome(num.toString()))
                .collect(Collectors.toList());
    }

    public static List<String> findSubstringPalindromes(String source) {
        if (source == null || source.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }

        List<String> allSubstrings = getAllSubstrings(source);
        return allSubstrings.stream().filter(ListOperations::isPalindrome).distinct().toList();
    }

    public static List<Integer> findPerfectNumbers(List<Integer> range) {
        if (range == null || range.size() != 2) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }

        return IntStream.rangeClosed(range.get(0), range.get(1))
                .boxed()
                .filter(num -> num > 0)
                .filter(ListOperations::isPerfectNum)
                .toList();
    }

    private static boolean isPerfectNum(Integer num) {
        var dividersSum = IntStream.rangeClosed(1, num / 2)
                .filter(innerNum -> num % innerNum == 0)
                .sum();
        return dividersSum == num;
    }

    private static List<String> getAllSubstrings(String source) {
        List<String> allSubstrings = new ArrayList<>();
        var lenSize = source.length();

        for (int i = 0; i < lenSize; i++) {
            for (int k = 0; k < lenSize - i; k++) {
                allSubstrings.add(source.substring(k, lenSize - i));
            }
        }
        return allSubstrings;
    }

    private static boolean isPalindrome(String str) {
        if (str == null || str.length() <= 1) {
            return true;
        }
        var left = 0;
        var right = str.length() - 1;
        var letters = str.toCharArray();

        while (left < right) {
            if (letters[left] != letters[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
