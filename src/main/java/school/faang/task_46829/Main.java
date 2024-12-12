package school.faang.task_46829;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 7);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        System.out.println("Сумма четных чисел: " + ListOperation.sumOfEvenNumbers(numbers));
        System.out.println("Максимум: " + ListOperation.maxInt(numbers));
        System.out.println("Среднее: " + ListOperation.findAverage(numbers));
        System.out.println("Количество строк, начинающихся на 'a': "
                + ListOperation.countStringsStartingWith(strings, 'a'));
        System.out.println("Строки, содержащие 'an': "
                + ListOperation.filterStringsContainingSubstring(strings, "an"));
        System.out.println("Отсортированные по длине строки: " + ListOperation.sortByLength(strings));
        System.out.println("Все ли числа чётные? " + ListOperation.allMatchCondition(numbers, n -> n % 2 == 0));
        System.out.println("Наименьшее число больше 4: " + ListOperation.findMinGreaterThan(numbers, 4));
        System.out.println("Длины строк: " + ListOperation.convertToLengths(strings));
    }
}

