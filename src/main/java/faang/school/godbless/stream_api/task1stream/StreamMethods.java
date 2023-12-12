package faang.school.godbless.stream_api.task1stream;

import java.util.List;

public class StreamMethods {
    public static int chetNumber(List<Integer> numbers) {
        return numbers.stream().
                filter((num) -> num % 2 == 0).
                mapToInt(Integer::intValue).
                sum();
    }

    public static int maxNumber(List<Integer> numbers) {
        return numbers.stream().
                max(Integer::compareTo).
                orElseThrow(() -> new IllegalArgumentException("Список пуст"));
    }

    public static double averageNumber(List<Integer> numbers) {
        return numbers.stream().
                mapToInt(Integer::intValue).
                average().
                orElseThrow(() -> new IllegalArgumentException("Список пуст"));
    }

    public static long countStartStr(List<String> strings, char symbol) {
        return strings.stream().
                filter(str -> str.startsWith(String.valueOf(symbol))).
                count();
    }

    public static List<String> countContainsStr(List<String> strings, String strParam) {
        return strings.stream().
                filter(str -> (str.contains(strParam))).
                toList();
    }

    public static List<String> sortStr(List<String> strings) {
        return strings.stream().
                sorted((str1, str2) -> str1.length() - str2.length()).
                toList();
    }

    public static boolean containsStrAll(List<String> strings, String strParam) {
        return strings.stream().
                allMatch(str -> str.contains(strParam));
    }

    public static int findMinNumber(List<Integer> numbers, int numParam) {
        return numbers.stream().
                filter(num -> num > numParam).
                min(Integer::compareTo).
                orElseThrow(() -> new IllegalArgumentException("Не нашлось такого числа"));
    }

    public static List<Integer> convertStrInLength(List<String> strings) {
        return strings.stream().
                map(String::length).
                toList();
    }
}
