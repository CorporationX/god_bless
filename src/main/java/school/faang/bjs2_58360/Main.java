package school.faang.bjs2_58360;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        // Пример использования методов:
        System.out.printf("Сумма четных чисел: %d%n", ListOperations.sumOfEvenNumbers(numbers));
        System.out.printf("Максимум: %d%n", ListOperations.findMax(numbers));
        System.out.printf("Среднее: %f%n", ListOperations.findAverage(numbers));
        System.out.printf(
                "Количество строк, начинающихся на 'a': %d%n",
                        ListOperations.countStringsStartingWith(strings, 'a'));
        System.out.println(
                "Строки, содержащие 'an': " +
                ListOperations.filterStringsContainingSubstring(strings, "an")
        );
        System.out.println("Отсортированные по длине строки: " + ListOperations.sortByLength(strings));
        System.out.printf("Все ли числа чётные? %b%n", ListOperations.allMatchCondition(numbers, n -> n % 2 == 0));
        System.out.printf("Наименьшее число больше 4: %d%n", ListOperations.findMinGreaterThan(numbers, 4));
        System.out.println("Длины строк: " + ListOperations.convertToLengths(strings));
    }

}
