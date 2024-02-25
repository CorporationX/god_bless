package faang.school.godbless.math;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Math {
    public static int sumOfEven(List<Integer> numbers){
        return numbers.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int max(List<Integer> numbers){
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow();
    }

    public static double average(List<Integer> numbers){
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow();
    }

    public static long countStringStartingWith(List<String> list, char letter){
        Objects.requireNonNull(list, "List cannot be null");

        return list.stream()
                .filter(str -> str != null && !str.isEmpty() && str.charAt(0) == letter)
                .count();
    }

    public static List<String> filterStringsContainsSubstring(List<String> list, String substring){
        return list.stream()
                .filter(str -> str != null && !str.isEmpty() && str.contains(substring))
                .collect(Collectors.toList());
    }

    public static List<String> sortStringsByLength(List<String> list){
        return list.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static boolean checkAllElementsMatchCondition(List<String> list, Predicate<String> condition){
        return list.stream()
                .allMatch(condition);
    }

    public static int findSmallestElementGreaterThan(List<Integer> numbers, int number){
        return numbers.stream()
                .filter(num -> num > number)
                .min(Integer::compareTo)
                .orElseThrow();
    }

    public static List<Integer> converterToLength(List<String> list){
        return list.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }
}
