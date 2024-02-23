package faang.school.godbless.streamapi1;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;


public class StreamStaticMethod {
    // Найти сумму четных чисел в списке. На вход получаем список чисел, на выходе должны получать int;
    public static int sumNumber(List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num % 2 == 0)
//                .reduce(0, ((a, b) -> a + b)) --- через лямбду
                .reduce(0, (Integer::sum));

    }

    // Найти максимальный элемент в списке чисел;
    public static int maxNumber(List<Integer> numbers) {
        return numbers.stream()
//                .max((a, b) -> a.compareTo(b)) --- через лямбду
                .max(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("Список пуст"));
    }

    // Найти среднее значение чисел в списке;
    public static double averageNumbers(List<Integer> numbers) {
        return numbers.stream()
//                .mapToInt(a -> (int) a) --- через лямбду
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new IllegalArgumentException("Список пуст"));
    }

    // Найти количество строк, начинающихся с определённого символа в списке строк;
    public static long findNumString(List<String> strings, char symbol) {
        return strings.stream().
                filter(s -> s.startsWith(String.valueOf(symbol))).
                count();
    }

    // Отфильтровать список строк и оставить только те, которые содержат определенную подстроку;
    public static List<String> filterListRows(List<String> strings, String substring) {
        return strings.stream()
                .filter(s -> s.contains(substring))
                .toList();
    }

    // Отсортировать список строк по длине;
    public static List<String> sortStringsByLength(List<String> strings) {
        return strings.stream()
//                .sorted((s1, s2) -> s1.length() - s2.length()) --- через лямбду
                .sorted(Comparator.comparingInt(String::length))
                .toList();

    }

    // Проверить, все ли элементы списка удовлетворяют определённому условию;
    public static boolean checkCondition(List<String> strings, Predicate<String> stringPredicate) {
        return strings.stream()
                .allMatch(stringPredicate);
    }

    // Найти наименьший элемент в списке, который больше заданного числа;
    public static int findSmallestNumbers(List<Integer> numbers, int num) {
        return numbers.stream()
                .filter(i -> i > num)
//                .min((a, b) -> a.compareTo(b)) --- через лямбду
                .min(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("Список пуст"));
    }

    // Преобразовать список строк в список их длин.
    public static List<Integer> convertListStringsLength(List<String> strings) {
        return strings.stream()
//                .map(s -> s.length()) --- через лямбду
                .map(String::length)
                .toList();
    }
}
