package faang.school.godbless.BJS2_23144;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 50, 7, 8, 9, 10));
        System.out.println(sumEvenNumbers(numbers));

        Optional<Integer> maxElement = findMaxElement(numbers);
        maxElement.ifPresent(System.out::println);

        List<String> strings = List.of("Java", "Php", "JavaScript", "Scala", "Kotlin", "kPhp", "C");
        System.out.println(countByStartingSymbol(strings, 'J'));

        System.out.println(filterBySubstring(strings, "Php"));

        System.out.println(sortByLength(strings));

        System.out.println(equalsLoveLanguage(strings, "Java"));

        Optional<Integer> threshold = findMinElementGreaterNumber(numbers, 12);
        threshold.ifPresent(System.out::println);

        System.out.println(stringsToStringLength(strings));
    }

    /**
    * 1. Найти сумму четных чисел в списке. На вход получаем список чисел, на выходе должны получать int;
    */
    public static int sumEvenNumbers(List<Integer> numbers) {
        return numbers.stream().filter(number -> number % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    /**
     * 2. Найти максимальный элемент в списке чисел
     */
    public static Optional<Integer> findMaxElement(List<Integer> numbers) {
        return numbers.stream().max(Integer::compare);
    }

    /**
     * 3. Найти количество строк, начинающихся с определённого символа в списке строк
     */
    public static long countByStartingSymbol(List<String> strings, char symbol) {
        return strings.stream()
                .filter(str -> str.startsWith(String.valueOf(symbol)))
                .count();
    }

    /**
     * 4. Отфильтровать список строк и оставить только те, которые содержат определенную подстроку
     */
    public static List<String> filterBySubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(str -> str.contains(substring))
                .toList();
    }

    /**
     * 5. Отсортировать список строк по длине
     */
    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    /**
     * 6. Проверить, все ли элементы списка удовлетворяют определённому условию
     */
    public static List<String> equalsLoveLanguage(List<String> strings, String language) {
        return strings.stream()
                .filter(str -> str.equals(language))
                .toList();
    }

    /**
     * 7. Найти наименьший элемент в списке, который больше заданного числа
     */
    public static Optional<Integer> findMinElementGreaterNumber(List<Integer> numbers, int greaterNumber) {
        return numbers.stream()
                .filter(number -> number > greaterNumber)
                .min(Integer::compare);
    }

    /**
     * 8. Преобразовать список строк в список их длин
     */
    public static List<Integer> stringsToStringLength(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}
