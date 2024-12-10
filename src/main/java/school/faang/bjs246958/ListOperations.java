package school.faang.bjs246958;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ListOperations {

    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .reduce(Integer::sum)
                .orElse(0);
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new RuntimeException("There is no any element in the list"));
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElseThrow(() -> new RuntimeException("There is no any element in the list"));
    }

    public static int countStringsStartingWith(List<String> list, char c) {
        return (int) list.stream()
                .filter(el -> el.startsWith(String.valueOf(c)))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> list, String word) {
        return list.stream()
                .filter(el -> el.contains(word))
                .toList();
    }

    public static List<String> sortByLength(List<String> list) {
        return list.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> list, Predicate<Integer> predicate) {
        return list.stream()
                .allMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> list, int given) {
        return list.stream()
                .filter(el -> el > given)
                .min(Integer::compareTo)
                .orElseThrow(() -> new RuntimeException("There is no any element in the list"));
    }

    public static List<Integer> convertToLengths(List<String> list) {
        return list.stream()
                .map(String::length)
                .toList();
    }

}
