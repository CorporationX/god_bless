package school.faang.streamapione;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 5, 20, 15, 3, 7);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        System.out.println(String.format("Сумма четных чисел: %d",
                ListOperations.sumOfEvenNumbers(numbers)));
        System.out.println(String.format("Максимум: %d",
                ListOperations.findMax(numbers)));
        System.out.println(String.format("Среднее: %.2f",
                ListOperations.findAverage(numbers)));
        System.out.println(String.format("Количество строк, начинающихся на 'a': %d",
                ListOperations.countStringsStartingWith(strings,'a')));
        System.out.println(String.format("Строки, содержащие 'an': %s",
                ListOperations.filterStringsContainingSubstring(strings,"an")));
        System.out.println(String.format("Отсортированные по длине строки: %s",
                ListOperations.sortByLength(strings)));
        System.out.println(String.format("Все ли числа чётные? %b",
                ListOperations.allMatchCondition(numbers,n ->n %2==0)));
        System.out.println(String.format("Наименьшее число больше 6: %d",
                ListOperations.findMinGreaterThan(numbers,6)));
        System.out.println(String.format("Количество букв в словах: %s",
                ListOperations.convertToLengths(strings)));
}
}