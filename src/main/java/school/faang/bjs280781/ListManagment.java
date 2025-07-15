package school.faang.bjs280781;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListManagment {
    public static int sumOfEvenNambers(List<Integer> list) {
        return list.stream()
                .filter(number -> number % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int maxNumber(List<Integer> list) {
        return list.stream()
                .max(Comparator.naturalOrder())
                .orElseThrow(() -> new IllegalArgumentException("Список пуст"));
    }

    public static double averageValue(List<Integer> list) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new IllegalArgumentException("Список пуст"));
    }

    public static long linesWithTheSameBeginning(List<String> list, char checkCharacter) {
        return list.stream()
                .filter(string -> string.charAt(0) == checkCharacter)
                .count();
    }

    public static List<String> wordStringFilter(List<String> list, String filterWord) {
        return list.stream()
                .filter(string -> string.contains(filterWord))
                .collect(Collectors.toList());
    }

    public static List<String> sortByStringLength(List<String> list) {
        return list.stream()
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static boolean customConditionCheck(List<Integer> list, Predicate<Integer> customCheck) {
        return list.stream()
                .allMatch(string -> customCheck.test(string));
    }

    public static int findMinGreaterThan(List<Integer> list, int number) {
        return list.stream()
                .filter(num -> num > number)
                .min(Comparator.naturalOrder())
                .orElseThrow();
    }

    public static List<Integer> convertToLengths(List<String> list) {
        return list.stream()
                .map(String::length)
                .toList();
    }
}
