package school.faang.stream2.streamapipractice1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> evenNumbers = Arrays.asList(12, 2, 32, 4, 58, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        System.out.println("Сумма четных чисел: " + ListOperations.sumOfEvenNumbers(numbers));
        System.out.println("Максимум: " + ListOperations.findMax(numbers));
        System.out.println("Среднее: " + ListOperations.computeAverage(numbers));
        System.out.println("Количество строк, начинающихся на 'a': " + ListOperations
                .countStringsStartingWith(strings, 'a'));
        System.out.println("Строки, содержащие 'an': " + ListOperations
                .filterStringsContainingSubstring(strings, "an"));
        System.out.println("Отсортированные по длине строки: " + ListOperations.sortByLength(strings));
        System.out.println("Все ли числа чётные в numbers? " + ListOperations
                .allMatchCondition(numbers, n -> n % 2 == 0));
        System.out.println("Все ли числа чётные в evenNumbers? " + ListOperations
                .allMatchCondition(evenNumbers, n -> n % 2 == 0));
        System.out.println("Наименьшее число больше 4: " + ListOperations.findMinGreaterThan(numbers, 4));
        System.out.println("Длины строк: " + ListOperations.convertToLengths(strings));
    }
}
