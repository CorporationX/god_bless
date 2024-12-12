package school.faang.sprint2.task47275;

import java.util.*;
import java.util.function.IntPredicate;

public class StreamFunc {

    public static int sumOfEventNumbers(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(i -> i)
                .filter(num -> num % 2 == 0)
                .sum();
    }

    public static int maxOfNumbers(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(i -> i)
                .max()
                .orElse(-1);
    }

    public static double averageOfNumbers(List<Integer> numbers) {
        OptionalDouble result = numbers.stream()
                .mapToInt(i -> i)
                .average();

        if (result.isPresent()) {
            return result.getAsDouble();
        } else {
            return -1;
        }
    }

    public static long numOfStringsByMask(List<String> strings, char prefix) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(prefix)))
                .count();
    }

    public static List<String> numOfStringsByMask(List<String> strings, String subString) {
        return strings.stream()
                .filter(str -> str.lastIndexOf(subString) > 0)
                .toList();
    }

    public static List<String> sortStringsByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean checkNumbers(List<Integer> numbers, IntPredicate predicate) {
        if (predicate != null) {
            return numbers.stream()
                    .mapToInt(i -> i)
                    .allMatch(predicate);
        }
        return false;
    }


    public static int getMinNumber(List<Integer> numbers, int minNumber) {
        int result;
        OptionalInt minNum = numbers.stream()
                .mapToInt(i -> i)
                .filter((i) -> i > minNumber)
                .min();
        if (minNum.isPresent()) {
            result = minNum.getAsInt();
        } else {
            throw new NoSuchElementException("Нет элементов больше " + minNumber);
        }
        return result;
    }

    public static List<Integer> getStringListLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}