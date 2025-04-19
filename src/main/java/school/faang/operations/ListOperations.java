package school.faang.operations;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ListOperations {

    public static int sumOfEven(List<Integer> integerList) {
        return integerList.stream()
                .filter(i -> i % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMaxNumber(List<Integer> integerList) {
        return integerList.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow();
    }

    public static double findAverage(List<Integer> integerList) {
        return integerList.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow();
    }

    public static long countByFirstLetter(List<String> stringList, char ch) {
        return stringList.stream()
                .filter(s -> s.charAt(0) == ch)
                .count();
    }

    public static List<String> filterBySubstring(List<String> stringList, String substring) {
        return stringList.stream()
                .filter(s -> s.contains(substring))
                .toList();
    }

    public static List<String> sortStringByLength(List<String> stringList) {
        return stringList.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean checkByCondition(List<Integer> integerList, Predicate<Integer> predicate) {
        return integerList.stream().allMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> integerList, int num) {
        return integerList.stream()
                .filter(i -> i > num)
                .mapToInt(Integer::intValue)
                .min()
                .orElseThrow(() -> new IllegalArgumentException("Нет чисел больше " + num));
    }

    public static List<Integer> convertStringsToLength(List<String> stringList) {
        return stringList.stream()
                .map(String::length)
                .toList();
    }
}