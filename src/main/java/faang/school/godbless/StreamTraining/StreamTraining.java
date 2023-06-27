package faang.school.godbless.StreamTraining;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamTraining<T> {

    //Найти сумму четных чисел в списке. На вход получаем список чисел, на выходе должны получать int;
    public static int evenSum(List<Integer> list) {
        return list.stream().filter(num -> num % 2 == 0).reduce(0, Integer::sum);
    }

    //Найти максимальный элемент в списке чисел;
    public static int maxElement(List<Integer> list) {
        return list.stream().max(Integer::compareTo).orElseThrow();
    }

    //Найти среднее значение чисел в списке;
    public static double averageValue(List<Integer> list) {
        return list.stream().mapToInt(e -> e).average().orElseThrow();
    }

    //Найти количество строк, начинающихся с определённого символа в списке строк;
    public static long stringCount(List<String> list, Character character) {
        return list.stream().map(String::toLowerCase).filter(string -> string.startsWith(String.valueOf(character).toLowerCase())).count();
    }

    //Отфильтровать список строк и оставить только те, которые содержат определенный подстроку;
    public static List<String> substringContains(List<String> list, String substring) {
        return list.stream().filter(string -> string.toLowerCase().contains(substring.toLowerCase())).toList();
    }

    //Отсортировать список строк по длине;
    public static List<String> sortByLength(List<String> list) {
        return list.stream().sorted(Comparator.comparing(String::length)).toList();
    }

    //Проверить, все ли элементы списка удовлетворяют определённому условию;
    public static <T> List<T> checkTheList(List<T> list, Predicate<T> predicate) {
        return list.stream().filter(predicate).toList();
    }

    //Найти наименьший элемент в списке, который больше заданного числа;
    public static Integer lessMoreThen(List<Integer> list, Integer num) {
        return list.stream().filter(e -> e > num).min(Integer::compareTo).orElseThrow();
    }

    //Преобразовать список строк в список их длин.
    public static List<Integer> stringToLength(List<String> list) {
        return list.stream().map(String::length).toList();
    }
}
