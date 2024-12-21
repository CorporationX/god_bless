package school.faang.sprint2.bjs247254;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(23, 53, 46, 1, 6, 765, 8, 6, 4);
        List<String> strings = Arrays.asList("cat", "dog", "pig", "horse", "bird", "delf", "or");

        System.out.println("Сумма четных чисел — " + ListOperations.sumUpEvenNumbers(numbers));
        System.out.println("Максимальное число в списке — " + ListOperations.findMax(numbers));
        System.out.println("Среднее значение — " + ListOperations.findAverage(numbers));
        System.out.println("Кол-во строк начинающихся на 'd' — " + ListOperations.findCountOfRowsStartingWith(strings, 'd'));
        System.out.println("Строки, содержащие 'or' — " + ListOperations.filterBySubstring(strings, "or"));
        System.out.println("Отсортированные строки по длине строки — " + ListOperations.sortByLength(strings));
        System.out.println("Все ли числа четные? — " + ListOperations.allMatchCondition(numbers, number -> number % 2 == 0));
        System.out.println("Минимальное число, большее 10 — " + ListOperations.findMinGreaterThan(numbers, 10));
        System.out.println("Длины строк — " + ListOperations.mappingToLengths(strings));
    }
}
