package school.faang.bjs247027;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        System.out.println("Сумма четных чисел: " + Utilities.sumOfEvenNumbers(numbers));
        System.out.println("Максимум: " + Utilities.findMax(numbers));
        System.out.println("Среднее: " + Utilities.findAverage(numbers));
        System.out.println("Количество строк, начинающихся на 'a': "
                + Utilities.countStringsStartingWith(strings, 'a'));
        System.out.println("Строки, содержащие 'an': " + Utilities.filterStringsContainingSubstring(strings, "an"));
        System.out.println("Отсортированные по длине строки: " + Utilities.sortByLength(strings));
        System.out.println("Все ли числа чётные? " + Utilities.allMatchCondition(numbers, n -> n % 2 == 0));
        System.out.println("Наименьшее число больше 4: " + Utilities.findMinGreaterThan(numbers, 4));
        System.out.println("Длины строк: " + Utilities.convertToLengths(strings));
    }
}
