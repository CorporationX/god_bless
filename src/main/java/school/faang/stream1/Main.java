package school.faang.stream1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = IntStream.rangeClosed(1, 6).boxed().toList();
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        System.out.println("Сумма четных чисел: " + ListOperations.sumOfEvenNumbers(numbers));
        System.out.println("Максимум: " + ListOperations.findMax(numbers));
        System.out.println("Среднее: " + ListOperations.findAverage(numbers));
        System.out.println("Количество строк, начинающихся на 'a': " + ListOperations.countStringsStartingWith(strings,
                'a'));
        System.out.println("Строки, содержащие 'an': " + ListOperations.filterStringsContainingSubstring(strings,
                "an"));
        System.out.println("Отсортированные по длине строки: " + ListOperations.sortStringsByLength(strings));
        System.out.println("Все ли числа чётные? " + ListOperations.allMatchCondition(numbers, n -> n % 2 == 0));
        System.out.println("Наименьшее число больше 4: " + ListOperations.findMinGreaterThan(numbers, 4));
        System.out.println("Длины строк: " + ListOperations.convertToLengths(strings));
    }
}
