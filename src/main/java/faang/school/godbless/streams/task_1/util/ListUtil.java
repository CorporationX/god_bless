package faang.school.godbless.streams.task_1.util;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ListUtil {

    public int sumEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();


    }

    public int findMaxNumber(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("Элементы отсутствуют"));
    }

    public double findAverageNumber(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(integer -> integer)
                .average().orElse(0);
    }

    public long countStringsStartsWithSymbol(char symbol, List<String> strings) {
        return strings.stream()
                .filter(string -> !string.isEmpty())
                .filter(string -> string.charAt(0) == symbol)
                .count();
    }

    public List<String> collectStringsContainsSubstring(String substring, List<String> strings) {
        return strings.stream()
                .filter(string -> !string.isEmpty())
                .filter(string -> string.contains(substring))
                .toList();
    }

    public List<String> sortListByStringsLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public <T> boolean checkListElements(List<T> elements, Predicate<T> filter) {
        return elements.stream()
                .allMatch(filter);
    }

    public int findMinElementWhichMoreThanThreshold(int threshold, List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number > threshold)
                .min(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("Элемент больше заданного порога отсутствует"));
    }

    public List<Integer> convertStringsToStringLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}