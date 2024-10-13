package school.faang.streamapione;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 4, 5, 7, 10);
        List<String> strings = Arrays.asList("Hello", "Bye", "Road", "Practice", "World");

        System.out.println("Сумма четных чисел: " + StreamProcessor.sumEvenNumbers(numbers));
        System.out.println("Максимальное число: " + StreamProcessor.findMaxNumber(numbers));
        System.out.println("Среднее: " + StreamProcessor.findAverageNumber(numbers));
        System.out.println("Количество строк, начинающихся на 'B': " + StreamProcessor.countNumberOfStringWithSpecialPrefix(strings, 'B'));
        System.out.println("Строки, содержащие 'or': " + StreamProcessor.findStringWithSpecialSubstring(strings, "or"));
        System.out.println("Отсортированные по длине строки: " + StreamProcessor.sortListByValuesLength(strings));
        System.out.println("Все ли числа чётные? " + StreamProcessor.checkIfNumbersAreCorrect(numbers, n -> n % 2 == 0));
        System.out.println("Наименьшее число больше 4: " + StreamProcessor.findMinNumberButGreaterThanInputNumber(numbers, 4));
        System.out.println("Длины строк: " + StreamProcessor.convertStringsToLengthOfStrings(strings));
    }
}
