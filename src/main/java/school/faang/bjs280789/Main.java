package school.faang.bjs280789;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        System.out.println("Сумма четных чисел: " + ListUtils.sumOfEvenNumbers(nums));
        System.out.println("Максимум: " + ListUtils.findMax(nums));
        System.out.println("Среднее: " + ListUtils.findAverage(nums));
        System.out.println("Количество строк, начинающихся на 'a': " + ListUtils.countStringsStartingWith(strings, 'a'));
        System.out.println("Строки, содержащие 'an': " + ListUtils.filterStringsContainingSubstring(strings, "an"));
        System.out.println("Отсортированные по длине строки: " + ListUtils.sortByLength(strings));
        System.out.println("Все ли числа чётные? " + ListUtils.allMatchCondition(nums, n -> n % 2 == 0));
        System.out.println("Наименьшее число больше 4: " + ListUtils.findMinGreaterThan(nums, 4));
        System.out.println("Длины строк: " + ListUtils.convertToLengths(strings));
    }
}
