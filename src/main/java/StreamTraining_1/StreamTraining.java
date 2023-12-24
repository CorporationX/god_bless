package StreamTraining_1;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.OptionalDouble;
import java.util.function.Predicate;

public class StreamTraining {

    public static int sumOdd(List<Integer> list) {
        return list.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int max(List<Integer> list) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow(()-> new IllegalArgumentException());
    }

    public static double average(List<Integer> list) {
        return list.stream()
                .mapToInt(n -> n).average()
                .orElseThrow(()->new IllegalArgumentException());
    }

    public static long countString(List<String> list, char symbol) {
        return (int) list.stream()
                .filter(n -> n.startsWith(String.valueOf(symbol)))
                .count();
    }

    public static List<String> stringFilter(List<String> list, String string) {
        return list.stream()
                .filter(n -> n.contains(string))
                .toList();
    }

    public static List<String> stringSorter(List<String> list) {
        return list.stream()
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static boolean check(List<String> list, Predicate<? super String> predicate) {
        return list.stream()
                .allMatch(predicate);
    }

    public static int min(List<Integer> list, int border) {
        return list.stream()
                .filter(n -> n > border)
                .mapToInt(Integer::intValue)
                .min()
                .orElseThrow(()->new IllegalArgumentException());
    }

    public static List<Integer> stringForLength(List<String> list) {
        return list.stream()
                .map(String::length)
                .toList();
    }
}
