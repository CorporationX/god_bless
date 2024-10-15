package school.faang.sprint_2.StreamAPI1;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(num -> num)
                .sum();
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream()
                .max((s1, s2) -> s1 - s2)
                .orElseThrow(() -> new IllegalStateException("Список пуст"));
    }

    public static int findAverage(List<Integer> numbers) {
        int sum = numbers.stream()
                .reduce((num1, num2) -> num1 + num2)
                .orElseThrow(() -> new IllegalStateException("Список пуст"));

        return sum / numbers.size();
    }

    public static int countStringsStartingWith(List<String> strings, char ch) {
        return (int) strings.stream()
                .filter(string -> !string.isEmpty() && string.charAt(0) == ch)
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(string -> string.contains(substring))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted((s1, s2) -> s1.length() - s2.length())
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream().
                allMatch(num -> predicate.test(num));
    }

    public static int findMinGreaterThan(List<Integer> numbers, int comparedNum) {
        return numbers.stream()
                .filter(num -> num > comparedNum)
                .min((n1, n2) -> n1 - n2)
                .orElseThrow(() -> new IllegalStateException("Список пуст"));
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream()
                .map(string -> string.length())
                .collect(Collectors.toList());
    }
}
