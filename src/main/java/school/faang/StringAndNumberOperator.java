package school.faang;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class StringAndNumberOperator {
    public static int sumEvenNumbers(List<Integer> numbers) {
        int result = numbers.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(num -> num)
                .sum();
        return result;
    }

    public static int findMaxValue(List<Integer> numbers) {
        Optional<Integer> maxValue = numbers.stream()
                .max((num1, num2) -> num1 - num2);
        int result = maxValue.orElse(0);
        return result;
    }

    public static double findAverageValue(List<Integer> numbers) {
        int sum = numbers.stream()
                .mapToInt(num -> num)
                .sum();
        long count = numbers.stream()
                .count();
        return count == 0 ? 0.0 : (double) sum / count;
    }

    public static int findCountOfStrings(List<String> strings, char firstChar) {
        long result = strings.stream()
                .filter(str -> str.startsWith(String.valueOf(firstChar)))
                .count();
        return (int) result;
    }

    public static List<String> filterSubstring(List<String> strings, String substring) {
        List<String> containingSubstring = strings.stream()
                .filter(str -> str.contains(substring))
                .toList();
        return containingSubstring;
    }

    public static List<String> sortByLength(List<String> strings) {
        List<String> sortedByLength = strings.stream()
                .sorted((str1, str2) -> str1.length() - str2.length())
                .toList();
        return  sortedByLength;
    }

    public static boolean isSatisfying(List<Integer> numbers, Predicate<Integer> predicate) {
        boolean result = numbers.stream()
                .allMatch(predicate);
        return result;
    }

    public static int findSmallestGreaterThanGivenValue(List<Integer> numbers, int number) {
        Optional<Integer> minValue = numbers.stream()
                .filter(num -> num > number)
                .min((num1, num2) -> num1 - num2);
        int result = minValue.orElse(0);
        return result;
    }

    public static List<Integer> convertToListOfLengths(List<String> strings) {
        List<Integer> lengthsOfStrings = strings.stream()
                .map(String::length)
                .toList();
        return lengthsOfStrings;
    }
}
