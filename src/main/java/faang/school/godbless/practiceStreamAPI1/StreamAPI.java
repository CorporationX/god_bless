package faang.school.godbless.practiceStreamAPI1;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;

import static java.util.stream.Collectors.toList;

public class StreamAPI {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(value -> value % 2 == 0)
                .reduce(Integer::sum).get();
    }

    public static OptionalInt findMaxValue(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue).max();
    }

    public static OptionalDouble findMediumValue(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue).average();
    }

    public static long findCountOfRows(List<String> rows) {
        return rows.stream()
                .filter(s -> s.startsWith("hello")).count();
    }

    public static long findCountOfRowsSecondSolution(List<String> rows, char chars) {
        return rows.stream()
                .filter(s -> s.charAt(0) == chars).count();
    }

    public static List<String> filterListOfRows(List<String> rows) {
        return rows.stream()
                .filter(s -> s.contains("hello")).toList();
    }

    public static List<String> filterListOfRowsSecondSolution(List<String> rows, String str) {
        return rows.stream()
                .filter(s -> s.contains(str)).toList();
    }

    public static List<String> sortListOfRowsByLength(List<String> rows) {
        return rows.stream()
                .sorted(Comparator.comparingInt(String::length)).toList();
    }



}
