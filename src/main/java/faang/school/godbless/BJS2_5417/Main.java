package faang.school.godbless.BJS2_5417;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        System.out.println(getSumEvenNumbers(List.of(1, 2, 3, 4, 5, 6, 7)));
        System.out.println(getMax(List.of(1, 2, 3, 4, 5, 6, 7)));
        System.out.println(getAverage(List.of(1, 2, 3, 4, 5, 6, 7, 1)));
        System.out.println(getCountBeginsChar(List.of("start", "finish"), "d"));
        System.out.println(getCountBeginsSomeChar(List.of("start", "finish", "first", "fixing"), "fi"));
        System.out.println(filterListBySubstring(List.of("start", "finish", "first", "fixing"), "fi"));
        System.out.println(sortListStringByLength(List.of("apple", "potato", "elephant", "fish", "dog")));
        Predicate<String> predicate = (x) -> x.length() > 2;
        System.out.println(allMatch(List.of("apple", "potato", "elephant", "fish", "dog"), predicate));
        System.out.println(findShorterSting(List.of("apple", "potato", "elephant", "fish", "dog"), 4));
        System.out.println(convertListStingToLength(List.of("apple", "potato", "elephant", "fish", "dog")));


    }

    public static int getSumEvenNumbers(List<Integer> nums) {
        return nums.stream().filter(x -> x % 2 == 0).mapToInt(i -> i).sum();
    }

    public static int getMax(List<Integer> nums) {
        return nums.stream().mapToInt(i -> i).max().orElse(0);
    }

    public static Double getAverage(List<Integer> nums) {
        return nums.stream().mapToInt(i -> i).average().orElse(0.0);
    }

    public static int getCountBeginsChar(List<String> strs, String symbol) {
        return (int) strs.stream().map(String::toLowerCase).filter(s -> s.startsWith(symbol.toLowerCase())).count();
    }

    public static long getCountBeginsSomeChar(List<String> strs, String symbols) {
        return strs.stream().map(String::toLowerCase).filter(s -> s.startsWith(symbols.toLowerCase())).count();
    }

    public static List<String> filterListBySubstring(List<String> strs, String symbols) {
        return strs.stream().map(String::toLowerCase).filter(s -> s.startsWith(symbols.toLowerCase())).toList();
    }

    public static List<String> sortListStringByLength(List<String> strs) {
        return strs.stream().sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static boolean allMatch(List<String> strs, Predicate<String> predicate) {
        return strs.stream().allMatch(predicate);
    }

    public static String findShorterSting(List<String> strs, int num) {
        return strs.stream().filter(x -> x.length() > num).min(Comparator.comparingInt(String::length)).orElse("");
    }

    public static List<Integer> convertListStingToLength(List<String> strs) {
        return strs.stream().map(String::length).toList();
    }
}
