package school.faang.bjs2_80745;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream().filter(number -> number % 2 == 0).mapToInt(number -> number).sum();
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream().max(Integer::compareTo).get();
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream().mapToDouble(number -> number).sum() / numbers.size();
    }

    public static long countStringsStartingWith(List<String> strings, char firstChar) {
        return strings.stream().filter(string -> string.charAt(0) == firstChar).count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String substring) {
        return strings.stream().filter(string -> string.contains(substring)).collect(Collectors.toList());
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream().sorted(Comparator.comparing(s -> s.length())).collect(Collectors.toList());
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream().allMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int value) {
        return numbers.stream().filter(number -> number > value).findFirst().get();
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream().map(String::length).collect(Collectors.toList());
    }
}
