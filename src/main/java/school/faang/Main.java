package school.faang;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        System.out.println("Сумма четных чисел: " + ListOperation.sumNumbers(numbers));
        System.out.println("Максимум: " + ListOperation.maxNumbers(numbers));
        System.out.println("Среднее: " + ListOperation.averageNubmers(numbers));
        System.out.println("Количество строк, начинающихся на 'a': " + ListOperation.startNumbersSpecificChar(strings, 'a'));
        System.out.println("Строки, содержащие 'an': " + ListOperation.listSpecificSubstring(strings, "an"));
        System.out.println("Отсортированные по длине строки: " + ListOperation.stringSize(strings));
        System.out.println("Все ли числа чётные? " + ListOperation.elementsList(numbers, n -> n % 2 == 0));
        System.out.println("Наименьшее число больше 4: " + ListOperation.minElement(numbers, 4));
        System.out.println("Длины строк: " + ListOperation.convertToLenght(strings));
    }
}


