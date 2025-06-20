package school.faang.bjs280781;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        // Пример использования методов:
        System.out.println("Сумма четных чисел: " + ListManagment.sumOfEvenNambers(numbers));
        System.out.println("Максимум: " + ListManagment.maxNumber(numbers));
        System.out.println("Среднее: " + ListManagment.averageValue(numbers));
        System.out.println("Количество строк, начинающихся на 'a': " 
                           + ListManagment.linesWithTheSameBeginning(strings, 'a'));
        System.out.println("Строки, содержащие 'an': " + ListManagment.wordStringFilter(strings, "an"));
        System.out.println("Отсортированные по длине строки: " + ListManagment.sortByStringLength(strings));
        System.out.println("Все ли числа чётные? " + ListManagment.customConditionCheck(numbers, n -> n % 2 == 0));
        System.out.println("Наименьшее число больше 4: " + ListManagment.findMinGreaterThan(numbers, 4));
        System.out.println("Длины строк: " + ListManagment.convertToLengths(strings));
    }
}
