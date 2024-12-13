package school.faang.sprint_2.task_bjs247136;

import lombok.experimental.UtilityClass;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

@UtilityClass
public class ListOperations {

    public int sumEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public int maxNumber(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("Empty list"));
    }

    public double averageNumber(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new NoSuchElementException("Empty list"));
    }

    public int countStringStartsWith(List<String> strings, char ch) {
        return (int) strings.stream()
                .filter(s -> !s.isEmpty() && s.charAt(0) == ch)
                .count();
    }

    public List<String> stringContains(List<String> strings, String toContain) {
        return strings.stream()
                .filter(string -> string.contains(toContain))
                .toList();
    }

    public List<String> orderByStringsLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> filter) {
        return numbers.stream()
                .allMatch(filter);
    }

    public int minNumberAboveBorder(List<Integer> numbers, int border) {
        return numbers.stream()
                .filter(number -> number > border)
                .min(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("No element above " + border));
    }

    public List<Integer> stringsToLength(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}
