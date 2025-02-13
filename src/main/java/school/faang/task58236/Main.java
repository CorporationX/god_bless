package school.faang.task58236;

import school.faang.task58236.service.ListOperations;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add((int) (Math.random() * 1000));
        }
        System.out.println("Вывод массива\n" + numbers + "\n");
        ListOperations listOperations = new ListOperations();
        System.out.println("Сумма четных элементов: " + listOperations.summaChet(numbers) + "\n");
        System.out.println("Максимальный элемент: " + listOperations.maxElement(numbers) + "\n");
        System.out.println("Среднее арифметическое: " + listOperations.midElement(numbers) + "\n");

        List<String> strings = List.of(
                "Тихий вечер, звезды мерцают",
                "Ветер шепчет, листья кружатся",
                "Солнце встает, тихий рассвет",
                "Волны бегут, ветер стихает",
                "Звезды гаснут, солнце сияет",
                "Время бежит, листья опадают"
        );

        System.out.println("Набор строк");
        strings.stream()
                .forEach(System.out::println);

        char startSymbol = 'В';
        System.out.println("Количество строк на букву " + startSymbol + " = " + listOperations.findStartChar(strings, startSymbol));
        String repeat = "ветер";
        System.out.println("Повторение слова \"" + repeat + "\" в строках" +listOperations.findSubString(strings, "ветер"));


    }
}
