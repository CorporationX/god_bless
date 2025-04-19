package school.faang.bjs2_70739;

import lombok.experimental.UtilityClass;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

@UtilityClass
public class ListOperations {
    public int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num % 2 == 0)
                .reduce((a, b) -> a + b)
                .orElseThrow(() -> new IllegalArgumentException("List doesn't contain even numbers"));
    }

    public int findMaxNumber(List<Integer> numbers) {
        return numbers.stream()
                .max(Comparator.comparingInt(a -> a))
                .orElseThrow(() -> new IllegalArgumentException("List is empty"));
    }

    public double countAverageNumber(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(num -> num)
                .average()
                .orElseThrow(() -> new IllegalArgumentException("List is empty"));
    }

    public long countStringsStartWith(List<String> strings, char symbol) {
        return strings.stream()
                .filter(string -> string.charAt(0) == symbol)
                .count();
    }

    public List<String> stringContainsSubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(string -> string.contains(substring))
                .toList();
    }

    public List<String> sortStringsByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public boolean checkListOfIntegers(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream()
                .allMatch(predicate);
    }

    public int findFirstBiggerThanCondition(List<Integer> numbers, int condition) {
        return numbers.stream()
                .sorted()
                .filter(num -> num > condition)
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("List don't contains number bigger than %s".formatted(condition)));
    }

    public List<Integer> mapStringsIntoLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}