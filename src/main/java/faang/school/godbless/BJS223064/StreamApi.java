package faang.school.godbless.BJS223064;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class StreamApi {
    public static int findSumEvenNumbers(List<Integer> integerList) {
        return integerList.stream().filter(n -> n % 2 == 0).mapToInt(Integer::intValue).sum();
    }

    public static int findMaximumElement(List<Integer> integerList) {
        return integerList.stream().max(Comparator.naturalOrder()).get();
    }

    public static double findAverageValueNumber(List<Integer> integerList) {
        return integerList.stream().mapToInt(Integer::intValue).average().
                orElseThrow(() -> new NullPointerException("List can not be empty"));
    }

    public static int findNumberLines(String symbol, List<String> stringList) {
        return (int) stringList.stream().filter(s -> s.startsWith(symbol)).count();
    }

    public static List<String> filterListSubstring(String string, List<String> stringList) {
        return stringList.stream().filter(s -> s.contains(string)).toList();
    }

    public static List<String> sortListByLength(List<String> stringList) {
        return stringList.stream().sorted((s1, s2) -> s1.length() - s2.length()).toList();
    }

    public static boolean checkListForStatement(List<String> stringList, Predicate<String> predicate) {
        return stringList.stream().allMatch(predicate);
    }

    public static int findMinElementAGiveNumber(Integer num, List<Integer> integerList) {
        return integerList.stream().filter(n -> n > num).min(Integer::compareTo).
                orElseThrow(() -> new NullPointerException("List can not be empty"));
    }

    public static List<Integer> convertListStringToListInt(List<String> stringList) {
        return stringList.stream().map(String::length).toList();
    }

}
