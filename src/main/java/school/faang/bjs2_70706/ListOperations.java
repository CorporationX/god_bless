package school.faang.bjs2_70706;

import lombok.experimental.UtilityClass;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Predicate;

@UtilityClass
public class ListOperations {
    /**
     * Метод принимает список чисел и возвращает сумму всех чётных чисел.
     */
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
            .filter(x -> x % 2 == 0)
            .reduce(0, Integer::sum);
    }

    /**
     * Метод принимает список чисел и возвращать максимальное значение.
     */
    public static int findMax(List<Integer> numbers) {
        return numbers.stream()
            .filter(Objects::nonNull)
            .max(Integer::compareTo)
            .orElseThrow(() -> new NoSuchElementException("Input list is empty"));
    }

    /**
     * Метод принимает список чисел и возвращать среднее арифметическое.
     */
    public static double findAverage(List<Integer> numbers) {
        return numbers.stream()
            .filter(Objects::nonNull)
            .mapToInt(Integer::intValue)
            .average()
            .orElse(Double.NaN);
    }

    /**
     * Метод принимает список строк и символ, возвращает количество строк, которые начинаются с символа,
     * указанного в параметре "startChar.
     */
    public static long countStringsStartingWith(List<String> words, char startChar) {
        return words.stream()
            .filter(Objects::nonNull)
            .filter(word -> !word.isEmpty() && word.charAt(0) == startChar)
            .count();
    }

    /**
     * Метод должен принимать список строк и подстроку, возвращать список строк, которые содержат подстроку,
     * указанную в параметре "searchString".
     */
    public static List<String> filterStringsContainingSubstring(List<String> words, String searchString) {
        return words.stream()
            .filter(Objects::nonNull)
            .filter(word -> word.contains(searchString))
            .toList();
    }

    /**
     * Метод должен принимать список строк и возвращать его отсортированным по длине строк.
     */
    public static List<String> sortByLength(List<String> words) {
        return words.stream()
            .sorted(Comparator.nullsFirst(Comparator.comparingInt(String::length)))
            .toList();
    }

    /**
     * Метод должен принимать список чисел и предикат, возвращать true, если все элементы
     * списка удовлетворяют условию.
     */
    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> match) {
        return numbers.stream()
            .allMatch(match);
    }

    /**
     * Метод должен принимать список чисел и значение, возвращать минимальное число из списка,
     * которое больше этого значения.
     * Например, для списка [10, 5, 20, 15, 3, 7] и порога 6, наименьший элемент, который больше 6, — это 7.
     */
    public static int findMinGreaterThan(List<Integer> numbers, int limit) {
        return numbers.stream()
            .filter(Objects::nonNull)
            .filter(number -> number > limit)
            .min(Integer::compareTo)
            .orElseThrow(
                () -> new NoSuchElementException("there are no numbers that are greater than %d".formatted(limit))
            );
    }

    /**
     * Метод должен принимать список строк и возвращать список целых чисел, представляющих длину каждой строки.
     */
    public static List<Integer> convertToLengths(List<String> words) {
        return words.stream()
            .map(word -> wordIsEmpty(word) ? 0 : word.length())
            .toList();
    }

    private static boolean wordIsEmpty(String word) {
        return word == null || word.isEmpty();
    }
}
