package school.faang.streamtraining1;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Predicate;

public class Transform {
    public static int evenNumbersSum(List<Integer> list) {
        return list.stream().filter(number -> number % 2 == 0).mapToInt(num -> num).sum();

//        Альтернативное решение
//        return list.stream()
//                .filter(number -> number % 2 == 0)
//                .reduce(0, Integer::sum);
    }

    public static Optional<Integer> maxInt(List<Integer> list) {
        return list.stream().max(Comparator.comparingInt(a -> a));
    }

    public static OptionalDouble average(List<Integer> list) {
        return list.stream().mapToInt(num -> num).average();
    }

    public static int sameFirstCharacter(List<String> list, char symbol) {
        return (int) list.stream().filter(str -> str.charAt(0) == symbol).count();
    }

    public static List<String> containsSubstring(List<String> list, String str) {
        return list.stream().filter(item -> item.contains(str)).toList();
    }

    public static List<String> sortStringList(List<String> list) {
        return list.stream().sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static boolean checkAllMatch(List<Integer> list, Predicate<Integer> condition) {
        return list.stream().allMatch(condition);
    }

    public static Optional<Integer> findMinBiggerThen(List<Integer> list, int endValue) {
        return list.stream()
                .filter(num -> num > endValue)
                .min(Comparator.comparingInt(num -> num));
    }

    public static List<Integer> stringToInteger(List<String> list) {
        return list.stream().map(String::length).toList();
    }
}
