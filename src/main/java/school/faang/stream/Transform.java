package school.faang.stream;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;


public class Transform {

    public static int sumOfEvenNumbers(List<Integer> list) {
        return list.stream().filter(number -> number % 2 == 0).mapToInt(num -> num).sum();
    }

    public static int findMax(List<Integer> list) {
        return list.stream().mapToInt(num -> num).max().orElse(0);

    }

    public static double findAverage(List<Integer> list) {
        return list.stream().mapToInt(num -> num).average().orElse(0);
    }

    public static int countStringsStartingWith(List<String> list, char s) {
        return (int) list.stream().filter(num -> num.charAt(0) == s).count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> list, String s) {
        List<String> rezalt = list.stream().filter(num -> num.contains(s)).toList();
        return rezalt;
    }

    public static List<String> sortByLength(List<String> list) {
        List<String> rezalt = list.stream().sorted(Comparator.comparing(String::length)).toList();
        return rezalt;
    }

    public static String allMatchCondition(List<Integer> list, Predicate<Integer> predicate) {
        List<Integer> rezalt = list.stream().filter(predicate).toList();
        if (list.size() == rezalt.size()) {
            return "Да";
        } else {
            return "Нет";
        }
    }

    public static int findMinGreaterThan(List<Integer> list, int numb) {
        return list.stream().filter(n -> n > numb).mapToInt(num -> num).min().orElse(0);
    }

    public static List<Integer> convertToLengths(List<String> list) {
        List<Integer> rezalt = list.stream().map(String::length).toList();
        return rezalt;
    }
}
