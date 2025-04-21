package school.faang.sprinttwo.streamapi1;

import lombok.experimental.UtilityClass;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

@UtilityClass
public class ListOperations {
    public int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(i -> i)
                .sum();
    }

    public int findMax(List<Integer> numbers) {
        return numbers.stream()
                .max(Comparator.naturalOrder())
                .orElseThrow(() -> new IllegalArgumentException("List cannot be empty"));
    }

    public double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToDouble(i -> i)
                .average()
                .orElseThrow(() -> new IllegalArgumentException("List cannot be empty"));
    }

    public long countStringsStartingWith(List<String> strings, char ch) {
        return strings.stream()
                .filter(w -> w.startsWith(Character.toString(ch)))
                .count();
    }

    public List<String> filterStringsContainingSubstring(List<String> strings, String str) {
        return strings.stream()
                .filter(w -> w.contains(str))
                .toList();
    }

    public List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> test) {
        return numbers.stream()
                .allMatch(test);
    }

    public Integer findMinGreaterThan(List<Integer> numbers, int number) {
        return numbers.stream()
                .sorted(Comparator.naturalOrder())
                .filter(digits -> digits > number)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("List cannot be empty"));
    }

    public List<Integer> convertToLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}