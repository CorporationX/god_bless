package school.faang.bjs46903;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Service {
    public static Set<Set<String>> commonFriend(Map<String, List<String>> friends) {
        return friends.entrySet().stream()
                .flatMap(entry -> entry.getValue().stream()
                        .flatMap(friend -> friends.getOrDefault(friend, Collections.emptyList()).stream())
                        .filter(friend -> !friend.equals(entry.getKey()) && !entry.getValue().contains(friend))
                        .map(secFriend -> Set.of(entry.getKey(), secFriend)))
                .collect(Collectors.toSet());
    }

    public static Map<String, Double> averageSalaryByDep(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::department, Collectors.averagingDouble(Employee::salary)));
    }

    public static Set<Integer> palindromeNumbers(int lowEdge, int topEdge) {
        return IntStream.rangeClosed(lowEdge, topEdge)
                .filter(number -> isPalindrome(String.valueOf(number)))
                .boxed()
                .collect(Collectors.toSet());
    }

    public static List<String> subPalindrome(String string) {
        return IntStream.range(0, string.length())
                .boxed()
                .flatMap(index -> IntStream.range(index, string.length())
                        .boxed()
                        .map(endIndex -> string.substring(index, endIndex)))
                .filter(Service::isPalindrome)
                .toList();
    }

    public static Set<Integer> perfectNumbers(int lowEdge, int topEdge) {
        return IntStream.rangeClosed(lowEdge, topEdge)
                .boxed()
                .filter(number -> number.equals(IntStream.rangeClosed(1, (int) Math.sqrt(number))
                        .filter(devisor -> number % devisor == 0)
                        .flatMap(divisor -> IntStream.of(divisor, number / divisor))
                        .distinct()
                        .sum() - number))
                .collect(Collectors.toSet());
    }

    public static boolean isPalindrome(String string) {
        return string.contentEquals(new StringBuilder(string).reverse()) && !string.isBlank();
    }
}

