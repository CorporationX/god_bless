package school.faang.bjs2_88144;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Streams {
    private Streams() {}

    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream().filter((num) -> num % 2 == 0).reduce(0, Integer::sum);
    }

    public static int maxValue(List<Integer> numbers) {
        return numbers.stream().max(Comparator.comparingInt(a -> a)).orElse(0);
    }

    public static double avgValue(List<Integer> numbers) {
        return numbers.stream().mapToInt((num) -> num).average().orElse(0.0);
    }

    public static long strFilter(List<String> strings, char symbol) {
        return strings.stream().filter((str) -> str.startsWith(Character.toString(symbol))).toList().size();
    }

    public static List<String> filterList(List<String> strings, String str) {
        return strings.stream().filter((string) -> string.contains(str)).toList();
    }

    public static List<String> sortStringListByLength(List<String> strings) {
        return strings.stream().sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static boolean allMatch(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream().allMatch(predicate);
    }

    public static int minBiggerNum(List<Integer> numbers, int value) {
        return numbers.stream().filter((num) -> num > value).min(Comparator.comparingInt(num -> num)).orElse(0);
    }

    public static List<Integer> lengthList(List<String> strings) {
        return strings.stream().map(String::length).toList();
    }
}