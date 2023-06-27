package faang.school.godbless.streamAPI.part1;

import java.util.List;
import java.util.function.Predicate;

public class StreamApiFunctions {
    public static Integer getEvenSum(List<Integer> integerList) {
        if (integerList == null) {
            return null;
        }
        return integerList.stream().filter(n -> n % 2 == 0).reduce(0, Integer::sum);
    }

    public static Integer getMaxValue(List<Integer> integerList) {
        if (integerList == null) {
            return null;
        }
        return integerList.stream().reduce(Integer::max).get();
    }

    public static Double getMeanValue(List<Integer> integerList) {
        if (integerList == null) {
            return null;
        }
        return integerList.stream().mapToInt(Integer::intValue).average().getAsDouble();
    }

    public static int getCountStrings(List<String> stringList, String charStart) {
        if (stringList == null) {
            return 0;
        }
        return (int) stringList.stream().filter(str -> str.toLowerCase().startsWith(charStart.toLowerCase()))
                .count();
    }

    public static List<String> filterStringsBySubstring(List<String> stringList, String subString) {
        if (stringList == null) {
            return null;
        }
        return stringList.stream().filter(str -> str.toLowerCase().contains(subString.toLowerCase()))
                .toList();
    }

    public static List<String> filterStringsByLength(List<String> stringList, int length) {
        if (stringList == null) {
            return null;
        }
        return stringList.stream().filter(string -> string.length() > length).toList();
    }

    public static boolean checkAllMatch(List<Integer> integerList, Predicate<Integer> predicate) {
        if (integerList == null) {
            return true;
        }
        return integerList.stream().allMatch(predicate);
    }

    public static Integer findMinMoreThan(List<Integer> integerList, Integer number) {
        if (integerList == null) {
            return null;
        }
        return integerList.stream().filter(intElement -> intElement > number).reduce(Integer::min).get();
    }

    public static List<Integer> stringsToLength(List<String> stringList) {
        if (stringList == null) {
            return null;
        }
        return stringList.stream().map(String::length).toList();
    }
}
