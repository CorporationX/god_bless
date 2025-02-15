package school.faang.BJS2_58264;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 13, -34, 3, 17, 23, -10, 21, 100);
        System.out.printf("Сумма четных чисел = %d\n", ListOperations.sumOfEvenNumbers(numbers));
        System.out.printf("Максимум = %d\n", ListOperations.findMax(numbers));
        System.out.println("Среднее = " + ListOperations.findAverage(numbers));

        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");
        System.out.println("Количество строк, начинающихся на 'b': "
                + ListOperations.countStrStartingWith(strings, 'b'));
        System.out.println("Строки, содержащие 'an': "
                + ListOperations.filterStrContainingSubstr(strings, "an"));
        System.out.println("Отсортированные по длине строки: " + ListOperations.sortByLength(strings));
        System.out.println("Все ли числа чётные? " + ListOperations.allMatchCondition(numbers, n -> n > 0));
        System.out.println("Наименьшее число больше 4: " + ListOperations.findMinGreaterThan(numbers, 4));
        System.out.println("Длины строк: " + ListOperations.convertToLengths(strings));
    }
}
