package school.faang.sprint2.bjs_47065;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        System.out.println("Сумма четных чисел: " + ListOperations.sumEvenNumbers(numbers));
        System.out.println("Максимум: " + ListOperations.maxNumber(numbers));
        System.out.println("Среднее: " + ListOperations.avgNumber(numbers));
        System.out.println("Количество строк, начинающихся на 'a': "
                + ListOperations.countStartsWithStrings(strings, 'a'));
        System.out.println("Строки, содержащие 'an': " + ListOperations.filteredSubstrings(strings, "an"));
        System.out.println("Отсортированные по длине строки: " + ListOperations.sortedByLength(strings));
        System.out.println("Все ли числа чётные? " + ListOperations.isAllPositive(numbers, n -> n % 2 == 0));
        System.out.println("Наименьшее число больше 4: " + ListOperations.minValue(numbers, 4));
        System.out.println("Длины строк: " + ListOperations.convertListStringsToListLengths(strings));
    }
}
