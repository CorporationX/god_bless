package faang.school.godbless.lambda_stream.training_StreamAPI_1;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class TrainingStreamAPI {
    public static int sumOfEvenNumbers(List<Integer> nums) {
        return nums.stream()
                .filter(num -> num % 2 == 0)
                .reduce(Integer::sum).orElse(0);
    }

    public static int maxNumber(List<Integer> nums) {
        return nums.stream().max(Comparator.naturalOrder()).orElse(0);
    }

    public static double avgNumber(List<Integer> nums) {
        return nums.stream().mapToDouble(Integer::doubleValue).average().orElse(0);
    }

    public static long countStartingWithChar(List<String> strings, char ch) {
        return strings.stream().filter(str -> str.charAt(0) == ch).count();
    }

    public static List<String> onlyStringsContainsSubstring(List<String> strings, String substring) {
        return strings.stream().filter(str -> str.contains(substring)).toList();
    }

    public static List<String> sortByStringLength(List<String> strings) {
        return strings.stream().sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static <T> boolean allElementsMatch(List<T> list, Predicate<T> predicate) {
        return list.stream().allMatch(predicate);
    }

    public static int minimumMoreThan(List<Integer> nums, int moreThan) {
        return nums.stream().filter(num -> num > moreThan).min(Comparator.naturalOrder()).orElse(0);
    }

    public static List<Integer> stringsToLength(List<String> strings) {
        return strings.stream().map(String::length).toList();
    }
}