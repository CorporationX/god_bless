package school.faang.sprint1.task_47182;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(x -> x % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer:: compareTo)
                .orElseThrow(() -> new NoSuchElementException("Список пуст"));
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer:: intValue)
                .average()
                .orElseThrow(() -> new NoSuchElementException("Среднее значение не найдено так как список пуст"));
    }

    public static int countStringsStartingWith(List<String> strings, char symbol) {
        return (int) strings.stream()
                .filter((string) -> string.startsWith("a"))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(string -> string.contains(substring))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String:: length))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> filter) {
        return numbers.stream()
                .allMatch(filter);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int numb) {
        return numbers.stream()
                .filter(x -> x > numb)
                .min(Integer:: compareTo)
                .orElseThrow(() -> new NoSuchElementException("Нет чисел больше - " + numb));

    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream()
                .map(String:: length)
                .toList();
    }
}
