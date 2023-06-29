package faang.school.godbless.Sprint3.Task_16_StreamAPI_1;

import java.util.List;
import java.util.function.Predicate;

public class StreamAPI_1 {
    public static int sumOfEvenNumbers (List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMaxNumber (List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
    }

    public static double calculateAverage (List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
    }

    public static int countStrings (List<String> strings, char character) {
        return (int) strings.stream()
                .filter(string -> string.charAt(0) == character)
                .count();
    }

    public static List<String> filterBySubstring (List<String> strings, String substring) {
        return strings.stream()
                .filter(string -> string.contains(substring))
                .toList();
    }

    public static List<String> sortByLength (List<String> strings) {
        return strings.stream()
                .sorted((s1, s2) -> s1.length() - s2.length())
                .toList();
    }

    public static <T> boolean checkAllMatch (List<T> list, Predicate<T> predicate) {
        return list.stream().allMatch(predicate);
    }

    public static int findSmallestNumber (List<Integer> numbers, int target) {
        return numbers.stream()
                .filter(number -> number > target)
                .mapToInt(Integer::intValue)
                .min()
                .orElse(0);
    }

    public static List<Integer> convertToLength (List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}
