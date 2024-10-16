package school.faang.streamAPI3;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SpecialOperations {
    public static Set<List<String>> findMutual(Map<String, List<String>> friends) {
        return friends.keySet().stream()
                .flatMap(person -> friends.get(person).stream()
                        .flatMap(friend1 -> friends.get(friend1).stream()
                                .filter(friend2 -> !person.equals(friend2) && !friends.get(person).contains(friend2))
                                .map(friend2 -> Arrays.asList(person, friend2))))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static Map<String, Double> findAverageSalary(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy((Employee::getDepartment),
                        Collectors.averagingDouble(Employee::getSalary)));
    }

    public static List<Integer> findPolindromeNumbers(int start, int end) {
        return IntStream.range(start, end)
                .filter(number -> Integer.toString(number)
                        .contentEquals(new StringBuilder(Integer.toString(number)).reverse()))
                .boxed()
                .toList();
    }

    public static Set<String> findPolindromeStrings(String str) {
        int n = str.length();
        return IntStream.range(0, n)
                .boxed()
                .flatMap(start -> IntStream.range(start + 1, n + 1).mapToObj(end -> str.substring(start, end)))
                .filter(sub -> sub.contentEquals(new StringBuilder(sub).reverse()))
                .collect(Collectors.toSet());
    }

    public static Set<Integer> findPerfectNumbers(int start, int end) {
        return IntStream.range(start, end)
                .filter(n -> (n == IntStream.range(1, n - 1).filter(d -> n % d == 0).sum()))
                .boxed()
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new)); // для сохранения порядка
    }
}
