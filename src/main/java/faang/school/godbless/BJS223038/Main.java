package faang.school.godbless.BJS223038;

import java.util.List;

public class Main {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers
                .stream()
                .filter(number -> number % 2 == 0)
                .reduce(0, (sum, number) -> sum + number);
    }

    public static int findMaxElement(List<Integer> numbers) {
        List<Integer> order = numbers
                .stream()
                .sorted((n1, n2) -> n2 - n1)
                .toList();
        return order.get(0);
    }

    public static double calculateAverage(List<Integer> numbers) {
        double sum = numbers
                .stream()
                .reduce(0, (sumNumbers, number) -> sumNumbers + number);
        return sum / numbers.size();
    }

    public static int countStringsStartingWith(List<String> strings, char c) {
        return (int) strings
                .stream()
                .filter(string -> string.startsWith(c + ""))
                .count();
    }

    public static List<String> filterStringsBySubstring(List<String> strings, String substring) {
        return strings
                .stream()
                .filter(string -> string.contains(substring))
                .toList();
    }

    public static List<String> sortStringsByLength(List<String> strings, int size) {
        return strings
                .stream()
                .filter(string -> string.length() >= size)
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
