package school.faang.godbless.bjs2_35493;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

        System.out.println("Сумма четных чисел: " + NumberManager.getSumOfEvenNumbers(numbers));
        System.out.println("Максимум: " + NumberManager.getMaxNumber(numbers));
        System.out.println("Среднее: " + NumberManager.getAverage(numbers));
        System.out.println("Количество строк, начинающихся на 'a': " + WordsManager.countStartsWith(strings, 'a'));
        System.out.println("Строки, содержащие 'an': " + WordsManager.getWordsContainingSubstring(strings, "an"));
        System.out.println("Отсортированные по длине строки: " + WordsManager.sortByWordsLength(strings));
        System.out.println("Все ли числа чётные? " + NumberManager.checkPredicate(numbers, n -> n % 2 == 0));
        System.out.println("Наименьшее число больше 4: " + NumberManager.findMinWithLowerBound(numbers, 4));
        System.out.println("Длины строк: " + WordsManager.getWordsLength(strings));
    }
}
