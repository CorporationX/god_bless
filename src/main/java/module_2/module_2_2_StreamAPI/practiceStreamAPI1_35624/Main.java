package module_2.module_2_2_StreamAPI.practiceStreamAPI1_35624;

import java.util.List;

public class Main {

    public static void main(String... args) {
        List<Integer> numbers = List.of(9, 0, 3, 2, 5, 6, 4, 8, 1, 7);
        List<String> words = List.of("apple", "banana", "cherry", "date", "yandex");

        System.out.println("Сумма чётных чисел: " + ListOperations.sumOfEvenNumbers(numbers));
        System.out.println("Максимум: " + ListOperations.findMax(numbers));
        System.out.println("Среднее: " + ListOperations.findAverage(numbers));
        System.out.println("Количество строк, начинающихся на 'a': "
                + ListOperations.countStringsStartingWith(words, 'a'));
        System.out.println("Строки, содержащие 'an': "
                + ListOperations.filterStringsContainingSubstring(words, "an"));
        System.out.println("Отсортированные по длине строки: " + ListOperations.sortByLength(words));
        System.out.println("Все ли числа чётные? " + ListOperations.allMatchCondition(numbers, n -> n % 2 == 0));
        System.out.println("Наименьшее число больше 4: " + ListOperations.findMinGreaterThan(numbers, 5));
        System.out.println("Длины строк: " + ListOperations.convertToLengths(words));
    }
}
