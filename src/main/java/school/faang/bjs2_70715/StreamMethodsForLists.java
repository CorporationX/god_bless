package school.faang.bjs2_70715;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class StreamMethodsForLists {

    public static int findEvenSum(List<Integer> list) {
        return list.stream().filter(x -> x % 2 == 0).reduce(0, Integer::sum);
    }

    public static int findMax(List<Integer> list) {
        return list.stream().max(Integer::compare).orElse(0);
    }

    public static double findAverage(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).average().orElse(0);
    }

    //Кастить до инта немножко "в лоб" решение, но лучше я не придумал.
    public static int findStringsStartingWith(List<String> list, char c) {
        return (int) list.stream().filter(string -> string.charAt(0) == c).count();
    }

    public static List<String> listContainsSubstring(List<String> list, String substring) {
        return list.stream().filter(string -> string.contains(substring)).toList();
    }

    public static boolean conditionCheck(List<Integer> list, Predicate<Integer> predicate) {
        return list.stream().allMatch(predicate);
    }

    public static int findMinBiggerThanGiven(List<Integer> list, int comp) {
        return list.stream().filter(x -> x > comp).min(Integer::compare)
                .orElseThrow(() -> new NoSuchElementException("No number in list is bigger than" + comp));
    }

    public static List<Integer> transformToListOfLenghts(List<String> list) {
        return list.stream().map(String::length).toList();
    }
}
