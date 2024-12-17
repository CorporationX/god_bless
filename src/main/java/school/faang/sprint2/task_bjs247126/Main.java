package school.faang.sprint2.task_bjs247126;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> emptyList = List.of();
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "average", "anaconda");

        System.out.println("Сумма четных чисел: " + ListOperations.sumOfEvenNumbers(numbers));
        System.out.println("Максимум: " + ListOperations.findMax(numbers));
        System.out.println("Среднее: " + ListOperations.findAverage(numbers));
        System.out.println("Количество строк, начинающихся на 'a': "
                + ListOperations.countStringsStartingWith(strings, 'a'));
        System.out.println("Строки, содержащие 'an': "
                + ListOperations.filterStringsContainingSubstring(strings, "an"));
        System.out.println("Отсортированные по длине строки: " + ListOperations.sortByLength(strings));
        System.out.println("Все ли числа чётные? " + ListOperations.allMatchCondition(numbers, n -> n % 2 == 0));
        System.out.println("Наименьшее число больше 4: " + ListOperations.findMinGreaterThan(numbers, 4));
        System.out.println("Наименьшее число больше 4: " + ListOperations.findMinGreaterThan(emptyList, 4));
        System.out.println("Длины строк: " + ListOperations.convertToLengths(strings));
    }
}
