package school.faang.task_47120;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        System.out.println("\n Сумма четных чисел: " + ListOperations.sumOfEvenNumbers(numbers));
        System.out.println("\n Максимум: " + ListOperations.findMax(numbers));
        System.out.println("\n Среднее: " + ListOperations.findAverage(numbers));
        System.out.println("\n Количество строк, начинающихся на 'a': "
                + ListOperations.countStringsStartingWith(strings, 'a'));
        System.out.println("\n Строки, содержащие 'an': "
                + ListOperations.filterStringsContainingSubstring(strings, "an"));
        System.out.println("\n Отсортированные по длине строки: " + ListOperations.sortByLength(strings));
        System.out.println("\n Все ли числа чётные? " + ListOperations.allMatchCondition(numbers, n -> n % 2 == 0));
        System.out.println("\n Наименьшее число больше 4: " + ListOperations.findMinGreaterThan(numbers, 4));
        System.out.println("\n Длины строк: " + ListOperations.convertToLengths(strings));
    }
}