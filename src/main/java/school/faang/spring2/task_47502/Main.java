package school.faang.spring2.task_47502;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        System.out.println("Сумма четных чисел: " + sumOfEvenNumbers(numbers));
        System.out.println("Максимум: " + maxElement(numbers));
        System.out.println("Среднее: " + findAverage(numbers));
        System.out.println("Количество строк, начинающихся на 'a': " + findWordsStartWith(strings, 'a'));
        System.out.println("Строки, содержащие 'an': " + containsSubstring(strings, "an"));
        System.out.println("Отсортированные по длине строки: " + sortByLength(strings));
        System.out.println("Все ли числа чётные? " + allMatchCondition(numbers, n -> n % 2 == 0));
        System.out.println("Наименьшее число больше 4: " + findMinGreaterThan(numbers, 4));
        System.out.println("Длины строк: " + convertToLengths(strings));
    }

    private static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream().map(String::length).toList();

    }

    private static int findMinGreaterThan(List<Integer> numbers, int i) {
        return numbers.stream().filter(e -> e > i).min(Comparator.comparingInt(e -> e))
                .orElseThrow(NoSuchElementException::new);
    }

    private static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream().allMatch(predicate);
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream().sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static int sumOfEvenNumbers(List<Integer> list) {
        return list.stream().filter(e -> e % 2 == 0).mapToInt(e -> e).sum();
    }

    public static int maxElement(List<Integer> list) {
        return list.stream().mapToInt(e -> e)
                .max().orElseThrow(() -> new NoSuchElementException("Unable to find max element"));
    }

    public static double findAverage(List<Integer> list) {
        return list.stream().mapToInt(e -> e).average().orElse(0.0);
    }

    public static int findWordsStartWith(List<String> words, char c) {
        return (int) words.stream().filter(w -> !w.isEmpty() && w.charAt(0) == c).count();
    }

    public static List<String> containsSubstring(List<String> words, String substring) {
        return words.stream().filter(w -> !w.isEmpty() && w.contains(substring)).toList();
    }
}
