package school.faang.bjs2_70706;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> numbersWithNull = Arrays.asList(1, 2, 3, null, 4, 5, 6, null);
        List<Integer> evenNumbers = Arrays.asList(2, 4, 6);
        List<Integer> emptyList = new ArrayList<>();
        List<String> stringsWithNull = Arrays.asList(
            "apple", "banana", "cherry", "date", "", "animal", "island", "angle", null, "  "
        );
        List<String> strings = Arrays.asList(
            "apple", "banana", "cherry", "date", "", "animal", "island", "angle", "  "
        );

        System.out.printf("Сумма четных чисел: %s\n", ListOperations.sumOfEvenNumbers(numbers));
        System.out.printf("Максимум: %d\n", ListOperations.findMax(numbers));
        System.out.printf("Максимум (null): %d\n", ListOperations.findMax(numbersWithNull));
        System.out.printf("Среднее: %s\n", ListOperations.findAverage(numbers));
        System.out.printf("Среднее: %s\n", ListOperations.findAverage(numbersWithNull));
        System.out.printf("Количество строк, начинающихся на 'a': %s\n",
            ListOperations.countStringsStartingWith(strings, 'a'));
        System.out.printf("Количество строк, начинающихся на 'a': %s\n",
            ListOperations.countStringsStartingWith(stringsWithNull, 'a'));
        System.out.printf("Строки, содержащие 'an': %s\n",
            ListOperations.filterStringsContainingSubstring(strings, "an"));
        System.out.printf("Строки, содержащие 'an': %s\n",
            ListOperations.filterStringsContainingSubstring(stringsWithNull, "an"));
        System.out.printf("Отсортированные по длине строки: %s\n", ListOperations.sortByLength(strings));
        System.out.printf("Отсортированные по длине строки: %s\n", ListOperations.sortByLength(stringsWithNull));
        System.out.printf("Все ли числа чётные? %s\n", ListOperations.allMatchCondition(numbers, n -> n % 2 == 0));
        System.out.printf("Все ли числа чётные? %s\n", ListOperations.allMatchCondition(evenNumbers, n -> n % 2 == 0));
        System.out.printf("Наименьшее число больше 4: %s\n", ListOperations.findMinGreaterThan(numbers, 4));
        System.out.printf("Наименьшее число больше 4: %s\n", ListOperations.findMinGreaterThan(numbersWithNull, 4));
        System.out.printf("Длины строк: %s\n", ListOperations.convertToLengths(stringsWithNull));
        System.out.printf("Длины строк: %s\n", ListOperations.convertToLengths(strings));
    }
}
