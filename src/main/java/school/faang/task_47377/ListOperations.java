package school.faang.task_47377;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ListOperations {

    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return (numbers.stream()
                .filter(x -> (x % 2 == 0))
                .mapToInt(Integer::intValue)
                .sum());
    }

    public static int findMax(List<Integer> numbers) {
        return (numbers.stream()
                .mapToInt(Integer::intValue)
                .max().orElse(0));
    }

    public static double findAverage(List<Integer> numbers) {
        return (numbers.stream()
                .mapToInt(Integer::intValue)
                .average().orElse(0));
    }

    public static int countStringsStartingWith(List<String> strings, char letter) {
        return (int) strings.stream()
                .filter(str -> str.startsWith(String.valueOf(letter)))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> list, String str) {
        return list.stream()
                .filter(s -> s.contains(str))
                .toList();
    }

    public static List<String> sortByLength(List<String> list) {
        return list.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> listInt, Predicate<Integer> predicate) {
        return listInt.stream()
                .allMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> listInt, int y) {
        return listInt.stream()
                .filter(x -> x > y)
                .mapToInt(Integer::intValue)
                .min().orElse(0);
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}
