package faang.school.godbless.stream_api1;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;

public class Main {
    public static int sumEven(List<Integer> nums) {
        return nums.stream().filter(n -> n % 2 == 0).mapToInt(Integer::intValue).sum();
    }

    public static int maxNum(List<Integer> nums) {
        return nums.stream().mapToInt(Integer::intValue).max().orElseThrow();
    }

    public static double averageNum(List<Integer> nums) {
        return nums.stream().mapToInt(Integer::intValue).average().orElseThrow();
    }

    public static long stringCount(List<String> strings, String symbol) {
        return strings.stream().filter(str -> str.startsWith(symbol)).count();
    }

    public static void getSubstring(List<String> strings, String substring) {
        strings.stream().filter(str -> str.contains(substring)).forEach((System.out::println));
    }

    public static void sortByLength(List<String> strings) {
        strings.stream().sorted(Comparator.comparingInt(String::length)).forEach(System.out::println);
    }

    public static boolean checkElement(List<String> strings) {
        return strings.stream().allMatch(str -> str.length() > 6);
    }

    public static OptionalInt getMinElement(List<Integer> nums, int a) {
        return nums.stream().filter(x -> x > a).mapToInt(Integer::intValue).min();
    }

    public static void stringsToLength(List<String> strings) {
        strings.stream().mapToInt(String::length).forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(3, 18, 11, 27);
        List<String> strings = List.of("Test", "TetsTest", "Tst", "T");
        System.out.println(sumEven(nums));
        System.out.println(maxNum(nums));
        System.out.println(averageNum(nums));
        System.out.println(stringCount(strings, "T"));
        getSubstring(strings, "Te");
        sortByLength(strings);
        System.out.println(checkElement(strings));
        System.out.println(getMinElement(nums, 11));
        stringsToLength(strings);
    }
}
