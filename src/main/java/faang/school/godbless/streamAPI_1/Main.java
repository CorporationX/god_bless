package faang.school.godbless.streamAPI_1;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    private static final List<Integer> NUMBERS = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    private static final List<String> STRINGS = List.of("one", "_one", "two", "_three", "four");

    public static int findSumNumbers(List<Integer> numbers) {
        return numbers.stream()
                .reduce(0, Integer::sum);
    }

    public static int findMax(List<Integer> numbers) {
//        int result = 0;
        return numbers.stream()
                .max(Comparator.naturalOrder())
                .orElse(Integer.MIN_VALUE);
    }

    public static double findAverage(List<Integer> numbers) {
        return (double) numbers.stream()
                .reduce(0, (before, next) -> before + next)/numbers.size();
    }

    public static long getAmountStringsBeginningConcreteSymbol(List<String> strings, char symbol) {
        return strings.stream()
                .filter(string -> string.charAt(0) == symbol)
                .count();
    }

    public static List<String> getFilteredStrings(List<String> strings, String filter) {
        return strings.stream()
                .filter(string -> string.contains(filter))
                .toList();
    }

    public static List<String> sortStringsByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static boolean checkCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream()
                .allMatch(predicate);
    }

    public static void findMinBiggerConcreteValue(List<Integer> numbers, int value) {
            numbers.stream()
                    .filter((number) -> number > value)
                    .min(Comparator.naturalOrder())
                    .ifPresent(System.out::println);
    }

    public static List<Long> getStringLengths(List<String> strings) {
        return strings.stream()
                .mapToLong(String::length)
                .boxed()
                .toList();
    }

    public static void main(String[] args) {
        System.out.println(findSumNumbers(NUMBERS));
        System.out.println(findMax(NUMBERS));
        System.out.println(findAverage(NUMBERS));
        System.out.println(getAmountStringsBeginningConcreteSymbol(STRINGS, '_'));
        System.out.println(getFilteredStrings(STRINGS, "one"));
        System.out.println(sortStringsByLength(STRINGS));
        System.out.println(checkCondition(NUMBERS, (number -> number % 2 == 0)));
        findMinBiggerConcreteValue(NUMBERS, 5);
        System.out.println(getStringLengths(STRINGS));
    }
}
