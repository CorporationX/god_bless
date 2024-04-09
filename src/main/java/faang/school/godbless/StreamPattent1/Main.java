package faang.school.godbless.StreamPattent1;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 4, 6, 3, 7, 2);
        List<String> words = List.of("Apple", "Amazon", "Uber", "Google");

        System.out.println("findEvenSum: " + findEvenSum(nums));
        System.out.println("findMaxElement: " + findMaxElement(nums));
        System.out.println("findAverage: " + findAverage(nums));
        System.out.println("countWordsThanStartsWith: " + countWordsThanStartsWith(words, 'A'));
        System.out.println("filterWordsThatContainsSubstring: ");
        filterWordsThatContainsSubstring(words, "le").forEach((word) -> System.out.println("----" + word));
        System.out.println("sortByLength: ");
        sortByLength(words).forEach((word) -> System.out.println("----" + word));
        System.out.println("checkAllElement: " + checkAllElement(nums, num -> num > 0));
        System.out.println("findMinElementThatBiggerThan: " + findMinElementThatBiggerThan(nums, 3));
        System.out.println("getListOfLengths: ");
        getListOfLengths(words).forEach((length) -> System.out.println("----" + length));
    }

    private static int findEvenSum(List<Integer> nums) {
        return nums.stream()
                .filter(num -> num % 2 == 0)
                .reduce(0, Integer::sum);
    }

    private static int findMaxElement(List<Integer> nums) {
        Optional<Integer> output = nums.stream()
                .max(Integer::compareTo);
        return output.orElseThrow(() -> new RuntimeException("Пустая коллекция"));
    }

    private static double findAverage(List<Integer> nums) {
        OptionalDouble output = nums.stream()
                .mapToDouble(Double::valueOf)
                .average();
        return output.orElseThrow(() -> new RuntimeException("Пустая коллекция"));
    }

    private static int countWordsThanStartsWith(List<String> words, char ch) {
        return (int) words.stream()
                .filter(word -> word.charAt(0) == ch)
                .count();
    }

    private static List<String> filterWordsThatContainsSubstring(List<String> words, String substring) {
        return words.stream()
                .filter(word -> word.contains(substring))
                .toList();
    }

    private static List<String> sortByLength(List<String> words) {
        return words.stream()
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    private static boolean checkAllElement(List<Integer> nums, Predicate<Integer> condition) {
        return nums.stream()
                .allMatch(condition);
    }

    private static int findMinElementThatBiggerThan(List<Integer> nums, int min) {
        Optional<Integer> output = nums.stream()
                .filter(num -> num > min)
                .min(Integer::compareTo);
        return output.orElseThrow(() -> new RuntimeException("Нет элементов больше чем переданное число"));
    }

    private static List<Integer> getListOfLengths(List<String> words) {
        return words.stream()
                .map(String::length)
                .toList();
    }
}
