package school.faang.task_46758;

import lombok.experimental.UtilityClass;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@UtilityClass
public class ListOperations {
    public int sumOfEvenNumbers(List<Integer> list) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public int findMax(List<Integer> list) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
    }

    public double findAverage(List<Integer> list) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
    }

    public long countStringsStartingWith(List<String> list, char c) {
        return list.stream()
                .filter(word -> word.charAt(0) == c)
                .count();
    }

    public List<String> filterStringsContainingSubstring(List<String> list, String s) {
        return list.stream()
                .filter(sentence -> sentence.contains(s))
                .collect(Collectors.toList());
    }

    public List<String> sortByLength(List<String> list) {
        return list.stream()
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
    }

    public boolean allMatchCondition(List<Integer> list, Predicate<Integer> predicate) {
        return list.stream().allMatch(predicate);
    }

    public int findMinGreaterThan(List<Integer> list, int k) {
        return list.stream()
                .filter(n -> n > k)
                .min(Integer::compareTo)
                .orElse(0);
    }

    public List<Integer> convertToLengths(List<String> list) {
        return list.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }
}
