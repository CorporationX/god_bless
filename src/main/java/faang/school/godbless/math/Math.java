package faang.school.godbless.math;

import java.util.Comparator;
import java.util.List;
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
                .orElse(0);
    }

    public static double average(List<Integer> numbers){
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
    }

    public static long countStringStartingWith(List<String> list, char letter){
        return list.stream()
                .filter(str -> !str.isEmpty() && str.charAt(0) == letter)
                .count();
    }

    public static List<String> filterStringsContainsSubstring(List<String> list, String substring){
        return list.stream()
                .filter(str -> !str.isEmpty() && str.contains(substring))
                .collect(Collectors.toList());
    }

    public static List<String> sortStringsByLength(List<String> list){
        return list.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static boolean allElementsMatchCondition(List<String> list, Predicate<String> condition){
        return list.stream()
                .allMatch(condition);
    }

    public static int findSmallestThan(List<Integer> numbers, int number){
        return numbers.stream()
                .filter(num -> num > number)
                .min(Integer::compareTo)
                .orElse(0);
    }

    public static List<Integer> converterToLength(List<String> list){
        return list.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }
}
