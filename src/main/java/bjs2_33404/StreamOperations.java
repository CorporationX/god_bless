package bjs2_33404;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamOperations {

    public static List<Set<String>> searchMutualFriends(Map<String, List<String>> friendLists) {
        return friendLists.entrySet().stream()
                .flatMap(entry -> entry.getValue().stream()
                        .flatMap(friend -> friendLists.get(friend).stream()
                                .filter(mutual -> !friendLists.getOrDefault(entry.getKey(),
                                        new ArrayList<>()).contains(mutual))
                                .filter(mutual -> !mutual.equals(entry.getKey()))
                                .map(mutual -> Set.of(entry.getKey(), mutual))))
                .distinct()
                .toList();
    }

    public static Map<String, Double> computeDepartmentsAvgSalary(List<Employee> employees) {
        Map<String, List<Integer>> salariesByDepartment = new HashMap<>();

        employees.stream()
                .forEach(employee -> salariesByDepartment.computeIfAbsent(employee.getDepartment(),
                        k -> new ArrayList<>()).add(employee.getSalary()));

        return salariesByDepartment.entrySet().stream()
                .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue().stream()
                        .mapToInt(salary -> salary).average().orElse(0.0)));
    }

    public static List<Integer> palindromesFromRange(int start, int end) {
        return IntStream.range(start, end)
                .boxed()
                .filter(num -> num.toString().equals(Util.reverseString(num.toString())))
                .toList();
    }

    public static List<String> palindromeStrings(String string) {
        return IntStream.range(0, string.length())
                .boxed()
                .flatMap(startIndex ->
                        IntStream.range(startIndex + 1, string.length() + 1)
                                .mapToObj(endIndex -> string.substring(startIndex, endIndex)))
                .filter(str -> str.equals(Util.reverseString(str)))
                .toList();
    }

    public static List<Integer> primeNumbers(int start, int end) {
        return IntStream.range(start, end)
                .boxed()
                .filter(num -> {
                    return num == IntStream.range(1, num)
                            .filter(i -> num % i == 0)
                            .sum();
                })
                .toList();
    }
}
