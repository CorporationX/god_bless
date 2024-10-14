package school.faang;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        // Пример использования методов:
        System.out.println("Сумма четных чисел: " + Operations.sum(numbers));
        System.out.println("Максимум: " + Operations.max(numbers));
        System.out.println("Среднее: " + Operations.averageValue(numbers));
        System.out.println("Количество строк, начинающихся на 'a': " + Operations.countString(strings, 'a'));
        System.out.println("Строки, содержащие 'an': " + Operations.substringFilter(strings, "an"));
        System.out.println("Отсортированные по длине строки: " + Operations.sortByLength(strings));
        System.out.println("Все ли числа чётные? " + Operations.allMatchCondition(numbers, n -> n % 2 == 0));
        System.out.println("Наименьшее число больше 4: " + Operations.minThanThis(numbers, 4));
        System.out.println("Длины строк: " + Operations.stringToLength(strings));
    }
}
