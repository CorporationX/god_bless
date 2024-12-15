package school.faang.sprint_2.task_46911;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ListOperations {
    // 1. сумма чётных чисел
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    // 2. максимальный элемент в списке
    public static int findMax(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("Список пуст"));
    }

    // 3. среднее значение в списке
    public static double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new NoSuchElementException("Список пуст"));
    }

    // 4. количество строк, начинающихся с определённого символа
    public static int countStringsStartingWith(List<String> strings, char symbol) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(symbol)))
                .toList()
                .size();
    }

    // 5. отфильтровать список строк и оставить только те, которые содержат определённую строку
    public static List<String> filterStringsContainingSubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(s -> s.contains(substring))
                .toList();
    }

    // 6. отсортировать список строк по длине
    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    // 7. проверить, все ли элементы списка удовлетворяют определённому условию
    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> condition) {
        return numbers.stream()
                .allMatch(condition);
    }

    // 8. найти наименьший элемент в списке, который больше заданного числа
    public static int findMinGreaterThan(List<Integer> numbers, int limit) {
        return numbers.stream()
                .filter(x -> x > limit)
                .min(Comparator.comparingInt(i -> i))
                .orElseThrow(() -> new NoSuchElementException("Нет элемента больше заданного"));
    }

    // 9. преобразовать список строк в список их длин
    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}
