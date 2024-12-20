package school.faang.task_47235;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SetOfMethods {
    public static int sumOfEvenNumbers(List<Integer> list) {
        return list.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int getMaxNumber(List<Integer> list) {
        return list.stream().max((x, y) -> x - y)
                .get();
    }

    public static double getArithmeticMean(List<Integer> list) {
        double average = list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();
        return average;
    }

    public static int findNumberOfLines(List<String> list, char firstChar) {
        return (int) list.stream()
                .filter(element -> element.charAt(0) == firstChar)
                .count();
    }

    public static List<String> filterStrings(List<String> list, String subString) {
        return list.stream().filter(element -> element.contains(subString))
                .collect(Collectors.toList());
    }

    public static List<String> sortingByLength(List<String> list) {
        return list.stream().sorted((x, y) -> x.length() - y.length())
                .collect(Collectors.toList());
    }

    public static boolean allMatch(List<Integer> list, Predicate<Integer> condition) {
        return list.stream().allMatch(condition);
    }

    public static int findMinNumber(List<Integer> list, int num) {
        return list.stream().filter(element -> element > num)
                .min((x, y) -> x - y).get();
    }

    public static List<Integer> convertStringToInt(List<String> list) {
        return list.stream().map(element -> element.length())
                .collect(Collectors.toList());
    }
}
