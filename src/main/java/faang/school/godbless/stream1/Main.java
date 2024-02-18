package faang.school.godbless.stream1;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Main {
    //Найти сумму четных чисел в списке. На вход получаем список чисел, на выходе должны получать int;
    public static int sumEvenNumbers(List<Integer> integers) {
        return integers.stream()
                .filter(integer -> integer % 2 == 0)
                .reduce(0, Integer::sum);
    }

    //Найти максимальный элемент в списке чисел;
    public static Integer findMax(List<Integer> integers) {
        return integers.stream()
                .mapToInt(integer -> integer)
                .max()
                .orElse(0);
    }

    //Найти среднее значение чисел в списке;
    public static double findAverage(List<Integer> integers) {
        return integers.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);
    }

    //Найти количество строк, начинающихся с определённого символа в списке строк;
    public static long matchesWithCharachter(List<String> strings, char c) {
        return strings.stream()
                .filter(str -> str.matches("^" + c + ".*"))
                .count();
    }

    //Отфильтровать список строк и оставить только те, которые содержат определенную подстроку;
    public static List<String> startsWithSubString(List<String> strings, String subString) {
        return strings.stream()
                .filter(str -> str.startsWith(subString))
                .toList();
    }

    //Отсортировать список строк по длине;
    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))  //I wrote "(str1, str2) -> str1.length() - str2.length()", but one more time was offered a new solution, that you can see
                .toList();
    }

    //Проверить, все ли элементы списка удовлетворяют определённому условию;
    public static boolean checkAllMatches(List<String> strings, Predicate<String> condition) {
        return strings.stream()
                .allMatch(condition);
    }

    //Найти наименьший элемент в списке, который больше заданного числа;
    public static Optional<Integer> findTheLeastListElement(List<Integer> ints, int i) {
        return ints.stream()
                .filter(a -> a > i)
                .min(Integer::compareTo);
    }

    //Преобразовать список строк в список их длин.
    public static List<Integer> convertStringsToLength(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }


    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 3, 4, 6, 7, 8, 89, 3, 3);

        System.out.println(sumEvenNumbers(integers));
        System.out.println(findMax(integers));

        List<String> strings = Arrays.asList("Chars", "Chapline", "Chapelle", "Trampoline", "tears");
        System.out.println(matchesWithCharachter(strings, 'C'));

        Predicate<String> condition = (str) -> str.matches(".*");
        System.out.println(checkAllMatches(strings, condition));

        System.out.println(findTheLeastListElement(integers, 9));
        System.out.println(convertStringsToLength(strings));
    }


}

