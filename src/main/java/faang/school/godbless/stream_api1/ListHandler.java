package faang.school.godbless.stream_api1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;

import static java.util.stream.Collectors.toList;

public class ListHandler {
    static int sumEven(List<Integer> nums) {
        return nums.stream().filter(n -> n % 2 == 0).mapToInt(Integer::intValue).sum();
    }

    static int findMax(List<Integer> nums) {

        return nums.stream().mapToInt(Integer::intValue).max().orElse(0);
    }

    static double findMean(List<Integer> nums) {
        return nums.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    static long findWords(List<String> strings, char character) {
        return strings.stream().filter(s -> s.charAt(0) == character).count();
    }
    //return
    static List<String> filter(List<String> strings, String string) {
        return strings.stream().filter(s -> s.contains(string)).toList();
    }

    static List<String> sortLength(List<String> strings) {
        return strings.stream().sorted(Comparator.comparing(String::length)).toList();
    }

    static <T> boolean allMatch(List<T> values, Predicate<T> condition) {
        return values.stream().allMatch(condition);
    }

    static OptionalInt findMinGreaterThen(List<Integer> nums, int value) {
        return nums.stream().filter(n -> n > value).mapToInt(Integer::intValue).min();
    }

    static List<Integer> getStringLength(List<String> strings) {
        return strings.stream().map(String::length).toList();
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 3, 5, 2);
        List<String> strings = List.of("auto", "uf", "auf");
        System.out.println(findMax(nums));
        System.out.println(sumEven(nums));
        System.out.println(findMean(nums));
        System.out.println(findWords(strings, 'a'));
        System.out.println(filter(strings, "uf"));
        System.out.println(sortLength(strings));
        System.out.println(allMatch(strings, (s -> s.contains("u"))));
        System.out.println(findMinGreaterThen(nums, 2).getAsInt());
        System.out.println(getStringLength(strings));
    }
}
