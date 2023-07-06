package faang.school.godbless.sprint3.streams.treaningStreamAPI.classes;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class StreamApiTraining {
    //Давайте представим что я во всех методах еще проверил на null и empty))
    public static int getSumOfEvenNumbers(int[] ints) {
        IntStream stream = Arrays.stream(ints);
        return stream
                .filter(num -> num % 2 == 0)
                .sum();
    }

    public static OptionalInt getMaxNumber(int[] ints) {
        return Arrays.stream(ints)
                .max();
    }

    public static OptionalDouble getAverageOfNumbers(int[] ints) {
        return Arrays.stream(ints)
                .average();
    }

    public static long getNumberOfLinesStartingWith(String[] lines, char symbol) {
        return Arrays.stream(lines)
                .filter(line -> line.startsWith(Character.toString(symbol)))
                .count();
    }

    public static List<String> filterStringBySubstring(String[] lines, String substring) {
        return Arrays.stream(lines)
                .filter(line -> line.contains(substring))
                .toList();
    }

    public static List<String> sortByLength(String[] lines) {
        return Arrays.stream(lines)
                .sorted(Comparator.naturalOrder())
                .toList();
    }

    public static <T> boolean isAllElementsSatisfyCondition(List<T> list, Predicate<T> predicate) {
        return list.stream()
                .allMatch(predicate);
    }

    public static OptionalInt findMinNumberWhichGreaterThan(int[] ints, int number) {
        return Arrays.stream(ints)
                .filter(num -> num > number)
                .min();
    }

    public static List<Integer> getListStringsLength(List<String> list) {
        return list.stream()
                .map(String::length)
                .toList();
    }
}
