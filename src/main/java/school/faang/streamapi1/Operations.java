package school.faang.streamapi1;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Operations {
    public static int sumEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int maxElement(List<Integer> numbers) {
        return numbers.stream()
                .max(Comparator.naturalOrder())
                .orElse(Integer.MIN_VALUE);
    }

    public static double averageValueNumbers(List<Integer> numbers) {
        return numbers.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);
    }

    public static long numbersLinesStartingCharacter(List<String> lines, char character) {
        return lines.stream()
                .filter(ch -> ch.startsWith(String.valueOf(character)))
                .count();
    }

    public static List<String> filterListRows(List<String> lines, String line) {
        return lines.stream()
                .filter(str -> str.contains(line))
                .toList();
    }

    public static List<String> sortLineStringsByLength(List<String> lines) {
        return lines.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean isListCondition(List<Integer> numbers, Predicate<Integer> filter) {
        return numbers.stream()
                .allMatch(filter);
    }

    public static int smallestItemThatLargerSpecified(List<Integer> numbers, int number) {
        return numbers.stream()
                .filter(num -> num > number)
                .min(Comparator.naturalOrder())
                .orElse(Integer.MIN_VALUE);
    }

    public static List<Integer> listStringsToTheirLengths(List<String> lines) {
        return lines.stream()
                .map(String::length)
                .toList();
    }
}
