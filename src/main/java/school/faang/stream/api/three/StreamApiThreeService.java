package school.faang.stream.api.three;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApiThreeService {
    public static List<Map<String, String>> findMutualFriends(Map<String, List<String>> peopleFriends) {
        return peopleFriends.entrySet().stream()
                .flatMap(person1 -> peopleFriends.entrySet().stream()
                        .filter(person2 -> !person1.getKey().equals(person2.getKey()))
                        .filter(person2 -> person1.getValue().stream().anyMatch(person2.getValue()::contains))
                        .map(person2 -> {
                            List<String> sortedPersons = Stream.of(person1.getKey(), person2.getKey())
                                    .sorted()
                                    .toList();
                            Map<String, String> pair = new HashMap<>();
                            pair.put(sortedPersons.get(0), sortedPersons.get(1));
                            return pair;
                        }))
                .distinct()
                .sorted(Comparator.comparing(map -> map.entrySet().iterator().next().getKey()))
                .collect(Collectors.toList());
    }

    public static Map<String, Double> findAverageSalary(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));

    }

    public static List<Integer> findNumbersPalindrome(Integer numberFrom, Integer numberTo) {
        return IntStream.rangeClosed(numberFrom, numberTo)
                .filter(number -> String.valueOf(number)
                        .equals(new StringBuilder(String.valueOf(number)).reverse().toString()))
                .boxed()
                .collect(Collectors.toList());
    }

    public static List<String> findStringPalindrome(String string) {
        return IntStream.range(0, string.length())
                .boxed()
                .flatMap(start -> IntStream.range(start + 1, string.length() + 1)
                        .mapToObj(end -> string.substring(start, end)))
                .filter(str -> str.equals(new StringBuilder(str).reverse().toString()))
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<Integer> findPerfectNumbers(Integer numberFrom, Integer numberTo) {
        return IntStream.rangeClosed(numberFrom, numberTo)
                .filter(number ->
                        number == IntStream.rangeClosed(1, number / 2)
                                .filter(i -> number % i == 0)
                                .sum())
                .boxed()
                .collect(Collectors.toList());
    }
}
