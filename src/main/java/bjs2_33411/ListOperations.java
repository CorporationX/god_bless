package bjs2_33411;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ListOperations {

    public static int sumEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .reduce(0, (sum, curr) -> sum += curr);
    }

    public static int searchMaxNumber(List<Integer> numbers) {
        return numbers.stream()
                .max(Comparator.naturalOrder()).get();
    }

    public static double computeMean(List<Integer> numbers) {
        return (double) numbers.stream()
                .reduce(0, (sum, curr) -> sum += curr)
                / numbers.size();
    }

    public static int countStringStartingWith(List<String> strs, char c) {
        return (int) strs.stream()
                .filter(s -> s.startsWith(Character.toString(c)))
                .count();
    }

    public static List<String> filterStringsBySubstring(List<String> strs,
                                                        String substr) {
        return strs.stream()
                .filter(str -> str.contains(substr))
                .toList();
    }

    public static List<String> sortByLength(List<String> strs) {
        return strs.stream()
                .sorted((str1, str2) -> str1.length() - str2.length())
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers,
                                            Predicate<Integer> predicate) {
        return numbers.stream()
                .allMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int num) {
        return numbers.stream()
                .filter(n -> n > num)
                .min(Comparator.naturalOrder()).get();
    }

    public static List<Integer> convertStrsToLength(List<String> strs) {
        return strs.stream()
                .map(String::length)
                .toList();
    }
}
