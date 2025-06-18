package school.faang.streamtraining1;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class StreamExecutor {

    public static int listSum(List<Integer> numList) {
        return numList.stream()
                .filter(integer -> integer % 2 == 0)
                .mapToInt(Integer::intValue).sum();
    }

    public static int maxNumber(List<Integer> incList) {
        return incList.stream().max(Integer::compare).orElseThrow();
    }

    public static double averageNumber(List<Integer> incList) {
        return incList.stream().mapToDouble(Integer::doubleValue).average().orElseThrow();
    }

    public static long innerCharCount(List<String> stringList, char firstChar) {
        return stringList.stream().filter(sym -> sym.startsWith(String.valueOf(firstChar))).count();
    }

    public static List<String> filterStringContainsSubstring(List<String> stringList, String substring) {
        return stringList.stream().filter(string -> string.contains(substring)).toList();
    }

    public static List<String> sortByStringLength(List<String> stringList) {
        return stringList.stream().sorted(Comparator.comparing(String::length)).toList();
    }

    public static boolean isAllTrue(List<Integer> list, Predicate<Integer> predicate) {
        return !list.isEmpty() && list.stream().allMatch(predicate);
    }

    public static int lowestElementByHighest(List<Integer> list, int num) {
        return list.stream().filter(integer -> integer > num)
                .min(Integer::compareTo)
                .orElseThrow();
    }

    public static List<Integer> stringsToLength(List<String> stringList) {
        return stringList.stream().map(String::length).toList();
    }

}
