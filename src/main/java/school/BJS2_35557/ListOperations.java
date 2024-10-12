package school.BJS2_35557;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOperations {

    public static int sumOfEvenNumbers(List<Integer> listToInt) {
        return listToInt.stream().filter(x -> x % 2 == 0).reduce(0, (acc, x) -> acc + x);
    }

    public static int findMax(List<Integer> listToMax) {
        return listToMax.stream().max(Comparator.naturalOrder()).get();
    }

    public static double findAverage(List<Integer> listToAvg) {
        int sum = listToAvg.stream().filter(x -> x % 2 == 0).reduce(0, (acc, x) -> acc + x);
        return sum / listToAvg.stream().count();
    }

    public static int countStringsStartingWith(List<String> list, char symbol) {
        return (int) list.stream().filter(x -> x.startsWith(String.valueOf(symbol))).count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> list, String line) {
        return list.stream().filter(x -> x.contains(line)).collect(Collectors.toList());
    }

    public static List<String> sortByLength(List<String> list) {
        return list.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
    }

    public static boolean allMatchCondition(List<Integer> list, Predicate<Integer> checkPredicate) {
        return list.stream().allMatch(checkPredicate);
    }

    public static int findMinGreaterThan(List<Integer> list, int number) {
        return list.stream().filter(x -> x > number).min(Comparator.naturalOrder()).get();
    }

    public static List<Integer> convertToLengths(List<String> list) {
        return list.stream().map(String::length).collect(Collectors.toList());
    }
}
