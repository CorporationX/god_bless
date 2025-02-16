package school.faang.BJS2_58325;

import lombok.NonNull;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class ListOperations {

    public static int sumOfEvenNumbers(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int findMax(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .max(Comparator.naturalOrder())
                .orElseThrow(() -> new IllegalArgumentException("List couldn't be empty!"));
    }

    public static double findAverage(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseGet(() -> {
                    System.out.println("List is empty, value by default: 0.0");
                    return 0.0;
                });
    }

    public static long countStringsStartingWith(List<String> strings, char a) {
        return Optional.ofNullable(strings)
                .map(list -> list.stream()
                        .filter(s -> s.startsWith(String.valueOf(a)))
                        .count())
                .orElseGet(() -> {
                    System.out.println("List is null, value by default: 0");
                    return 0L;
                });
    }

    public static List<String> filterStringsContainingSubstring(@NonNull List<String> strings, @NonNull String an) {
        return strings.stream()
                .filter(s -> s.contains(an))
                .toList();
    }

    public static List<String> sortByLength(@NonNull List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static boolean allMatchCondition(@NonNull List<Integer> numbers, @NonNull Predicate<Integer> predicate) {
        return numbers.stream()
                .allMatch(predicate);
    }

    public static int findMinGreaterThan(@NonNull List<Integer> numbers, int i) {
        return numbers.stream()
                .filter(n -> n > i)
                .min(Integer::compare)
                .orElseGet(() -> {
                    System.out.println("There is no such value, value by default: 0");
                    return 0;
                });
    }

    public static List<Integer> convertToLengths(@NonNull List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}
