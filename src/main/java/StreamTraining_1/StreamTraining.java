package StreamTraining_1;

import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Predicate;

public class StreamTraining {

    public static int sumOdd(List<Integer> list) {
        return list.stream().filter(n -> n % 2 == 0).mapToInt(Integer::intValue).sum();
    }

    public static int max(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).max().getAsInt();
    }

    public static double average(List<Integer> list) {
        OptionalDouble average = list.stream().mapToInt(n -> n).average();
        return average.getAsDouble();
    }

    public static int countString(List<String> list, char symbol) {
        return (int) list.stream().filter(n -> n.charAt(0) == symbol).count();
    }

    public static List<String> stringFilter(List<String> list, String string) {
        return list.stream().filter(n -> n.contains(string)).toList();
    }

    public static List<String> stringSorter(List<String> list) {
        return list.stream().sorted((a, b) -> {
            if (a.length() > b.length()) return -1;
            else return 1;
        }).toList();
    }

    public static boolean check(List<String> list, Predicate<String> predicate) {
        return list.stream().allMatch(predicate);
    }

    public static int min(List<Integer> list, int border) {
        return list.stream().filter(n -> n > border).mapToInt(Integer::intValue).min().getAsInt();
    }

    public static List<Integer> stringForLength(List<String> list) {
        return list.stream().map(String::length).toList();
    }
}
