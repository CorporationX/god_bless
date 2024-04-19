package BJS2_5450;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> testNumber = List.of(1, 3, 4, 5, 6, 7, 8);
        // 1
        System.out.println(sumEvenNumber(testNumber));
        // 2
        if (maxNumberAtList(testNumber).isPresent()) {
            System.out.println(maxNumberAtList(testNumber).get());
        } else {
            System.out.println("Вы передали пустой список");
        }
        // 3
        if (avgNumberAtList(testNumber).isPresent()) {
            System.out.println(avgNumberAtList(testNumber).getAsDouble());
        } else {
            System.out.println("Вы передали пустой список");
        }
        // 4
        System.out.println(countStrWithChar(List.of("a", "b", "c", "a", "d", "a"), 'a'));
        // 5
        System.out.println(filterStrContainingSubstring(List.of("hello asdf", "asdfqwerqwe", "asdf wwww", "dfs"), "asdf"));
        // 6
        System.out.println(sortStringLength(List.of("Russia", "Italy", "USA", "China", "Germany")));
        // 7
        System.out.println(matchLengthPassword(List.of("asdf12345", "qwerty1234", "asdddddd", "13241243asdf")));
        // 8
        if (findMinNumberElement(testNumber, 3).isPresent()) {
            System.out.println(findMinNumberElement(testNumber, 3).get());
        } else {
            System.out.println("Вы передали пустой список");
        }
        // 9
        System.out.println(convertStringsToLengths(List.of("asdf", "qqqqq", "hello", "bye")));
    }

    public static int sumEvenNumber(List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(num -> num)
                .sum();
    }

    public static Optional<Integer> maxNumberAtList(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compareTo);
    }

    public static OptionalDouble avgNumberAtList(List<Integer> numbers) {
        return numbers.stream()
                .mapToDouble(num -> num)
                .average();
    }

    public static long countStrWithChar(List<String> strings, char character) {
        return strings.stream()
                .filter(str -> str.startsWith(Character.toString(character)))
                .count();
    }

    public static List<String> filterStrContainingSubstring(List<String> strings, String phrase) {
        return strings.stream()
                .filter(str -> str.contains(phrase))
                .collect(Collectors.toList());
    }

    public static List<String> sortStringLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static boolean matchLengthPassword(List<String> strings) {
        return strings.stream()
                .allMatch(str -> str.length() >= 8);
    }

    public static Optional<Integer> findMinNumberElement(List<Integer> numbers, int sortNumber) {
        return numbers.stream()
                .filter(num -> num > sortNumber)
                .min(Integer::compareTo);
    }

    public static List<Integer> convertStringsToLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }
}
