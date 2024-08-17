package faang.school.godbless.BJS2_23051;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Streams {
    public static int sumEvenNumbers(List<Integer> nums) {
        return nums.stream()
                .filter(num -> num % 2 == 0)
                .reduce(0, (summa, num) -> summa + num);
    }

    public static int maxNumList(List<Integer> nums) {
        return nums.stream()
                .max((e1,e2) -> e1 - e2).orElseThrow(NoSuchElementException::new);
    }

    public static double avgNumList(List<Integer> nums) {
        return nums.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public static long stringCertainCharacterCount(List<String> strings, String symbol) {
        return strings.stream()
                .filter(str -> str.startsWith(symbol))
                .count();
    }

    public static List<String> stringsSpecificSubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(str -> str.contains(substring))
                .collect(Collectors.toList());
    }

    public static boolean areAllElementsSatisfyingCondition(List list, Predicate<Integer> condition) {
        return list.stream().allMatch(condition);
    }

    public static List<String> listStringsLength(List<String> strings, int length) {
        return strings.stream()
                .filter(str -> str.length() >= length)
                .collect(Collectors.toList());
    }

    public static int minElementList(List<Integer> intList, int num) {
        return intList.stream()
                .filter(number -> number > num)
                .min((s1, s2) -> s1 - s2)
                .orElse(0);
    }

    public static List<Integer> convertListOfLength(List<String> strings) {
        return strings.stream()
                .map(str -> str.length())
                .collect(Collectors.toList());
    }
}
