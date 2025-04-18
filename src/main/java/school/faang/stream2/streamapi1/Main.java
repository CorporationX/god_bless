package school.faang.stream2.streamapi1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> numbers2 = Arrays.asList(10, 5, 20, 15, 3, 7);
        int threshold = 6;
        String subString = "an";
        char firstLetter = 'a';
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        System.out.println("Сумма четных чисел: " + ListOperations.sumOfEvenNumbers(numbers1));
        System.out.println("Максимум: " + ListOperations.findMax(numbers1));
        System.out.println("Среднее: " + ListOperations.findAverage(numbers1));
        System.out.printf("Количество строк, начинающихся на '%s': %s\n",
                firstLetter, ListOperations.countStringsStartingWith(strings, firstLetter));
        System.out.printf("Строки, содержащие '%s': %s\n",
                subString, ListOperations.filterStringsContainingSubstring(strings, subString));
        System.out.println("Отсортированные по длине строки: " + ListOperations.sortByLength(strings));
        System.out.println("Все ли числа чётные? " + ListOperations.allMatchCondition(numbers1, n -> n % 2 == 0));
        System.out.printf("Наименьшее число больше %s: %s\n",
                threshold, ListOperations.findMinGreaterThan(numbers2, threshold));
        System.out.println("Длины строк: " + ListOperations.convertToLengths(strings));
    }
}
