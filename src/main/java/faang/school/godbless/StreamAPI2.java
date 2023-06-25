package faang.school.godbless;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI2 {
    public Set<Pair<Integer>> findUniquePairs(List<Integer> nums, int targetSum) {
        return nums.stream().flatMap(
                num1 -> nums.stream()
                        .filter(num2 -> num1 + num2 == targetSum && !num1.equals(num2))
                        .map(num2 -> new Pair<Integer>(Integer.max(num2, num1), Integer.min(num2, num1)))
        ).collect(Collectors.toSet());
    }

    public record Pair<T>(T firstValue, T secondValue) {}

    public List<String> sortCountries(Map<String, String> counties) {
        return counties.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public List<String> sortStrings(List<String> words, char firstSymbol) {
        return words.stream()
                .filter(word -> !word.isBlank() && word.charAt(0) == firstSymbol)
                .sorted(Comparator.comparing(String::length)).toList();
    }
    // Задача меня победила, не ворк
    public Set<Pair<String>> findPossibleFriends(Map<String, List<String>> userFriends) {
        var possibleFriends = userFriends.entrySet().stream()
                .flatMap(entry1 -> userFriends.entrySet().stream()
                        .filter(entry2 -> !entry2.getKey().equals(entry1.getKey()))
                        .filter(entry2 -> !entry2.getValue().contains(entry1.getKey()))
                        .filter(entry2 -> !entry1.getValue().contains(entry2.getKey()))
                        .filter(entry2 -> entry1.getValue().stream().anyMatch(entry2.getValue()::contains))
                        .map(entry2 ->
                                entry2.getKey().compareTo(entry1.getKey()) > 0 ?
                                        new Pair<>(entry1.getKey(), entry2.getKey()) :
                                        new Pair<>(entry2.getKey(), entry1.getKey())
                        )
                ).collect(Collectors.toSet());
        return possibleFriends;
    }


    public Map<String, Double> calculateAvgSalary(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary))
                );
    }

    public List<String> stringFilter(List<String> strings, String alphabet) {
        List<String> alphabetList = Collections.singletonList(alphabet);
        return strings.stream()
                .filter(s -> s.matches("[" + alphabet + "]+"))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public List<String> intToString(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> Integer.toString(number, 2))
                .toList();
    }

    public List<Integer> getPalindromes(int start, int end) {
        var result = Stream.iterate(start, c -> c + 1)
                .limit(end - start + 1)
                .filter(
                        num -> Integer.toString(num).contentEquals(new StringBuilder(Integer.toString(num)).reverse())
                ).toList();
        return result;
    }
}
