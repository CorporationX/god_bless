package school.faang.trainingstreamapi1;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class ListOperations {
    public static int findSumEvenNumbers(List<Integer> list) {
        validateList(list);
        return list.stream().filter(number -> number % 2 == 0).reduce(0, Integer::sum);
    }

    public static int findMaxElement(List<Integer> list) {
        validateList(list);
        return list.stream().max(Integer::compareTo).orElse(0);
    }

    public static double findAverageValue(List<Integer> list) {
        validateList(list);
        if (list.isEmpty()) {
            return 0;
        }
        return (double) list.stream().reduce(0, Integer::sum) / list.size();
    }

    public static long findCountLinesStartingWithChar(List<String> list, char symbol) {
        validateList(list);
        return list.stream().filter(string -> string.startsWith(String.valueOf(symbol))).count();
    }

    public static List<String> filterListLinesWithConcreteLine(List<String> list, String concreteString) {
        validateList(list);
        return list.stream().filter(string -> string.contains(concreteString)).toList();
    }

    public static List<String> sortedListLinesWithLength(List<String> list) {
        validateList(list);
        return list.stream().sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static boolean checkListOfConcreteCondition(List<Integer> list, Predicate<Integer> predicate) {
        validateList(list);
        validatePredicate(predicate);
        if (list.isEmpty()) {
            return false;
        }
        return list.stream().allMatch(predicate);
    }

    public static int findMinElementWithGreaterNumber(List<Integer> list, int number) {
        validateList(list);
        return list.stream().filter(value -> value > number).min(Integer::compare).orElse(0);
    }

    public static List<Integer> transformListLinesToListLengths(List<String> list) {
        validateList(list);
        return list.stream().map(String::length).toList();
    }

    private static void validateList(List<?> list) {
        Objects.requireNonNull(list, "Invalid value for list");
    }

    private static void validatePredicate(Predicate<Integer> predicate) {
        Objects.requireNonNull(predicate, "Predicate cannot be null");
    }
}
