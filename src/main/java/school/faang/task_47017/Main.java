package school.faang.task_47017;

import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(8, 2, 7, 54, 1, 36, 14);
        List<Integer> emptyNumbers = Collections.emptyList();

        List<String> words = List.of("java", "laptop", "dog", "river", "description", "watch", "diamond");

        System.out.println("Сумма четных чисел: " + StreamUtils.sumEvens(numbers));

        System.out.println("Максимум: " + StreamUtils.findMax(numbers));

        System.out.println("Среднее: " + StreamUtils.findAvg(numbers));
        System.out.println("Среднее: " + StreamUtils.findAvg(emptyNumbers));

        System.out.println("Количество строк, начинающихся на 'd': " + StreamUtils.findStartsWith(words, 'd'));

        System.out.println("Строки, содержащие 'on': " + StreamUtils.findContainsString(words, "on"));

        System.out.println("Отсортированные по длине строки: " + StreamUtils.sortByLength(words));

        System.out.println("Все ли числа больше 0? "
                + StreamUtils.isAllSatisfyPredicate(numbers, number -> number > 0));

        System.out.println("Наименьшее число больше 5: " + StreamUtils.findNextSortedNumber(numbers, 5));

        System.out.println("Длины строк: " + StreamUtils.mapStringToInteger(words));
    }
}
