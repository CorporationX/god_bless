package faang.school.godbless.StreamApi1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static int getSumOfHonestNumber(int[] integers) {
        validateArray(integers);
        IntStream intStream = Arrays.stream(integers);
        int sum = intStream
                .filter(i -> i % 2 == 0)
                .sum();
        return sum;
    }

    public static int getMaxNumber(int[] integers) {
        validateArray(integers);
        IntStream intStream = Arrays.stream(integers);
        OptionalInt max = intStream.max();
        return max.getAsInt();
    }

    public static double getMiddleNumber(int[] integers) {
        validateArray(integers);
        IntStream intStream = Arrays.stream(integers);
        OptionalDouble average = intStream.average();
        return average.getAsDouble();
    }

    public static long getCountOfOneLetterStrings(List<String> strings, char letter) {
        String letterStr = String.valueOf(letter);
        validateList(strings);
        return strings.stream()
                .filter(string -> string.startsWith(letterStr)).count();
    }

    public static List<String> getStringsContainsSubstring(List<String> strings, String substring) {
        if (substring == null || substring.isEmpty()) {
            throw new IllegalArgumentException("Substring can't be empty");
        }
        validateList(strings);
        return strings.stream()
                .filter(string -> string.contains(substring))
                .collect(Collectors.toList());
    }

    public static List<String> getSortedStringsByLength(List<String> strings) {
        validateList(strings);
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static boolean isAllStringsSatisfyCondition(List<String> strings, Predicate<String> predicate) {
        validateList(strings);
        return strings.stream()
                .allMatch(predicate);
    }

    public static int getSmallestElement(List<Integer> integers, int number) {
        validateList(integers);
        return integers.stream()
                .filter(x -> x > number)
                .collect(Collectors.summarizingInt(x -> x))
                .getMin();
    }

    public static List<Integer> convertListStringsIntoListLength(List<String> strings) {
        validateList(strings);
        return strings.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }

    private static void validateArray(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array is empty");
        }
    }

    private static <T> void validateList(List<T> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }
    }
}
