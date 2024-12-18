package school.faang.sprint2task47037;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ListOperations {
    private static <T> void checkNull(List<T> numbers, String message) {
        if (numbers == null) {
            throw new IllegalArgumentException(message);
        }
    }

    public static int sumOfEvenNumbers(List<Integer> numbers) {
        checkNull(numbers, "Number cannot be null");
        return numbers.stream().filter(k -> k % 2 == 0).mapToInt(Integer::intValue).sum();
    }

    public static int findMax(List<Integer> numbers) {
        checkNull(numbers, "Numbers list cannot be null");
        return numbers.stream().mapToInt(Integer::intValue).max()
                .orElseThrow(() -> new IllegalStateException("List is empty, cannot find max"));
    }

    public static double findAverage(List<Integer> numbers) {
        checkNull(numbers, "Numbers list cannot be null");
        return numbers.stream().mapToDouble(Integer::intValue).average()
                .orElseThrow(() -> new IllegalStateException("List is empty, cannot calculate average"));
    }

    public static int countStringsStartingWith(List<String> strings, char a) {
        checkNull(strings, "Strings list cannot be null");
        return (int) strings.stream().filter(k -> !k.isEmpty() && k.charAt(0) == a).count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String an) {
        checkNull(strings, "Strings list cannot be null");
        return strings.stream().filter(k -> k.contains(an)).toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        checkNull(strings, "Strings list cannot be null");
        return strings.stream().sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static Boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        checkNull(numbers, "Numbers list cannot be null");
        return numbers.stream().allMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int i) {
        checkNull(numbers, "Numbers list cannot be null");
        return numbers.stream().filter(k -> k > i).mapToInt(Integer::intValue).min()
                .orElseThrow(() -> new IllegalStateException("No elements greater than " + i));
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        checkNull(strings, "Strings list cannot be null");
        return strings.stream().map(String::length).toList();
    }
}