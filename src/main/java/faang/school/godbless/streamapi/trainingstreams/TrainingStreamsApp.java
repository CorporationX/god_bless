package faang.school.godbless.streamapi.trainingstreams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class TrainingStreamsApp {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 7);
        List<String> strings = Arrays.asList("1", "2", "3", "4", "54", "777", "2");
        int evenSum = evenNumbersSum(numbers);
        System.out.println("evenSum = " + evenSum);
        int maxNumber = maxNumber(numbers);
        System.out.println("maxNumber = " + maxNumber);
        double averageNumber = averageNumber(numbers);
        System.out.println("averageNumber = " + averageNumber);
        int stringsNumber = stringsNumber('2', strings);
        System.out.println("stringsNumber = " + stringsNumber);
        List<String> filterBySubstring = filterBySubstring("2", strings);
        System.out.println("filterBySubstring = " + filterBySubstring);
        List<String> sortByLength = sortByLength(strings);
        System.out.println("sortByLength = " + sortByLength);
        boolean checkByCondition = checkByCondition(strings, string -> string.length() <= 3);
        System.out.println("checkByCondition = " + checkByCondition);
        int minElementLargerThan = minElementLargerThan(2, numbers);
        System.out.println("minElementLargerThan 2 = " + minElementLargerThan);
        List<Integer> stringsToLengths = stringsToLengths(strings);
        System.out.println("stringsToLengths = " + stringsToLengths);

    }

    public static int evenNumbersSum(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("Empty list");
        }
        return numbers.stream().reduce(0, (sum, number) -> number % 2 == 0 ? sum + number : sum);
    }

    public static int maxNumber(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("Empty list");
        }
        return numbers.stream().max(Integer::compare).orElseThrow(() -> new RuntimeException("There is no max element"));
    }

    public static double averageNumber(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("Empty list");
        }
        return (double) numbers.stream().reduce(0, Integer::sum) / numbers.size();
    }

    public static int stringsNumber(char startingChar, List<String> strings) {
        if (strings.isEmpty()) {
            throw new IllegalArgumentException("Empty list");
        }
        return (int) strings.stream().filter(string -> string.charAt(0) == startingChar).count();
    }

    public static List<String> filterBySubstring(String subString, List<String> strings) {
        if (strings.isEmpty()) {
            throw new IllegalArgumentException("Empty list");
        }
        return strings.stream().filter(string -> string.contains(subString)).toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        if (strings.isEmpty()) {
            throw new IllegalArgumentException("Empty list");
        }
        return strings.stream().sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static <T> boolean checkByCondition(List<T> list, Predicate<T> predicate) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Empty list");
        }
        return list.stream().allMatch(predicate);
    }

    public static int minElementLargerThan(int startingNumber, List<Integer> numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("Empty list");
        }
        return numbers.stream().filter(number -> number > startingNumber).min(Integer::compare)
                .orElseThrow(() -> new RuntimeException("There is no min element"));
    }

    public static List<Integer> stringsToLengths(List<String> strings) {
        if (strings.isEmpty()) {
            throw new IllegalArgumentException("Empty list");
        }
        return strings.stream().map(String::length).toList();
    }

}
