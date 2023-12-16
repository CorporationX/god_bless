package faang.school.godbless;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Methods {
    public static int sum(List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int max(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compareTo)
                .orElse(0);
    }

    public static double average(List<Integer> numbers) {
        return numbers.stream()
                .mapToDouble(Integer::intValue)
                .average()
                .orElse(0);
    }

    public static long countStringFirsElement(List<String> textList, String element) {
        return textList.stream()
                .filter(text -> text.startsWith(String.valueOf(element)))
                .count();
    }

    public static List<String> FilterStringElement(List<String> textList, StringBuilder str) {
        return textList.stream()
                .filter(text -> text.contains(str))
                .collect(Collectors.toList());
    }

    public static List<String> CortStringElement(List<String> textList) {
        return textList.stream()
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
    }

    public static <T> boolean checkCondition(List<T> textList, Predicate<T> predicate) {
        return textList.stream()
                .allMatch(predicate);
    }

    public static int minWithCount(List<Integer> numbers, int count) {
        return numbers.stream()
                .filter(num -> num > count)
                .min(Integer::compareTo)
                .orElse(0);
    }

    public static List<Integer> lengsString(List<String> textList) {
        return textList.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }
}
