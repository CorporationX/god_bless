package Practice_StreamAPI_1;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Predicate;

public class PracticeStreamAPI {

    //Найти сумму четных чисел в списке.
    public static int findSumOfEvenNumbers(List<Integer> numbers) {
        int sum = 0;
        Optional<Integer> optionalSum = numbers.stream()
                .filter(number -> number % 2 == 0)
                .reduce((sumOfNums, number) -> sumOfNums + number);
        if (optionalSum.isPresent()) {
            sum = optionalSum.get();
        }
        return sum;
    }

    //Найти максимальный элемент в списке чисел
    public static int findMaxElement(List<Integer> numbers) {
        int maxElement = numbers.get(0);
        Optional<Integer> maxElementOptional = numbers.stream()
                .max((n1, n2) -> n1 - n2);
        if (maxElementOptional.isPresent()) {
            maxElement = maxElementOptional.get();
        }
        return maxElement;
    }

    //Найти среднее значение чисел в списке
    public static double findAverageValue(List<Integer> numbers) {
        double result = numbers.get(0);
        OptionalDouble optionalResult = numbers.stream()
                .mapToInt(value -> value)
                .average();
        if (optionalResult.isPresent()) {
            result = optionalResult.getAsDouble();
        }
        return result;
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
        int min = numbers.get(0);
        Optional<Integer> optionalMin = numbers.stream()
                .filter(num -> num > number)
                .min((n1, n2) -> n1 - n2);
        if (optionalMin.isPresent()) {
            min = optionalMin.get();
        }
        return min;
    }

    //Преобразовать список строк в список их длин
    public static List<Integer> toLengthList(List<String> strings) {
        return strings.stream()
                .map(str -> str.length())
                .toList();
    }
}
