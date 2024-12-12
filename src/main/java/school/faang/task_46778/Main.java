package school.faang.task_46778;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        try {
            // Пример использования методов:
            System.out.println("Сумма четных чисел: " + ListProcessor.sumOfEvenNumbers(numbers));
            System.out.println("Максимум: " + ListProcessor.findMax(numbers));
            System.out.println("Среднее: " + ListProcessor.findAverage(numbers));
            System.out.println("Количество строк, начинающихся на 'a': "
                    + ListProcessor.countStringsStartingWith(strings, 'a'));
            System.out.println("Строки, содержащие 'an': "
                    + ListProcessor.filterStringsContainingSubstring(strings, "an"));
            System.out.println("Отсортированные по длине строки: " + ListProcessor.sortByLength(strings));
            System.out.println("Все ли числа чётные? " + ListProcessor.allMatchCondition(numbers, n -> n % 2 == 0));
            System.out.println("Наименьшее число больше 4: " + ListProcessor.findMinGreaterThan(numbers, 4));
            System.out.println("Длины строк: " + ListProcessor.convertToLengths(strings));
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }

    }
}
