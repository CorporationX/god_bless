package faang.school.godbless.Sprint_3.StreamAPI.LetsTrainSreamAPI_1;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.Predicate;

public class Methods {
    public static int sumEven(List<Integer> nums) {
        return nums.stream()
                .filter(num -> num % 2 == 0)
                .reduce(0, (sum, num) -> sum + num);
    }

    public static OptionalInt maxElement(List<Integer> nums) {
        return nums.stream()
                .mapToInt(Integer::intValue)
                .max();
    }

    public static OptionalDouble average(List<Integer> nums) {
        return nums.stream()
                .mapToInt(Integer::intValue)
                .average();
    }

    public static int startWith(List<String> strings, char sym) {
        return (int) strings.stream()
                .filter(str -> !str.isEmpty())
                .filter(str -> str.charAt(0) == sym)
                .count();
    }

    public static List<String> strFilter(List<String> strings,  String substr) {
        return strings.stream()
                .filter(str -> !str.isEmpty())
                .filter(str -> str.contains(substr))
                .toList();
    }

    public static List<String> sortStringByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static boolean checkElements(List<?> list, Predicate condition) {
        return list.stream()
                .allMatch(condition);
    }

    public static OptionalInt minAfter(List<Integer> nums, int num) {
        return nums.stream()
                .filter(n -> n > num)
                .mapToInt(Integer::intValue)
                .min();
    }

    public static List<Integer> stringsToLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }


}
