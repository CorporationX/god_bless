package school.faang.lets_practice_streamAPI_1.BJS2_58330;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        System.out.printf("Сумма четных чисел: %d%n", ListOperations.sumOfEvenNumbers(numbers));
        System.out.printf("Максимум: %d%n", ListOperations.findMax(numbers));
        System.out.printf("Среднее: %.1f%n", ListOperations.findAverage(numbers));
        System.out.printf("Количество строк, начинающихся на 'a': %s%n",
                ListOperations.countStringsStartingWith(strings, 'a'));
        System.out.printf("Строки, содержащие 'an': %s%n",
                ListOperations.filterStringsContainingSubstring(strings, "an"));
        System.out.printf("Отсортированные по длине строки: %s%n",
                ListOperations.sortByLength(strings));
        System.out.printf("Все ли числа чётные? %b%n",
                ListOperations.allMatchCondition(numbers, n -> n % 2 == 0));
        System.out.printf("Наименьшее число больше 4: %d%n",
                ListOperations.findMinGreaterThan(numbers, 4));
        System.out.printf("Длины строк: %s%n", ListOperations.convertToLengths(strings));
    }
}
