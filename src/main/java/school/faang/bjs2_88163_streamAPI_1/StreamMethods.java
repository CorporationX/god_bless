package school.faang.bjs2_88163_streamAPI_1;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.OptionalInt;
import java.util.function.Predicate;

public class StreamMethods {
    //Найти сумму четных чисел в списке.
    public static int sumEvenNumbers(List<Integer> list) {
        return list.stream()
                .filter(Objects::nonNull)
                .filter(num -> num % 2 == 0)
                .mapToInt(num -> num)
                .sum();
    }

    // Найти максимальный элемент в списке чисел.
    public static int findMax(List<Integer> list) {
        return list.stream()
                .filter(Objects::nonNull)
                .mapToInt(num -> num)
                .max()
                .orElse(0);
    }

    //Найти среднее значение чисел в списке.
    public static double countAverage(List<Integer> list) {
        return list.stream()
                .filter(Objects::nonNull)
                .mapToInt(num -> num)
                .average()
                .orElse(0.0);
    }

    // Найти количество строк, начинающихся с определённого символа.
    @SuppressWarnings("checkstyle:ParameterName")
    public static long countStringsStartingWith(List<String> list, char ch) {
        return list.stream()
                .filter(Objects::nonNull)
                .filter(str -> !str.isEmpty())
                .filter(str ->
                        Character.toLowerCase(str.charAt(0))
                                == Character.toLowerCase(ch))
                .count();
    }

    //Отфильтровать список строк и оставить только те, которые содержат определённую подстроку.
    public static List<String> filterBySubstring(List<String> list, String substring) {
        return list.stream()
                .filter(Objects::nonNull)
                .filter(str -> !str.isEmpty())
                .filter(str -> str.toLowerCase().contains(substring.toLowerCase()))
                .toList();
    }

    //Отсортировать список строк по длине.
    public static List<String> sortStringByLong(List<String> list) {
        return list.stream()
                .filter(Objects::nonNull)
                .filter(str -> !str.isEmpty())
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    // Проверить, все ли элементы списка удовлетворяют определённому условию.
    public static boolean allMatch(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream()
                .filter(Objects::nonNull)
                .allMatch(predicate);
    }

    //Найти наименьший элемент в списке, который больше заданного числа.
    public static OptionalInt findMinGreaterThan(List<Integer> numbers, int num) {
        return numbers.stream()
                .filter(Objects::nonNull)
                .mapToInt(n -> n)
                .filter(n -> n > num)
                .min();
    }

    public static List<Integer> mapToLength(List<String> strings) {
        return strings.stream()
                .filter(Objects::nonNull)
                .map(String::length)
                .toList();
    }
}