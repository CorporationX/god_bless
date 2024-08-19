package faang.school.godbless.BJS223038;

import java.util.List;

public class Main {

    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers
                .stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMaxElement(List<Integer> numbers) {
        return numbers
                .stream()
                .mapToInt(Integer::intValue)
                .max()
                .getAsInt();
    }

    public static double calculateAverage(List<Integer> numbers) {
        return numbers
                .stream()
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();
    }

    public static int countStringsStartingWith(List<String> strings, char c) {
        return (int) strings
                .stream()
                .filter(string -> string.startsWith(String.valueOf(c)))
                .count();
    }

    public static List<String> filterStringsBySubstring(List<String> strings, String substring) {
        return strings
                .stream()
                .filter(string -> string.contains(substring))
                .toList();
    }

    public static List<String> sortStringsByLength(List<String> strings) {
        return strings
                .stream()
                .sorted((s1, s2) -> Integer.compare(s1.length(), s2.length()))
                .toList();
    }

    public static boolean allElementsMatchCondition(List<Integer> numbers) {
        return numbers
                .stream()
                .allMatch(number -> number > 0);
    }

    public static int findSmallestGreaterThan(List<Integer> numbers, int threshold) {
        return numbers
                .stream()
                .filter(number -> number > threshold)
                .mapToInt(Integer::intValue)
                .min()
                .getAsInt();
    }

    public static List<Integer> convertStringsToLengths(List<String> strings) {
        return strings
                .stream()
                .map(String::length)
                .toList();
    }
}
