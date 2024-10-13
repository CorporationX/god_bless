package faang.school.godbless.streamapi.streamapi1;

import lombok.NonNull;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ListUtility {
    private ListUtility() {
    }

    public static int sumEvenNumbers(@NonNull List<Integer> numbers) {
        return numbers.stream().filter(n -> n != null && n % 2 == 0).reduce(0, Integer::sum);
    }

    public static int findMax(@NonNull List<Integer> numbers) {
        return numbers.stream().max(Integer::compareTo).orElseThrow();
    }

    public static double findAvg(@NonNull List<Integer> numbers) {
        return numbers.stream().mapToDouble(Integer::doubleValue).average().orElse(0);
    }

    public static int countStringStartWith(@NonNull List<String> strings, char symbol) {
        return (int) strings.stream().filter(s -> s != null && s.length() > 1 && s.charAt(0) == symbol).count();
    }

    public static List<String> filterStringsContainsSubstring(@NonNull List<String> strings, @NonNull String substring) {
        return strings.stream().filter(s -> s != null && s.contains(substring)).toList();
    }

    public static List<String> sortByLength(@NonNull List<String> strings) {
        return strings.stream().sorted(Comparator.comparingInt(s -> s != null ? s.length() : -1)).toList();
    }

    public static boolean allMatchCondition(@NonNull List<Integer> numbers, Predicate<Integer> condition) {
        return numbers.stream().allMatch(condition);
    }

    public static int findMinNumberGreaterThan(@NonNull List<Integer> numbers, int borderNumber) {
        return numbers.stream().filter(n -> n != null && n > borderNumber).min(Integer::compareTo).orElseThrow();
    }

    public static List<Integer> stringsToLengths(@NonNull List<String> strings) {
        return strings.stream().map(s -> s == null ? null : s.length()).toList();
    }
}
