package school.faang.BJS2_35685;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        List<Integer> numbers = Arrays.asList(6, 2, 4, 4, 21, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "asds");

        // Пример использования методов:
        System.out.println("Сумма чисел: " + ListOperations.sumOfNumbers(numbers));
        System.out.println("Сумма четных чисел: " + ListOperations.sumOfEvenNumbers(numbers));
        System.out.println("Максимум: " + ListOperations.findMax(numbers).orElse(null));
        System.out.println("Среднее: " + ListOperations.findAverage(numbers).orElse(null));
        System.out.println("Количество строк, начинающихся на 'a': " + ListOperations.countStringsStartingWith(strings, 'a'));
        System.out.println("Строки, содержащие 'an': " + ListOperations.filterStringsContainingSubstring(strings, "an"));
        System.out.println("Отсортированные по длине строки: " + ListOperations.sortByLength(strings));
        System.out.println("Все ли числа чётные? " + ListOperations.allMatchCondition(numbers, n -> n % 2 == 0));
        System.out.println("Наименьшее число больше 4: " + ListOperations.findMinGreaterThan(numbers, 100).orElse(null));
        System.out.println("Длины строк: " + ListOperations.convertToLengths(strings));
    }
}
