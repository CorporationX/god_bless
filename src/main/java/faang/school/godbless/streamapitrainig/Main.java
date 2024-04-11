package faang.school.godbless.streamapitrainig;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("sumNumbers test, expected 30");
        System.out.println(sumNumbers(numbers) + "\n");
        System.out.println("findMaxNumber test, exp 10");
        System.out.println(findMaxNumber(numbers) + "\n");
        System.out.println("findAverage test, exp 5.5");
        System.out.println(findAverage(numbers) + "\n");

        List<String> strings = List.of("qwetttt", "qwrt", "qe", "werttttq");
        System.out.println("countStringByPrefix test, exp 2 (qw)");
        System.out.println(countStringByPrefix(strings, "qw") + "\n");
        System.out.println("filterStringBySubstring test, exp qwe, qwr (qw)");
        filterStringsBySubstring(strings, "qw").forEach(System.out::println);
        System.out.println();
        System.out.println("sortStringByLength, exp: qe qwrt qwetttt werttttq");
        System.out.println(sortStringsByLength(strings));

        List<Integer> evenNumbers = List.of(2, 4, 6);
        System.out.println("predicateEvenNumbers, exp true");
        System.out.println(predicateEvenNumbers(evenNumbers));
        System.out.println("predicateEvenNumbers, exp false");
        System.out.println(predicateEvenNumbers(numbers));

        System.out.println("findLowestElement, exp 6 (5)");
        System.out.println(findLowestElement(numbers, 5));

        System.out.println("stringToLength Test, exp 7 4 2 8");
        System.out.println(stringToLength(strings));
    }

    public static int sumNumbers(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .filter(num -> num % 2 == 0)
                .sum();
    }

    public static int findMaxNumber(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .max().orElse(0);
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average().orElse(0);
    }

    public static long countStringByPrefix(List<String> strings, String prefix) {
        return strings.stream()
                .filter(string -> string.startsWith(prefix))
                .count();
    }

    public static List<String> filterStringsBySubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(str -> str.contains(substring))
                .toList();
    }

    public static List<String> sortStringsByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean predicateEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .allMatch(num -> num % 2 == 0);
    }

    public static int findLowestElement(List<Integer> numbers, int minNumber) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .filter(num -> num > minNumber)
                .min().orElse(0);
    }

    public static List<Integer> stringToLength(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}
