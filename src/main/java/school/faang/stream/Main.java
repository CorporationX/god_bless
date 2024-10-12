package school.faang.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        // Пример использования методов:
        System.out.println("Сумма четных чисел: " + Transform.sumOfEvenNumbers(numbers));
        System.out.println("Максимум: " + Transform.findMax(numbers));
        System.out.println("Среднее: " + Transform.findAverage(numbers));
        System.out.println("Количество строк, начинающихся на 'a': " + Transform.countStringsStartingWith(strings, 'a'));
        System.out.println("Строки, содержащие 'an': " + Transform.filterStringsContainingSubstring(strings, "an"));
        System.out.println("Отсортированные по длине строки: " + Transform.sortByLength(strings));
        System.out.println("Все ли числа чётные? " + Transform.allMatchCondition(numbers, n -> n % 2 == 0));
        System.out.println("Наименьшее число больше 4: " + Transform.findMinGreaterThan(numbers, 4));
        System.out.println("Длины строк: " + Transform.convertToLengths(strings));
    }
}


