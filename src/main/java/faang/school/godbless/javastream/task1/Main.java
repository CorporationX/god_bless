package faang.school.godbless.javastream.task1;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 20, 6, 7, 8, 10);
        List<String> strings = List.of("8RkgGbcVd", "LKFjkrEy6Frg$GHD", "eKJSvflfvXIW", "81lfJpM2zp");
        System.out.println(sumOfEvenNumbers(integers));
        System.out.println(getMaxInt(integers));
        System.out.println(getNumberOfLinesStartWithCharacter(strings, '8'));
        System.out.println(filterBySubstring(strings, "lf"));
        sortedByLengthLines(strings).forEach(System.out::println);
        System.out.println(checkForMatch(strings, s -> s.length() < 8));
        System.out.println(checkForMatch(strings, s -> s.length() < 10));
        System.out.println(getMinIntAndGreaterNumber(integers, 5));
        System.out.println(convertToListOfLengths(strings));
    }

    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .reduce(0, (currentResult, number) -> {
                    if (number % 2 == 0) {
                        return currentResult + number;
                    }
                    return currentResult;
                });
    }

    public static int getMaxInt(List<Integer> numbers) {
        return numbers.stream()
                .reduce(Integer.MIN_VALUE, Integer::max);
    }

    public static long getNumberOfLinesStartWithCharacter(List<String> strings, char symbol) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(symbol)))
                .count();
    }

    public static List<String> filterBySubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(s -> s.contains(substring))
                .toList();
    }

    public static Stream<String> sortedByLengthLines(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length));
    }

    public static boolean checkForMatch(List<String> strings, Predicate<String> stringPredicate) {
        return strings.stream()
                .anyMatch(stringPredicate);
    }

    public static int getMinIntAndGreaterNumber(List<Integer> numbers, Integer integer) {
        return numbers.stream()
                .filter(number -> number > integer)
                .reduce(Integer.MAX_VALUE, Integer::min);
    }

    public static List<Integer> convertToListOfLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}