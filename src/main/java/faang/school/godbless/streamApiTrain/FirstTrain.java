package faang.school.godbless.streamApiTrain;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
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
        Optional<Integer> max = list.stream()
                .max(Comparator.comparingInt(x -> x));
        if (max.isPresent()) {
            return max.get();
        } else {
            throw new RuntimeException("метод Stream.max вернул null");
        }
    }

    public static double getAverage(List<Integer> list) {
        return list.stream()
                .map(x -> x / (double) list.size())
                .reduce(0d, Double::sum);
    }


    public static long getCount(List<String> strings, Character c) {
        return strings.stream()
                .filter(string -> string.startsWith(c.toString()))
                .count();
    }

    public static List<String> filterCompare(List<String> strings, String string) {
        return strings.stream().filter(s -> s.contains(string)).toList();
    }

    public static List<String> sortStrings(List<String> strings) {
        return strings.stream().sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static boolean isFulfill(List<Integer> integers, Predicate<Integer> predicate) {
        return integers.stream().allMatch(predicate);
    }

    public static int minIntBiggerThanFloor(List<Integer> integers, Integer floor) {
        Optional<Integer> optional = integers.stream()
                .filter(x -> x > floor)
                .min(Comparator.comparingInt(x -> x));

        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> mapStringsToLengths(List<String> strings) {
        return strings.stream().map(String::length).toList();
    }
}
