package school.faang.BJS2_35638;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOperations {

//    1️⃣ Найти сумму четных чисел в списке.
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
            .filter(number-> number % 2 == 0)
            .mapToInt(Integer::intValue)
            .sum();
    }

//    2️⃣ Найти максимальный элемент в списке чисел.
    public static int findMax(List<Integer> numbers) {
        return numbers.stream()
            .max(Integer::compareTo)
            .orElseThrow(NoSuchElementException::new);
    }

//    3️⃣ Найти среднее значение чисел в списке.
    public static double findAverage(List<Integer> numbers) {
        return numbers.stream()
            .mapToInt(Integer::intValue)
            .average()
            .orElse(0);
    }

//    4️⃣ Найти количество строк, начинающихся с определённого символа.
    public static int countStringsStartingWith(List<String> strings, char c) {
        return (int) strings.stream()
            .filter(string -> !string
                .isEmpty() && string
                .charAt(0) == c)
            .count();
    }

//    5️⃣ Отфильтровать список строк и оставить только те, которые содержат определённую подстроку.
    public static List<String> filterStringsContainingSubstring(List<String> strings, String substring) {
        return strings.stream()
            .filter(string -> string
                .contains(substring))
            .toList();
    }

//    6️⃣ Отсортировать список строк по длине.
    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
            .sorted(Comparator.comparingInt(String::length))
            .collect(Collectors.toList());
    }

//    7️⃣ Проверить, все ли элементы списка удовлетворяют определённому условию.
    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> condition) {
        return numbers.stream()
            .allMatch(condition);
    }

//    8️⃣ Найти наименьший элемент в списке, который больше заданного числа.
    public static int findMinGreaterThan(List<Integer> numbers, int threshold) {
        return numbers.stream()
            .filter(number -> number > threshold)
            .min(Integer::compareTo)
            .orElseThrow(NoSuchElementException::new);
    }

//    9️⃣ Преобразовать список строк в список их длин.
    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream()
            .map(String::length)
            .collect(Collectors.toList());
    }
}
