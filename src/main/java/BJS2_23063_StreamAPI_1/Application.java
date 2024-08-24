package BJS2_23063_StreamAPI_1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    private static final List<Integer> NUMS = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    private static final List<String> STRINGS = Arrays.asList("Hi", "Hey-ho!", "This is", "Just", "a", "Test", "list");
    private static final String H = "H";
    private static final String ST = "st";
    private static final int TARGET = 5;

    public static void main(String[] args) {

        sumAllElementsInList(NUMS);

        getMaximumElementInList(NUMS);

        getAverageInList(NUMS);

        countStringsThatStartsWithSymbol(STRINGS, H);

        getStringsWithSpecificSubstring(STRINGS, ST);

        sortStringsByLength(STRINGS);

        checkIfSatisfiesCondition(NUMS, TARGET);

        findMinThatMoreThanGiven(NUMS, TARGET);

        convertStringsToListByItsLength(STRINGS);
    }

    public static void sumAllElementsInList(List<Integer> nums) {
        System.out.println(nums.stream()
                .mapToInt(i -> i)
                .sum());
    }

    public static void getMaximumElementInList(List<Integer> nums) {
        System.out.println(nums.stream()
                .mapToInt(i -> i)
                .max()
                .getAsInt());
    }

    public static void getAverageInList(List<Integer> nums) {
        System.out.println(nums.stream()
                .mapToInt(i -> i).average()
                .getAsDouble());
    }

    public static void countStringsThatStartsWithSymbol(List<String> strings, String h) {
        System.out.println(strings.stream()
                .filter(s -> s.startsWith(h))
                .count());
    }

    public static void getStringsWithSpecificSubstring(List<String> strings, String st) {
        System.out.println(strings.stream()
                .filter(s -> s.contains(st))
                .collect(Collectors.toList()));
    }

    public static void sortStringsByLength(List<String> strings) {
        System.out.println(strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList()));
    }

    public static void checkIfSatisfiesCondition(List<Integer> nums, int target) {
        System.out.println(nums.stream()
                .filter(x -> x > target)
                .collect(Collectors.toList()));
    }

    public static void findMinThatMoreThanGiven(List<Integer> nums, int target) {
        System.out.println(nums.stream()
                .mapToInt(i -> i)
                .filter(x -> x > target)
                .min().getAsInt());
    }

    public static void convertStringsToListByItsLength(List<String> strings) {
        System.out.println(strings.stream()
                .map(String::length)
                .collect(Collectors.toList()));
    }

}
