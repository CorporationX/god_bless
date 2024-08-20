package faang.school.godbless.BJS223289;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {
        System.out.println(sumOfEvenNumbers(List.of(1, 2, 3, 4, 5, 6)));
        System.out.println(findMaxNumber(List.of(12,54,23,6,76)));
        System.out.println(findAverageNumber(List.of(23,33,11,76)));
        System.out.println(countStringsStartWith(List.of("Madrid", "Mexico", "Astana", "Moscow"), "Ma"));
        System.out.println(filterStringsBySubstring(List.of("Pudge", "Tinker", "Rubick", "Tiny"), "Tin"));
        System.out.println(sortStringByLength(List.of("Ronaldo", "Messi", "Modric")));
        System.out.println(allMatchCondition(List.of(1,2,23,32,52,323,4,6), n -> n > 2));
        System.out.println(findMinGreaterThan(List.of(1,2,23,32,52,323,4,6), 10));
        System.out.println(mapStringsToLength(List.of("Ronaldo", "Messi", "Modric")));


    }

    List<String> strings = new ArrayList<>();
    List<Integer> numbers = new ArrayList<>();


    //Найти сумму четных чисел в списке. На вход получаем список чисел, на выходе должны получать int;
    private static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream().filter(n -> n % 2 == 0).mapToInt(Integer::intValue).sum();
    }

    //Найти максимальный элемент в списке чисел;
    private static int findMaxNumber(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("Empty"));
    }

    //Найти среднее значение чисел в списке;
    private static double findAverageNumber(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new IllegalArgumentException("Empty"));
    }

    //Найти количество строк, начинающихся с определённого символа в списке строк;
    private static long countStringsStartWith(List<String> strings, String prefix) {
        return strings.stream()
                .filter(s -> s.startsWith(prefix))
                .count();
    }

    //Отфильтровать список строк и оставить только те, которые содержат определенную подстроку;
    private static List<String> filterStringsBySubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(s -> s.contains(substring))
                .collect(Collectors.toList());
    }

    //Отсортировать список строк по длине;
    private static List<String> sortStringByLength(List<String> strings) {
        return strings.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
    }

    //Проверить, все ли элементы списка удовлетворяют определённому условию;
    private static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> condition) {
        return numbers.stream()
                .allMatch(condition);
    }

    //Найти наименьший элемент в списке, который больше заданного числа;
    private static int findMinGreaterThan(List<Integer> numbers, int threshold) {
        return numbers.stream()
                .filter(n -> n > threshold)
                .min(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("No element greater than threshold"));
    }

    //Преобразовать список строк в список их длин.
    private static List<Integer> mapStringsToLength(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }

}
