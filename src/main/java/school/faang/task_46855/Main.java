package school.faang.task_46855;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        System.out.println("Сумма четных чисел: " + StreamOperations.sumOfEvenNumbers(numbers));
        System.out.println("Максимум: " + StreamOperations.findMax(numbers));
        System.out.println("Среднее: " + StreamOperations.findAverage(numbers));
        System.out.println("Количество строк, начинающихся на 'a': "
                + StreamOperations.countStringsStartingWith(strings, 'a'));
        System.out.println("Строки, содержащие 'an': "
                + StreamOperations.filterStringsContainingSubstring(strings, "te"));
        System.out.println("Отсортированные по длине строки: " + StreamOperations.sortByLength(strings));
        System.out.println("Все ли числа чётные? " + StreamOperations.allMatchCondition(numbers, n -> n % 2 == 0));
        System.out.println("Наименьшее число больше 4: " + StreamOperations.findMinGreaterThan(numbers, 4));
        System.out.println("Длины строк: " + StreamOperations.convertToLengths(strings));
    }
}
