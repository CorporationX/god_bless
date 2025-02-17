package teststream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        System.out.printf("Сумма четных чисел: %d%n", ListOperations.findSumOfEvenNumbers(numbers));
        System.out.printf("Максимум: %d%n", ListOperations.findMax(numbers));
        System.out.printf("Среднее: %.2f%n", ListOperations.findAverage(numbers));
        System.out.printf("Количество строк, начинающихся на 'a': %d%n",
                ListOperations.countStringsStartingWith(strings, 'a'));
        System.out.printf("Строки, содержащие 'an': %s%n",
                ListOperations.findStringsContainingSubstring(strings, "an"));
        System.out.printf("Отсортированные по длине строки: %s%n", ListOperations.sortByLength(strings));
        System.out.printf("Все ли числа чётные? %b%n", ListOperations.allMatchCondition(numbers, n -> n % 2 == 0));
        System.out.printf("Наименьшее число больше 4: %d%n", ListOperations.findMinGreaterThan(numbers, 4));
        System.out.printf("Длины строк: %s%n", ListOperations.convertToLengths(strings));

        List<Integer> extremeValues = Arrays.asList(Integer.MIN_VALUE, -1, 0, 1, Integer.MAX_VALUE);

        System.out.printf("Сумма четных чисел (граничные значения): %d%n",
                ListOperations.findSumOfEvenNumbers(extremeValues));
        System.out.printf("Максимум (граничные значения): %d%n", ListOperations.findMax(extremeValues));
        System.out.printf("Среднее (граничные значения): %.2f%n", ListOperations.findAverage(extremeValues));
        System.out.printf("Все ли числа чётные (граничные значения)? %b%n",
                ListOperations.allMatchCondition(numbers, n -> n % 2 == 0));
        System.out.printf("Наименьшее число больше 0 (граничные значения): %d%n",
                ListOperations.findMinGreaterThan(extremeValues, 0));
    }
}
