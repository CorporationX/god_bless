package faang.school.godbless.sprint3.stream_api1;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Utils<T> {
    public static int sum(List<Integer> nums) {
        return nums.stream()
                .reduce(0, Integer::sum);
    }

    public static int max(List<Integer> nums) {
        return nums.stream()
                .max(Comparator.naturalOrder())
                .orElseThrow();
    }

    public static double average(List<Integer> nums) {
        return nums.stream()
                .mapToInt(e -> e)
                .average()
                .orElseThrow();
    }

    public static long getCountOfStringsStartingWithSpecificChar(List<String> stringList, char specific) {
        return stringList.stream()
                .filter(s -> s.startsWith(String.valueOf(specific)))
                .count();
    }

    public static List<String> getListContainingSpecificSubstring(List<String> stringList, String specific) {
        return stringList.stream()
                .filter(s -> s.contains(specific))
                .toList();
    }

    public static List<String> sortByLength(List<String> stringList) {
        return stringList.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static <T> boolean allMatch(List<T> elements, Predicate<T> condition) {
        return elements.stream()
                .allMatch(condition);
    }

    public static List<Integer> convertToLengths(List<String> stringList) {
        return stringList.stream()
                .map(String::length)
                .toList();
    }
}
