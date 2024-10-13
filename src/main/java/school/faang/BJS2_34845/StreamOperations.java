package school.faang.BJS2_34845;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOperations {
    public static List<Map<Person, Person>> findPeopleWithMutualFriends(Map<Person, List<Person>> peopleWithFriends) {
        return peopleWithFriends.entrySet().stream()
                .flatMap(person1 -> peopleWithFriends.entrySet().stream()
                        .filter(person2 -> !person1.getKey().equals(person2.getKey()))
                        .filter(person2 -> person1.getValue().stream().anyMatch(person2.getValue()::contains))
                        .map(person2 -> {
                            List<Person> sortedPersons = Stream.of(person1.getKey(), person2.getKey())
                                    .sorted()
                                    .toList();
                            Map<Person, Person> pair = new HashMap<>();
                            pair.put(sortedPersons.get(0), sortedPersons.get(1));
                            return pair;
                        }))
                .distinct()
                .sorted(Comparator.comparing(map -> map.entrySet().iterator().next().getKey()))
                .toList();
    }

    public static Map<String, Double> findAverageSalaryBYDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.averagingDouble(Employee::getSalary)
                        )
                );
    }

    public static List<Integer> findPalindromeNumbers(Integer numbersFrom, Integer numbersTo) {
        return IntStream.rangeClosed(numbersFrom, numbersTo)
                .filter(number ->
                        Integer.toString(number)
                                .contentEquals(new StringBuilder(Integer.toString(number))
                                        .reverse()))
                .boxed()
                .toList();
    }

    public static List<String> findPalindromeSubstrings(String string) {
        return IntStream.range(0, string.length())
                .boxed()
                .flatMap(start -> IntStream.range(start + 1, string.length() + 1)
                        .mapToObj(end -> string.substring(start, end)))
                .filter(str -> str.contentEquals(new StringBuilder(str).reverse()))
                .distinct()
                .toList();
    }

    public static List<Integer> findPerfectNumbers(Integer numbersFrom, Integer numbersTo) {
        return IntStream.rangeClosed(numbersFrom, numbersTo)
                .filter(number ->
                        number == IntStream.rangeClosed(1, number / 2)
                                .filter(divider -> number % divider == 0)
                                .sum())
                .boxed()
                .toList();
    }
}
