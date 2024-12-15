package school.faang.sprint_1.task_streamapi1bjs2n47048;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> listInteger) {
        return listInteger.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(Integer::intValue).sum();
    }

    public static int findMax(List<Integer> listInteger) {
        return listInteger.stream()
                .max(Integer::compare).get();
    }

    public static double findAverage(List<Integer> listInteger) {
        int sum = listInteger.stream()
                .mapToInt(Integer::intValue).sum();
        return (double) sum/listInteger.size();
    }

    public static int countStringsStartingWith(List<String> listInteger, char ch) {
        return (int)listInteger.stream()
                .filter(s -> s.startsWith(String.valueOf(ch)))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> listInteger, String startString) {
        return listInteger.stream()
                .filter(s -> s.contains(startString))
                .toList();
    }

    public static List<String> sortByLength(List<String> listInteger) {
        return listInteger.stream()
                .sorted(Comparator.comparing(String::length))
                .toList();
    }
}
