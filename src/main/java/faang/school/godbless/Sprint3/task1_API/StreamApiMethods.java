package faang.school.godbless.Sprint3.task1_API;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class StreamApiMethods {

    public static Integer sumOfEvenNumbers(List<Integer> integerList) {
        return integerList.stream()
                .filter(x -> x % 2 == 0)
                .reduce(Integer::sum)
                .orElseThrow(() -> new IllegalArgumentException("Invalid parameters"));
    }

    public static Integer maxElem(List<Integer> integerList) {
        return integerList.stream()
                .max(Comparator.naturalOrder())
                .orElseThrow(() -> new IllegalArgumentException("Invalid parameters"));
    }

    public static Double avg(List<Integer> integerList) {
        return integerList.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElseThrow(() -> new IllegalArgumentException("Invalid parameters"));
    }

    public static long countLinesStartsWith(List<String> strings, Character symbol) {
        return strings.stream()
                .filter(line -> line.charAt(0) == symbol)
                .count();
    }

    public static List<String> containsSubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(string -> string.contains(substring))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparing(String::length).reversed())
                .toList();
    }

    public static <T> boolean matchElem(List<T> strings, Predicate<T> checker) {
        return strings.stream()
                .allMatch(checker);
    }

    public static Integer minElemAfterArg(List<Integer> integerList, Integer arg) {
        return integerList.stream()
                .filter(x -> x > arg)
                .min(Comparator.naturalOrder())
                .orElseThrow(() -> new IllegalArgumentException("Invalid parameters"));
    }

    public static List<Integer> convertStringsToLength(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}

