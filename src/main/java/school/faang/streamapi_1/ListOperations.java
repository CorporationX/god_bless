package school.faang.streamapi_1;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Проект: god_bless
 * Класс ListOperations
 * Автор: Vital
 * Дата: 22.09.2025
 */

public class ListOperations {
    //Сумма всех чисел
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    //Поиск максимального элемента коллекции
    public static int findMax(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("Список пуст"));
    }

    //Среднее значение
    public static double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    //Поиск строк, начинающихся с определенного символа
    public static long countStringsStartinWith(List<String> strings, char c) {
        return strings.stream()
                .filter(s -> !s.isEmpty() && s.charAt(0) == c)
                .count();
    }

    //Выборка по подстроке
    public static List<String> filterStringsContainingSubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(s -> s.contains(substring))
                .collect(Collectors.toList());
    }

    //Выборка строк по длине
    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    //Проверка, все ли элементы удовлетворяют условию
    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> condition) {
        return numbers.stream()
                .allMatch(condition);
    }

    //Поиск минимального элемента больше заданного числа
    public static int findMinGreaterThan(List<Integer> numbers, int threshold) {
        return numbers.stream()
                .filter(n -> n > threshold)
                .min(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("Нет элементов больше " + threshold));
    }

    //Преобразовать строки в список длин
    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }
}
