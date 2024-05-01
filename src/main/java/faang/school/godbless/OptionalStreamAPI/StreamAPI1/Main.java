package faang.school.godbless.OptionalStreamAPI.StreamAPI1;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1,2,3,5,6,7,8,4,9);
        System.out.println("sumNumbers - " + sumNumbers(numbers));
        System.out.println("findMaxNumber - " + findMaxNumber(numbers));
        System.out.println("findAverage - " + findAverage(numbers));
        System.out.println("findMinWhichGreater - " + findMinWhichGreater(numbers, 2));

        List<String> strings = List.of("one", "two", "three", "four", "five");
        System.out.println("findStringWithStartingSymbol - " + findStringWithStartingSymbol(strings, 'f') );
        System.out.println("filterStringBySubstring - " + filterStringBySubstring(strings, "four"));
        System.out.println("sortStringsByLength - " + sortStringsByLength(strings));

        Predicate<String> stringPredicate = (line) -> !(line.length() < 4);
        Predicate<String> stringPredicate2 = (line) -> !(line.length() < 2);
        System.out.println("allElementsCondition - " + allElementsCondition(strings, stringPredicate));
        System.out.println("allElementsCondition - " + allElementsCondition(strings, stringPredicate2));
        System.out.println("StringToLength - " + StringToLength(strings));


    }

    public static int sumNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMaxNumber(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToDouble(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public static long findStringWithStartingSymbol(List<String> strings, char symbol) {
        return strings.stream()
                .filter(str -> !str.isEmpty() && str.charAt(0) == symbol)
                .count();
    }

    public static List<String> filterStringBySubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(str -> str.contains(substring))
                .toList();
    }

    public static List<String> sortStringsByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparing(String :: length))
                .toList();
    }

    public static boolean allElementsCondition (List<String> strings, Predicate<String> condition) {
        return strings.stream()
                .allMatch(condition);
    }

    public static int findMinWhichGreater(List<Integer> numbers,  int number) {
        return numbers.stream()
                .filter(num -> num > number)
                .min(Integer::compare)
                .orElse(0);
    }

    public static List<Integer> StringToLength(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}
