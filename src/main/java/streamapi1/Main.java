package streamapi1;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.OptionalDouble;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(1, 2, 3, 5, 6, 7, 8, 9, 10);
        System.out.println("===Check method nums===");
        System.out.println(sumIntegerNumbers(nums));

        nums = Arrays.asList(1, 2, 3, 5, 222, 7, 8, 9, 10);
        System.out.println("\n===Check method max===");
        System.out.println(max(nums));

        nums = Arrays.asList(1, 2, 3, 4, 5, 20);
        System.out.println("\n===Check method avgValue===");
        System.out.println(calculateAverageValue(nums));

        List<String> strings = List.of("Hello", "Hi-Tech", "Mom", "Dad", "House");
        System.out.println("\n===Check method countStringsWhichStartsWithASymbol===");
        System.out.println(countStringsWhichStartsWithASymbol(strings, 'H'));

        strings = List.of("Hello Mom", "Hi-Tech house", "Mom went shopping", "Dad worked at a factory", "Programming is cool");
        System.out.println("\n===Check method filterStringsBySubstring===");
        System.out.println(filterStringsBySubstring(strings, "Mom"));

        strings = List.of("Hello Mom", "Hi-Tech house", "Mom went shopping", "Dad worked at a factory", "Programming is cool");
        System.out.println("\n===Check method sortByLength===");
        System.out.println(sortByLength(strings));

        strings = List.of("Hello Mom", "Hi-Tech house", "Mom went shopping", "Dad worked at a factory", "Programming");
        System.out.println("\n===Check method checkConditionForString===");
        System.out.println(checkStringForConditions(strings, str -> str.length() > 12));

        nums = Arrays.asList(1, 2, 3, 5, 6, 7, 8, 9, 10);
        System.out.println("\n===Check method findMinElementInListWhichOverGivenNumber===");
        System.out.println(findMinElementInListWhichOverGivenNumber(nums, 5));

        strings = List.of("Hello Mom", "Hi-Tech house", "Mom went shopping", "Dad worked at a factory", "Programming");
        System.out.println("\n===Check method mapListOfStringsInListOfLengths===");
        System.out.println(mapListOfStringsInListOfLengths(strings));

    }

    static int sumIntegerNumbers(List<Integer> nums) {
        return nums.stream()
                .reduce(0, Integer::sum);
    }

    static int max(List<Integer> nums) {
        return nums.stream()
                .max(Integer::compareTo)
                .get();
    }

    static OptionalDouble calculateAverageValue(List<Integer> nums) {
        return nums.stream()
                .mapToInt(num -> num)
                .average();

    }

    static long countStringsWhichStartsWithASymbol(List<String> strings, char symbol) {
        return strings.stream()
                .filter(string -> string.charAt(0) == symbol)
                .count();
    }

    static List<String> filterStringsBySubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(string -> string.contains(substring))
                .toList();
    }

    static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted()
                .toList();
    }

    static boolean checkStringForConditions(List<String> strings, Predicate<String> condition) {
        return strings.stream()
                .allMatch(condition);
    }

    static int findMinElementInListWhichOverGivenNumber(List<Integer> nums, int number) {
        return nums.stream()
                .filter(num -> num > number)
                .min(Integer::compareTo).orElseThrow(NoSuchElementException::new);
    }

    static List<Integer> mapListOfStringsInListOfLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}

