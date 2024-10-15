package school.faang.bjs2_35654;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(6, 5, 4, 3, 2, 1);
        List<String> list = Arrays.asList("Pipe", "Pod", "Balcony", "Later", "Balon");

        System.out.println(getSumOfEvenNumbers(numbers));
        System.out.println(findMaxElementOfList(numbers));
        System.out.println(findArithmeticAverage(numbers));
        System.out.println(getSumStringsStartingWithSoecificChar(list, 'P'));
        System.out.println(getFilteredListContainsSubstring(list, "Bal"));
        System.out.println(sortListByLength(list));
        System.out.println(isSatisfyCondition(numbers, number -> number % 2 == 0));
        System.out.println(findMinElementInListGreaterThanGivenNumber(numbers, 1));
        System.out.println(convertListOfStringsToListOfTheirLength(list));
    }

    public static int getSumOfEvenNumbers(List<Integer> list) {
        return list.stream().filter(number -> number % 2 == 0).mapToInt(Integer::intValue).sum();
    }

    public static int findMaxElementOfList(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).max().orElse(0);
    }

    public static double findArithmeticAverage(List<Integer> list) {
        return list.stream().mapToDouble(Integer::doubleValue).average().orElse(0);
    }

    public static int getSumStringsStartingWithSoecificChar(List<String> list, char specificChar) {
        return list.stream().filter(s -> s.startsWith(Character.toString(specificChar))).toList().size();
    }

    public static List<String> getFilteredListContainsSubstring(List<String> list, String substring) {
        return list.stream().filter(s -> s.contains(substring)).toList();
    }

    public static List<String> sortListByLength(List<String> list) {
        return list.stream().sorted(Comparator.comparing(String::length)).toList();
    }

    public static boolean isSatisfyCondition(List<Integer> list, Predicate<Integer> predicate) {
       return list.stream().allMatch(predicate);
    }

    public static int findMinElementInListGreaterThanGivenNumber(List<Integer> list, int number) {
        return list.stream().sorted().filter(n -> n > number).findAny().orElse(0);
    }

    public static List<Integer> convertListOfStringsToListOfTheirLength(List<String> list) {
        return list.stream().mapToInt(String::length).boxed().toList();
    }
}
