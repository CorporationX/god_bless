package school.faang.stream_api_one;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        System.out.println("Сумма четных чисел: " + sumOfEvenNumbers(numbers));
        System.out.println("Максимум: " + findMax(numbers));
        System.out.println("Среднее: " + findAverage(numbers));
        System.out.println("Количество строк, начинающихся на 'a': " + countStringsStartingWith(strings, 'a'));
        System.out.println("Строки, содержащие 'an': " + filterStringsContainingSubstring(strings, "an"));
        System.out.println("Отсортированные по длине строки: " + sortByLength(strings));
        System.out.println("Все ли числа чётные? " + allMatchCondition(numbers, n -> n % 2 == 0));
        System.out.println("Наименьшее число больше 4: " + findMinGreaterThan(numbers, 4));
        System.out.println("Длины строк: " + convertToLengths(strings));
    }

    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(integer -> integer % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .max().getAsInt();
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average().getAsDouble();
    }

    public static long countStringsStartingWith(List<String> strings, char first) {
        return strings.stream()
                .filter(string -> string.indexOf(first) == 0)
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String string) {
        return strings.stream()
                .filter(string1 -> string1.contains(string))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> filter) {
        return numbers.stream()
                .allMatch(filter);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int min) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .filter(n -> n > min)
                .min().getAsInt();
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}