package faang.school.godbless.BJS2_10460;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class APP_10460 {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 4, 5, 9, 9, 2);
        List<Integer> bigNums = List.of(1, 4, 3, 5, 4, 8, 46, 5, 4, 6, 5, 4, 32, 1, 35, 4, 6, 12, 31, 58, 64, 49);
        List<String> rows = List.of("!Benjamin", "Doll is laying under tree", "Dog was dag up its bone in the garden", "That was pretty old but cosy house", "James was born in Texas", "We will cross the river on boats", "Light shimmering on the surface of water");
        System.out.println(sumEvenNums(nums));
        System.out.println(getMax(nums));
        System.out.println(getAverage(nums));
        System.out.println(countStringsStartsWith("D", rows));
        System.out.println(leaveStrokesContains("on", rows));
        System.out.println(sortStringsByLength(rows));
        System.out.println(satisfyCondition(num -> num > 0, bigNums));
        System.out.println(getMinElementGreaterThenNum(10, bigNums));
        System.out.println(turnStringsListToLengthList(rows));

    }

    public static int sumEvenNums(List<Integer> nums) {
        return nums.stream().filter(num -> num % 2 == 0).reduce(Integer::sum).get();
    }

    public static int getMax(List<Integer> nums) {
        return nums.stream().max(Comparator.comparingInt(x -> x)).get();
    }

    public static double getAverage(List<Integer> nums) {
        return (double) nums.stream().reduce(Integer::sum).get() / nums.size();
    }

    public static int countStringsStartsWith(String pattern, List<String> text) {
        return (int) text.stream().filter(str -> str.startsWith(pattern)).count();
    }

    public static List<String> leaveStrokesContains(String pattern, List<String> text) {
        return text.stream().filter(str -> str.contains(pattern)).toList();
    }

    public static List<String> sortStringsByLength(List<String> text) {
        return text.stream().sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static boolean satisfyCondition(Predicate<Integer> cond, List<Integer> nums) {
        return nums.stream().allMatch(cond);
    }

    public static int getMinElementGreaterThenNum(int num, List<Integer> nums) {
        return nums.stream().filter(fNum -> fNum > num).min(Comparator.comparingInt(x -> x)).get();
    }

    public static List<Integer> turnStringsListToLengthList(List<String> text) {
        return text.stream().map(String::length).toList();
    }

}