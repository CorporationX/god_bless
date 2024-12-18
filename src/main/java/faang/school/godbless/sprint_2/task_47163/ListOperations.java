package faang.school.godbless.sprint_2.task_47163;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        checkCollectionForNull(numbers);
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int findMax(List<Integer> numbers) {
        checkCollectionForNull(numbers);
        return numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("Список не может быть пуст!"));
    }

    public static double findAverage(List<Integer> numbers) {
        checkCollectionForNull(numbers);
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public static int countStringsStartingWithCharacter(List<String> strings, char c) {
        checkCollectionForNull(strings);
        return (int) strings.stream()
                .filter(string -> string.startsWith(Character.toString(c)))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String substring) {
        checkCollectionForNull(strings);
        return strings.stream()
                .filter(string -> string.contains(substring))
                .toList();
    }

    public static List<String> sortStringsByLength(List<String> strings) {
        checkCollectionForNull(strings);
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> condition) {
        checkCollectionForNull(numbers);
        return numbers.stream()
                .allMatch(condition);
    }

    public static int findMinGreaterThanNumber(List<Integer> numbers, int number) {
        checkCollectionForNull(numbers);
        return numbers.stream()
                .filter(n -> n > number)
                .min(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("Элемента больше заданного числа не существует!"));
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        checkCollectionForNull(strings);
        return strings.stream().map(String::length).toList();
    }

    private static void checkCollectionForNull(Collection<?> collection) {
        if (collection == null) {
            throw new IllegalArgumentException("Коллекция не может быть null!");
        }
        if (collection.contains(null)) {
            throw new IllegalArgumentException("Коллекция не может содержать null!");
        }
    }
}
