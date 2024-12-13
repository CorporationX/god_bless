package school.faang.task_46778;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListProcessor {
    private static final String EMPTY_FIELD_ERROR = "%s не может быть пустым";

    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return processList(numbers, "numbers", list ->
                list.stream()
                        .filter(n -> n % 2 == 0)
                        .mapToInt(Integer::intValue)
                        .sum());
    }

    public static int findMax(List<Integer> numbers) {
        return processList(numbers, "numbers", list ->
                list.stream()
                        .mapToInt(Integer::intValue)
                        .max()
                        .orElse(0));
    }

    public static double findAverage(List<Integer> numbers) {
        return processList(numbers, "numbers", list ->
                list.stream()
                        .mapToInt(Integer::intValue)
                        .average()
                        .orElse(0.0));
    }

    public static long countStringsStartingWith(List<String> strings, char ch) {
        return processList(strings, "strings", list ->
                list.stream()
                        .filter(string ->
                                !string.isEmpty() && string.charAt(0) == ch)
                        .count());
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings,
                                                                String substring) {
        return processList(strings, "strings", list ->
                list.stream()
                        .filter(string -> string.contains(substring))
                        .collect(Collectors.toList()));
    }

    public static List<String> sortByLength(List<String> strings) {
        return processList(strings, "strings", list ->
                list.stream()
                        .sorted(Comparator.comparing(String::length))
                        .collect(Collectors.toList()));
    }

    public static boolean allMatchCondition(List<Integer> numbers,
                                            Predicate<Integer> condition) {
        return processList(numbers, "numbers", list ->
                list.stream()
                        .allMatch(condition));
    }

    public static int findMinGreaterThan(List<Integer> numbers, int number) {
        return processList(numbers, "numbers", list ->
                list.stream()
                        .filter(n -> n > number)
                        .min(Integer::compareTo)
                        .orElseThrow(() ->
                                new NoSuchElementException(String.format("Нет элемента больше %s", number))));
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return processList(strings, "strings", list ->
                list.stream().map(String::length).toList());
    }

    private static <T, R> R processList(List<T> list,
                                        String listName,
                                        Function<List<T>, R> processor) {
        listCheck(list, listName);
        return processor.apply(list);
    }

    private static void listCheck(List<?> list, String listName) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException(String.format(EMPTY_FIELD_ERROR, listName));
        }
    }
}
