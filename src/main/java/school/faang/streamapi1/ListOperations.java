package school.faang.streamapi1;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ListOperations {

    public static int sumOfEvenNumbers(List<Integer> integerList) {
        return integerList.stream()
                .filter(i -> i % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMax(List<Integer> integerList) {
        return integerList.stream()
                .max(Comparator.naturalOrder())
                .orElseThrow(() -> new NoSuchElementException("List " +
                        "is empty"));
    }

    public static double findAverage(List<Integer> integerList) {
        return integerList.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(Double.NaN);
    }

    public static int countStringsStartingWith(List<String> stringList, char ch) {
        return (int) stringList.stream().filter(s -> s.startsWith(String.valueOf(ch))).count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> stringList, String string) {
        return stringList.stream().filter(s -> s.contains(string)).toList();
    }

    public static List<String> sortByLength(List<String> stringList) {
        return stringList.stream().sorted((s1, s2) -> s1.length() - s2.length()).toList();
    }

    public static boolean allMatchCondition(List<Integer> integerList,
                                            Predicate<Integer> predicate) {
        return integerList.stream().allMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> integerList, int number) {
        return integerList.stream().filter(i -> i > number)
                .min(Comparator.naturalOrder())
                .orElseThrow(() -> new NoSuchElementException("No element greater than " + number));
    }

    public static List<Integer> convertToLengths(List<String> stringList) {
        return stringList.stream().map(s -> s.length()).toList();
    }
}
