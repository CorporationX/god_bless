package school.faang.bjs2_88210;

import org.w3c.dom.ls.LSOutput;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(5, 49, 98, 37, 81, 9, 41, 44, 54, 88);
        System.out.printf("1. Сумма четных чисел в списке: %d%n", sumEvenNumbers(numbers));
        System.out.printf("2. Максимальное число в списке: %d%n", getMaxNumber(numbers).orElse(-1));
        System.out.printf("3. Среднее арифметическое списка: %.3f%n", evaluateArithmeticMean(numbers));
        System.out.printf("4. Список соответствует условию: %b%n", isMatch(numbers, number -> number > 20));
        System.out.printf("5. Минимальное число после заданного: %d%n",
                getMinNumberAfterBound(numbers, 50).orElse(-1));

        List<String> strings = List.of(
                "Метод должен принимать",
                "возвращать максимальное значение",
                "список строк",
                "Отсортировать",
                "которые содержат определённую",
                "возвращать список строк, которые содержат эту подстроку",
                "наименьший элемент в списке",
                "Преобразовать список",
                "список целых чисел",
                "Стримы позволяют написать более компактный и выразительный код"
        );
        System.out.printf("6. Количество строк, начинающихся с заданного символа: %d%n",
                getAmountOfStringsStartingWithSymbol(strings, 'в'));
        System.out.println("7. Строки, включающие с заданную строку:");
        getStringsWithSubstring(strings, "список").forEach(System.out::println);
        System.out.println("8. Список, отсортированный по длине строки:");
        sortStringsByLength(strings).forEach(System.out::println);
        System.out.println("9. Список, переведенный в длину строки:");
        convertStringToNumbers(strings).forEach(System.out::println);
    }

    public static int sumEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static Optional<Integer> getMaxNumber(List<Integer> numbers) {
        return numbers.stream()
                .max(Comparator.naturalOrder());
    }

    public static double evaluateArithmeticMean(List<Integer> numbers) {
        int sum = numbers.stream()
                .reduce(0, Integer::sum);
        long count = numbers.size();
        return sum * 1.0 / count;
    }

    public static long getAmountOfStringsStartingWithSymbol(List<String> strings, char symbol) {
        return strings.stream()
                .filter(string -> string.startsWith(String.valueOf(symbol)))
                .count();
    }

    public static List<String> getStringsWithSubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(string -> string.contains(substring))
                .toList();
    }

    public static List<String> sortStringsByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean isMatch(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream()
                .allMatch(predicate);
    }

    public static Optional<Integer> getMinNumberAfterBound(List<Integer> numbers, int bound) {
        return numbers.stream()
                .filter(number -> number > bound)
                .min(Comparator.naturalOrder());
    }

    public static List<Integer> convertStringToNumbers(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}
