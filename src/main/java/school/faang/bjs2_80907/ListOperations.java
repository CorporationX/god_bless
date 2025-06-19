package school.faang.bjs2_80907;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ListOperations {

    public static int sumEvenNumbers(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("Список не должен быть пустым или null");
        }
        int sum = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {
                sum += number;
            }

        }
        return sum;
    }

    public static int findMax(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("Список не должен быть пустым или null");
        }
        int max = Integer.MIN_VALUE;
        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }

    public static double findAverage(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("Список не должен быть пустым или null");
        }
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return (double) sum / numbers.size();
    }

    public static long countStringsStartingWith(List<String> strings, char a) {
        if (strings == null || strings.isEmpty()) {
            throw new IllegalArgumentException("Список не должен быть пустым или null");
        }
        long count = 0;
        for (String s : strings) {
            if (s == null || s.isEmpty()) {
                continue;
            }
            if (s.charAt(0) == 'a') {
                count++;
            }
        }
        return count;
    }

    public static long filterStringsContainingSubstring(List<String> strings, String substring) {
        if (strings == null || strings.isEmpty()) {
            throw new IllegalArgumentException("Список не должен быть пустым или null");
        }
        long count = 0;
        for (String s : strings) {
            if (s == null || s.isEmpty()) {
                continue;
            }
            if (s.contains("an")) {
                count++;
            }
        }
        return count;
    }

    public static List<String> sortByLength(List<String> strings) {
        if (strings == null || strings.isEmpty()) {
            throw new IllegalArgumentException("Список не должен быть пустым или null");
        }
        List<String> sorted = new ArrayList<>(strings);
        sorted.sort(Comparator.comparingInt(String::length));
        return sorted;
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("Список не должен быть пустым или null");
        }
        for (Integer number : numbers) {
            if (!predicate.test(number)) {
                return false;
            }

        }
        return true;

    }

    public static Integer findMinGreaterThan(List<Integer> numbers, int threshold) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("Список не должен быть пустым или null");
        }
        Integer min = null;
        for (Integer number : numbers) {
            if (number > threshold && (min == null || number < min)) {
                min = number;
            }
        }
        if (min == null) {
            throw new NoSuchElementException("Нет подходящих чисел");
        }
        return min;
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        if (strings == null || strings.isEmpty()) {
            throw new IllegalArgumentException("Список не должен быть пустым или null");
        }
        List<Integer> lengths = new ArrayList<>();
        for (String s : strings) {
            if (s == null) {
                continue;
            } else {

                lengths.add(s.length());
            }

        }
        return lengths;
    }

}


