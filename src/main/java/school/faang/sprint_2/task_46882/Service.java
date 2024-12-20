package school.faang.sprint_2.task_46882;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Service {
    public static Set<List<String>> strangersWithMutualFriends(Map<String, List<String>> friends) {
        return friends.keySet().stream()
                .flatMap(f ->
                        friends.keySet().stream()
                                .filter(friend -> !f.equals(friend))
                                .filter(friend -> !friends.get(f).contains(friend))
                                .filter(friend ->
                                        friends.get(f).stream()
                                                .anyMatch(friends.get(friend)::contains))
                                .map(stranger -> {
                                    List<String> pair = new ArrayList<>(Arrays.asList(f, stranger));
                                    Collections.sort(pair);
                                    return pair;
                                }))
                .collect(Collectors.toSet());
    }

    public static Map<String, Double> averageSalaryForEachDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::department,
                        Collectors.averagingDouble(Employee::salary)));
    }

    public static Set<Integer> palindromicNumbers(int a, int b) {
        Set<Integer> range = IntStream.rangeClosed(a, b).boxed().collect(Collectors.toSet());
        return range.stream()
                .map(String::valueOf)
                .filter(s -> s.contentEquals(new StringBuilder(s).reverse()))
                .map(Integer::valueOf)
                .collect(Collectors.toSet());
    }

    public static Set<String> palindromeSubstrings(String string) {
        return IntStream.range(0, string.length()).mapToObj(i -> IntStream.range(i + 1, string.length() + 1)
                        .mapToObj(j -> string.substring(i, j)))
                .flatMap(s -> s)
                .filter(s -> s.contentEquals(new StringBuilder(s).reverse()))
                .collect(Collectors.toSet());
    }

    public static Set<Integer> perfectNumbers(int a, int b) {
        return IntStream.rangeClosed(a, b)
                .filter(n -> {
                    int sum = IntStream.rangeClosed(1, n / 2)
                            .filter(i -> n % i == 0)
                            .sum();
                    return n == sum;
                })
                .boxed()
                .collect(Collectors.toSet());
    }
}
