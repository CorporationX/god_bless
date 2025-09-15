package school.faang.bjs2_88282;

import lombok.NonNull;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ListOperations {
    public static int countEvenNumbersSum(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int maxNumber(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow(() -> new NoSuchElementException("Невозможно найти максимальное число"));
    }

    public static double averageValue(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new NoSuchElementException("Невозможно посчитать среднее значение."));
    }

    public static long countStringsStartWithSymbol(@NonNull List<String> strings, char symbol) {
        return strings.stream()
                .filter(letter -> letter.startsWith(String.valueOf(symbol)))
                .count();
    }

    public static List<String> selectStringsWithSubstring(
            @NonNull List<String> strings, @NonNull String substring) {
        return strings.stream()
                .filter(text -> text.contains(substring))
                .toList();
    }

    public static List<String> sortByLength(@NonNull List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean checkCondition(
            @NonNull List<Integer> numbers, @NonNull Predicate<Integer> predicate) {
        return numbers.stream()
                .allMatch(predicate);
    }

    public static int findMinSatisfyCondition(@NonNull List<Integer> numbers, int conditionNumber) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .filter(x -> x > conditionNumber)
                .min()
                .orElseThrow(() -> new NoSuchElementException("Невозможно найти минимальное число"));
    }

    public static List<Integer> convertListStringToListLength(@NonNull List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}
