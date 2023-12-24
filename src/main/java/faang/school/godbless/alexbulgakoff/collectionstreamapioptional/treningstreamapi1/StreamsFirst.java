package faang.school.godbless.alexbulgakoff.collectionstreamapioptional.treningstreamapi1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Alexander Bulgakov
 */

public class StreamsFirst {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 8, 7, 11, 12);
        int number = 10;

        List<String> strings = Arrays.asList("Yellow", "Sale", "Food", "Stop");

        List<String> pushkin = Arrays.asList("На берегу пустынных волн",
                                            "Стоял он, дум великих полн,",
                                            "И вдаль глядел. Пред ним широко",
                                            "Река неслася; бедный чёлн",
                                            "По ней стремился одиноко.",
                                            "По мшистым, топким берегам",
                                            "Чернели избы здесь и там,",
                                            "Приют убогого чухонца;",
                                            "И лес, неведомый лучам",
                                            "В тумане спрятанного солнца,",
                                            "Кругом шумел.");
        String substring = "По мшистым, топ";

        List<String> unsortedStrings = Arrays.asList("like", "StreamAPI in Java", "I");
        List<String> conditionStrings = Arrays.asList("Approve", "use GitHub", "lambda");
        int condition = 5;

        System.out.println(sumEvenNumbers(numbers));
        System.out.println(maxNumber(numbers));
        System.out.println(averageValue(numbers));

        System.out.println(countString(strings));
        System.out.println(filterStrings(pushkin, substring));
        System.out.println(sortedStringsByLength(unsortedStrings));
        System.out.println(isConditionByStrings(conditionStrings, condition));
        System.out.println(minElementWhichIsLargerThanAGivenNumber(numbers, number));
        System.out.println(convertListStringsToListOfLengths(pushkin));
    }


    //Найти сумму четных чисел в списке. На вход получаем список чисел, на выходе должны получать int;

    public static int sumEvenNumbers(List<Integer> numbers) {
        return numbers.stream().filter(e -> e % 2 == 0).reduce(0, Integer::sum);
    }

    //Найти максимальный элемент в списке чисел;

    public static int maxNumber(List<Integer> numbers) {
        return numbers.stream().max(Integer::compare).get();
    }

    //Найти среднее значение чисел в списке;

    public static int averageValue(List<Integer> numbers) {
        return (int) numbers.stream().mapToInt(num -> num).average().getAsDouble();
    }

    //Найти количество строк, начинающихся с определённого символа в списке строк;
    public static long countString(List<String> strings) {
        return strings.stream().filter(s -> s.startsWith("S")).count();
    }

    //Отфильтровать список строк и оставить только те, которые содержат определенную подстроку;

    public static List<String> filterStrings(List<String> strings, String substring) {
        return strings.stream().filter(s -> s.contains(substring)).toList();
    }

    //Отсортировать список строк по длине;

    public static List<String> sortedStringsByLength(List<String> strings) {
        return strings.stream().sorted((Comparator.comparingInt(String::length))).toList();
    }

    //Проверить, все ли элементы списка удовлетворяют определённому условию;

    public static boolean isConditionByStrings(List<String> strings, int condition) {
        return strings.stream().allMatch(s -> s.length() > condition);
    }

    //Найти наименьший элемент в списке, который больше заданного числа;
    public static int minElementWhichIsLargerThanAGivenNumber(List<Integer> numbers, int number) {
        return numbers.stream().filter((n) -> n > number).min(Integer::compare).get();
    }

    //Преобразовать список строк в список их длин.
    public static List<Integer> convertListStringsToListOfLengths(List<String> strings) {
        return strings.stream().map(String::length).toList();
    }
}
