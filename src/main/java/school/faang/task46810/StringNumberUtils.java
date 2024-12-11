package school.faang.task46810;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class StringNumberUtils {
    private static Logger logger = LoggerFactory.getLogger(StringNumberUtils.class);

    private static <T> void validateList(List<T> list) {
        if (list == null) {
            throw new IllegalArgumentException("Список не должен быть null");
        }
    }

    public static int sumEvenNumbers(List<Integer> numbers) {
        validateList(numbers);

        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMaxNumber(List<Integer> numbers) {
        try {
            validateList(numbers);

            return numbers.stream()
                    .max(Integer::compareTo)
                    .orElseThrow(() -> new NoSuchElementException("Список пуст"));
        } catch (NoSuchElementException e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    public static double findAverage(List<Integer> numbers) {
        try {
            validateList(numbers);

            return numbers.stream()
                    .mapToDouble(Integer::doubleValue)
                    .average()
                    .orElseThrow(() -> new NoSuchElementException("Список пуст"));
        } catch (NoSuchElementException e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    public static int countStringWithChar(List<String> stringList, char character) {
        validateList(stringList);

        return (int) stringList.stream()
                .filter(string -> !string.isBlank() && string.charAt(0) == character)
                .count();
    }

    public static List<String> stringContainsSubstring(List<String> stringList, String substring) {
        validateList(stringList);
        if (substring == null || substring.isBlank()) {
            throw new IllegalArgumentException("substring не может быть пустым или null");
        }

        return stringList.stream()
                .filter(string -> string.contains(substring))
                .toList();
    }

    public static List<String> sortStringByLength(List<String> stringList) {
        validateList(stringList);

        return stringList.stream()
                .sorted((string1, string2) -> string2.length() - string1.length())
                .toList();
    }

    public static boolean isPredicateNumbers(List<Integer> numbers, Predicate<Integer> predicate) {
        validateList(numbers);
        if (predicate == null) {
            throw new IllegalArgumentException("Predicate не может быть null");
        }

        return numbers.stream()
                .allMatch(predicate);
    }

    public static int findMinNumberMoreSpecifiedNumber(List<Integer> numbers, int specifiedNumber) {
        validateList(numbers);

        return numbers.stream()
                .filter(number -> number > specifiedNumber)
                .min(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("Список пуст"));
    }

    public static List<Integer> convertListStringsToListLength(List<String> stringList) {
        validateList(stringList);

        return stringList.stream()
                .map(String::length)
                .toList();
    }
}
