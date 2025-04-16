package school.faang.sprint_2.streamapi1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");

        // Пример использования методов:
        System.out.println("Сумма четных чисел: " + Processor.sumEvenNumbers(numbers));
        System.out.println("Максимум: " + Processor.maxElement(numbers));
        System.out.println("Среднее: " + Processor.averageValue(numbers));
        System.out.println("Количество строк, начинающихся на 'a': "
                + Processor.findStringAmountStartedWith(words, 'a'));
        System.out.println("Строки, содержащие 'an': "
                + Processor.findWordsContaintsSubstring(words, "an"));
        System.out.println("Отсортированные по длине строки: " + Processor.sortListByLength(words));
        System.out.println("Все ли числа чётные? "
                + Processor.compareListWithCondition(numbers, n -> n % 2 == 0));
        System.out.println("Наименьшее число больше 4: "
                + Processor.findMinValueGreaterTarget(numbers, 4));
        System.out.println("Длины строк: " + Processor.convertStringToIntByLength(words));
    }
}