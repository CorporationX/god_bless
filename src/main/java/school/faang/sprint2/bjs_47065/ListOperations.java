package school.faang.sprint2.bjs_47065;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOperations {
    public static int sumEvenNumbers(List<Integer> list) {
        return list.stream()
                .filter(x -> x % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int maxNumber(List<Integer> list) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .max()
                .getAsInt();
    }

    public static double avgNumber(List<Integer> list) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();
    }

    public static int countStartsWithStrings(List<String> list, char symbol) {
        return (int) list.stream()
                .filter(x -> x.startsWith(String.valueOf(symbol)))
                .count();
    }

    public static List<String> filteredSubstrings(List<String> list, String substring) {
        return list.stream()
                .filter(x -> x.contains(substring))
                .collect(Collectors.toList());
    }

    public static List<String> sortedByLength(List<String> list) {
        return list.stream()
                .sorted(Comparator.comparingLong(String::length))
                .collect(Collectors.toList());
    }

    public static boolean isAllPositive(List<Integer> list, Predicate<Integer> predicate) {
        return list.stream()
                .allMatch(predicate);
    }

    public static int minValue(List<Integer> list, int number) {
        return list.stream()
                .filter(x -> x > number)
                .mapToInt(Integer::intValue)
                .min()
                .getAsInt();
    }

    public static List<Integer> convertListStringsToListLengths(List<String> list) {
        return list.stream()
                .map(x -> x.length())
                .collect(Collectors.toList());
    }
}
