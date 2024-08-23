package faang.school.godbless.streamapi.streamapitrainone;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> words = List.of("Hello", "Bonjour", "Hi", "Cat", "Bingo", "Hurricane", "HelloWorld");

        System.out.println(getSumOfEvens(nums));
        System.out.println(getMax(nums));
        System.out.println(getAverage(nums));
        System.out.println(getStringsStartsWithPattern(words, "He"));
        System.out.println(getFilterdList(words, "a"));
        System.out.println(getListSortedByStringLength(words));
        System.out.println(isAllElementsMatchCondition(words, word -> word.length() > 1));
        System.out.println(getMinElementGreaterThan(nums, 3));
        System.out.println(getStringLengths(words));
    }

    public static int getSumOfEvens(List<Integer> nums) {
        return nums.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int getMax(List<Integer> nums) {
        return nums.stream()
                .max(Integer::compareTo)
                .orElseThrow();
    }

    public static double getAverage(List<Integer> nums) {
        return nums.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow();
    }

    public static long getStringsStartsWithPattern(List<String> lines, String pattern) {
        return lines.stream()
                .filter(line -> line.startsWith(pattern))
                .count();
    }

    public static List<String> getFilterdList(List<String> lines, String substring) {
        return lines.stream()
                .filter(line -> line.contains(substring))
                .toList();
    }

    public static List<String> getListSortedByStringLength(List<String> lines) {
        return lines.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static <T> boolean isAllElementsMatchCondition(List<T> elements, Predicate<T> condition) {
        return elements.stream()
                .allMatch(condition);
    }

    public static int getMinElementGreaterThan(List<Integer> nums, int min) {
        return nums.stream()
                .filter(num -> num > min)
                .min(Integer::compareTo)
                .orElseThrow();
    }

    public static List<Integer> getStringLengths(List<String> lines) {
        return lines.stream()
                .map(String::length)
                .toList();
    }

}