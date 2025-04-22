package school.faang.streamapi1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> numbers2 = Arrays.asList(6, 2, 8);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "april");

        System.out.println("Сумма четных чисел: " + ListOperations.sumOfEvenNumbers(numbers));
        System.out.println("Максимум: " + ListOperations.maxNumber(numbers));
        System.out.println("Среднее: " + ListOperations.findAverage(numbers));
        System.out.println("Кол-во строк, нач. на 'a':" +
                ListOperations.countStringsStartingWithSymbol(strings, 'a'));
        System.out.println("Строки, содержащие 'ap': " + ListOperations.filterBySubstring(strings, "ap"));
        System.out.println("Отсортированные по длине строки: " + ListOperations.sortByLength(strings));
        System.out.println("Все ли числа чётные? " + ListOperations.allMatchCondition(numbers2, n -> n % 2 == 0));
        System.out.println("Наименьшее число больше 4: " + ListOperations.findMinGreaterThan(numbers, 4));
        System.out.println("Длины строк: " + ListOperations.convertToLengths(strings));
    }
}
