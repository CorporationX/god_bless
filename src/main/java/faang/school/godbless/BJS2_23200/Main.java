package faang.school.godbless.BJS2_23200;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static int sumEvenNumbers(List<Integer> listNumbers) {
        return listNumbers.stream()
                .filter(num -> (num % 2 == 0))
                .mapToInt(Integer::intValue)
                .sum();
    }
    public static int maxInList(List<Integer> integerList) {
        return integerList.stream()
                .mapToInt(Integer::intValue)
                .max().orElseThrow();
    }
    public static double avgInList(List<Integer> integerList) {
        return integerList.stream()
                .mapToInt(Integer::intValue)
                .average().orElseThrow();
    }
    public static long countString(List<String> stringList, char x) {
        return stringList.stream()
                .filter(string -> string.startsWith(String.valueOf(x)))
                .count();
    }
    public static List<String> filterStrings(List<String> stringList, String substring) {
        return stringList.stream()
                .filter(string -> string.contains(substring))
                .toList();
    }
    public static List<String> filterStringsByLength(List<String> stringList) {
        return stringList.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
    public static List<String> filteringByCondition(List<String> stringList, Predicate<String> predicate) {
        return stringList.stream()
                .filter(predicate)
                .toList();
    }
    public static int minElementWhichLessNumber(List<Integer> integerList, int x) {
        return integerList.stream()
                .filter(integer -> integer > x)
                .min(Integer::compareTo)
                .orElseThrow();
    }
    public static List<Integer> listStringsToListLengthStrings(List<String> stringList) {
        return stringList.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }
}
