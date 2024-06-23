package faang.school.godbless.trainingstream1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static final int DIVISOR = 2;
    public static final int REMAINDER = 0;

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        List<String> strings = Arrays.asList("water", "food", "bed", "date");

        System.out.println("Sum: " + sumOfEvens(nums));
        System.out.println("Max number: " + maxValue(nums));
        System.out.println("Average: " + averageValue(nums));
        System.out.println("Count of strings starting with 'f': " + countStringsStartWith(strings, 'f'));
        System.out.println("Strings containing 'be': " + filterStringContaining(strings, "be"));
        System.out.println("Strings sorted by length: " + filterStringByLength(strings));
        System.out.println("All numbers greater than 2: " + checkCondition(nums, n -> n > 2));
        System.out.println("Min number greater than 3: " + minValue(nums, 3));
        System.out.println("Lengths of strings: " + convertListStringsToLength(strings));
    }

    /**
     * Найти сумму четных чисел в списке.
     *
     * @param numbers список чисел
     * @return sum
     */
    public static int sumOfEvens(List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num % DIVISOR == REMAINDER)
                .mapToInt(i -> i)
                .sum();
    }

    /**
     * Найти максимальный элемент в списке чисел.
     *
     * @param numbers список чисел
     * @return max
     */
    public static int maxValue(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compare)
                .orElse(0);
    }

    /**
     * Найти среднее значение чисел в списке.
     *
     * @param numbers список чисел
     * @return average
     */
    public static double averageValue(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(i -> i)
                .average()
                .orElse(0.0);
    }

    /**
     * Найти количество строк, начинающихся с определённого символа в списке строк.
     *
     * @param strings список строк
     * @param symb    символ начала строки
     * @return count
     */
    public static long countStringsStartWith(List<String> strings, char symb) {
        return strings.stream()
                .filter(str -> str.charAt(0) == symb)
                .count();
    }

    /**
     * Отфильтровать список строк и оставить только те, которые содержат определенную подстроку.
     *
     * @param strings   список строк
     * @param substring подстрока
     * @return filtered string
     */
    public static List<String> filterStringContaining(List<String> strings, String substring) {
        return strings.stream()
                .filter(str -> str.contains(substring))
                .toList();
    }

    /**
     * Отсортировать список строк по длине.
     *
     * @param strings список строк
     * @return sorted string by length
     */
    public static List<String> filterStringByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    /**
     * Проверить, все ли элементы списка удовлетворяют определённому условию.
     *
     * @param data      список
     * @param condition условие соответствия
     * @return true if the condition is true, or false in another one
     */
    public static <T> boolean checkCondition(List<T> data, Predicate<T> condition) {
        return data.stream()
                .allMatch(condition);
    }

    /**
     * Найти наименьший элемент в списке, который больше заданного числа.
     *
     * @param numbers     список чисел
     * @param constNumber заданное число
     * @return min value in list
     */
    public static int minValue(List<Integer> numbers, int constNumber) {
        return numbers.stream()
                .filter(num -> num > constNumber)
                .min(Integer::compare)
                .orElse(0);
    }

    /**
     * Преобразовать список строк в список их длин.
     *
     * @param strings список строк
     * @return list of length
     */
    public static List<Integer> convertListStringsToLength(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();

    }
}
