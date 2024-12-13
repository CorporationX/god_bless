package school.faang.sprint_2.task_46860;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOperations {

    public static List<List<String>> getCrossFriends(Map<String, List<String>> peopleWithFriends) {
        return peopleWithFriends.entrySet()
                .stream()
                .flatMap(person1 -> peopleWithFriends.entrySet()
                        .stream()
                        .filter(person2 -> {
                            if (person1.getKey().equals(person2.getKey())) {
                                return false;
                            }
                            if (person1.getValue().contains(person2.getKey())) {
                                return false;
                            }
                            HashSet<String> commonFriends = new HashSet<>(person1.getValue());
                            commonFriends.addAll(person2.getValue());
                            return !commonFriends.isEmpty();
                        })
                        .map(person2 -> Arrays.asList(person1.getKey(), person2.getKey()))
                        .map(list -> list.stream()
                                .sorted()
                                .toList()))
                .distinct()
                .toList();
    }

    public static Map<String, Double> getAverageSalaryInDepartments(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::department))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> {
                    BigDecimal amountOfEmployeesInDepartment = BigDecimal.valueOf(entry.getValue()
                            .size());
                    BigDecimal sumOfDepartmentSalary = BigDecimal.valueOf(entry.getValue()
                            .stream()
                            .mapToDouble(Employee::salary)
                            .sum());

                    return sumOfDepartmentSalary.divide(amountOfEmployeesInDepartment, 2, RoundingMode.HALF_UP)
                            .doubleValue();
                }));
    }

    public static List<Integer> findPalindromes(int from, int to) {
        return Stream.iterate(from, i -> i + 1)
                .limit(to)
                .filter(integer -> integer.equals(
                        Integer.valueOf(new StringBuilder(integer.toString())
                                .reverse()
                                .toString())))
                .toList();
    }

    public static List<String> findSubStringPalindromes(String string) {
        char[] chars = string.toCharArray();
        List<String> allSubStrings = new ArrayList<>();
        StringBuilder supportBuilder;

        for (int i = 0; i < chars.length; i++) {
            supportBuilder = new StringBuilder();
            for (int j = i; j < chars.length; j++) {
                supportBuilder.append(chars[j]);
                allSubStrings.add(supportBuilder.toString());
            }
        }

        return allSubStrings.stream()
                .filter(subString -> subString.contentEquals(new StringBuilder(subString).reverse()))
                .distinct()
                .toList();
    }

    public static List<Integer> findPerfectNumbers(int from, int to) {
        return IntStream.rangeClosed(from, to)
                .filter(number -> {
                    if (number <= 1) {
                        return false;
                    }
                    int sumOfDivisors = IntStream.range(1, number)
                            .filter(divisor -> number % divisor == 0)
                            .sum();
                    return sumOfDivisors == number;
                })
                .boxed()
                .toList();
    }
}
