package faang.school.godbless.training_stream_api;

import lombok.NonNull;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamApiTraining {

    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 2443, 6, 4, 5);
        List<String> words = List.of("Rauan", "Rasul", "Alex", "Yan", "Samanta", "");
        System.out.println("sumEvenNumbers: " + sumEvenNumbers(nums));
        System.out.println("findMaxNumber: " + findMaxNumber(nums));
        System.out.println("findAverageNumber: " + findAverageNumber((nums)));
        System.out.println("countingStringsWith: " + countStringsStartsWith(words, 'R'));
        System.out.println("filteredBySubstring: " + filteredBySubstring(words, "a"));
        System.out.println("sortWordsByLength: " + sortWordsByLength(words));
        System.out.println("isMatch: " + isMatch(words, word -> !word.isBlank()));
        System.out.println("findMinFromBiggerNums: " + findMinFromBiggerNums(nums, 5));
        System.out.println("mapStringsByLength: " + mapStringsByLength(words));
    }

    public static int sumEvenNumbers(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(num -> num)
                .sum();
    }

    public static int findMaxNumber(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(num -> num)
                .max()
                .orElseThrow();
    }

    public static double findAverageNumber(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(num -> num)
                .average()
                .orElseThrow();
    }

    public static int countStringsStartsWith(@NonNull List<String> words, char s) {
        return words.stream()
                .filter(word -> word.startsWith(String.valueOf(s)))
                .mapToInt(o -> 1)
                .sum();
    }

    public static List<String> filteredBySubstring(@NonNull List<String> words, @NonNull String subString) {
        return words.stream()
                .filter(word -> word.contains(subString))
                .collect(Collectors.toList());
    }

    public static List<String> sortWordsByLength(@NonNull List<String> words) {
        return words.stream()
                .sorted((o1, o2) -> o1.length() - o2.length())
                .collect(Collectors.toList());
    }

    public static boolean isMatch(@NonNull List<String> words, Predicate<String> predicate) {
        return words.stream()
                .allMatch(predicate);
    }

    public static int findMinFromBiggerNums(@NonNull List<Integer> numbers, int source) {
        return numbers.stream()
                .filter(num -> num > source)
                .mapToInt(num -> num).min()
                .orElseThrow();
    }

    public static List<Integer> mapStringsByLength(@NonNull List<String> words) {
        return words.stream()
                .mapToInt(String::length)
                .boxed()
                .toList();
    }
}
