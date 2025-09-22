package school.faang.streamapi_1;

import java.util.List;

/**
 * Проект: god_bless
 * Класс Main
 * Автор: Vital
 * Дата: 22.09.2025
 */

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<String> strings = List.of("apple", "banan", "cherry", "pineapple", "strawberry");

        System.out.printf("Сумма четных чисел: %d%n", ListOperations.sumOfEvenNumbers(numbers));
        System.out.printf("Максимум: %d%n", ListOperations.findMax(numbers));
        System.out.printf("Среднее: %.2f%n", ListOperations.findAverage(numbers));
        System.out.printf("Количество строк, начинающихся на 'b': %d%n",
                ListOperations.countStringsStartinWith(strings, 'b'));
        System.out.printf("Строки, содержащие 'pi': %s%n",
                ListOperations.filterStringsContainingSubstring(strings, "pi"));
        System.out.printf("Отсортированные по длине строки: %s%n", ListOperations.sortByLength(strings));
        System.out.printf("Все ли числа нечетные? %b%n",
                ListOperations.allMatchCondition(numbers, n -> n % 2 != 0));
        System.out.printf("Наименьшее число больше 6: %d%n", ListOperations.findMinGreaterThan(numbers, 6));
        System.out.printf("Длины строк: %s%n", ListOperations.convertToLengths(strings));
    }
}