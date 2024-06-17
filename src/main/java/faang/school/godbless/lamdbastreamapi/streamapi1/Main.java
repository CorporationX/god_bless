package faang.school.godbless.lamdbastreamapi.streamapi1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(List.of(1, -1, 8, -10, 13, -12, 2, 3, 4, 5, 6));
        System.out.println(sumEvenNumbers(nums));
        System.out.println(getMaxElement(nums).orElse(0));
        System.out.println(getAvg(nums).orElse(0));

        List<String> words = new ArrayList<>(List.of(
                "Hello",
                "dratuti",
                "World",
                "wasadad",
                "dafafd"
        ));
        System.out.println(countStringStartChar(words, 'd'));
        System.out.println(getStringsContainsSubstr(words, "da"));
        System.out.println(filterStringsByLength(words, 6));

        System.out.println(checkAllSatisfyCondition(nums, n -> n >= -12));
        System.out.println(getMinElement(nums, 4).orElse(4));
        System.out.println(transfomToLenghs(words));
    }

    public static Integer sumEvenNumbers(List<Integer> numbers) {
        return numbers.stream().filter((number) -> number % 2 == 0).mapToInt(number -> number).sum();
    }

    public static Optional<Integer> getMaxElement(List<Integer> numbers) {
        return numbers.stream().max(Integer::compare);
    }

    public static OptionalDouble getAvg(List<Integer> numbers) {
        return numbers.stream().mapToInt(number -> number).average();
    }

    public static long countStringStartChar(List<String> words, char firstChar) {
        return words.stream().filter(word -> word.charAt(0) == firstChar).count();
    }

    public static List<String> getStringsContainsSubstr(List<String> words, String subst) {
        return words.stream().filter(word -> word.contains(subst)).toList();
    }

    public static List<String> filterStringsByLength(List<String> words, int length) {
        return words.stream().filter(word -> word.length() >= length).toList();
    }

    public static boolean checkAllSatisfyCondition(List<Integer> nums, Predicate<Integer> condition) {
        return nums.stream().allMatch(condition);
    }

    public static OptionalInt getMinElement(List<Integer> nums, int border) {
        return nums.stream().mapToInt(num -> num).filter(num -> num > border).min();
    }

    public static List<Integer> transfomToLenghs(List<String> words) {
        return words.stream().map(String::length).toList();
    }
}
