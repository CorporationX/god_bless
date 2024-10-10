package school.faang.sprint_2.bjs2_35587;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = asList(1, 2, 3, 4, 5, 6);
        List<String> strings = asList("apple", "banana", "cherry", "date");

        System.out.println("Сумма четных чисел: " + sumOfEvenNumbers(numbers));
        System.out.println("Максимум: " + findMax(numbers));
        System.out.println("Среднее: " + findAverage(numbers));
        System.out.println("Количество строк, начинающихся на 'a': " + countStringsStartingWith('a', strings));
        System.out.println("Строки, содержащие 'an': " + filterStringsContainingSubstring("an", strings));
        System.out.println("Отсортированные по длине строки: " + sortByLength(strings));
        System.out.println("Все ли числа чётные? " + allMatchCondition(numbers, n -> n % 2 == 0));
        System.out.println("Наименьшее число больше 4: " + findMinGreaterThan(numbers, 4));
        System.out.println("Длины строк: " + convertToLengths(strings));
    }

    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow(() -> new NoSuchElementException("List is empty"));
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new NoSuchElementException("List is empty"));
    }

    public static int countStringsStartingWith(char ch, List<String> strings) {
        return (int) strings.stream()
                .filter(s -> s.startsWith(String.valueOf(ch)))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(String filterBy, List<String> strings) {
        return strings.stream()
                .filter(s -> s.contains(filterBy))
                .collect(Collectors.toList());
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream()
                .allMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int filter) {
        return numbers.stream()
                .filter(n -> n < filter)
                .mapToInt(Integer::intValue)
                .min()
                .orElseThrow(() -> new NoSuchElementException("List is empty"));
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }
}
