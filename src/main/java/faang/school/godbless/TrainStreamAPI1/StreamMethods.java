package faang.school.godbless.TrainStreamAPI1;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class StreamMethods {

    // Найти сумму четных чисел в списке. На вход получаем список чисел, на выходе должны получать int;
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(integer -> integer % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    //Найти максимальный элемент в списке чисел
    public static int maxElement(List<Integer> numbers) {
        return numbers.stream()
                .max((a, b) -> a.compareTo(b))      //.mapToInt(Integer::intValue).max()
                .orElse(0);
    }

    //Найти среднее значение чисел в списке
    public static double averageNumbers(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
    }

    //Найти количество строк, начинающихся с определённого символа в списке строк
    public static int startWithLetter(Character character, List<String> stringList) {
        return (int) stringList.stream()
                .map(String::toLowerCase)
                .filter(string -> string.startsWith(String.valueOf(character)))
                .count();
    }

    //Отфильтровать список строк и оставить только те, которые содержат определенную подстроку
    public static List<String> stringFilter(String string, List<String> stringList) {
        return stringList.stream()
                .filter(word -> word.contains(string))
                .toList();
    }

    //Отсортировать список строк по длине
    public static List<String> sortByLenght(List<String> stringList) {
        return stringList.stream()
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    //Проверить, все ли элементы списка удовлетворяют определённому условию
    public static <T> boolean check(List<T> stringList, Predicate<T> predicate) {
        return stringList.stream()
                .allMatch(predicate);
    }

    //Найти наименьший элемент в списке, который больше заданного числа
    public static int minElementMoreValue(Integer number, List<Integer> integers) {
        return integers.stream()
                .filter(num -> number < num)
                .min(Integer::compareTo)
                .orElse(0);
    }

    //Преобразовать список строк в список их длин
    public static List<Integer> listByStringLenght(List<String> stringList) {
        return stringList.stream()
                .map(String::length)
                .toList();
    }
}
