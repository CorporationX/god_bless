package school.faang;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        System.out.println(String.format("Сумма четных чисел: %d", ListOperation.sumNumbers(numbers)));
        System.out.println(String.format("Максимум: %d", ListOperation.maxNumbers(numbers)));
        System.out.println(String.format("Среднее: %2f", ListOperation.averageNumbers(numbers)));
        System.out.println(String.format("Количество строк, начинающихся на 'a': %d",
                 ListOperation.startNumbersSpecificChar(strings, 'a')));
        System.out.println(String.format("Строки, содержащие 'an': %s",
                ListOperation.listSpecificSubstring(strings, "an")));
        System.out.println(String.format("Отсортированные по длине строки: %s", ListOperation.stringSize(strings)));
        System.out.println(String.format("Все ли числа чётные? %b",
                ListOperation.elementsList(numbers, n -> n % 2 == 0)));
        System.out.println(String.format("Наименьшее число больше 4: %d",
                ListOperation.minElement(numbers, 4)));
        System.out.println(String.format("Длины строк: %s", ListOperation.convertToLength(strings)));
    }
}