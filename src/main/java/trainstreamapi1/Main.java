package trainstreamapi1;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        // Пример использования методов:
        System.out.println("Сумма четных чисел: " + ListOperations.sumEvenNumbers(numbers));
        System.out.println("Максимум: " + ListOperations.findMaxNumber(numbers));
        System.out.println("Среднее: " + ListOperations.findAvgNumber(numbers));
        System.out.println("Количество строк, начинающихся на 'a': " + ListOperations.countStringsStartingWith(strings, 'a'));
        System.out.println("Строки, содержащие 'an': " + ListOperations.filterStringsContaining(strings, "an"));
        System.out.println("Отсортированные по длине строки: " + ListOperations.sortStringsByLength(strings));
        System.out.println("Все ли числа чётные? " + ListOperations.allElementsMatchCondition(numbers, n -> n % 2 == 0));
        System.out.println("Наименьшее число больше 4: " + ListOperations.findSmallestElementGreaterThan(numbers, 4));
        System.out.println("Длины строк: " + ListOperations.mapStringsToLengths(strings));
    }
}

