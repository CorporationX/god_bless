package school.faang.task_47245;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream().filter((numb) -> numb % 2 == 0).mapToInt(Integer::intValue).sum();
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream().max(Integer::compareTo).orElseThrow(() -> new NoSuchElementException("Список пуст"));
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    public static int countStringsStartingWith(List<String> strings, char c) {
        return (int) strings.stream().filter(s -> !s.isEmpty() && s.charAt(0) == c).count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String substring) {
        return strings.stream().filter(str -> str.contains(substring)).collect(Collectors.toList());
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream().allMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int value) {
        return numbers.stream().filter(x -> x > value).min(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("Элементов больше, чем " + value + " нет"));
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream().map(String::length).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        // Пример использования методов:
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
}
