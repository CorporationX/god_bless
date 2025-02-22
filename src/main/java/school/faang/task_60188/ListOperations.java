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

    public static Map<String, Double> avgDepartmentFee(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getFee)
                ));
    }

    public static List<Integer> palindromesNumbers(Map<Integer, Integer> range) {
        return range.keySet().stream()
                .flatMap(num1 -> IntStream.range(num1, range.get(num1))
                        .boxed())
                .filter(number -> number == Integer
                        .parseInt(new StringBuilder(Integer.toString(number)).reverse().toString()))
                .collect(Collectors.toList());
    }

    public static Set<String> searchPalindromesSubString(String inputWord) {
        return IntStream.range(0, inputWord.length())
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, inputWord.length() + 1)
                        .mapToObj(j -> inputWord.substring(i, j)))
                .filter(sub -> sub.contentEquals(new StringBuilder(sub).reverse()))
                .collect(Collectors.toSet());
    }

    public static List<Integer> searchPerfectNumbers(Map<Integer, Integer> rangeNumbers) {
        return rangeNumbers.keySet().stream()
                .flatMap(num1 -> IntStream.range(num1, rangeNumbers.get(num1))
                        .boxed())
                .filter(number -> number == IntStream.range(1, number)
                        .filter(n -> number % n == 0)
                        .sum())
                .collect(Collectors.toList());
    }
}

