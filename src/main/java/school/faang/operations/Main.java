package school.faang.operations;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "berry", "date");

        System.out.println("Cумма всех чётных чисел: " + ListOperations.sumOfEven(numbers));
        System.out.println("Максимальное значение: " + ListOperations.findMaxNumber(numbers));
        System.out.println("Среднее значение: " + ListOperations.findAverage(numbers));
        System.out.println("Количество строк, начинающихся на 'b': "
                + ListOperations.countByFirstLetter(strings, 'b'));
        System.out.println("Строки, содержащие 'erry': "
                + ListOperations.filterBySubstring(strings, "erry"));
        System.out.println("Сортировка по длине строк: " + ListOperations.sortStringByLength(strings));
        System.out.println("Удовлетворяют условию: "
                + ListOperations.checkByCondition(numbers, n -> n % 2 != 0));
        System.out.println("Наименьшее число больше 3: " + ListOperations.findMinGreaterThan(numbers, 3));
        System.out.println("Длины строк: " + ListOperations.convertStringsToLength(strings));
    }
}