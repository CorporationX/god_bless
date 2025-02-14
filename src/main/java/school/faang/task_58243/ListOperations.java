package school.faang.task_58243;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return filterNonNull(numbers).stream().filter(number ->
                number % 2 == 0).mapToInt(number -> number).sum();
    }

    public static int findMax(List<Integer> numbers) {
        return filterNonNull(numbers).stream().max(Integer::compare).orElse(0);
    }

    public static double findAverage(List<Integer> numbers) {
        return filterNonNull(numbers).stream().mapToInt(Integer::intValue).average().orElse(0);
    }

    public static long countStringsStartingWith(List<String> words, char prefix) {
        return filterNonNull(words).stream().filter(string ->
                string.startsWith(Character.toString(prefix))).count();
    }

    private static  <T> List<T> filterNonNull(List<T> list) {
        if (list == null) {
            return Collections.emptyList();
        }
        return list.stream().filter(Objects::nonNull).toList();
    }
}
