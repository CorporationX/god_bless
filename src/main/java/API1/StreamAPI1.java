package API1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.Predicate;

public class StreamAPI1 {
    public static int findSumEvenNumbers(List<Integer> list){
        return list.stream()
                .filter(x -> x % 2 == 0)
                .mapToInt(Integer::intValue)
                .reduce(Integer::sum).getAsInt();
    }

    public static OptionalInt findMaxElement(List<Integer> list){
        return list.stream()
                .mapToInt(Integer::intValue)
                .max();
    }

    public static OptionalDouble findAverageNumber(List<Integer> list){
        return list.stream().mapToInt(Integer::intValue).average();
    }

    public static long findStringStartingWith(List<String> list, char symbol){
        return list.stream().filter(s -> s.charAt(0) == symbol).count();
    }

    public static List<String> filterSubstring(List<String> list, String substring){
        return list.stream()
                .filter(s -> s.contains(substring))
                .toList();
    }

    public static List<String> filterByLength(List<String> list){
        return list.stream()
                .sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static boolean conditionSatisfaction(List<Integer> list, Predicate<Integer> predicate){
        return list.stream().allMatch(predicate);
    }

    public static OptionalInt minInteger(List<Integer> list, int integer){
        return list.stream().map(s -> integer).mapToInt(Integer::intValue).min();
    }

    public static List<Integer> convertToCountList(List<String> list){
        return list.stream().map(String::length).toList();
    }

}
