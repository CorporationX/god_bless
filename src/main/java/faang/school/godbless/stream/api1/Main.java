package faang.school.godbless.stream.api1;


import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(6, 1, 3, 4, 10);
        List<String> strings = List.of("hi", "cool", "cold", "Programming");

        System.out.println(filterStringBySubstring(strings, "co"));
        System.out.println(allMatch(strings, str -> str.contains("o")));
    }

    //Найти сумму четных чисел в списке. На вход получаем список чисел, на выходе должны получать int;
    public static int sumOfNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .reduce(Integer::sum)
                .orElse(0);
    }

    //Найти максимальный элемент в списке чисел;
    public static int maxOfNumbers(List<Integer> numbers) {
        return numbers.stream()
                .reduce(Integer::max)
                .orElse(0);
    }

    //Найти среднее значение чисел в списке;
    public static double avgOfNumbers(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::valueOf)
                .average()
                .orElse(0D);
    }

    //Найти количество строк, начинающихся с определённого символа в списке строк;
    public static long countStrStart(List<String> strings, char ch) {
        return strings.stream()
                .filter(str -> str.charAt(0) == ch)
                .count();
    }

    //Отфильтровать список строк и оставить только те, которые содержат определенную подстроку;
    public static List<String> filterStringBySubstring(List<String> strings, String substrring) {
        return strings.stream()
                .filter(string -> string.contains(substrring))
                .toList();
    }

    //Отсортировать список строк по длине
    public static List<String> sortStringByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    //Проверить, все ли элементы списка удовлетворяют определённому условию;
    public static boolean allMatch(List<String> strings, Predicate<String> condition) {
        return strings.stream()
                .allMatch(condition);
    }

    //Найти наименьший элемент в списке, который больше заданного числа;
    public static int smallestEllement(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number > 3)
                .reduce(Integer::min)
                .orElse(0);
    }

    //Преобразовать список строк в список их длин.
    public static List<Integer> stringsToLength(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}


