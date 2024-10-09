package school.faang.godbless.bjs2_35493;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        System.out.println("Сумма четных чисел: " + UtilsWithStreamApi.getSumOfEvenNumbers(numbers));
        System.out.println("Максимум: " + UtilsWithStreamApi.getMaxNumber(numbers));
        System.out.println("Среднее: " + UtilsWithStreamApi.getAverage(numbers));
        System.out.println("Количество строк, начинающихся на 'a': " + UtilsWithStreamApi.countStartsWith(strings, 'a'));
        System.out.println("Строки, содержащие 'an': " + UtilsWithStreamApi.getWordsContainingSubstring(strings, "an"));
        System.out.println("Отсортированные по длине строки: " + UtilsWithStreamApi.sortByWordsLength(strings));
        System.out.println("Все ли числа чётные? " + UtilsWithStreamApi.checkPredicate(numbers, n -> n % 2 == 0));
        System.out.println("Наименьшее число больше 4: " + UtilsWithStreamApi.findMinWithLowerBound(numbers, 4));
        System.out.println("Длины строк: " + UtilsWithStreamApi.getWordsLength(strings));
    }
}
