package faang.school.godbless.stream_1;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("The sum of even numbers is: " + summingEvenNumbers(List.of(1, 3, 2, 10, 8)));
        System.out.println("The maximum element in the list is: " + findMaxOfNumbers(List.of(1, 3, 2, 110, 8)));
        System.out.println("The average value of the numbers is: " + findAverageValue(List.of(1, 3, 2)));

        List<String> lines = Arrays.asList("Mom", "washed", "the", "window", "frame", "fox");
        System.out.println("The number of strings starting with " + countNumbersStringStartWithCharacter(lines, "f"));

        List<String> lines1 = Arrays.asList("maman", "kukumber", "washed", "the", "window", "frame", "fox");
        System.out.println("Filtered list of strings containing the substring: " + filterStringsBySubstring(lines1,"as"));

        System.out.println("Sorted list of strings by length: " + sortStringsByLength(lines1));

        List<Integer> lst = Arrays.asList(2,4,22,10,14);
        Predicate<Integer> condition = num -> num % 2 == 0;
        boolean allEven = allMatchCondition(lst, condition);
        System.out.println("Are all numbers from the list even? - " + allEven);

        int thresholdValue = 3;
        int minFind = findSmallestNumberGreaterThanOnePassedParameter(lst, thresholdValue);
        System.out.println("The minimum number in the list that is greater than the number " + thresholdValue + " is: " + minFind);

        List<Integer> leight = convertStringsToLengths(lines1);
        System.out.println("The lengths of the strings from the list: " + leight);
    }
    public static int summingEvenNumbers (List <Integer> evenNumbers) {
        return evenNumbers.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(x -> x)
                .sum();
    }
    public static int findMaxOfNumbers (List <Integer> list) {
        return list.stream()
                .max(Integer::compareTo)
                .orElse(Integer.MIN_VALUE);
    }
    public static double findAverageValue (List <Integer> list) {
        return list.stream()
                .mapToInt(lists -> Integer.valueOf(lists))
                .average()
                .orElse(0.0);
    }
    public static long countNumbersStringStartWithCharacter (List <String> lines, String symbol){
        return lines.stream()
                .filter(line -> line.startsWith(symbol))
                .count();
    }
    public static List<String> filterStringsBySubstring (List<String> lines, String substring) {
        return lines.stream()
                .filter(line -> line.contains(substring))
                .collect(Collectors.toList());
    }
    public static List<String> sortStringsByLength (List<String> lines) {
        return lines.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
    public static boolean allMatchCondition (List<Integer> num, Predicate<Integer> condition) {
        return num.stream()
                .allMatch(condition);
    }
    public static int findSmallestNumberGreaterThanOnePassedParameter (List<Integer> numbr, int thresholdValue) {
        return numbr.stream()
                .filter(num -> num > thresholdValue)
                .min(Integer::compareTo)
                .orElse(Integer.MAX_VALUE);
    }
    public static List<Integer> convertStringsToLengths (List<String> listOfStrings) {
        return listOfStrings.stream()
                .map(list -> list.length())
                .collect(Collectors.toList());
    }
}