package school.faang.sprint_2.task_bjs247136;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        System.out.println("Сумма четных чисел: " + ListOperations.sumEvenNumbers(numbers));
        System.out.println("Максимум: " + ListOperations.maxNumber(numbers));
        System.out.println("Среднее: " + ListOperations.averageNumber(numbers));
        System.out.println("Количество строк на 'a': " + ListOperations.countStringStartsWith(strings, 'a'));
        System.out.println("Строки, содержащие 'an': " + ListOperations.stringContains(strings, "an"));
        System.out.println("Отсортированные по длине строки: " + ListOperations.orderByStringsLength(strings));
        System.out.println("Все ли числа чётные? " + ListOperations.allMatchCondition(numbers, n -> n % 2 == 0));
        System.out.println("Наименьшее число больше 4: " + ListOperations.minNumberAboveBorder(numbers, 4));
        System.out.println("Длины строк: " + ListOperations.stringsToLength(strings));
    }
}
