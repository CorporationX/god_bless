package faang.school.godbless.task.StreamApi1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class StreamApi {

    public static int getSum(int[] numbers) {
        return Arrays.stream(numbers)
                .sum();
    }

    public static int getMax(int[] numbers) {
        return Arrays.stream(numbers)
                .max().orElseThrow(() -> new NoSuchElementException("array have no elements"));
    }


    public static double getAvg(int[] numbers) {
        return Arrays.stream(numbers)
                .average().orElseThrow(() -> new NoSuchElementException("array have no elements"));
    }

    public static long getCountOfStringWhichStarts(List<String> strings, Character firstLetter) {
        return strings.stream()
                .map(String::toLowerCase)
                .filter(string -> string.startsWith(String.valueOf(firstLetter).toLowerCase()))
                .count();
    }

    public static List<String> getStringsWhichContainSubStrings(List<String> strings, String subString) {
        return strings.stream()
                .filter(string -> string.contains(subString))
                .toList();
    }

    public static List<String> getSortedByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean isListMetCondition(List<String> strings, Predicate<String> predicate) {
        return strings.stream().allMatch(predicate);
    }

    public static int getSmallestWhichGreaterThan(int[] numbers, int number) {
        return Arrays.stream(numbers)
                .filter(a -> a > number)
                .sorted()
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("have no number which greater than " + number));
    }

    public static List<Integer> getListOfLength(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 32, 5, -3, 2};
        int[] numbersEmpty = {};
        List<String> words = List.of("Moscow", "London", "Paris", "Pittsburgh", "Poltava", "Lisbon");
        List<String> wordsEmpty = List.of();

        System.out.println(getSum(numbers));
        System.out.println(getSum(numbersEmpty));
        System.out.println(getMax(numbers));
        System.out.println(getAvg(numbers));
        System.out.println(getCountOfStringWhichStarts(words, 'p'));
        System.out.println(getCountOfStringWhichStarts(wordsEmpty, 'L'));
        System.out.println(getStringsWhichContainSubStrings(words, "is"));
        System.out.println(getStringsWhichContainSubStrings(wordsEmpty, "is"));
        System.out.println(getSortedByLength(words));
        System.out.println(isListMetCondition(words, string -> string.contains("o")));
        System.out.println(isListMetCondition(wordsEmpty, string -> string.length() > 3));
        System.out.println(getSmallestWhichGreaterThan(numbers, 4));
        System.out.println(getListOfLength(words));
    }


}
