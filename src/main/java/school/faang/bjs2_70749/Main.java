package school.faang.bjs2_70749;

import java.util.Arrays;
import java.util.List;

public class Main {

    private static final List<Integer> NUMBERS = Arrays.asList(1, 2, 3, 4, null, 5, 6);
    private static final List<String> STRINGS = Arrays.asList("apple", "banana", null, "cherry", "date");

    public static void main(String[] args) {


        // Пример использования методов:
        System.out.println("Сумма четных чисел: " + ListOperations.sumOfEvenNumbers(NUMBERS));

        try {
            System.out.println("Максимум: " + ListOperations.findMax(NUMBERS));
        } catch (ValueNotFoundException ex) {
            System.out.println("Максимум: " + ex.getMessage());
        }

        try {
            System.out.println("Среднее: " + ListOperations.findAverage(NUMBERS));
        } catch (ValueNotFoundException ex) {
            System.out.println("Среднее: " + ex.getMessage());
        }

        System.out.println("Количество строк, начинающихся на 'a': "
                + ListOperations.countStringsStartingWith(STRINGS, 'a'));
        System.out.println("Строки, содержащие 'an': "
                + ListOperations.filterStringsContainingSubstring(STRINGS, "an"));

        System.out.println("Отсортированные по длине строки: " + ListOperations.sortByLength(STRINGS));

        System.out.println("Все ли числа чётные? " + ListOperations.allMatchCondition(NUMBERS, n -> n % 2 == 0));

        try {
            System.out.println("Наименьшее число больше 4: " + ListOperations.findMinGreaterThan(NUMBERS, 4));
        } catch (ValueNotFoundException ex) {
            System.out.println("Наименьшее число больше 4: " + ex.getMessage());
        }

        System.out.println("Длины строк: " + ListOperations.convertToLengths(STRINGS));
    }
}
