package school.faang.streamapi1;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(Integer::intValue).sum();
    }

    public static int findMax(List<Integer> numbers) {
        Optional<Integer> maxNumber = numbers.stream().max(Comparator.naturalOrder());
        if (maxNumber.isPresent()) {
            return maxNumber.get();
        } else {
            throw new IllegalArgumentException("List is empty");
        }
    }

    public static double findAverage(List<Integer> numbers) {
        if (numbers != null && !numbers.isEmpty()) {
            return (numbers.stream().mapToInt(Integer::intValue).sum()) / (double) numbers.size();
        } else {
            throw new IllegalArgumentException("List is empty");
        }
    }

    public static int countStringsStartingWith(List<String> strings, char startChar) {
        return (int) strings.stream().filter(s -> s.startsWith(String.valueOf(startChar))).count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String subString) {
        return strings.stream().filter(s -> s.contains(subString)).collect(Collectors.toList());
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream().sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> condition) {
        if (numbers.stream().filter(condition).count() == numbers.size()) {
            return true;
        } else {
            return false;
        }
    }

    public static int findMinGreaterThan(List<Integer> numbers, int number) {
        Optional<Integer> minGreaterThan = numbers.stream().filter(n -> n > number).min(Comparator.naturalOrder());
        if (minGreaterThan.isPresent()) {
            return minGreaterThan.get();
        } else {
            throw new IllegalArgumentException("List is empty");
        }
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream().map(num -> num.length()).collect(Collectors.toList());
    }
}
