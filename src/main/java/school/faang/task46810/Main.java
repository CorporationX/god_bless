package school.faang.task46810;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>(
                List.of("char", "character", "apple", "list of strings"));

        List<Integer> numbers = new ArrayList<>(
                List.of(1, 5, 6, 12, -2, 15, 25, 40));

        System.out.printf("Сумма четных чисел: %d%n", StringNumberUtils.sumEvenNumbers(numbers));
        System.out.printf("Максимальное число в списке: %d%n", StringNumberUtils.findMaxNumber(numbers));
        System.out.printf("Среднее арифметическое: %f%n", StringNumberUtils.findAverage(numbers));
        System.out.printf("Количество строк, начинающиеся с символа: %d%n",
                StringNumberUtils.countStringWithChar(strings, 'c'));
        System.out.printf("Строки отсортированные по длине: %s%n",
                String.join(", ", StringNumberUtils.sortStringByLength(strings)));
        System.out.printf("Числа соблюдают заданное условие: %b%n",
                StringNumberUtils.isPredicateNumbers(numbers, number -> number % 5 == 0));
        System.out.printf("Следующее минимальное число, которое больше заданного: %d%n",
                StringNumberUtils.findMinNumberMoreSpecifiedNumber(numbers, 13));
        System.out.printf("Список длин заданных строк: %s%n",
                StringNumberUtils.convertListStringsToListLength(strings).stream()
                        .map(String::valueOf).collect(Collectors.joining(", ")));
        System.out.printf("Строки которые содержат подтроку: %s%n",
                StringNumberUtils.stringContainsSubstring(strings, "char").stream()
                        .collect(Collectors.joining(", ")));
    }
}
