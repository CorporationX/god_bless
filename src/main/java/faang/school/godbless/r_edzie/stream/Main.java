package faang.school.godbless.r_edzie.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        List<String> strings = new ArrayList<>(List.of("Apple", "Astro", "Banana", "Dota", "Beta"));

        System.out.println(sumOfEven(numbers));
        System.out.println(maxValue(numbers));
        System.out.println(averageOfNumbers(numbers));
        System.out.println(countOfStringsStart(strings, 'A'));
        System.out.println(filterListOfStringsBySubString(strings, "ta"));
        System.out.println(sortListOfStringsByLength(sortListOfStringsByLength(strings)));
        System.out.println(isConditionSatisfied(numbers, number -> number > 4));
        System.out.println(findSmallestThan(numbers, 4));
        System.out.println(convertListOfStringToStringsLength(strings));
    }

    public static int sumOfEven(List<Integer> numbers) {
        return numbers
                .stream()
                .filter(num -> num % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int maxValue(List<Integer> numbers) {
        return numbers
                .stream()
                .max(Integer::compare)
                .orElse(0);
    }

    public static double averageOfNumbers(List<Integer> numbers) {
        return numbers
                .stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
    }

    public static long countOfStringsStart(List<String> strings, char startChar) {
        return strings
                .stream()
                .filter(element -> element.startsWith(String.valueOf(startChar))).count();
    }

    public static List<String> filterListOfStringsBySubString(List<String> strings, String substring) {
        return strings
                .stream()
                .filter(string -> string.contains(substring))
                .collect(Collectors.toList());
    }

    public static List<String> sortListOfStringsByLength(List<String> strings) {
        return strings
                .stream()
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
    }

    public static boolean isConditionSatisfied(List<Integer> numbers, Predicate<Integer> condition) {
        return numbers
                .stream()
                .allMatch(condition);
    }

    public static int findSmallestThan(List<Integer> numbers, int target) {
        return numbers
                .stream()
                .filter(n -> n > target)
                .min(Integer::compareTo)
                .orElse(0);
    }

    public static List<Integer> convertListOfStringToStringsLength(List<String> strings) {
        return strings
                .stream()
                .map(String::length)
                .collect(Collectors.toList());
    }
}
