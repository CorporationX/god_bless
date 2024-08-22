package faang.school.godbless.BJS2_23016;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> words = List.of("Hello", "Bonjour", "Hi", "Cat", "Bingo", "Hurricane", "HelloWorld");
        System.out.println("sum of even numbers:");
        System.out.println(sumEvenNumbers(nums));

        System.out.println("Max element:");
        System.out.println(maxNumber(nums));

        System.out.println("Avg value: ");
        System.out.println(avgValue(nums));

        System.out.println("Count words starts with 'H':");
        System.out.println(countWordLetterH(words, "H"));

        System.out.println("Words contain 'ello':");
        System.out.println(wordContain(words, "ello"));

        System.out.println("Sorted words:");
        System.out.println(sortedWordsByLength(words));

        System.out.println("Elements condtion:");
        Predicate<String> predicate = (word) -> word.length() > 1;
        System.out.println(elementsCondition(words, predicate));

        System.out.println("Min element that is greater than condition:");
        System.out.println(minElementGreaterCondition(nums, 4));

        System.out.println("List of strings to list of string lengths:");
        System.out.println(stringsToStringLength(words));
    }

    private static int sumEvenNumbers(List<Integer> nums) {
        return nums.stream().filter(num -> num % 2 == 0)
                .reduce(0, Integer::sum);
    }

    private static int maxNumber(List<Integer> nums) {
        return nums.stream()
                .max(Integer::compare)
                .orElse(0);
    }

    private static double avgValue(List<Integer> nums) {
        return (double) nums.stream()
                .reduce(0, Integer::sum) / nums.size();
    }

    private static long countWordLetterH(List<String> words, String letter) {
        return words.stream()
                .filter(word -> word.startsWith(letter))
                .count();
    }

    private static List<String> wordContain(List<String> words, String word) {
        return words.stream()
                .filter(wordElement -> wordElement.contains(word))
                .toList();
    }

    private static List<String> sortedWordsByLength(List<String> words) {
        return words.stream()
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    private static <T> boolean elementsCondition(List<T> words, Predicate<T> predicate) {
        return words.stream()
                .allMatch(predicate);
    }

    private static int minElementGreaterCondition(List<Integer> nums, int condition) {
        return nums.stream()
                .filter(num -> num > condition)
                .min(Integer::compare)
                .orElse(Integer.MAX_VALUE);
    }

    private static List<Integer> stringsToStringLength(List<String> words) {
        return words.stream()
                .map(String::length)
                .toList();
    }
}
