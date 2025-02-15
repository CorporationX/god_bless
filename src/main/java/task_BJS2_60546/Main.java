package task_BJS2_60546;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = List.of("apple", "banana", "cherry", "date");
        List<String> listWithOneStringElement = List.of("cherry");
        List<Integer> listWithOneIntElement = List.of(5);
        List<String> emptyStringList = new ArrayList<>();
        List<Integer> emptyIntList = new ArrayList<>();

        System.out.printf("Сумма четных чисел: %d\n", ListOperations.getSumOfEvenNumbers(numbers));
        System.out.printf("Максимум: %d\n", ListOperations.getMaxNumber(numbers));
        System.out.printf("Среднее: %f\n", ListOperations.getAverageNumber(numbers));
        System.out.printf("Количество строк, начинающихся на 'a': %s\n",
                ListOperations.countStringsStartingWith(strings, 'a'));
        System.out.printf("Строки, содержащие 'an': %s\n",
                ListOperations.filterStringsContainingSubstring(strings, "an"));
        System.out.printf("Отсортированные по длине строки: %s\n", ListOperations.sortByLength(strings));
        System.out.printf("Все ли числа чётные? %b\n", ListOperations.allMatchCondition(numbers, n -> n % 2 == 0));
        System.out.printf("Наименьшее число больше 4: %d\n", ListOperations.findMinGreaterThan(numbers, 4));
        System.out.printf("Длины строк: %s\n", ListOperations.convertToLengths(strings));


        System.out.printf("Сумма четных чисел: %d\n", ListOperations.getSumOfEvenNumbers(listWithOneIntElement));
        System.out.printf("Максимум: %d\n", ListOperations.getMaxNumber(listWithOneIntElement));
        System.out.printf("Среднее: %f\n", ListOperations.getAverageNumber(listWithOneIntElement));
        System.out.printf("Количество строк, начинающихся на 'a': %s\n",
                ListOperations.countStringsStartingWith(listWithOneStringElement, 'a'));
        System.out.printf("Строки, содержащие 'an': %s\n",
                ListOperations.filterStringsContainingSubstring(listWithOneStringElement, "an"));
        System.out.printf("Отсортированные по длине строки: %s\n",
                ListOperations.sortByLength(listWithOneStringElement));
        System.out.printf("Все ли числа чётные? %b\n", ListOperations.allMatchCondition(listWithOneIntElement,
                n -> n % 2 == 0));
        System.out.printf("Наименьшее число больше 4: %d\n", ListOperations.findMinGreaterThan(listWithOneIntElement,
                4));
        System.out.printf("Длины строк: %s\n", ListOperations.convertToLengths(listWithOneStringElement));


        System.out.printf("Сумма четных чисел: %d\n", ListOperations.getSumOfEvenNumbers(emptyIntList));
        System.out.printf("Максимум: %d\n", ListOperations.getMaxNumber(emptyIntList));
        System.out.printf("Среднее: %f\n", ListOperations.getAverageNumber(emptyIntList));
        System.out.printf("Количество строк, начинающихся на 'a': %s\n",
                ListOperations.countStringsStartingWith(emptyStringList, 'a'));
        System.out.printf("Строки, содержащие 'an': %s\n",
                ListOperations.filterStringsContainingSubstring(emptyStringList, "an"));
        System.out.printf("Отсортированные по длине строки: %s\n",
                ListOperations.sortByLength(emptyStringList));
        System.out.printf("Все ли числа чётные? %b\n", ListOperations.allMatchCondition(emptyIntList,
                n -> n % 2 == 0));
        System.out.printf("Наименьшее число больше 4: %d\n", ListOperations.findMinGreaterThan(emptyIntList,
                4));
        System.out.printf("Длины строк: %s\n", ListOperations.convertToLengths(emptyStringList));
    }
}
