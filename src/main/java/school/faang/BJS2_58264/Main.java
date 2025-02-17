package school.faang.BJS2_58264;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 13, -34, 3, 17, 23, -10, 21, 100);
        System.out.printf("Сумма четных чисел = %d\n", ListOperations.sumOfEvenNumbers(numbers));
        System.out.printf("Максимум = %d\n", ListOperations.findMax(numbers));
        System.out.printf("Среднее = %.2f\n", ListOperations.findAverage(numbers));

        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");
        System.out.printf("Количество строк, начинающихся на 'b': %d\n",
                ListOperations.countStrStartingWith(strings, 'b'));
        System.out.printf("Строки, содержащие 'an': %s\n",
                ListOperations.filterStrContainingSubstr(strings, "an"));
        System.out.printf("Отсортированные по длине строки: %s\n",
                ListOperations.sortByLength(strings));
        System.out.printf("Все ли числа чётные? %b\n", ListOperations.allMatchCondition(numbers, n -> n > 0));
        System.out.printf("Наименьшее число больше 4: %d\n", ListOperations.findMinGreaterThan(numbers, 4));
        System.out.printf("Длины строк: %s\n", ListOperations.convertToLengths(strings));
    }
}
