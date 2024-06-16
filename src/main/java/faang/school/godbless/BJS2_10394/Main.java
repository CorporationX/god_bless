package faang.school.godbless.BJS2_10394;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    //Найти сумму четных чисел в списке. На вход получаем список чисел, на выходе должны получать int;
    public static int findEvenNumber(List<Integer> list) {
        return list.stream()
                .filter(num -> num % 2 == 0)
                .reduce((first, second) -> first + second)
                .orElse(0);
    }

    //Найти максимальный элемент в списке чисел;
    public static int findMaxNumber(List<Integer> list) {
        return list.stream().max((first, second) -> first - second).orElse(0);
    }

    //Найти среднее значение чисел в списке;
    public static double findAverageNumber(List<Integer> list) {
        return list.stream().mapToDouble(i -> i).average().orElse(0);
    }

    //Найти количество строк, начинающихся с определённого символа в списке строк;
    public static int findString(List<String> list, Character symbol) {
        return (int) list.stream().filter((line) -> symbol.equals(line.charAt(0))).count();
    }

    //Отфильтровать список строк и оставить только те, которые содержат определенную подстроку;
    public static List<String> findSubString(List<String> list, String substring) {
        return list.stream().filter((line) -> line.startsWith(substring)).toList();
    }

    //Отсортировать список строк по длине;
    public static List<String> sortByLength(List<String> list) {
        return list.stream().sorted((first, second) -> first.length() - second.length()).toList();
    }

    //Проверить, все ли элементы списка удовлетворяют определённому условию;
    public static boolean filterList(List<String> list, Predicate<String> predicate) {
        return list.stream().allMatch(line -> predicate.test(line));
    }

    //Найти наименьший элемент в списке, который больше заданного числа;
    public static int findMinNumber(List<Integer> list, int num) {
        return list.stream().filter(i -> i > num).min(Comparator.comparingInt(t -> t)).orElse(0);
    }

    //Преобразовать список строк в список их длин.
    public static List<Integer> convertToListOfLength(List<String> list) {
        return list.stream().map(first -> first.length()).toList();
    }
}
