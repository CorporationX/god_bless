package faang.school.godbless.sapi1;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Main {

    public static final String STRING_START = "к";
    public static final String SUBSTRING = "как";
    public static final List<Integer> NUMS = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    public static final List<String> STRINGS_OF_DIFFERENT_SIZE = List.of("Строка еще больше",
            "Строка больше", "Строка", "Самая большая строка в мире");
    public static final List<String> DIFFERENT_STRINGS = List.of("Привет, как дела?", "А это спам", "Fedor работал 8 часов в день",
            "Антон, как хороший сотрудник, приходит вовремя");
    public static final int GIVEN_NUMBER = 5;

    public static void main(String[] args) {
        System.out.println(sumOfEvenNumbers(NUMS)); // 30
        maxElement(NUMS).ifPresent(System.out::println); //10
        System.out.println(averageValue(NUMS)); // 5.5
        System.out.println(findNumberOfLines(DIFFERENT_STRINGS, STRING_START)); // 2
        filterStrings(DIFFERENT_STRINGS, SUBSTRING).forEach(System.out::println);
        // "Привет, как дела?"
        // "Антон, как хороший сотрудник, приходит вовремя"
        sortStringsByLength(STRINGS_OF_DIFFERENT_SIZE).forEach(System.out::println);
        // Строка
        // Строка больше
        // Строка еще больше
        // Самая большая строка в мире
        System.out.println(satisfyCondition(NUMS, GIVEN_NUMBER)); // false
        minElementMoreThanSpecified(NUMS, GIVEN_NUMBER).ifPresent(System.out::println); // 6
        stringsToLength(STRINGS_OF_DIFFERENT_SIZE).forEach(System.out::println);
        // 17
        // 13
        // 6
        // 27
    }

    //     Найти сумму четных чисел в списке. На вход получаем список чисел, на выходе должны получать int
    public static int sumOfEvenNumbers(List<Integer> nums) {
        return nums.stream().filter(num -> num % 2 == 0).reduce(0, Integer::sum);
    }

    //    Найти максимальный элемент в списке чисел;
    public static Optional<Integer> maxElement(List<Integer> nums) {
        return nums.stream().max(Comparator.comparingInt(x -> x));
    }

    //    Найти среднее значение чисел в списке
    public static double averageValue(List<Integer> nums) {
        return (double) nums.stream().reduce(0, Integer::sum) / nums.size();
    }

    //    Найти количество строк, начинающихся с определённого символа в списке строк
    public static long findNumberOfLines(List<String> strings, String startChar) {
        return strings.stream().filter(str -> str.startsWith(startChar)).count();
    }

    //    Отфильтровать список строк и оставить только те, которые содержат определенную подстроку
    public static List<String> filterStrings(List<String> strings, String subString) {
        return strings.stream().filter(str -> str.contains(subString)).toList();
    }

    //    Отсортировать список строк по длине
    public static List<String> sortStringsByLength(List<String> strings) {
        return strings.stream().sorted(Comparator.comparingInt(String::length)).toList();
    }

    //    Проверить, все ли элементы списка удовлетворяют определённому условию
    public static boolean satisfyCondition(List<Integer> nums, int num) {
        return nums.stream().allMatch(n -> n > num);
    }

    //    Найти наименьший элемент в списке, который больше заданного числа
    public static Optional<Integer> minElementMoreThanSpecified(List<Integer> nums, int num) {
        return nums.stream().sorted(Comparator.comparingInt(x -> x)).filter(n -> n > num).findFirst();
    }

    //    Преобразовать список строк в список их длин
    public static List<Integer> stringsToLength(List<String> strings) {
        return strings.stream().map(String::length).toList();
    }
}
