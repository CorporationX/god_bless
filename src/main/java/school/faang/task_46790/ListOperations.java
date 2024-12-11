package school.faang.task_46790;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compareTo).orElse(0);
    }

    public static double findAverage(List<Integer> numbers) {
        return (double) numbers.stream()
                .reduce(0, Integer::sum) / numbers.size();
    }

    public static int countStringsStartingWith(List<String> strings, char symbol) {
        return strings.stream()
                .filter(str -> str.startsWith(Character.toString(symbol)))
                .toList()
                .size();
    }

    public static List<String> filterStringsContainingSubstring(String str, List<String> strings) {
        return strings.stream()
                .filter(currentStr -> currentStr.contains(str))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream().sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream().allMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int number) {
        return numbers.stream()
                .filter(currentNumber -> currentNumber > number)
                .min(Integer::compareTo).stream()
                .findFirst()
                .orElse(0);
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream().map(String::length).toList();
    }
}
