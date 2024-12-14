package school.faang.task_47223;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ListOperations {

    public static int sumOfEvenNumbers(List<Integer> integerList) {
        return integerList.stream()
                .filter(n -> n % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int findMax(List<Integer> integerList) {
        return integerList.stream()
                .reduce(0, Integer::max);
    }

    public static float findAverage(List<Integer> integerList) {
        return (float) integerList.stream()
                .reduce(0, Integer::sum) / integerList.size();
    }

    public static int countStringsStartingWith(List<String> stringList, char symbol) {
        return stringList.stream()
                .filter(string -> string.charAt(0) == symbol)
                .toList()
                .size();
    }

    public static List<String> filterStringsContainingSubstring(List<String> stringList, String str) {
        return stringList.stream()
                .filter(string -> string.contains(str))
                .toList();
    }

    public static List<String> sortByLength(List<String> stringList) {
        return stringList.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> integerList, Predicate<Integer> predicate) {
        return integerList.stream()
                .allMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> integerList, int k) {
        return integerList.stream()
                .filter(n -> n > k)
                .min(Integer::compareTo)
                .orElseThrow(() ->new NoSuchElementException("Нет элементов удовлетваорящие условиям."));
    }

    public static List<Integer> convertToLengths(List<String> stringList) {
        return stringList.stream()
                .map(String::length)
                .toList();
    }
}
