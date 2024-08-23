package faang.school.godbless.BJS2_23108;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamApiFirst {
    //Найти сумму четных чисел в списке. На вход получаем список чисел, на выходе должны получать int;
    public static Integer sum(List<Integer> list) {
        return list.stream().filter(i -> i % 2 == 0).mapToInt(Integer::intValue).sum();
    }

    //Найти максимальный элемент в списке чисел;
    public static Integer findMax(List<Integer> list) {
        return list.stream().max(Comparator.naturalOrder()).get();
    }

    //Найти среднее значение чисел в списке;
    public static Double findAverage(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).average().getAsDouble();
    }

    //Найти количество строк, начинающихся с определённого символа в списке строк;
    public static Integer findStringThatStartWith(List<String> list, String symbol) {
        return Math.toIntExact(list.stream().filter(s -> s.startsWith(symbol)).count());
    }

    //Отфильтровать список строк и оставить только те, которые содержат определенную подстроку;
    public static List<String> filterStringThatContain(List<String> list, String substring) {
        return list.stream().filter(s -> s.contains(substring)).toList();
    }

    //Отсортировать список строк по длине;
    public static List<String> sortStringByLength(List<String> list) {
        return list.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
    }

    //Проверить, все ли элементы списка удовлетворяют определённому условию;
    public static Boolean checkingString(List<String> list, Predicate<String> condition) {
        return list.stream().allMatch(condition);
    }

    //Найти наименьший элемент в списке, который больше заданного числа;
    public static Integer findMinElementThatBiggerThan(List<Integer> list, int number) {
        return list.stream().filter(i -> i > number).min(Comparator.naturalOrder()).get();
    }

    //Преобразовать список строк в список их длин.
    public static List<Integer> transformStringToLength(List<String> list) {
        return list.stream().map(String::length).collect(Collectors.toList());
    }
}
