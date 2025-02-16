package school.faang.task58319;

import lombok.NonNull;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOperations {

    public static int sumOfEvenNumbers(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .filter(integer -> integer % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int findMax(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .max(Comparator.comparingInt(n -> n))
                .orElse(0);
    }

    public static double findAverage(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0d);
    }

    public static long countStringsStartingWith(@NonNull List<String> strings, char a) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(a)))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(@NonNull List<String> strings, @NonNull String an) {
        return strings.stream()
                .filter(s -> s.startsWith(an))
                .collect(Collectors.toList());
    }


    public static List<String> sortByLength(@NonNull List<String> strings) {
        return strings.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public static boolean allMatchCondition(@NonNull List<Integer> numbers, @NonNull Predicate<Integer> predicate) {
        return numbers.stream()
                .allMatch(predicate);
    }


    public static int findMinGreaterThan(@NonNull List<Integer> numbers, int i) {
        List<Integer> list = numbers.stream()
                .filter(n -> n > i)
                .sorted()
                .limit(1)
                .toList();
        return list.get(0);
    }

    public static List<Integer> convertToLengths(@NonNull List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}
