package school.faang.bjs2x47077;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        final List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        System.out.println("Сумма четных чисел: " + ListOperations.sumOfEvenNumbers(numbers));
        try {
            System.out.println("Максимум: " + ListOperations.findMax(numbers));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("Среднее: " + ListOperations.findAverage(numbers));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Количество строк, начинающихся на 'a': "
                + ListOperations.countStringsStartingWith(strings, 'a'));
        System.out.println("Строки, содержащие 'an': "
                + ListOperations.filterStringsContainingSubstring(strings, "an"));
        System.out.println("Отсортированные по длине строки: "
                + ListOperations.sortByLength(strings));
        System.out.println("Все ли числа чётные? "
                + ListOperations.allMatchCondition(numbers, n -> n % 2 == 0));
        try {
            System.out.println("Наименьшее число больше 4: "
                    + ListOperations.findMinGreaterThan(numbers, 4));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Длины строк: " + ListOperations.convertToLengths(strings));
    }
}

