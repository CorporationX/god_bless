package StreamAPIOne;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    // Вопрос, мог бы я тут все методы обернуть в Optional? Чтобы не проверять на null?
    public static int findMaxNumber(List<Integer> numbers) {
        return  numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("Пустой список"));
    }

    public static double findAverageNumber(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average().orElseThrow(() -> new NoSuchElementException("Пустой список"));
    }

    public static long numberOfLines(List<String> strings, char c) {
        return strings.stream()
                .filter(s -> s != null && !s.isEmpty() && s.charAt(0) == c)
                .count();
    }

    public static List<String> stringFilter(List<String> strings, String substring) {
        return strings.stream()
                .filter(s -> s.contains(substring))
                .toList();
    }

    public static List<String> sortedList(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean satisfactionOfCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream()
                .allMatch(predicate);
    }

    public static int findMinNumber(List<Integer> numbers, int value) {
        return numbers.stream()
                .filter(n -> n > value)
                .min(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("Пустой список"));
    }

    public static List<Integer> stringLength(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}
