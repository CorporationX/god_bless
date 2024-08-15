package faang.school.godbless.sprint2.streamAPI.BJS2_23057;

import faang.school.godbless.BJS2_18601.Character;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Tasks {
    protected static int findSumOfEvenFrom(List<Integer> list) {
        return list.stream()
                .filter(i -> i % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    protected static int findMaxIntFrom(List<Integer> list) {
        return list.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("List can not be empty"));
    }

    protected static double findAverageIntFrom(List<Integer> list) {
        return list.stream().
                mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new IllegalArgumentException("List can not be empty"));
    }

    protected static int findLinesCountStartsWith(char symbol, List<String> list) {
        return (int) list.stream()
                .filter(s -> s.startsWith(String.valueOf(symbol)))
                .count();
    }

    protected static List<String> findLinesThatContains(String substring, List<String> list) {
        return list.stream()
                .filter(s -> s.startsWith(substring))
                .toList();
    }

    protected static List<String> getLinesSortedByLength(List<String> list) {
        return list.stream()
                .sorted((s1, s2) -> s1.length() - s2.length())
                .toList();
    }

    protected static boolean checkListForStatement(List<String> list, Predicate<String> predicate) {
        return list.stream()
                .allMatch(predicate);
    }

    protected static int findMinElementGreaterThan(int number, List<Integer> list) {
        return list.stream()
                .filter(n -> n > number)
                .min(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("List can not be empty"));
    }

    protected static List<Integer> castStringToLenghtList(List<String> list) {
        return list.stream()
                .mapToInt(String::length)
                .boxed().toList();
    }
}
