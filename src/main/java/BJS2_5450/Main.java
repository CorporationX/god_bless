package BJS2_5450;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // 1
        System.out.println(sumEvenNumber(List.of(1, 3, 4, 5, 6, 7, 8)));
        // 2
        if (maxNumberAtList(List.of(1, 2, 3)).isPresent()) {
            System.out.println(maxNumberAtList(List.of(1, 2, 3)).get());
        } else {
            System.out.println("Вы передали пустой список");
        }
        // 3
        if (avgNumberAtList(List.of(1, 2, 3)).isPresent()) {
            System.out.println(avgNumberAtList(List.of(1, 2, 3)).getAsDouble());
        } else {
            System.out.println("Вы передали пустой список");
        }
        // 4
        System.out.println(countStrWithChar(List.of("a", "b", "c", "a", "d", "a"), 'a'));
        // 5
        System.out.println(filterStr(List.of("hello asdf", "asdfqwerqwe", "asdf wwww", "dfs"), "asdf"));
        // 6
        System.out.println(filterCountry(List.of("Russia", "Italy", "USA", "China", "Germany")));
        // 7
        System.out.println(correctPassword(List.of("asdf12345", "qwerty1234", "asdddddd", "13241243asdf")));
        // 8
        if (findMinNumberElement(List.of(1, 2, 3, 4, 5)).isPresent()) {
            System.out.println(findMinNumberElement(List.of(1, 2, 3, 4, 5)).get());
        } else {
            System.out.println("Вы передали пустой список");
        }
        // 9
        System.out.println(reverseStringInLength(List.of("asdf", "qqqqq", "hello", "bye")));
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

    public static List<String> filterStr(List<String> strings, String phrase) {
        return strings.stream()
                .filter(str -> str.contains(phrase))
                .collect(Collectors.toList());
    }

    public static List<String> filterCountry(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static boolean correctPassword(List<String> strings) {
        return strings.stream()
                .allMatch(str -> str.length() >= 8);
    }

    public static Optional<Integer> findMinNumberElement(List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num > 3)
                .min(Integer::compareTo);
    }

    public static List<Integer> reverseStringInLength(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }
}
