package school.faang.bjs2_70885;

import java.util.Arrays;
import java.util.List;

/**
 * Задача "Потренируем StreamAPI 1"
 */
public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> numbers2 = Arrays.asList(10, 5, 20, 15, 3, 7);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        System.out.printf("Сумма четных: %s%n", StreamListOperations.sumEven(numbers));
        System.out.printf("Максимум: %s%n", StreamListOperations.max(numbers));
        System.out.printf("Среднее: %s%n", StreamListOperations.average(numbers));
        System.out.printf("Количество строк начинается с 'a': %s%n",
                StreamListOperations.countStartWithPrefix(strings, "a"));
        System.out.printf("Количество строк содержит 'an': %s%n",
                StreamListOperations.containSubstring(strings, "an").toString());
        System.out.printf("Сортировка по длине строки: %s%n", StreamListOperations.sortByLength(strings).toString());
        System.out.printf("Все ли числа чётные? %s%n", StreamListOperations.allMatch(numbers, n -> n % 2 == 0));
        System.out.println("Наименьшее число больше 4: " + StreamListOperations.getMinGreaterThan(numbers2, 6));
        System.out.println("Длины строк: " + StreamListOperations.getStringLengths(strings));
    }
}
