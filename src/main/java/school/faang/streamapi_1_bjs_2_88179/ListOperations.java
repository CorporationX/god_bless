package school.faang.streamapi_1_bjs_2_88179;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ListOperations {
    public static int sumEvenNumbers(List<Integer> listnumbers) {
        return listnumbers.stream()
                .filter(number -> number % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int maxNumber(List<Integer> listnumbers) {
        return listnumbers.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("Пусто"));
    }

    public static double findAverage(List<Integer> listnumbers) {
        return listnumbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new NoSuchElementException("Пусто"));
    }

    public static long findCharStrings(List<String> liststrings, char c) {
        return liststrings.stream()
                .filter(s -> !s.isEmpty() && s.charAt(0) == c)
                .count();
    }

    public static List<String> findNeedStrings(List<String> liststrings, String s) {
        return liststrings.stream()
                .filter(st -> st.contains(s))
                .toList();

    }

    public static List<String> sortLength(List<String> liststrings) {
        return liststrings.stream()
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> listinteger, Predicate<Integer> condition) {
        return listinteger.stream()
                .allMatch(condition);
    }

    public static int findMinGreaterThan(List<Integer> listinteger, int i) {
        return listinteger.stream()
                .filter(x -> x > i)
                .min(Integer::compareTo)
                .orElse(0);
    }

    public static List<Integer> convertToLengths(List<String> liststrings) {
        return liststrings.stream()
                .map(String::length)
                .toList();
    }
}
