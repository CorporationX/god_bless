package school.faang.task58236;

import school.faang.task58236.service.ListOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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
        strings.forEach(System.out::println);

        char startSymbol = 'В';
        System.out.println("Количество строк на букву " + startSymbol + " = " + listOperations.findStartChar(strings, startSymbol));
        String repeat = "ветер";
        System.out.println("Повторение слова \"" + repeat + "\" в строках" + listOperations.findSubString(strings, "ветер"));
        System.out.println("Сортировка по длине\n");
        listOperations.sortToLength(strings).forEach(System.out::println);

        System.out.println("Вывод массива\n" + numbers + "\n");
        System.out.println("Проверка на условие в массиве чисел");
        Predicate<Integer> checkIf = integer -> integer > 0;
        boolean checkNumb = listOperations.checkIf(numbers, checkIf);
        System.out.println(checkNumb ? "Удовлетворяет" : "Не удовлетворяет");

        int after = 500;
        System.out.println("\nСортировка после " + after);
        int findNum = listOperations.findMinAfterValue(numbers, after);
        System.out.println(findNum != 0 ? findNum + "\n" : after + " - слишком большое число");

        strings.forEach(System.out::println);
        System.out.println("\n\nПреобразование строк в длину");
        System.out.println(listOperations.mapStrToInt(strings));
    }
}
