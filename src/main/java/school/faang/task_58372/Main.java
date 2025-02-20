package school.faang.task_58372;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "pear");

        System.out.printf("Сумма четных чисел: %d%n", ListOfOperations.sumOfEvenNumbers(numbers));
        System.out.printf("Максимум: %d%n", ListOfOperations.findMax(numbers));
        System.out.printf("Среднее: %.2f%n", ListOfOperations.findAverage(numbers));
        System.out.printf("Количество строк, начинающихся на 'a': %d%n",
                ListOfOperations.countStringsStartingWith(strings, 'a'));
        System.out.printf("Строки, содержащие 'an': %s%n",
                ListOfOperations.filterStringsContainingSubstring(strings, "an"));
        System.out.printf("Отсортированные по длине строки: %s%n",
                ListOfOperations.sortByLength(strings));
        System.out.printf("Все ли числа чётные? %b%n",
                ListOfOperations.allMatchCondition(numbers, n -> n % 2 == 0));
        System.out.printf("Наименьшее число больше 4: %d%n",
                ListOfOperations.findMinGreaterThan(numbers, 4));
        System.out.printf("Длины строк: %s%n",
                ListOfOperations.convertToLengths(strings));
    }
}
