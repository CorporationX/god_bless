package school.faang.lets_practice_streamAPI_1.BJS2_58330;

import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Predicate;

public class ListOperations {
    private static final Logger LOGGER = LoggerFactory.getLogger(ListOperations.class);

    public static int sumOfEvenNumbers(@NonNull List<Integer> list) {
        validateListIsEmpty(list);

        return list.stream().filter(integer -> integer % 2 == 0).mapToInt(integer -> integer).sum();
    }

    public static int findMax(@NonNull List<Integer> list) {
        validateListIsEmpty(list);

        return list.stream()
                .max(Integer::compare)
                .orElseThrow(() -> new RuntimeException("Max element is less than 0"));
    }

    public static double findAverage(@NonNull List<Integer> list) {
        validateListIsEmpty(list);

        OptionalDouble average = list.stream().mapToInt(Integer::intValue).average();
        if (average.isEmpty()) {
            throw new IllegalArgumentException("Невозможно вычислить среднее значение: список пустой");
        }
        return average.getAsDouble();
    }

    public static long countStringsStartingWith(@NonNull List<String> list, char ch) {
        validateListIsEmpty(list);

        return list.stream().filter(string -> string.startsWith(String.valueOf(ch))).count();
    }

    public static List<String> filterStringsContainingSubstring(
            @NonNull List<String> list, @NonNull String substring) {
        validateListIsEmpty(list);

        return list.stream()
                .filter(string -> string.contains(substring))
                .toList();
    }

    public static List<String> sortByLength(@NonNull List<String> list) {
        validateListIsEmpty(list);

        return list.stream()
                .sorted((Comparator.comparingInt(String::length)).reversed()).toList();
    }

    public static boolean allMatchCondition(
            @NonNull List<Integer> list, @NonNull Predicate<Integer> predicate) {
        validateListIsEmpty(list);

        return list.stream().allMatch(predicate);
    }

    public static int findMinGreaterThan(@NonNull List<Integer> list, int value) {
        validateListIsEmpty(list);

        return list.stream()
                .filter(integer -> integer > value)
                .min(Integer::compare)
                .orElseThrow(() -> new RuntimeException("Min element is greater than 0"));
    }

    public static List<Integer> convertToLengths(@NonNull List<String> list) {
        validateListIsEmpty(list);

        return list.stream().map(String::length).toList();
    }

    private static <T> void validateListIsEmpty(List<T> list) {
        if (list.isEmpty()) {
            LOGGER.error("List is empty");
            throw new IllegalArgumentException("List is empty");
        }
    }
}
