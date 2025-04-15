package school.faang.sprint_2.streamapi1;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Processor processor = new Processor();
        processor.numbers = List.of(1, 2, 3, 4, 5, 6);
        processor.words = List.of("apple", "banana", "cherry", "date");

        // Пример использования методов:
        System.out.println("Сумма четных чисел: " + processor.sumEvenNumbers(processor.numbers));
        System.out.println("Максимум: " + processor.maxElement(processor.numbers));
        System.out.println("Среднее: " + processor.averageValue(processor.numbers));
        System.out.println("Количество строк, начинающихся на 'a': "
                + processor.findStringAmountStartedWith(processor.words, 'a'));
        System.out.println("Строки, содержащие 'an': "
                + processor.findWordsContaintsSubstring(processor.words, "an"));
        System.out.println("Отсортированные по длине строки: " + processor.sortListByLength(processor.words));
        System.out.println("Все ли числа чётные? "
                + processor.compareListWithCondition(processor.numbers, n -> n % 2 == 0));
        System.out.println("Наименьшее число больше 4: "
                + processor.findMinValueMoreThanTarget(processor.numbers, 4));
        System.out.println("Длины строк: " + processor.convertStringToIntByLength(processor.words));
    }
}
