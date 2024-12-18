package school.faang.sprint_2.task_46746;

import school.faang.sprint_2.task_46228.Image;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ListOperations {

    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream()
                .max((a, b) -> a.compareTo(b))
                .orElseThrow(() -> new NoSuchElementException("Данный список - пустой"));
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(value -> value)
                .average()
                .orElseThrow(() -> new NoSuchElementException("Данный список - пустой"));
    }

    public static int countStringsStartingWith(List<String> strings, char ch) {
        return (int) strings.stream()
                .filter(string -> string.charAt(0) == ch)
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String string) {
        return strings.stream()
                .filter(s -> s.contains(string))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> integers, Predicate<Integer> predicate) {
        return integers.stream()
                .allMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> integers, int number) {
        return integers.stream()
                .filter(i -> i > number)
                .min(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("Нет чисел больше " + number));
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}
