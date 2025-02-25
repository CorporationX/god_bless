package school.faang.task_60188;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ListOperations {
    public static Set<List<String>> findPeopleWithCommonFriends(Map<String, List<String>> friendsConnections) {
        return friendsConnections.keySet().parallelStream()
                .flatMap(personFriends -> friendsConnections.keySet().stream()
                        .filter(otherPerson -> !otherPerson.equals(personFriends)
                                && !friendsConnections.get(personFriends).contains(otherPerson))
                        .map(otherPerson -> Stream.of(personFriends, otherPerson)
                                .sorted()
                                .collect(Collectors.toList()))
                )
                .filter(pair -> friendsConnections.get(pair.get(0)).stream()
                        .anyMatch(friend -> friendsConnections.get(pair.get(1)).contains(friend)))
                .collect(Collectors.toSet());
    }

    public static Map<String, Double> calculateAvgDepartmentFee(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getFee)
                ));
    }

    public static List<Integer> findPalindromeNumbersV1(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .boxed()
                .filter(number -> number == Integer
                        .parseInt(new StringBuilder(Integer.toString(number)).reverse().toString()))
                .toList();
    }

    public static List<Integer> findPalindromeNumbersV2(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .filter(number -> {
                    if (number < 0) return false;
                    int reversed = 0;
                    int original = number;
                    while (original != 0) {
                        reversed = reversed * 10 + original % 10;
                        original /= 10;
                    }
                    return reversed == number;
                })
                .boxed()
                .toList();
    }

    public static Set<String> findPalindromeSubstringV1(String inputWord) {
        return IntStream.range(0, inputWord.length())
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, inputWord.length() + 1)
                        .mapToObj(j -> inputWord.substring(i, j)))
                .filter(sub -> sub.contentEquals(new StringBuilder(sub).reverse()))
                .collect(Collectors.toSet());
    }

    public static Set<String> findPalindromeSubstringV2(String inputWord) {
        return IntStream.range(0, inputWord.length())
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, inputWord.length() + 1)
                        .mapToObj(j -> inputWord.substring(i, j)))
                .filter(sub -> {
                    int left = 0;
                    int right = sub.length() - 1;
                    while (left < right) {
                        if (sub.charAt(left++) != sub.charAt(right--)) {
                            return false;
                        }
                    }
                    return true;
                })
                .collect(Collectors.toSet());
    }

    public static List<Integer> findPerfectNumbers(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .boxed()
                .filter(number -> number == IntStream.range(1, number)
                        .filter(n -> number % n == 0)
                        .sum())
                .toList();
    }
}

