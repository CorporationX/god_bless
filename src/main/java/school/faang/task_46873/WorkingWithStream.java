package school.faang.task_46873;

import org.w3c.dom.ls.LSException;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class WorkingWithStream {

    public static int sumOfEvenNumbers(List<Integer> listNumber) {
        return listNumber.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMax(List<Integer> listNumber) {
        return listNumber.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("Список пуст"));
    }

    public static double findAverage(List<Integer> listNumber) {
        return listNumber.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public static int countStringsStartingWith(List<String> listString, char symbol) {
        return (int) listString.stream()
                .filter(s -> s.startsWith(String.valueOf(symbol)))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> listString, String substring) {
        return listString.stream()
                .filter(s -> s.contains(substring))
                .toList();
    }

    public static List<String> sortByLength(List<String> listString) {
        return listString.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> listInt, Predicate<Integer> predicate) {
        return listInt.stream().allMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> listInteger, int doorstep) {
        return listInteger.stream()
                .filter(s -> s > doorstep)
                .min(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("Нет элементов больше " + doorstep));
    }

    public static List<Integer> convertToLengths(List<String> listString) {
        return listString.stream()
                .map(String::length)
                .toList();
    }
}
