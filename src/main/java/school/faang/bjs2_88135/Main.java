package school.faang.bjs2_88135;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");
        System.out.printf("Сумма четных чисел: %d\n", ListOperations.sumOfEvenNumbers(numbers));
        try {
            System.out.printf("Максимум: %d\n", ListOperations.findMax(numbers));
            System.out.printf("Среднее: %f\n", ListOperations.findAverage(numbers));
            System.out.printf("%nНаименьшее число больше 4: %d%n", ListOperations.findMinGreaterThan(numbers, 4));
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        System.out.printf("Количество строк, начинающихся на 'a': %s\n",
                ListOperations.countStringsStartingWith(strings, 'a'));
        System.out.printf("Строки, содержащие 'an': %s\n",
                ListOperations.filterStringsContainingSubstring(strings, "an"));
        System.out.printf("Отсортированные по длине строки: %s", ListOperations.sortByLength(strings));
        System.out.printf("%nВсе ли числа чётные?: %b", ListOperations.allMatchCondition(numbers, n -> n % 2 == 0));
        System.out.print("Длины строк: " + ListOperations.convertToLengths(strings).toString());
    }
}
