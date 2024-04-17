package faang.school.godbless.stream_one;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Source list of numbers: " + numbers);
        System.out.println("Sum of even numbers: " + sumOfEven(numbers));
        System.out.println("Max element in list: " + max(numbers));
        System.out.println("Average value in list: " + average(numbers));

        Predicate<Integer> predicate = n -> n >= 0;
        List<Integer> nums_2 = List.of(-1, 2, 3, 5);
        System.out.println("All number of list is positive: " + isMatch(numbers, predicate));
        System.out.println("All number of another list is positive: " + isMatch(nums_2, predicate));

        System.out.println("Smallest element of list numbers greater than number: "
                + isMinNumGreaterThenTemplate(numbers, 3));

        List<String> words = List.of("one", "two", "free", "zero", "seven");
        System.out.println("Source list of words: " + words);
        System.out.println("Occurrences of words according to a given pattern: "
                + findStartsWith(words, "o"));
        System.out.println("Filtered by template list of strings :"
                + filterByTemplate(words, "ee"));
        System.out.println("Sorted by length list words: " + sortByLength(words));
        System.out.println("converted list of strings to lengths: " + convertStrToListLenStr(words));
    }

    public static Integer sumOfEven(List<Integer> nums) {
        return nums.stream()
                .filter(index -> index % 2 == 0)
                .mapToInt(i -> i)
                .sum();
    }

    public static Integer max(List<Integer> nums) {
        return nums.stream()
                .reduce(0, Integer::max);
    }

    public static Double average(List<Integer> nums) {
        return nums.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);
    }

    public static Long findStartsWith(List<String> words, String template) {
        return words.stream()
                .filter(str -> str.startsWith(template)).count();
    }

    public static List<String> filterByTemplate(List<String> words, String template) {
        return words.stream()
                .filter(value -> value.contains(template))
                .toList();
    }

    public static List<String> sortByLength(List<String> words) {
        return words.stream()
                .sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static Boolean isMatch(List<Integer> nums, Predicate<Integer> predicate) {
        return nums.stream()
                .allMatch(predicate::test);
    }

    public static Integer isMinNumGreaterThenTemplate(List<Integer> nums, int template) {
        return nums.stream()
                .filter(i -> i > template)
                .min(Comparator.naturalOrder()).orElse(null);
    }

    public static List<Integer> convertStrToListLenStr(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}
