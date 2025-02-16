package school.faang.BJS2_58325;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        System.out.println("Сумма четных чисел: %d".formatted(ListOperations.sumOfEvenNumbers(numbers)));
        System.out.println("Максимум: %d".formatted(ListOperations.findMax(numbers)));
        System.out.println("Среднее: %.2f".formatted(ListOperations.findAverage(numbers)));
        System.out.println("Количество строк, начинающихся на 'a': %d".formatted(
                ListOperations.countStringsStartingWith(strings, 'a')));
        System.out.println("Строки, содержащие 'an': %s".formatted(
                ListOperations.filterStringsContainingSubstring(strings, "an")));
        System.out.println("Отсортированные по длине строки: %s".formatted(ListOperations.sortByLength(strings)));
        System.out.println("Все ли числа чётные? %b".formatted(
                ListOperations.allMatchCondition(numbers, n -> n % 2 == 0)));
        System.out.println("Наименьшее число больше 4: %d".formatted(ListOperations.findMinGreaterThan(numbers, 4)));
        System.out.println("Длины строк: %s".formatted(ListOperations.convertToLengths(strings)));
    }
}