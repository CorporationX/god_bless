package school.faang.task_BJS2_58375;

import java.util.List;
import java.util.function.Predicate;

public class ListOperations {
    public static int calcSumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int findMaxElement(List<Integer> numbers) {
        return numbers.stream().reduce(Integer.MIN_VALUE, Integer::max);
    }

    public static double findAverageValueOfNumbers(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("The list must not be empty");
        }
        return numbers.stream().reduce(0, Integer::sum) / numbers.size();
    }

    public static long findElementsStartWithSpecChar(List<String> stringList, char specChar) {
        return stringList.stream()
                .filter(string -> string.startsWith(Character.toString(specChar)))
                .count();
    }

    public static List<String> filterElementsWithSpecSubstring(List<String> stringList, String subString) {
        return stringList.stream().filter(string -> string.contains(subString)).toList();
    }

    public static List<String> sortListByElementsLength(List<String> stringList) {
        return stringList.stream().sorted((s1, s2) ->
                Integer.compare(s1.length(), s2.length())).toList();
    }

    public static boolean isAllListElementsMeetCertainCond(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream().allMatch(predicate);
    }

    public static int findMinElementGreaterThanThreshold(List<Integer> numbers, Integer threshold) {
        return numbers.stream().filter(digit -> digit > threshold).reduce(Integer::min).orElse(threshold);
    }

    public static List<Integer> convertToLengths(List<String> stringList) {
        return stringList.stream().map(string -> string.length()).toList();
    }

}
