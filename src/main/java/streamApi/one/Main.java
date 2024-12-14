package streamApi.one;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "sam", "cherry", "date", "abobus", "anaerobic");

        System.out.println("Сумма четных чисел: " + ListOperations.sumOfEvenNumbers(numbers));
        System.out.println("Максимальное число: " + ListOperations.findMax(numbers));
        System.out.println("Среднее арифметическое: " + ListOperations.findAverage(numbers));
        System.out.println("Количество строк, начинающихся на 'a': " + ListOperations.countStringsStartingWith(strings, 'a'));
        System.out.println("Строки, содержащие 'an': " + ListOperations.filterStringsContainingSubstring(strings, "an"));
        System.out.println("Отсортированные по длине строки: " + ListOperations.sortByLength(strings));
        System.out.println("Все ли числа чётные? " + ListOperations.allMatchCondition(numbers, n -> n % 2 == 0));
        System.out.println("Наименьшее число больше 5: " + ListOperations.findMinGreaterThan(numbers, 5));
        System.out.println("Длины строк: " + ListOperations.convertToLengths(strings));
    }
}
