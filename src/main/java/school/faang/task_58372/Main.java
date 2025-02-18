package school.faang.task_58372;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "pear");

        System.out.println("Сумма четных чисел: " + ListOfOperations.sumOfEvenNumbers(numbers));
        System.out.println("Максимум: " + ListOfOperations.findMax(numbers));
        System.out.println("Среднее: " + ListOfOperations.findAverage(numbers));
        System.out.println("Количество строк, начинающихся на 'a': "
                + ListOfOperations.countStringsStartingWith(strings, 'a'));
        System.out.println("Строки, содержащие 'an': "
                + ListOfOperations.filterStringsContainingSubstring(strings, "an"));
        System.out.println("Отсортированные по длине строки: " + ListOfOperations.sortByLength(strings));
        System.out.println("Все ли числа чётные? "
                + ListOfOperations.allMatchCondition(numbers, n -> n % 2 == 0));
        System.out.println("Наименьшее число больше 4: " + ListOfOperations.findMinGreaterThan(numbers, 4));
        System.out.println("Длины строк: " + ListOfOperations.convertToLengths(strings));

    }
}
