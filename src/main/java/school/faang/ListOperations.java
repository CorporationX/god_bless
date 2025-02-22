package school.faang;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ListOperations {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");
        char d = 'd';
        String substring = "ba";
        Predicate<Integer> condition = n -> n % 2 == 0;
        int min = 3;

        System.out.println("Сумма четных чисел: " + ListOperations.sumOfEvenNumbers(numbers));
        System.out.println("Максимальное число: " + ListOperations.findMax(numbers));
        System.out.println("Среднее число: " + ListOperations.findAverage(numbers));
        System.out.println("Количество строк на 'd'" + ListOperations.valueStrings(strings, d));
        System.out.println("Строки содержащие " + substring + ": " + ListOperations.filterBySubstring(strings,
                substring));
        System.out.println("Отсортированные по длине строки: " + ListOperations.sortByLength(strings));
        System.out.println("Все ли числа чётные? " + ListOperations.allMatchCondition(numbers, condition));
        System.out.println("Наименьшее число больше " + min + ": " + ListOperations.findMinGreaterThan(numbers, min));
        System.out.println("Длины строк: " + ListOperations.convertToLengths(strings));
    }

    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(x -> x % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("Список пуст"));
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public static long valueStrings(List<String> strings, char d) {
        return strings.stream()
                .filter(string -> !string.isEmpty() && string.charAt(0) == d)
                .count();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static List<String> filterBySubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(s -> s.contains(substring))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> condition) {
        return numbers.stream()
                .allMatch(condition);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int min) {
        return numbers.stream()
                .filter(n -> n > min)
                .min(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("Нет элементов больше " + min));
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }

}
