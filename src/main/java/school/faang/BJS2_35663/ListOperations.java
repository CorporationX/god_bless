package school.faang.BJS2_35663;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOperations {

    // 1. Найти сумму четных чисел в списке
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    // 2. Найти максимальный элемент в списке чисел
    public static int findMax(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow(NoSuchElementException::new);
    }

    // 3. Найти среднее значение чисел в списке
    public static double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    // 4. Найти количество строк, начинающихся с определённого символа
    public static int countStringsStartingWith(List<String> strings, char c) {
        return (int) strings.stream()
                .filter(s -> s.startsWith(String.valueOf(c)))
                .count();
    }

    // 5. Отфильтровать список строк и оставить только те, которые содержат определённую подстроку
    public static List<String> filterStringsContainingSubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(s -> s.contains(substring))
                .toList();
    }

    // 6. Отсортировать список строк по длине
    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    // 7. Проверить, все ли элементы списка удовлетворяют определённому условию
    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> condition) {
        return numbers.stream()
                .allMatch(condition);
    }

    // 8. Найти наименьший элемент в списке, который больше заданного числа
    public static int findMinGreaterThan(List<Integer> numbers, int threshold) {
        return numbers.stream()
                .filter(n -> n > threshold)
                .min(Integer::compareTo)
                .orElseThrow(NoSuchElementException::new);
    }

    // 9. Преобразовать список строк в список их длин
    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}
