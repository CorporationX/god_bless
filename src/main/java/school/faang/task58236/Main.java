package school.faang.task58236;

import school.faang.task58236.service.ListOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private static final int LIST_SIZE = 10;
    private static final int MAX_RANDOM_VALUE = 1000;

    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> numbers = Stream.generate(() -> random.nextInt(MAX_RANDOM_VALUE))
                .limit(LIST_SIZE)
                .collect(Collectors.toList());
        System.out.println(String.format("Вывод массива\n%s\n", numbers));

        ListOperations listOperations = new ListOperations();
        System.out.println(String.format("Сумма четных элементов: %d\n", listOperations.summaChet(numbers)));
        System.out.println(String.format("Максимальный элемент: %d\n", listOperations.maxElement(numbers)));
        System.out.println(String.format("Среднее арифметическое: %.2f\n", listOperations.midElement(numbers)));

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
        System.out.println(String.format("Количество строк на букву %c = %d", startSymbol, listOperations.findStartChar(strings, startSymbol)));

        String repeat = "ветер";
        System.out.println(String.format("Повторение слова \"%s\" в строках: %s", repeat, listOperations.findSubString(strings, repeat)));

        System.out.println("Сортировка по длине:");
        listOperations.sortToLength(strings).forEach(System.out::println);

        System.out.println(String.format("\nВывод массива\n%s\n", numbers));
        System.out.println("Проверка на условие в массиве чисел");
        Predicate<Integer> checkIf = integer -> integer > 0;
        boolean checkNumb = listOperations.checkIf(numbers, checkIf);
        System.out.println(checkNumb ? "Удовлетворяет" : "Не удовлетворяет");

        int after = 500;
        System.out.println(String.format("\nСортировка после %d", after));
        int findNum = listOperations.findMinAfterValue(numbers, after);
        System.out.println(findNum != 0 ? String.format("%d\n", findNum) : String.format("%d - слишком большое число", after));

        System.out.println("\nИсходные строки:");
        strings.forEach(System.out::println);
        System.out.println("\nПреобразование строк в длину:");
        System.out.println(listOperations.mapStrToInt(strings));
    }
}