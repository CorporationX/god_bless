package school.faang.training.streamapi1;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        final List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        System.out.printf("Сумма четных чисел: %d%n", ListOperations.sumOfEvenNumbers(numbers));
        try {
            System.out.printf("Максимум: %d%n", ListOperations.findMax(numbers));
        } catch (NoSuchElementException e) {
            System.out.println("Максимум: список пуст");
        }
        System.out.printf("Среднее: %.2f%n", ListOperations.findAverage(numbers));
        System.out.printf("Количество строк, начинающихся на 'a': %d%n",
                ListOperations.countStringsStartingWith(strings, 'a'));
        System.out.printf("Строки, содержащие 'an': %s%n",
                ListOperations.filterStringsContainingSubstring(strings, "an"));
        System.out.printf("Отсортированные по длине строки: %s%n", ListOperations.sortByLength(strings));
        System.out.printf("Все ли числа чётные? %b%n",
                ListOperations.allMatchCondition(numbers, n -> n % 2 == 0));
        try {
            System.out.printf("Наименьшее число больше 4: %d%n", ListOperations.findMinGreaterThan(numbers, 4));
        } catch (NoSuchElementException e) {
            System.out.println("Наименьшее число больше 4: не найдено");
        }
        System.out.printf("Длины строк: %s%n", ListOperations.convertToLengths(strings));
    }
}
