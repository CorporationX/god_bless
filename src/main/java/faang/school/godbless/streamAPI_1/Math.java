package faang.school.godbless.streamAPI_1;

import java.util.Comparator;
import java.util.List;

public class Math {
    public static int sumOfEvenNumbers(List<Integer> nums){
        return nums.stream().filter(num -> num % 2 == 0).mapToInt(Integer::intValue).sum();
    }

    public static int maxInEventNumbers(List<Integer> nums){
        return nums.stream().mapToInt(Integer::intValue).max().orElse(Integer.MIN_VALUE);
    }

    public static double average(List<Integer> nums){
        return nums.stream().mapToDouble(Integer::doubleValue).average().orElse(0);
    }

    public static long countStringsStartingWith(List<String> strings, char c){
        return strings.stream().filter(str -> str.charAt(0) == c).count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings){
        return strings.stream().filter(str -> str.contains("a")).toList();
    }

    public static List<String> sortStringsByLength(List<String> strings){
        return strings.stream().sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static boolean allElementsSatisfyCondition(List<Integer> nums, Condition condition) {
        return nums.stream().allMatch(condition::test);
    }

    public static int minElement(List<Integer> nums, int value){
        return nums.stream().filter(num -> num > value).min(Integer::compare).orElse(Integer.MIN_VALUE);
    }

    public static List<Integer> lengthsStrings(List<String> strings){
        return strings.stream().map(String::length).toList();
    }
    public interface Condition {
        boolean test(int num);
    }
}
