package school.faang.bjs2_80865;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream().reduce(0, Integer::sum);
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream()
                .max(Comparator.naturalOrder())
                .orElse(-1);
    }

    public static double findAverage(List<Integer> numbers) {
        return (double) sumOfEvenNumbers(numbers) / numbers.size();
    }

    public static long countStringsStartingWith(List<String> strings, char checkingForContainsChar) {
        return strings.stream()
                .filter(str -> str.startsWith(String.valueOf(checkingForContainsChar)))
                .toList()
                .size();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(str -> str.contains(String.valueOf(substring)))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted((str1, str2) -> str2.length() - str1.length())
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream().allMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int minNumb) {
        return numbers.stream()
                .filter(n -> n > minNumb)
                .sorted()
                .findFirst()
                .orElse(-1);
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream().map(String::length).toList();
    }
}
