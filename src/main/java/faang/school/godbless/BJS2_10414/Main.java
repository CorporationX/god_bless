package faang.school.godbless.BJS2_10414;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> strings = List.of("aaa", "bbb", "ccc", "ddd", "eee", "fff", "ggg", "hhh", "iii", "abb", "mm", "gg", "r");

        System.out.println(sumEvenNumbers(numbers));
        System.out.println(maxNumber(numbers));
        System.out.println(averageValue(numbers));
        System.out.println(firstLetterStringCounter(strings, 'a'));
        System.out.println(filterSubString(strings, "bb"));
        System.out.println(sortByLength(strings));
        System.out.println(meetsTheCondition(strings, n -> n.length() < 4));
        System.out.println(minNumberBiggerThanGiven(numbers, 5));
        System.out.println(stringsMapToLength(strings));
    }

    //сумма четных чисел списка
    public static int sumEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .reduce(Integer::sum)
                .orElse(-1);
    }

    //максимальный элемент в списке чисел
    public static int maxNumber(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compare)
                .orElse(-1);
    }

    //среднее значение чисел в списке
    public static double averageValue(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(n -> n)
                .average()
                .orElse(-1);
    }

    //количество строк, начинающихся с заданного символа
    public static int firstLetterStringCounter(List<String> sourceStrings, char letter) {
        return (int) sourceStrings.stream()
                .filter(n -> n.regionMatches(false, 0, Character.toString(letter), 0, 1))
                .count();
    }

    //оставить только те, которые содержат заданную подстроку
    public static List<String> filterSubString(List<String> sourceString, String subString) {
        return sourceString.stream()
                .filter(n -> n.contains(subString))
                .collect(Collectors.toList());
    }

    //сортировка списка строк по длине элементов
    public static List<String> sortByLength(List<String> sourceStrings) {
        return sourceStrings.stream()
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
    }

    //проверка удовлетворения заданному условию всех элементов списка
    public static boolean meetsTheCondition(List<String> sourceStrings, Predicate<String> condition) {
        return sourceStrings.stream()
                .allMatch(condition);
    }

    //наименьший элемент списка, значение которого больше заданного числа
    public static int minNumberBiggerThanGiven(List<Integer> numbers, Integer boundNumber) {
        return numbers.stream()
                .filter(n -> n > boundNumber)
                .min(Integer::compare)
                .orElse(-1);
    }

    //преобразование списка строк в список длин этих строк
    public static List<Integer> stringsMapToLength(List<String> sourceStrings) {
        return sourceStrings.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }
}
