package faang.school.godbless.StreamAPI_1;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ClassStatic {
    public static int getSumEven(List<Integer> nums) {
        return nums.stream()
                .filter(n -> n % 2 == 0).
                mapToInt(Integer::intValue)
                .sum();
    }

    public static int getMaxElement(List<Integer> nums) {
        return nums.stream().max(Integer::compareTo).orElseThrow();
    }

    public static double getAverageElement(List<Integer> nums) {
        return nums.stream().mapToInt(Integer::intValue).average().orElseThrow();
    }

    public static int getCountStringsStatsWith(List<String> strings, String character) {
        return (int) strings.stream().filter(string -> string.startsWith(character)).count();
    }

    public static List<String> getCountStringsContains(List<String> strings, String substring) {
        return strings.stream().filter(string -> string.contains(substring)).toList();
    }

    public static List<String> getFilterStringsByLength(List<String> strings) {
        return strings.stream().sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static <T> boolean checkingElementsByTrue(List<T> elements, Predicate<T> predicate) {
        return elements.stream().allMatch(predicate);
    }

    public static int getMinElementGreaterThanAGivenNumber(List<Integer> nums, int a) {
        return nums.stream().filter(num -> a < num).min(Integer::compareTo).orElseThrow();
    }

    public static List<Integer> mapStringToListLength(List<String> strings) {
        return strings.stream().map(String::length).toList();
    }
}
