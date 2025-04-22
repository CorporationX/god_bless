package school.faang.trainStreamApi1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 9, 12, 15);
        List<String> lines = Arrays.asList("ок", "школа", "руккола", "бананы", "апельсины", "ананасы");

        System.out.println("Сумма четных чисел: " + ListOfOperations.sumEvenNumbers(numbers));
        System.out.println("Максимум: " + ListOfOperations.findMaxNumber(numbers));
        System.out.println("Среднее: " + (ListOfOperations.findAverageNumber(numbers)));
        System.out.println("Количество строк:" + ListOfOperations.findLinesBeginWithSymbol(lines, 'а'));
        System.out.println("Cтроки, содержащие 'кола: " + ListOfOperations.findLinesContainSubstring(lines, "кола"));
        System.out.println("Отсортированные по длине строки: " + ListOfOperations.sortLinesLength(lines));
        System.out.println("Все числа? " + ListOfOperations.checkListOnCondition(numbers, n -> n % 3 == 0));
        System.out.println("Наименьшее число больше 9: " + ListOfOperations.findMinNumber(numbers, 9));
        System.out.println("Длины строк: " + ListOfOperations.mapListOfLinesToListOfLengthLines(lines));
    }
}