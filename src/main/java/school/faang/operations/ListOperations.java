package school.faang.operations;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;


public class ListOperations {

    public static Integer summaEvenNumbers(List<Integer> integerList) {
        return integerList
                .stream()
                .filter(even -> even % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static Integer findMaxElement(List<Integer> integerList) {
        return integerList
                .stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("List is empty"));
    }

    public static double findAverage(List<Integer> integerList) {
        return integerList.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public static Integer countStringsStartWith(List<String> stringList, char ch) {
        return (int) stringList
                .stream()
                .filter(str -> !str.isEmpty() && str.charAt(0) == ch)
                .count();
    }

    public static List<String> returnStringListContainsSubstring(List<String> stringList, String substring) {
        return stringList
                .stream()
                .filter(str -> !str.isEmpty() && str.contains(substring))
                .toList();
    }

    public static List<String> sortStringList(List<String> stringList) {
        return stringList
                .stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean checkByPredicate(List<Integer> integerList, Predicate<Integer> predicate) {
        return integerList.stream().allMatch(predicate);
    }

    public static Integer findMinGreaterThan(List<Integer> integerList, Integer integer) {
        return integerList
                .stream()
                .filter(n -> n > integer)
                .max(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("List is empty"));
    }

    public static List<Integer> convertStringToLength(List<String> stringList) {
        return stringList
                .stream()
                .mapToInt(String::length)
                .boxed()
                .toList();
    }
}
