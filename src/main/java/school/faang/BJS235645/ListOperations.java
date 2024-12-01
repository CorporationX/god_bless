package school.faang.BJS235645;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> listOfNums) {
        return listOfNums.stream()
                .filter(n -> n % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int findMax(List<Integer> listOfNums) {
        return listOfNums.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("The list is empty"));
    }

    public static double findAverage(List<Integer> listOfNums) {
        return listOfNums.stream()
                .mapToInt(Integer::intValue).average()
                .orElseThrow(() -> new NoSuchElementException("The list is empty"));
    }

    public static long countStringsStartingWith(List<String> listOfStrings, char ch) {
        return listOfStrings.stream()
                .filter(s -> s.startsWith(String.valueOf(ch)))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> listOfString, String sub) {
        return listOfString.stream()
                .filter(s -> s.contains(sub))
                .toList();
    }

    public static List<String> sortByLength(List<String> listOfStrig) {
        return listOfStrig.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> nums, Predicate<Integer> predicate) {
        return nums.stream().allMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> nums, int value) {
        return nums.stream()
                .filter(n -> n > value)
                .min(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("The list is empty"));
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }
}
