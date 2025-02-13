package school.faang.streamapione;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 5, 20, 15, 3, 7);
        List<String> strings = Arrays.asList("Арбуз", "Банан", "Вишня", "Слон", "Ананас");

        // Примеры вызовов методов
        System.out.printf("Сумма четных чисел: %s%n", ListProcessor.sumOfEvenNumbers(numbers));
        System.out.printf("Максимальный элемент: %s%n", ListProcessor.findMaxElement(numbers));
        System.out.printf("Среднее значение: %s%n", ListProcessor.findAverage(numbers));
        System.out.printf("Количество строк, начинающихся с 'А': %s%n",
                ListProcessor.countStringsStartingWith(strings, 'А'));
        System.out.printf("Строки, содержащие 'на': %s%n ", ListProcessor.filterBySubstring(strings, "на"));
        System.out.printf("Строки, отсортированные по длине: %s%n", ListProcessor.sortStringsByLength(strings));
        System.out.printf("Все элементы больше 0: %s%n",
                ListProcessor.allElementsMatch(numbers, n -> n > 0));
        System.out.printf("Наименьший элемент больше 4: %s%n",
                ListProcessor.findSmallestElementGreaterThan(numbers, 4));
        System.out.printf("Длины строк: %s%n", ListProcessor.convertStringsToLengths(strings));
    }
}
