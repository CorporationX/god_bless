package school.faang.streams.streamApi1;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        checkingListForNull(numbers);
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int findMax(List<Integer> numbers) {
        checkingListForNull(numbers);
        return numbers.stream()
                .max(Integer::compare)
                .orElseThrow(() -> new IllegalArgumentException("List is empty"));
    }

    public static double findAverage(List<Integer> numbers) {
        checkingListForNull(numbers);
        return numbers.stream().collect(Collectors.averagingInt(n -> n));
    }

    public static int countStringsStartingWith(List<String> strings, char ch) {
        checkingListForNull(strings);
        return strings.stream()
                .filter(x -> x.charAt(0) == ch)
                .toList()
                .size();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String substring) {
        checkingListForNull(strings);
        return strings.stream()
                .filter(s -> s.contains(substring))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        checkingListForNull(strings);
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        checkingListForNull(numbers);
        return numbers.stream().allMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int num) {
        checkingListForNull(numbers);
        return numbers.stream()
                .filter(n -> n > num)
                .min(Integer::compare)
                .orElseThrow(() -> new IllegalArgumentException("List is empty"));
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        checkingListForNull(strings);
        return strings.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }

    private static <T> void checkingListForNull(List<T> list) {
        if (list == null) {
            throw new IllegalArgumentException("List cannot be null");
        }
    }
}
