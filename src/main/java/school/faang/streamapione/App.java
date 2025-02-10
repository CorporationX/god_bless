package school.faang.streamapione;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 5, 20, 15, 3, 7);
        List<String> strings = Arrays.asList("Арбуз", "Банан", "Вишня", "Слон", "Ананас");

        // Примеры вызовов методов
        System.out.println("Сумма четных чисел: " + ListProcessor.sumOfEvenNumbers(numbers));
        System.out.println("Максимальный элемент: " + ListProcessor.findMaxElement(numbers));
        System.out.println("Среднее значение: " + ListProcessor.findAverage(numbers));
        System.out.println("Количество строк, начинающихся с 'А': "
                + ListProcessor.countStringsStartingWith(strings, 'А'));
        System.out.println("Строки, содержащие 'на': " + ListProcessor.filterBySubstring(strings, "на"));
        System.out.println("Строки, отсортированные по длине: " + ListProcessor.sortStringsByLength(strings));
        System.out.println("Все элементы больше 0: "
                + ListProcessor.allElementsMatch(numbers, n -> n > 0));
        System.out.println("Наименьший элемент больше 4: "
                + ListProcessor.findSmallestElementGreaterThan(numbers, 4));
        System.out.println("Длины строк: " + ListProcessor.convertStringsToLengths(strings));
    }
}
