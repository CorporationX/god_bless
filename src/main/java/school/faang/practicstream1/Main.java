package school.faang.practicstream1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        // Пример использования методов:
        System.out.println("Сумма четных чисел: " + ListOperation.sumOfEvenNumbers(numbers));
        System.out.println("Максимум: " + ListOperation.findMaxElement(numbers));
        System.out.println("Среднее: " + ListOperation.findAverageValue(numbers));
        System.out.println("Количество строк, начинающихся на 'a': " +
                ListOperation.countStringStartWithChar(strings, 'a'));
        System.out.println("Строки, содержащие 'an': " + ListOperation.filterSubstring(strings, "an"));
        System.out.println("Отсортированные по длине строки: " + ListOperation.sortedStringsByLength(strings));
        System.out.println("Все ли числа чётные? " + ListOperation.checkCondition(numbers, n -> n % 2 == 0));
        System.out.println("Наименьшее число больше 4: " + ListOperation.findMixElementAndMoreValue(numbers, 4));
        System.out.println("Длины строк: " + ListOperation.transformationStringToLength(strings));
    }
}