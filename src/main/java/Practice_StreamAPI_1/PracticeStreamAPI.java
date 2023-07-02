package Practice_StreamAPI_1;

import java.util.List;
import java.util.function.Predicate;

public class PracticeStreamAPI {

    //Найти сумму четных чисел в списке.
    public static int findSumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .reduce((sumOfNums, number) -> sumOfNums + number)
                .orElse(0);
    }

    //Найти максимальный элемент в списке чисел
    public static int findMaxElement(List<Integer> numbers) {
        return numbers.stream()
                .max((n1, n2) -> n1 - n2)
                .orElse(numbers.get(0));
    }

    //Найти среднее значение чисел в списке
    public static double findAverageValue(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(value -> value)
                .average()
                .orElse(numbers.get(0));
    }

    //Найти количество строк, начинающихся с определённого символа в списке строк
    public static int findQuantityOfStringsStartsWithSymbol(List<String> strings, String symbol) {
        return (int) strings.stream()
                .filter(str -> str.startsWith(symbol))
                .count();
    }

    //Отфильтровать список строк, которые содержат определенную подстроку
    public static List<String> leaveThatContainSubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(str -> str.contains(substring))
                .toList();
    }

    //Отсортировать список строк по длине
    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted((str1, str2) -> str1.length() - str2.length())
                .toList();
    }

    //Проверить, все ли элементы списка удовлетворяют определённому условию
    public static boolean checkAllElements(List<Integer> numbers, Predicate<Integer> condition) {
        return numbers.stream()
                .allMatch(num -> condition.test(num));
    }

    //Найти наименьший элемент в списке, который больше заданного числа
    public static int findMinMoreThenNumber(List<Integer> numbers, int number) {
        return numbers.stream()
                .filter(num -> num > number)
                .min((n1, n2) -> n1 - n2)
                .orElse(numbers.get(0));
    }

    //Преобразовать список строк в список их длин
    public static List<Integer> toLengthList(List<String> strings) {
        return strings.stream()
                .map(str -> str.length())
                .toList();
    }
}
