package school.faang.stream1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        System.out.printf("Сумма четных чисел: %s \n", StreamTest.sumEvenNumber(numbers));

        System.out.printf("Максимум: %s \n", StreamTest.findMax(numbers));

        System.out.printf("Среднее: %s \n", StreamTest.findAverage(numbers));

        System.out.printf("Количество строк, начинающихся на 'a': %s \n",
                StreamTest.countStringsStartingWith(strings, 'a'));

        System.out.printf("Строки, содержащие 'an': %s \n ",
                StreamTest.filterStringsContainingSubstring(strings, "an"));

        System.out.printf("Отсортированные по длине строки: %s \n", StreamTest.sortByLength(strings));

        System.out.printf("Все ли числа чётные? %s \n",
                StreamTest.allMatchCondition(numbers, n -> n % 2 == 0));

        System.out.printf("Наименьшее число больше 4: %s \n",
                StreamTest.findMinGreaterThan(numbers, 4));

        System.out.printf("Длины строк: %s \n", StreamTest.convertToLengths(strings));

        try {
            System.out.printf("Тест null листа: %s \n", StreamTest.sumEvenNumber(null));
        } catch (Exception e) {
            System.out.printf("ОШИБКА: %s \n", e.getMessage());
        }

        try {
            List<Integer> emptyList = new ArrayList<>();
            System.out.printf("Тест пустого листа: %s \n", StreamTest.sumEvenNumber(emptyList));
        } catch (Exception e) {
            System.out.printf("ОШИБКА: %s \n", e.getMessage());
        }
    }
}
