package faang.school.godbless.strqmApiFirst;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Predicate;

public class StreamApiExamples {
    public static int sum(List<Integer> nums) {
        return nums
                .stream()
                .filter(n -> n % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static Optional<Integer> max(List<Integer> nums) {
        return nums
                .stream()
                .max(Integer::compare);
    }

    public static OptionalDouble average(List<Integer> nums) {
        return nums
                .stream()
                .mapToInt(i -> i)
                .average();
    }

    public static long countStringsStartingWith(List<String> strings, String prefix) {
        return strings
                .stream()
                .filter(i -> i.startsWith(prefix))
                .count();
    }

    public static List<String> containSubstr(List<String> strings, String substr) {
        return strings
                .stream()
                .filter(i -> i.contains(substr))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings
                .stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static <T> boolean checkAllElements(List<T> list, Predicate<T> predicate) {
        return list
                .stream()
                .allMatch(predicate);
    }

    public static Optional<Integer> findMinGreaterThan(List<Integer> nums, int number) {
        return nums
                .stream()
                .filter(i -> i > number)
                .min(Integer::compare);
    }

    public static List<Integer> stringListToLengthList(List<String> strings) {
        return strings
                .stream()
                .map(String::length)
                .toList();
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(-3, -2, -1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //28
        System.out.println("Sum: " + sum(nums));
        //10
        System.out.println("Max: " + max(nums));
        //3.76923
        System.out.println("Average: " + average(nums));

        List<String> strings = List.of("hello", "world", "java", "programming", "streams", "strings");

        //2
        System.out.println("Number of strings starting with s: " + countStringsStartingWith(strings, "s"));
        //streams, strings
        System.out.println("Strings containing substring str: " + containSubstr(strings, "str"));
        System.out.println("Strings sorted by length: " + sortByLength(strings));

        //false
        System.out.println("All numbers in nums are positive: " + checkAllElements(nums, i -> i > 0));
        //true
        System.out.println("All numbers in nums are greater than -4: " + checkAllElements(nums, i -> i > -4));
        //3
        System.out.println("Min in nums greater than 2: " + findMinGreaterThan(nums, 2));
        System.out.println("Lengths of strings: " + stringListToLengthList(strings));
    }
}
