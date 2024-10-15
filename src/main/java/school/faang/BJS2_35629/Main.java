package school.faang.BJS2_35629;

import java.util.Arrays;
import java.util.List;

import static school.faang.BJS2_35629.ListOperations.allMatchCondition;
import static school.faang.BJS2_35629.ListOperations.convertToLengths;
import static school.faang.BJS2_35629.ListOperations.countStringsStartingWith;
import static school.faang.BJS2_35629.ListOperations.filterStringsContainingSubstring;
import static school.faang.BJS2_35629.ListOperations.findAverage;
import static school.faang.BJS2_35629.ListOperations.findMax;
import static school.faang.BJS2_35629.ListOperations.findMinGreaterThan;
import static school.faang.BJS2_35629.ListOperations.sortByLength;
import static school.faang.BJS2_35629.ListOperations.sumOfEvenNumbers;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        System.out.println("Сумма четных чисел: " + sumOfEvenNumbers(numbers));
        System.out.println("Максимум: " + findMax(numbers));
        System.out.println("Среднее: " + findAverage(numbers));
        System.out.println("Количество строк, начинающихся на 'a': " + countStringsStartingWith(strings, 'a'));
        System.out.println("Строки, содержащие 'an': " + filterStringsContainingSubstring(strings, "an"));
        System.out.println("Отсортированные по длине строки: " + sortByLength(strings));
        System.out.println("Все ли числа чётные? " + allMatchCondition(numbers, n -> n % 2 == 0));
        System.out.println("Наименьшее число больше 4: " + findMinGreaterThan(numbers, 4));
        System.out.println("Длины строк: " + convertToLengths(strings));
    }
}
