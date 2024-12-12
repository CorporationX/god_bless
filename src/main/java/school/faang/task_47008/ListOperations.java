package school.faang.task_47008;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOperations {

    public static int sumOfEvenNumbers(List<Integer> num) {
        if (num == null || num.isEmpty()) {
            return 0;
        }
        return num.stream().filter(n -> n % 2 == 0).mapToInt(n -> n).sum();
    }

    public static int findMax(List<Integer> num) {
        if (num == null || num.isEmpty()) {
            return 0;
        }
        return num.stream().max(Integer::compare).orElse(0);
    }

    public static double findAverage(List<Integer> num) {
        if (num == null || num.isEmpty()) {
            return 0.0;
        }
        return num.stream().filter(n -> n != 0).mapToInt(n -> n).average().orElse(0.0);
    }

    public static int countStringsStartingWith(List<String> as, char a) {
        if (as == null || as.isEmpty()) {
            return 0;
        }
        return (int) as.stream()
                .filter(str -> str != null && str.charAt(0) == a)
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String substring) {
        if (strings == null || substring == null) {
            return List.of();
        }
        return strings.stream().filter(str -> str != null && str.contains(substring)).collect(Collectors.toList());
    }

    public static List<String> sortByLength(List<String> strings) {
        if (strings == null || strings.isEmpty()) {
            return List.of();
        }
        return strings.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
    }

    public static boolean allMatchCondition(List<Integer> integer, Predicate<Integer> predicate) {
        if (integer == null || integer.isEmpty()) {
            return false;
        }
        return integer.stream().allMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> integers, int num) {
        if (integers == null || integers.isEmpty()) {
            return num;
        }
        return integers.stream().filter(someNum -> someNum > num).min(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("Нет элементов больше " + num));
    }

    public static List<Integer> convertToLengths(List<String> stringList) {
        if (stringList == null || stringList.isEmpty()) {
            return List.of();
        }
        return stringList.stream().map(String::length).collect(Collectors.toList());
    }
}