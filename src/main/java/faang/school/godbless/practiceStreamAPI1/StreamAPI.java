package faang.school.godbless.practiceStreamAPI1;

import java.util.*;
import java.util.function.Predicate;

public class StreamAPI {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(value -> value % 2 == 0)
                .reduce(Integer::sum).orElseThrow(IllegalArgumentException::new);
    }

    public static int findMaxValue(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("List is empty!"));
    }

    public static double findMediumValue(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new IllegalArgumentException("List is empty!"));
    }

    public static long findCountOfRows(List<String> rows) {
        return rows.stream()
                .filter(s -> s.startsWith("hello")).count();
    }

    public static List<String> filterListOfRows(List<String> rows) {
        return rows.stream()
                .filter(s -> s.contains("hello")).toList();
    }

    public static List<String> sortListOfRowsByLength(List<String> rows) {
        return rows.stream()
                .sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static boolean checkAllElements(List<Integer> elements, Predicate<Integer> predicate) {
        return elements.stream().allMatch(predicate);
    }


    public static int findMinIntThanValue(List<Integer> elements, int number) {
        return elements.stream()
                .filter(e -> e > 4).min(Integer::compareTo).orElseThrow();
    }

    public static List<Integer> convertStringToLength(List<String> strings) {
        return strings.stream()
                .map(String::length).toList();
    }

}
