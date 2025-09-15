package school.faang.bjs2_88203;

import java.util.List;
import java.util.NoSuchElementException;

public class ListOperations {
    // 1. Сумма четных чисел
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }
    // 2. Максимальный элемент
    public static findMax(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("Список пуст"));
    }
    // 3. Среднее значение
    public static double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(Double.NaN);
    }
    // 4. Количество строк, начинающихся с символа
    public static long countStringsStartingWith(List<String> strings, char c) {
        return strings.stream()
                .filter(s -> !s.isEmpty() && s.charAt(0) == c)
                .count();
    }
}
