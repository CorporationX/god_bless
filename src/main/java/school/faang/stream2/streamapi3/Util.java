package school.faang.stream2.streamapi3;

import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Util {
    public static List<Set<String>> findNoFriendsWithCommon(Map<String, List<String>> socium) {
        return socium.entrySet().stream()
                .flatMap(entry -> {
                    Set<String> allPeople = new HashSet<>(socium.keySet());
                    allPeople.remove(entry.getKey());
                    entry.getValue().forEach(allPeople::remove);
                    return allPeople.stream()
                            .map(human -> Set.of(entry.getKey(), human));
                })
                .distinct()
                .filter(set -> {
                    List<String> pair = set.stream().toList();
                    return socium.get(pair.get(0)).stream()
                            .anyMatch(socium.get(pair.get(1))::contains);
                })
                .toList();
    }

    public static Map<String, Double> findAverageSalaryByDepartment(List<Employee> employees) {
        Map<String, List<Employee>> departments = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        return departments.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream()
                                .mapToInt(Employee::getSalary)
                                .average().orElse(0.0)
                        )
                );
    }

    public static List<Integer> findAllPalindromsInRange(int min, int max) {
        return IntStream.range(min, max)
                .filter(num -> {
                    String stringNum = String.valueOf(num);
                    return IntStream.range(0, stringNum.length() / 2)
                            .allMatch(i -> stringNum.charAt(i) == stringNum.charAt(stringNum.length() - 1 - i));
                })
                .boxed()
                .toList();
    }

    public static List<String> findAllPalindromsInString(String word) {
        return IntStream.range(0, word.length())
                .boxed()
                .flatMap(begin -> IntStream.range(begin + 1, word.length() + 1)
                        .mapToObj(end -> word.substring(begin, end))
                )
                .distinct()
                .filter(pal -> IntStream.range(0, pal.length() / 2)
                        .allMatch(i -> pal.charAt(i) == pal.charAt(pal.length() - 1 - i)))
                .toList();
    }

    public static List<Integer> findAllPerfectNumbersInRange(int start, int end) {
        if (start <= 0) {
            start = 1;
        }
        if (end < start) {
            end = start;
        }
        return IntStream.range(start, end)
                .boxed()
                .filter(integer ->
                        integer == IntStream.range(1, integer / 2 + 1)
                                .filter(delimiter -> integer % delimiter == 0)
                                .sum()
                ).toList();
    }


    @Data
    public static class Employee {
        private final String name;
        private final int salary;
        private final String department;
    }
}

