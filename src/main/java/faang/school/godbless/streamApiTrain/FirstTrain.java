package faang.school.godbless.streamApiTrain;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class FirstTrain {
    private FirstTrain() {

    }

    public static int evenSum(List<Integer> list) {
        return list.stream()
                .filter(x -> x % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int getMax(List<Integer> list) {
        return list.stream()
                .max(Comparator.comparingInt(x -> x)).orElse(0);
    }

    public static double getAverage(List<Integer> list) {
        return list.stream()
                .map(x -> x / (double) list.size())
                .reduce(0d, Double::sum);
    }


    public static long getCountOfStringsStartsWithC(List<String> strings, Character c) {
        return strings.stream()
                .filter(string -> string.startsWith(c.toString()))
                .count();
    }

    public static List<String> getStringsContainsString(List<String> strings, String string) {
        return strings.stream()
                .filter(s -> s.contains(string))
                .toList();
    }

    public static List<String> sortStrings(List<String> strings) {
        return strings.stream().sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static boolean isEveryoneIsSatisfied(List<Integer> integers, Predicate<Integer> predicate) {
        return integers.stream()
                .allMatch(predicate);
    }

    public static int minIntBiggerThanFloor(List<Integer> integers, Integer floor) {
        return integers.stream()
                .filter(x -> x > floor)
                .min(Comparator.comparingInt(x -> x))
                .orElse(0);
    }

    public static List<Integer> mapStringsToLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}
