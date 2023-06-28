package sprint3.stream.training.two;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamTrainer {
    public static Set<Pair> findPairNumbers(List<Integer> nums, int sum) {
        Set<Pair> pairs;
        Set<Integer> set = new HashSet<>(nums);
        pairs = nums.stream()
                .filter(num -> set.contains(sum - num))
                .map(num -> new Pair(num, sum - num))
                .collect(Collectors.toSet());
        return pairs;
    }

    public static void sortStringMapAndPrint(Map<String, String> countries) {
        countries.entrySet().stream()
                .sorted()
                .map(Map.Entry::getValue)
                .forEach(System.out::println);
    }

    public static List<String> sortStringsByFirstLetterAndLength(List<String> strings, char firstLetter) {
        return strings.stream()
                .filter(str -> str.charAt(0) == firstLetter)
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static Map<String, String> filterUsersByMutualFriends(Map<String, List<String>> users) {
        return null;
    }

    public static Map<String, Double> getAverageSalary(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.averagingInt(Employee::salary)
                ));
    }

    record Pair(int first, int second) {
    }

    record Employee(String name, int salary, String department) {
    }
}
