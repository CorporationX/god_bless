package school.faang.stream_api_first_task;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        System.out.println("Сумма четных чисел: " + ListOperations.sumEvenNums(numbers));

        System.out.println("Максимум: " + ListOperations.findBiggestElement(numbers));
        System.out.println("Среднее: " + ListOperations.getAverage(numbers));
        System.out.println("Количество строк, начинающихся на 'a': " +
                ListOperations.findAmountOfStringsStartsWith(strings, 'a'));
        System.out.println("Строки, содержащие 'an': " + ListOperations.findAmountOfStringsStartsWith(strings, 'd'));
        System.out.println("Отсортированные по длине строки: " + ListOperations.sortStringsByLength(strings));
        System.out.println("Все ли числа чётные? " + ListOperations
                .isGreaterThanCertainElement(numbers, n -> n % 2 == 0));
        System.out.println("Наименьшее число больше 4: " + ListOperations.findLowestElementAtList(numbers, 4));
        System.out.println("Длины строк: " + ListOperations.transformStringsToLengths(strings));
    }
}
